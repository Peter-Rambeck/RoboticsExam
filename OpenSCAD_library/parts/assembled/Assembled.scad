use <frames/Frames.scad>

function Assembled_Parts() = Flatten
(
    [
        Extend_Part_Type("Assembled", Frame_Parts())
    ]  
);

//Handle requests
module __Assembled_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{ 
    if(type[0] == "Frame")
    {
        __Frames_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    else
    {
        echo("Could not regconize frame part type: ", type);
    }
}

// ToDo:
//This method is called when an assembler needs parts for the assembly
//module __Assembler_Part_Request(request, part_id, parts_list,  )