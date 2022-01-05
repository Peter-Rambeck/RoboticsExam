


//Copy this file to the project folder and rename it to Part.scad and set up the parts allowed in the project in the following way:
__project_allowed_part_ids =
[
    "Rectangular_Brick_1x1x5"
];

__project_allowed_part_list = Get_Restricted_Part_List_From_ID_List(__project_allowed_part_ids);

module Part(part_id, params=[])
{
    part = Find_Part(part_id, __project_allowed_part_list);
    if(part == 0)
    {
        echo("Could not find part in project part list: ", part_id);
    }
    else
    {
        values = part[1];
        type = part[2];
        Part_Generator(part_id, type, values, params);
    }
}