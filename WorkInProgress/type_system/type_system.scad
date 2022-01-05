////////////////////////////////////////////////////////////////////////////////
// definitions
///////////////////////////////////////////////////////////////////////////////
// Leaf Type: [name, [], description, value_def, param_def, instances]
// Node Type: [name, type]
// Part : [path, name, type, values]
////////////////////////////////////////////////////////////////////////////////
function type_get_name(type) = type[0];
function type_is_leaf(type) = type[1] == [];
function type_get_description(type) = type[2];
function type_get_value_definitions(type) = type[3];
function type_get_param_definitions(type) = type[4];
function type_get_instances(type) = type[5];

function type_get_value_index(type, value_name) =
    index_of( type_get_value_def(type), value_name );

function type_get_instance(type, name) =
    find_in_list(type_get_instances(type), name);

function instance_get_name(instance) = instance[0];
function instance_get_values(instance) = instance[1];

function get_part(type_tree, full_part_name) = 
    let (search_res = search_tree(type_tree, build_path_from_name(full_part_name)))
        search_res == [] ? [] :
        let(    path = search_res[0],
                name = search_res[1],
                type = search_res[2],
                instance = find_in_list(type_get_instances(type), name)  )
                [path, instance_get_values(instance)];


//////////////////////////////////////////////////////////////////////////////////
// Switch between name and tree representation...
//////////////////////////////////////////////////////////////////////////////////
        
function build_path_from_name(part_name) =
    part_name == "" ? [] :
        let(pair = str_split_first(part_name,"/"))
        [pair[0], build_path_from_name(pair[1])];
        
function build_name_from_path(name_tree) =
    name_tree == [] ? "" :
        name_tree[1] == [] ? name_tree[0] :
        str(name_tree[0], "/", build_name_from_path(name_tree[1]));
 
//////////////////////////////////////////////////////////////////////////////////
// Building the type tree
////////////////////////////////////////////////////////////////////////////////// 

function create_type(name, description, value_def, param_def, instances) = 
    [name, [], description, value_def, param_def, instances];

function extend_type(name, sub_type_list) = [name, sub_type_list];

//////////////////////////////////////////////////////////////////////////////////
// Using the type tree
//////////////////////////////////////////////////////////////////////////////////

function search_tree(type_tree, path) = _rec_search_tree(type_tree, path, path);

function _is_leaf(obj) = obj[1] == [];   

function _rec_search_tree(type_tree, path, path_rest) = 
    //Did we reach end of path?
    path_rest == [] ? [] :
    (
        _is_leaf(type_tree) ?
        (
            _is_leaf(path_rest) ? [path, path_rest[0], type_tree] : []
        )
        :
        (
            let (sub_tree = find_in_list(type_tree[1], path_rest[0]))
                sub_tree == [] ? [] : _rec_search_tree(sub_tree, path, path_rest[1])
        )
     );


////////////////////////////////////////////////////////////////////////////////////
// get information out of type_tree
////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
// Creates an overview of the type_tree
/////////////////////////////////////////////////////////////////
function overview(type_tree) = _rec_overview(0, "", type_tree);

function _rec_overview(indent, acc, type_tree) = 
    let (name = type_tree[0])
    _is_leaf(type_tree) ?
         str(acc, _line(_mark(name), indent)) :
         let (new_acc = str(acc, _line(name, indent)))
        _rec_overview_2(0, len(type_tree[1]), indent + 1, new_acc, type_tree[1]);
 
function _rec_overview_2(i, stop, indent, acc, list) =
    i == stop ? acc : 
        let(new_acc = _rec_overview(indent, acc, list[i])) 
        _rec_overview_2(i+1, stop, indent, new_acc, list); 
        
          
function _line(string, i) = str(repeat_string("    ", i), string, "\n");           

function _mark(string) = str("->", string);

function count_types(type_tree) = _rec_count_types(0, type_tree);

function _rec_count_types(sum, type_tree) = 
    _is_leaf(type_tree) ?
         sum + 1 :
        _rec_count_types_2(0, len(type_tree[1]), sum, type_tree[1]);
 
function _rec_count_types_2(i, stop, sum, list) =
    i == stop ? sum : 
        let(new_sum = _rec_count_types(sum, list[i])) 
        _rec_count_types_2(i+1, stop, new_sum, list); 
 

//////////////////////////////////////////////////////////////////////////////////////
// String helper functions
/////////////////////////////////////////////////////////////////////////////////////

function str_index_of(string, char) =
    _rec_str_index_of(0, len(string), string, char);
function _rec_str_index_of(i, stop, string, char) = 
  i == stop ? -1 :
    char == string[i] ? i :
        _rec_str_index_of(i+1, stop, string, char);
        
function str_rest(string, from) = _rec_str_rest(from, len(string), "", string);
function _rec_str_rest(i, stop, acc, string) =
    i >= stop ? acc :
        _rec_str_rest(i+1, stop, str(acc, string[i]), string);

function str_first(string, char) = _rec_str_first(0, len(string), "", string, char);
function _rec_str_first(i, stop, acc, string, char) =
    i == stop ? string :
        char == string[i] ? acc :
            _rec_str_first(i+1, stop, str(acc, string[i]), string, char);
 
function str_split_first(string, char) =
    let(pos = str_index_of(string, char))
        pos < 0 ? [string, ""] :
        [str_first(string, char), str_rest(string, pos + 1)];
        
function repeat_string(string, i) = i <= 0 ? "" : str(string, repeat_string(string, i-1));
        
//////////////////////////////////////////////////////////////////////////////////
// list helpers
//////////////////////////////////////////////////////////////////////////////////       

function find_in_list(list, name) = 
    let (index = index_of(list, name))
        index == [] ? [] : list[index];
/*
function find_in_list(list, name) = _rec_find_in_list(0, len(list), list, name);


        
function _rec_find_in_list(i, stop, list, name) = 
        i == stop ? [] :
            name == list[i][0] ? list[i] :
                _rec_find_in_list(i+1, stop, list, name); 
*/

function index_of(list, name) = _rec_index_of(0, len(list), list, name);
function _rec_index_of(i, stop, list, name) = 
    i == stop ? [] :
        name == list[i][0] ? i :
            _rec_index_of(i+1, stop, list, name); 
            
////////////////////////////////////////////////////////////////////////////////
//  Check consistency
////////////////////////////////////////////////////////////////////////////////

//function check_type_consistency(type)



function check_values(type) = 
let (   value_definitions = type_get_value_definitions(type),
        instances = type_get_instances(type) )
    _rec_check_values(0, len(instances), "", instances, value_definitions);

function _rec_check_values(i, stop, acc, instances, value_definitions) =
    i == stop ? acc : 
        let (error = _check_values_against_definitions( value_definitions,
                                                        instance_get_values(instances[i])))
            error == [] ? _rec_check_values(i+1, stop, acc, instances, value_definitions) :
                let (   name = instance_get_name(instances[i]),
                        new_acc = str(acc, "\n", name, ": ", error) ) 
                            _rec_check_values(i+1, stop, new_acc, instances, value_definitions);
                                                        


function _check_values_against_definitions(value_definitions, values) =
    len(value_definitions) == len(values) ? [] : "Number of values does not match";

            
////////////////////////////////////////////////////////////////////////////////
// generate templates
//////////////////////////////////////////////////////////////////////////////// 

function generator_module_template(type) =
    str("module ",
        type_get_name(type),
        "_generator(full_name, values, params)\n{\n    echo(str(\"Generating: \", full_name));\n\n",
        value_lines(type_get_value_definitions(type)),
        "\n",
        param_lines(type_get_param_definitions(type)),
        "\n\n    //Create geometry code here.....\n\n}\n");


function value_lines(definitions) =
    _rec_value_lines(0, len(definitions), "", definitions);
    
function _rec_value_lines(i, stop, acc, definitions) = 
    i == stop ? acc :
    let (new_acc = str(acc, value_line(definitions[i], i)))
        _rec_value_lines(i+1, stop, new_acc, definitions);

function value_line(definition, i) =
    str("    ", definition[0], " = values[", i,
        "]; // (", definition[1], ") ", definition[2], "\n");
        
function param_lines(definitions) =
    _rec_param_lines(0, len(definitions), "", definitions);
    
function _rec_param_lines(i, stop, acc, definitions) = 
    i == stop ? acc :
    let (new_acc = str(acc, param_line(definitions[i])))
        _rec_param_lines(i+1, stop, new_acc, definitions);
        
 function param_line(definition, i) =
    str(    "    ",
            definition[0],
            " = get_param(params, \"",
            definition[0],
            "\", ",
            definition[2],
            "); // (", definition[1], ") ", definition[3], "\n");
        