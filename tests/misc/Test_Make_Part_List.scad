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

type = "Vector";
value_names = ["x", "y", "z"];
part_id_and_values_list =
[
    ["Vec1", [1,2,3]],
    ["Vec2", [3,4,5]]
];
echo(Make_Part_List(type, value_names, part_id_and_values_list));