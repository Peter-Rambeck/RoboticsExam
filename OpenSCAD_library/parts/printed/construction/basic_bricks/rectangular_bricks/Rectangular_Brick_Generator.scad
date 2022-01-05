use <parts/Part_Functions.scad>
include <core/Core.scad>

module Rectangular_Brick_Generator(type, values, params)
{
    if(type == "END")
    {
        __Rectangular_BrickGenerator(values, params);
    }
    else
    {
        echo("This type should not end up in Rectangular_BrickGenerator: ", type);
    }
}

module __Rectangular_BrickGenerator(values, params)
{
    size_x = values[0];
    size_y = values[1];
    size_z = values[2];
    holes_x = values[3];
    holes_y = values[4];
    holes_z = values[5];
    unit = values[6];
    hole = values[7];
    
    angular_resolution = Get_Parameter("angular_resolution", 64, params);
    display_color = Get_Parameter("color", [0.3,0.3,0.3], params);
    
    color(display_color)
    translate([(size_x*0.5-0.5)*unit,(size_y*0.5-0.5)*unit,-0.5*unit])
    difference()
    {
        Box([unit*size_x, unit*size_y, unit*size_z], t_z = "pos");
        if(holes_x)
        {
            for(y = [0 : size_y-1])
                    for(z = [0 : size_z-1])
                        translate([ 0,
                                    unit*(-0.5*size_y+0.5+y),
                                    unit*(0.5+z)])
                        rotate([0,90,0])
                        Cylinder(   diameter=hole,
                                    height=unit*size_x+2,
                                    angular_resolution=angular_resolution);
        }
        if(holes_y)
        {
            for(x = [0 : size_x-1])
                    for(z = [0 : size_z-1])
                        translate(  [unit*(-0.5*size_x+0.5+x),
                                    0,
                                    unit*(0.5+z)])
                        rotate([90,0,0])
                        Cylinder(   diameter=hole,
                                    height=unit*size_y+2,
                                    angular_resolution=angular_resolution);
        }
        if(holes_z)
        {
            for(x = [0 : size_x-1])
                    for(y = [0 : size_y-1])
                        translate([ unit*(-0.5*size_x+0.5+x),
                                    unit*(-0.5*size_y+0.5+y),
                                    -1])
                        Cylinder(   diameter=hole,
                                    height=unit*size_z+2,
                                    t_z="pos",
                                    angular_resolution=angular_resolution);
        }
                
    }
}