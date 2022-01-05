//Helper functions

//Anatomi of a part list
function part_id(part) = part[0];
function part_values(part) = part[1];
function part_type(part) = part[2];

//Get a value from the values list
function Get_Value(name, values) =
    __rec_get_value(0, len(values), name, values);

function __rec_get_value(i, stop, name, values) =
    i == stop ? "VALUE_DOES_NOT_EXIST" :
    name == values[i][0] ? values[i][1] :
    __rec_get_value(i+1, stop, name, values);

//Get a parameter from a parameter list 
function Get_Parameter(param, default, params) =
    __rec_get_parameter(len(params)-1, param, default, params);

function __rec_get_parameter(i, param, default, params) =
    i < 0 ? default :
    param == params[i][0] ? params[i][1] :
    __rec_get_parameter(i-1, param, default, params);

//Find part in part_list
function Find_Part(part_id, part_list=[]) = __rec_find(0, len(part_list), part_id, part_list);

function __rec_find(i, stop, part_id, part_list) =
    i == stop ? "PART_NOT_IN_LIST" :
    part_id == part_list[i][0] ? part_list[i] :
    __rec_find(i + 1, stop, part_id, part_list);

//Helper functions to access values directly from part_id.
//This may be used in assemblies, that need to access information on sub-parts   
function Get_Part_Values_From_ID(part_id, part_list) =
    let (part = Find_Part(part_id, part_list))
        part == "PART_NOT_IN_LIST" ? part : part[1];

//Used to flatten the lists, when collecting parts
function Flatten(list) = [ for (i = list, v = i) v ];


//Used to restrict accessible parts by a whitelist
function Get_Restricted_Part_List(id_list, part_list) =
[ for (part_id = id_list) Find_Part(part_id, part_list) ];
 

//Creating the types when collecting the parts

//Make a parts list from the list of id and values
function Make_Part_List(type, value_names, part_id_and_values_list) =
[
    for(part = part_id_and_values_list)
        let(part_id = part[0])
        let(values = part[1])
        [part_id, __pair_up(value_names, values), [type, "END"]]
];
 
function __pair_up(list_1, list_2) =
    let(count_1 = len(list_1))
    let(count_2 = len(list_2))
    count_1 != count_2 ? "Pair Up Error!" : 
    [ for(i = [0 : count_1-1]) [list_1[i], list_2[i]] ];
        


// Extend the abstract type information, when going up the tree.
function Extend_Part_Type(new_type, list) =
[
    for(part = list)
        let(part_id = part[0])
        let(values = part[1])
        let(type = part[2])
        [part_id, values, [new_type, type]]
];


////Printing parts on the console:
function Full_Name(part) = str(Type_To_Str(part_type(part)), part_id(part));

function Type_To_Str(type) = 
    type == "END" ? "" : str(type[0], "/", Type_To_Str(type[1]));

function Values_To_Str(values) = _rec_values_to_string(0, len(values), values);

function _rec_values_to_string(i, stop, values) =
    i == stop ? "" :
        str(values[i][0], ": ", values[i][1], "\n",
        _rec_values_to_string(i+1, stop, values));

function Part_To_Str(part) = str(
"\n",
"Part ID: ", part_id(part), "\n",
"Part path: ", Full_Name(part), "\n",
"Part values:\n",
Values_To_Str(part_values(part))
);
