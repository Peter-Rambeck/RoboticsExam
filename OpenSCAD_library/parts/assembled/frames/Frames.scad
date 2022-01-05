use <parts/Parts_Functions.scad> 
use <xyz_frames/XYZ_Frames.scad>

function Frame_Parts() = Flatten
(
    [
        Extend_Part_Type("Frame", XYZ_Frame_Parts())
    ]  
);

module  __Frames_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{
    if(type[0] == "XYZ_Frame")
    {
        __XYZ_Frames__Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    else
    {
        echo("Could not regconize assembled/frame part type: ", type);
    }
}