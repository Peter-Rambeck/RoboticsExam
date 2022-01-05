// Auther: Tobias Grundtvig
// Date: Oct 1, 2020
//
// A segment of a flat ring

include <core/Core.scad>

Torus_Segment(  diameter=40,
                tube_diameter=10,
                from_angle=45,
                to_angle=90,
                t_y="neg",
                angular_resolution=64);

module Torus_Segment(   diameter,
                        tube_diameter,
                        from_angle,
                        to_angle,
                        t_x="center",
                        t_y="center",
                        t_z="center",
                        angular_resolution=32)
{
    tx = t_x == "neg" ? -0.5*diameter - 0.5*tube_diameter : 
            t_x == "pos" ? 0.5*diameter + 0.5*tube_diameter : 0;
    ty = t_y == "neg" ? -0.5*diameter - 0.5*tube_diameter : 
            t_y == "pos" ? 0.5*diameter + 0.5*tube_diameter : 0;
    tz = t_z == "neg" ? -0.5*tube_diameter : 
            t_z == "pos" ? 0.5*tube_diameter : 0;
    translate([tx, ty, tz])
    intersection()
    {
        linear_extrude(height=tube_diameter+2, center=true)
        {
            Pie_2D
            (
                diameter=(tube_diameter+diameter)*2,
                from_angle=from_angle,
                to_angle=to_angle,
                steps = 8
            );
        }
        Torus(  diameter=diameter,
                tube_diameter=tube_diameter,
                angular_resolution=angular_resolution);
    }
}
