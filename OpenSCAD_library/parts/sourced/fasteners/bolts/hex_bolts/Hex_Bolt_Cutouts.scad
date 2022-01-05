module Hex_Bolt_Cutout( values,
                        fitting = 0.2,
                        fix_overhang = false)
{
    diameter = values[0];
    length = values[1];
    head_width  = values[3];
    head_height  = values[4];
    angular_resolution = values[5];
    color("green")
    union()
    {
        if(fix_overhang)
        {
            hull()
            {
                //Head
                Cylinder(   diameter=Hexagon_Diameter(head_width+2*fitting),
                            height=head_height,
                            t_z="pos",
                            angular_resolution=6);
                Cylinder(   diameter=diameter+2*fitting,
                            height=0.5*(Hexagon_Diameter(head_width+2*fitting) - diameter),
                            t_z="neg",
                            angular_resolution=angular_resolution);
            } 
        }
        else
        {
            //Head
            Cylinder(   diameter=Hexagon_Diameter(head_width+2*fitting),
                        height=head_height,
                        t_z="pos",
                        angular_resolution=6);         
        }
        Cylinder(   diameter=diameter+2*fitting,
                    height=length,
                    t_z="neg",
                    angular_resolution=angular_resolution);
    }
}