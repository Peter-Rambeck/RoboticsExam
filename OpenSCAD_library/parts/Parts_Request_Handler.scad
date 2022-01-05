use <./Parts_Functions.scad>
//use <assembled/Assembled.scad>
//use <laser_cut/Laser_Cut.scad>
//use <machined/Machined.scad>
//use <printed/Printed.scad>
use <sourced/Sourced.scad>


//Handle requests
module __Parts_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{  
    /*
    if(type[0] == "Assembled")
    {
        __Assembled_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    else if(type[0] == "Laser_Cut")
    {
        __Laser_Cut_Request_Handler(type[1], request, part_id, values, params);
    }

    else if(type[0] == "Machined")
    {
        __Machined_Request_Handler(type[1], request, part_id, values, params);
    }
    
    else if(type[0] == "Printed")
    {
        __Printed__Request_Handler(type[1], request, part_id, values, params);
    }
    else*/
    if(type[0] == "Sourced")
    {
        __Sourced_Request_Handler(type[1], request, part_id, values, params);
    }
    else
    {
        echo("Could not regconize part type: ", type);
    }
}
