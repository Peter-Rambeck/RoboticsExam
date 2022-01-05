use <parts/Parts_Functions.scad>
use <parts/sourced/fasteners/Fasteners.scad>
//use <parts/sourced/actuators/Actuators.scad>

function Sourced_Parts() = Flatten
(
    [
        Extend_Part_Type("Sourced", Fastener_Parts()),
        //Extend_Part_Type("Sourced", Actuator_Parts())
    ] 
    
);

//Handle requests
module __Sourced_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{ 
    if(type[0] == "Fastener")
    {
        __Fasteners_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    /*
    else if(type[0] == "Actuator")
    {
        __Actuators_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    */
    else
    {
        echo("Could not regconize sourced part type: ", type);
    }
}