use <parts/Parts_Functions.scad>
use <parts/All_Parts.scad>
use <parts/Send_Part_Request.scad>

//Copy this file to the project folder and rename it to Part.scad and set up the parts allowed in the project in the following way:
__project_allowed_part_ids =
[
    "Hex_Bolt_M3x25"
];



__all_parts = All_Parts();


__project_allowed_part_list =
    Get_Restricted_Part_List(__project_allowed_part_ids, __all_parts);

echo(__project_allowed_part_list);
// Or if the project allows all existing parts in the system, then use the following line instead:
//__project_allowed_part_list = All_Parts();


//Helper functions to use the parts library


module Part(part_id, params=[])
{
    Send_Part_Request("Get_Part", part_id, params, __project_allowed_part_list);
}

module Echo_Part_Type(part_id)
{
    Send_Part_Request("Echo_Part_Type", part_id, [], __project_allowed_part_list);
}

module Echo_Part_Values(part_id)
{
    Send_Part_Request("Echo_Part_Values", part_id, [], __project_allowed_part_list);
}

module LookUpPart(part_id)
{
    part = Find_Part(part_id, __all_parts);
    echo("LookUpPart", part_id, part);
}