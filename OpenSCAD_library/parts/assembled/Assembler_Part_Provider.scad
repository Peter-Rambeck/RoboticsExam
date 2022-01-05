use <parts/Parts_Request_Handler.scad>

module __Handle_Part_Request(request, part_id, params, allowed_parts_list)
{
    _part = Find_Part(part_id, allowed_parts_list);
    if(_part == "Not_In_List")
    {
        echo("Could not find the part in the list of allowed parts: ", part_id);
    }
    else
    {
        type = __type(_part);
        if(type[0] == "Assembled")
        {
            //ToDo handle special request of count and stuff
            __Assembled_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
        }
        else if(request == "Echo_Part_Values")
        {
            Echo_Part_Values(_part);
        }
        else if(request == "Echo_Part_Type")
        {
            Echo_Part_Type(_part);
        }
        else if(request == "Get_Part")
        {
            echo("Get_Part fot assembly: ", part_id);
            __Parts_Request_Handler(__type(_part), request, part_id, __values(_part), params, allowed_parts_list);
        }
        else
        {
            echo("Illegal request for assembler: ", part_id, request);
        }
    }
}

module __Handle_Part_Request(request, part, params, allowed_parts_list)
{
    values = __values(part);
    part_id = __id(part);
    type = __type(part);
    if(type[0] == "Assembled")
    {
        //ToDo handle special request of count and stuff
        __Assembled_Request_Handler(type[1], request, part_id, values, params, allowed_parts_list);
    }
    else if(request == "Get_Part")
    {
        echo("Get_Part fot assembly: ", part_id);
        __Parts_Request_Handler(__type(_part), request, part_id, __values(_part), params, allowed_parts_list);
    }
    else
    {
        echo("Illegal request for assembler: ", part_id, request);
    }
    
}


module Get_Part_From_ID(allowed_parts_list, part_id, params=[])
{
    part = Find_Part(part_id, allowed_parts_list);
    if(_part == "Not_In_List")
    {
        echo("Could not find the part in the list of parts: ", part_id);
    }
    else
    {
        __Handle_Part_Request("Get_Part", part, params, allowed_parts_list);
    }
}

module Get_Part(allowed_parts_list, part, params[])
{
    __Handle_Part_Request("Get_Part", part, params, allowed_parts_list);
}