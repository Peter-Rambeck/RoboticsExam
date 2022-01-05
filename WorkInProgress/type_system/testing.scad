use <type_system.scad>
use <Bolts.scad>

catalog = ["parts",[ Bolts() ]];


/*
catalog =
[
    "parts",
    [ 
        [
            "bolts",
            [
                ["allen_bolts", [], "Allen Bolts data"],
                ["hex_bolts", [], "Hex Bolts data"]
            ]
        ],
        [   
            "nuts",
            [
                ["hex_nuts", [], "Hex nut data"],
                ["lock_nuts", [], "lock nuts data"]
            ]
        ]        
    ]
];



catalog =
[
    "test1",
    [
        [
            "test2",
            [
                ["test3", []],
                ["test4", []]
            ]
        ],
        [
            "test5",
            [
                ["test6", []],
                ["test7", []]
            ]
        ]
     ]
];
*/
echo(str("\n\n", overview(catalog), "\n\n"));
echo(str("\n\n", count_types(catalog), "\n\n"));

part_name = "bolts/allen_bolts/M3x22";
//part_name = "bolts/allen_bolts/M3x22";
//part_name = "bolts/allen_bolts/M3x22";

part_id = build_path_from_name(part_name);

echo(part_id);

result = search_tree(catalog, part_id);

echo(result);

part = get_part(catalog, part_name);

print(part);

/*


echo(type_get_value_index(result[2], "thread__length"));

echo(type_get_instance(result[2], "M3x18"));

part = get_part(catalog, part_name);

echo(part);
*/

print(generator_module_template(result[2]));
print(check_values(result[2]));

module print(s)
{
    echo(str("\n\n", s, "\n\n"));
}