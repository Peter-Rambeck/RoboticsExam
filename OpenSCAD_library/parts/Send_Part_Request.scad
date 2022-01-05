//Dependecies
use <parts/Parts_Functions.scad>
use <parts/Parts_Request_Handler.scad>

module Send_Part_Request(request, part_id, params, allowed_parts_list)
{
    _part = Find_Part(part_id, allowed_parts_list);
    if(_part == "PART_NOT_IN_LIST")
    {
        echo("Could not find the part in the list of parts: ", part_id);
    }
    else
    {
        if(request == "Echo_Part_Values")
        {
            echo(part_id(_part),part_values(_part));
        }
        else if(request == "Echo_Part_Type")
        {
            echo(part_id(_part),part_type(_part));
        }
        else if(request == "Get_Part")
        {
            echo("Get_Part", part_id);
            __Parts_Request_Handler(part_type(_part),
                                    request, part_id,
                                    part_values(_part),
                                    params,
                                    allowed_parts_list);
        }
        else if(request == "Get_Print_Part")
        {
            echo("Get_Print_Part", part_id);
            __Parts_Request_Handler(part_type(_part),
                                    request,
                                    part_id,
                                    part_values(_part),
                                    params,
                                    allowed_parts_list);
        }
        else if(request == "Get_Cutout_Part")
        {
            //Cutouts are not restricted to the allowed list of parts.
            echo("Get_Cutout_Part", part_id);
            __Parts_Request_Handler(part_type(_part),
                                    request,
                                    part_id,
                                    part_values(_part),
                                    params,
                                    __all_parts_list);
        }
        else
        {
            echo("Unknown_Request", part_id, request);
        }
    }
}