include <core/Core.scad>
include <Hex_Bolt_Parts.scad>

module __Hex_Bolts_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{
    if(type != "END")
    {
        echo("__Hex_Bolts_Request_Handler got wrong type:", type);
    }
    else
    {
        __Hex_Bolt_Generator(values, params);
    }
}

module __Hex_Bolt_Generator(values, params)
{
    diameter = Get_Value("diameter", values);
    length = Get_Value("length", values);
    thread_length = Get_Value("thread_length", values);
    head_width = Get_Value("head_width", values);
    head_height = Get_Value("head_height", values);
    
    angular_resolution = Get_Parameter("angular_resolution", 64, params);
    
    union()
    {
        //Non-threaded part
        if(thread_length < length)
        {
            color("silver")
            Cylinder(   diameter=diameter,
                        height=length-thread_length,
                        t_z="neg",
                        angular_resolution=angular_resolution);
        }
        //Threaded part
        translate([0,0,-(length-thread_length)])
        color("grey")
        Cylinder(   diameter=diameter,
                    height=thread_length,
                    t_z="neg",
                    angular_resolution=angular_resolution);
        
        //Head
        color("silver")
        Cylinder(   diameter=Hexagon_Diameter(head_width),
                    height=head_height,
                    t_z="pos",
                    angular_resolution=6);
    }   
}