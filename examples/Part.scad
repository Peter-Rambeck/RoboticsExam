
use <parts/All_Parts.scad>
use <parts/Find_Part.scad>
use <parts/Get_Restricted_Part_List_From_ID_List.scad>
use <parts/Part_Generator>

//Copy this file to the project folder and set up the parts allowed in the project in the following way:
/*

__project_allowed_part_ids =
[
    "Allen_Bolt_M3x25",
    "M3_Hex_Nut"
]

__project_allowed_part_list = Get_Restricted_Part_List_From_ID_List(__project_allowed_part_ids);

*/

//If the project uses a restricted part list, comment out this line:
__project_allowed_part_list = All_Parts();



module Part(part_id)
{
    part = Find_Part(__project_allowed_part_list, part_id);
    if(part == 0)
    {
        echo("Could not find part in project part list: ", part_id);
    }
    else
    {
        values = part[1];
        type = part[2];
        Part_Generator(type, values);
    }
}