////////////////////////////////////////////////////////////////////////////////
// definition of types
///////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////
// Basic types
////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

/*

component_type :
[
    name : string,
    value_definitions : value_definition_list,
    tasks : task_list,
    instances : instance_list
]

value_definition_list :
[
    value_definition,
    value_definition,
    ...
]  // may be empty

value_definition : 
[
    name : string,
    type : string //(name of a primitive type) 
    description : string
]

The value definitions describe the core elements of the component.
Every instance must provide each of these values since they define the nature of the component.
The name of the type can be:
"boolean",
"number",
"string" or
"list"

List can be a list of anything, so for now type checking stops here. If the OpenSCAD language had been
a little nicer and supported higher order functions, we could have made a more advanced type system,
where new types could be defined by the user, but it is too much work for now.

task_list :
[
    task,
    task,
    ...
]

task : 
[
    name : string,
    parameters : param_definition_list
]

A task could be: 

    RENDER      Just showing the part on the screen.

    ASSEMBLE    Add to the BOM and get the part in a specific detail
                level for rendering in a larger assembly. This is
                recursive and detail level should lower further down
                in the sub-assemblies.

    GEOMETRY    For adding or subtracting in the design of other parts.
                There must be parameters for both adding and subtracting.
                (Maybe adding and subtracting geometry should be different tasks).

    SOURCE      List of places to buy.

    PRINT       Generate a 3D stl-file for printing (maybe even slice to gcode?)

    LASER       Generate a 2D dxf-file for laser cutting the part.

    MACHINE     Generate some file for CNC machining the part. (Not thought through yet...)

Most component types would only have a selection of these tasks available. A hex_bolt can not be laser_cut. It could theoretically be printed for show :-)

param_definition_list :
[
    param_definition,
    param_definition,
    ...
]  // may be empty

param_definition :
[
    name : string,
    type : string, //(name of a primitive type) 
    default_value : (must match primitive type)),
    description : string
]

Each task can define a set of extra parameters, that can be provided when calling the task.
These could be different for each task, such as line width for printing, detail level
for assembly etc. These parameters should all have predefined default values and should 
only be used for optional optimizations in the given situation.

instance_list
[
    instance,
    instance,
    ...
] //List of instances of the component type

instance
[
    name : string,
    values : list_of_values
]

list_of_values
[
    value : unchecked,
    value : unchecked,
    ...
]

The list of values must match the length and types of the value_definition_list.
The length of the list is checked, but the types of the individual values are not
checked.



*/

//////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////
// Primitive type checking
//////////////////////////////////////////////////////////////////////////////
function _primitive_type_of(unknown) =
    unknown == undef ? "undef" :
    unknown == "" ? "string" :
    unknown == [] ? "list" :
    (         
        //len(unknown) == undef ?
        unknown[0] ==  undef ? 
        (  // number or boolean
            unknown + 1 != undef ?
                "number" :  
                "boolean"
        ) : 
        unknown != _h_str_to_list(unknown) ? "string" : "list"
    );
function _h_str_to_list(s) = [for (ch = s) ch] ;

/////////////////////////////////////////////////////////////////////////////////
// Types
/////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// Value definitions
////////////////////////////////////////////////////////////////////////////////
function value_definition_name(value_definition) = value_definition[0];
function value_definition_type(value_definition) = value_definition[1];
function value_definition_description(value_definition) = value_definition[2];


function is_primitive_type_name(name) =
    name == "boolean" || name == "number" || name == "string" || name == "list";


function check_value_definition(unknown, output) =
    _primitive_type_of(unknown) != "list" ?
        [false, str(output, "This value is not a list\n")] :
        len(unknown) != 3 ?
            [false, str(output, "This list is not 3 long\n")] :
            _primitive_type_of(unknown[0]) != "string" ?
                [false, str(output, "name is not a string\n")] :
                unknown[0] == "" ?
                    [false, str(output, "name is an empty string\n")] :
                    _primitive_type_of(unknown[1]) != "string" ?
                        [false, str(output, "type is not a string\n")] :
                        !is_primitive_type_name(unknown[1]) ?
                            [false, str(output, "type: ", unknown[1], " is not the name of a primitive type.\n")] :
                            _primitive_type_of(unknown[2]) != "string" ?
                                [false, str(output, "Description is not a string\n")] :
                                unknown[2] == "" ?
                                    [false, str(output, "Description is an empty string\n")] :
                                    [true, str(output, "OK\n")];

function check_value_definition_list(value_definition_list, output) =
    let(output = str(output, "\nChecking value definition list:\n"))
        value_definition_list == [] ?
            [true, str(output, "    The list is empty (which is sometimes OK)\n")] :
            _primitive_type_of(value_definition_list) != "list" ?
                [false, str(output, "    This value is not a list\n")] :
                let(result = _rec_check_value_definition_list(  0,
                                                                len(value_definition_list),
                                                                value_definition_list,
                                                                output,
                                                                true))
                result[0] == false ? result : 
                check_for_duplicate_names_in_list(value_definition_list, result[1]);

                                            
function _rec_check_value_definition_list(  i,
                                            stop,
                                            value_definition_list,
                                            output,
                                            res) =
    i == stop ? [res, output] :
        let(result = check_value_definition(value_definition_list[i], str(output, "    ", i, " - ")))
            _rec_check_value_definition_list(   i+1,
                                                stop,
                                                value_definition_list,
                                                result[1],
                                                res && result[0]);

////////////////////////////////////////////////////////////////////////////////
// Parameter definitions
////////////////////////////////////////////////////////////////////////////////
function param_definition_name(param_definition) = param_definition[0];
function param_definition_type(param_definition) = param_definition[1];
function param_definition_default_value(param_definition) = param_definition[2];
function param_definition_description(param_definition) = param_definition[3];


function check_param_definition(unknown, output) =
    _primitive_type_of(unknown) != "list" ?
        [false, str(output, "This value is not a list\n")] :
        len(unknown) != 4 ?
            [false, str(output, "This list is not 4 long\n")] :
            _primitive_type_of(unknown[0]) != "string" ?
                [false, str(output, "Name is not a string\n")] :
                _primitive_type_of(unknown[1]) != "string" ?
                        [false, str(output, "type is not a string\n")] :
                        !is_primitive_type_name(unknown[1]) ?
                            [false, str(output, "type: ", unknown[1], " is not the name of a primitive type.\n")] :
                            _primitive_type_of(unknown[2]) != unknown[1] ?
                                [false, str(output, "default value does not match type.\n")] :
                                _primitive_type_of(unknown[3]) != "string" ?
                                    [false, str(output, "Description is not a string\n")] :
                                    unknown[3] == "" ?
                                        [false, str(output, "Description is an empty string\n")] :
                                        [true, str(output, "OK\n")];


function check_param_definition_list(param_definition_list, output) =
    let(output = str(output, "\nChecking param definition list:\n"))
        param_definition_list == [] ?
            [true, str(output, "    The list is empty (which is sometimes OK)\n")] :
            _primitive_type_of(param_definition_list) != "list" ?
                [false, str(output, "    This value is not a list\n")] :
                let(result = _rec_check_param_definition_list(  0,
                                                                len(param_definition_list),
                                                                param_definition_list,
                                                                output,
                                                                true))
                result[0] == false ? result :
                check_for_duplicate_names_in_list(param_definition_list, result[1]);

                                            
function _rec_check_param_definition_list(  i,
                                            stop,
                                            param_definition_list,
                                            output,
                                            res) =
    i == stop ? [res, output] :
        let(result = check_param_definition(param_definition_list[i], str(output, "    ", i, " - ")))
            _rec_check_param_definition_list(   i+1,
                                                stop,
                                                param_definition_list,
                                                result[1],
                                                res && result[0]);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Check values against definitions
//////////////////////////////////////////////////////////////////////////////////////////////////////////////77
function check_value_list(value_list, value_definition_list, output) =
    _primitive_type_of(value_list) != "list" ?
        [false, str(output, "value_list is not a list\n")] :
            len(value_list) != len(value_definition_list) ?
                [false, str(output, "the value_list is not the same length as the value definition list\n")] :
                _rec_check_value_list(0, len(value_list), value_list, value_definition_list, output);

function _rec_check_value_list(i, stop, value_list, value_definition_list, output) =
    i == stop ?
        [true, str(output, "    OK\n")] :
        let(vt = _primitive_type_of(value_list[i]), dt = value_definition_type(value_definition_list[i]))
        vt !=  dt ?
            [false, str(output, "value on index ", i, " has type ", vt, " but definition is ", dt, "\n")] :
            _rec_check_value_list(i+1, stop, value_list, value_definition_list, output);

            
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Check for duplicates in a list of named entities
//////////////////////////////////////////////////////////////////////////////////////////////////////////////77

function check_for_duplicate_names_in_list(list, output) =
    let(output = str(output, "Checking for duplicate names in the list:\n"))
    _rec_check_for_duplicate_names_in_list(0, len(list), list, output);

function _rec_check_for_duplicate_names_in_list(i, stop, list, output) =
    i == stop ? [true, str(output, "    OK\n")] :
        let(count = _rec_count_name_in_list(i+1, len(list), 1, list[i][0], list))
        count > 1 ? [false, str(output, "\"",list[i][0], "\" appears ", count , " times in the list\n")] :
        _rec_check_for_duplicate_names_in_list(i+1, stop, list, output);


function count_name_in_list(name, list) =
    _rec_count_name_in_list(0, len(list), 0, name, list);

function _rec_count_name_in_list(i, stop, sum, name, list) =
    i == stop ? sum :
        name == list[i][0] ? 
            _rec_count_name_in_list(i+1, stop, sum+1, name, list) :
            _rec_count_name_in_list(i+1, stop, sum, name, list);




                                                