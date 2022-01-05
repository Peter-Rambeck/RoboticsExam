use <type_system_v2.scad>

value_definition_list =
[
    ["length", "number", "The length of the object"],
    ["bla", "list", "The length of the object"],
    ["foo", "number", "The length of the object"],
];

param_definition_list =
[
    ["length", "string", "Hello", "The length of the object"],
    ["height", "boolean", true, "The length of the object"],
    ["width", "list", [13], "The length of the object"],
];


echo(check_value_definition_list(value_definition_list, ""));

echo(check_param_definition_list(param_definition_list, "\nhello"));

echo(check_value_list([1, false, 3], value_definition_list, ""));

echo(_primitive_type_of(false));