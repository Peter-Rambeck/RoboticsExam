include <core/Core.scad>
use <parts/Part_Functions.scad>
 
module Alu_Rect_Rod_Generator(type, values, params)
{
    if(type == "END")
    {
        __Alu_Rect_Rod(values, params);
    }
    else
    {
        echo("This type should not end up in Alu_Rect_Rod_Generator: ", type);
    }
}

module __Alu_Rect_Rod(values, params)
{
    size_x = values[0];
    size_y = values[1];
    length = values[2];
    mat = values[3];
    unit = values[4];
    hole = values[5];

    angular_resolution = Get_Parameter("angular_resolution", 64, params);
    
    color("LightGray")
    translate([(0.5*size_x-0.5)*unit, (0.5*size_y-0.5)*unit, -0.5*unit])
    difference()
    {
        Box([unit*size_x, unit*size_y, unit*length], t_z = "pos");
        translate([0,0,-1])
        Box([unit*size_x-2*mat, unit*size_y-2*mat, unit*length+2], t_z="pos");
        for(x = [0 : size_x-1])
                for(z = [0 : length-1])
                    translate([unit*(-0.5*size_x+0.5+x),0,unit*(0.5+z)])
                    rotate([90,0,0])
                    Cylinder(diameter=hole, height=unit*size_y+2, angular_resolution=ang_res);
        for(y = [0 : size_y-1])
                for(z = [0 : length-1])
                    translate([0, unit*(-0.5*size_y+0.5+y),unit*(0.5+z)])
                    rotate([0,90,0])
                    Cylinder(diameter=hole, height=unit*size_x+2, angular_resolution=ang_res);
                
    }
}