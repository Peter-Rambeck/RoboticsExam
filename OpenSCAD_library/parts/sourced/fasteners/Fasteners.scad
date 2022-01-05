use <parts/Parts_Functions.scad>
use <parts/sourced/fasteners/bolts/Bolts.scad>
//use <parts/sourced/actuators/Actuators.scad>

function Fastener_Parts() = Flatten
(
    [
        Extend_Part_Type("Fastener", Bolt_Parts()),
        
    ] 
    
);

//Handle requests
module __Fasteners_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{ 
    if(type[0] == "Bolt")
    {
        __Bolts_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    /*
    else if(type[0] == "Actuator")
    {
        __Actuators_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    */
    else
    {
        echo("Could not regconize fastener part type: ", type);
    }
}