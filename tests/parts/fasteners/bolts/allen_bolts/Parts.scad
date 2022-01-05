use <parts/Parts_Functions.scad>
use <parts/All_Parts.scad>
use <parts/Send_Part_Request.scad>

//Copy this file to the project folder and rename it to Part.scad and set up the parts allowed in the project in the following way:
__project_allowed_part_ids =
[
    "Allen_Bolt_M3x25"
];



__all_parts = All_Parts();


_project_parts =
    Get_Restricted_Part_List(__project_allowed_part_ids, __all_parts);
// Or if the project allows all existing parts in the system, then use the following line instead:
//__project_allowed_part_list = All_Parts();
function Project_Parts() = _project_parts;

//Helper functions to use the parts library


module Part(part_id, params=[])
{
    Send_Part_Request("Get_Part", part_id, params, _project_parts);
}

module Echo_Part_Type(part_id)
{
    Send_Part_Request("Echo_Part_Type", part_id, [], _project_parts);
}

module Echo_Part_Values(part_id)
{
    Send_Part_Request("Echo_Part_Values", part_id, [], _project_parts);
}

module LookUpPart(part_id)
{
    part = Find_Part(part_id, __all_parts);
    echo("LookUpPart", part_id, part);
}