

module Allen_Bolt_Cutout(values, insert_length = 0, fitting = 0.2, fix_overhang = false)
{
    diameter = values[0];
    length = values[1];
    head_diameter = values[3];
    head_height = values[4];
    angular_resolution = values[7];

    color("green")

    union()
    {
        if(fix_overhang)
        {
            hull()
            {
                //Heads
                Cylinder(   diameter=head_diameter+2*fitting,
                            height=head_height+insert_length,
                            t_z="pos",
                            angular_resolution=angular_resolution);
                Cylinder(   diameter=diameter+2*fitting,
                            height=0.5*(head_diameter - diameter),
                            t_z="neg",
                            angular_resolution=angular_resolution);
            } 
        }
        else
        {
            //Head
            Cylinder(   diameter=head_diameter+2*fitting,
                        height=head_height+insert_length,
                        t_z="pos",
                        angular_resolution=angular_resolution);       
        }
        Cylinder(   diameter=diameter+2*fitting,
                    height=length,
                    t_z="neg",
                    angular_resolution=angular_resolution);
    }
}