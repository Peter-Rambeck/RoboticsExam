include <core/Core.scad>

module Smooth_Rod_Generator(values)
{
    diameter = values[0];
    length = values[1];
    angular_resolution = values[2];
    
    end_height = 0.1*diameter;
    end_diameter = 0.9*diameter;
    
    color("silver")
    union()
    {
        Cone(   bottom_diameter=end_diameter,
                top_diameter = diameter,
                height = end_height,
                t_z = "pos",
                angular_resolution = angular_resolution);
        
        translate([0,0,end_height])
        Cylinder(   diameter=diameter,
                    height = length - 2*end_height,
                    t_z = "pos",
                    angular_resolution = angular_resolution);
        
        translate([0,0,length-end_height])           
        Cone(   bottom_diameter=diameter,
                top_diameter = end_diameter,
                height = end_height,
                t_z = "pos",
                angular_resolution = angular_resolution);
    }
}