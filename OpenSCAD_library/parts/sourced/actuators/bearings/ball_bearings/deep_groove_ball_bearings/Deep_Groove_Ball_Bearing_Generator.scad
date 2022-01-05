use <parts/Part_Functions.scad>
include <core/Core.scad>

module Deep_Groove_Ball_Bearing_Generator(type, values, params)
{
    if(type == "END")
    {
        __Deep_Groove_Ball_Bearing_Generator(values, params);
    }
    else
    {
        echo("This type should not end up in Deep_Groove_Ball_Bearing_Generator: ", type);
    }
}

module __Deep_Groove_Ball_Bearing_Generator(values, params)
{
    // d = inner diameter
    // D = outer diameter
    // B = width
    // d1 = inner shoulder outer diameter
    // D1 = outer shoulder inner diameter
    d = values[0];
    D = values[1];
    B = values[2];
    d1 = values[3];
    D1 = values[4];
    ring_clearance = values[5];
    
    angular_resolution = Get_Parameter("angular_resolution", 64, params);
    seal_color = Get_Parameter("seal_color", "black", params);
    
    union()
    {
        //Inner ring
        color("silver")
        Flat_Ring(  inner_diameter=d,
                    outer_diameter=d1,
                    height=B,
                    t_z="pos",
                    angular_resolution = angular_resolution);
        //Sealing
        color(seal_color)
        translate([0,0,ring_clearance])
        Flat_Ring(  inner_diameter=d1,
                    outer_diameter=D1,
                    height=B-2*ring_clearance,
                    t_z="pos",
                    angular_resolution = angular_resolution);
        //outer ring
        color("silver")
        Flat_Ring(  inner_diameter=D1,
                    outer_diameter=D,
                    height=B,
                    t_z="pos",
                    angular_resolution = angular_resolution);
    }    
}