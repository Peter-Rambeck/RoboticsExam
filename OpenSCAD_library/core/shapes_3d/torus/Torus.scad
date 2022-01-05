// Auther: Tobias Grundtvig
// Date: Oct 1, 2020
//
// A Torus

Torus(diameter=40, tube_diameter=10, t_z="pos", t_y="neg", angular_resolution=64);

module Torus(   diameter,
                tube_diameter,
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
        rotate_extrude(convexity = 10, $fn=angular_resolution)
            translate([0.5*diameter, 0, 0])
                circle(r = 0.5*tube_diameter, $fn=angular_resolution);
    
}