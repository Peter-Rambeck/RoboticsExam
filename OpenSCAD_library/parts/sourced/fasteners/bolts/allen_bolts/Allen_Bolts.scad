include <core/Core.scad>
include <Allen_Bolt_Parts.scad>

module __Allen_Bolts_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{
    if(type != "END")
    {
        echo("__Allen_Bolts_Request_Handler got wrong type:", type);
    }
    else
    {
        __Allen_Bolt_Generator(values, params);
    }
}

module __Allen_Bolt_Generator(values, params)
{
    diameter = Get_Value("diameter", values);
    length = Get_Value("length", values);
    thread_length = Get_Value("thread_length", values);
    head_diameter = Get_Value("head_diameter", values);
    head_height = Get_Value("head_height", values);
    hex_width = Get_Value("hex_width", values);
    hex_depth = Get_Value("hex_depth", values);

    angular_resolution = Get_Parameter("angular_resolution", 64, params);
    
    difference()
    {
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
            Cylinder(   diameter=head_diameter,
                        height=head_height,
                        t_z="pos",
                        angular_resolution=angular_resolution);
        }
        //Hex hole
        translate([0,0,head_height-hex_depth])
        color("silver")
        Cylinder(   diameter=Hexagon_Diameter(hex_width),
                    height=hex_depth+1,
                    t_z="pos",
                    angular_resolution=6 );
    }
}