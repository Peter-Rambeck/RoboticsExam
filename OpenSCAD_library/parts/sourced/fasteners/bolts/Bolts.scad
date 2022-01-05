use <parts/Parts_Functions.scad>
use <parts/sourced/fasteners/bolts/allen_bolts/Allen_Bolts.scad>
use <parts/sourced/fasteners/bolts/hex_bolts/Hex_Bolts.scad>

function Bolt_Parts() = Flatten
(
    [
        Extend_Part_Type("Bolt", Allen_Bolt_Parts()),
        Extend_Part_Type("Bolt", Hex_Bolt_Parts()),
    ] 
    
);

//Handle requests
module __Bolts_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{ 
    if(type[0] == "Allen_Bolt")
    {
        __Allen_Bolts_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    else if(type[0] == "Hex_Bolt")
    {
        __Hex_Bolts_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    else
    {
        echo("Could not regconize bolt part type: ", type);
    }
}