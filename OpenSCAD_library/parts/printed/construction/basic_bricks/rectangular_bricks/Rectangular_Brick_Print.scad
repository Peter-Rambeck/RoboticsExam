module Rectangular_Brick_Print(values, line_width, line_height)
{
    size_x = values[0];
    size_y = values[1];
    size_z = values[2];
    holes_x = values[3];
    holes_y = values[4];
    holes_z = values[5];
    unit = values[6];
    hole = values[7] + line_width;
    
    ang_res = 128;
    
    rotate([0,90,0])
    difference()
    {
        Box([   unit*size_x,
                unit*size_y-line_width,
                unit*size_z-line_width ]);
        if(holes_x)
        {
            for(y = [0 : size_y-1])
                    for(z = [0 : size_z-1])
                        translate([ 0,
                                    unit*(-0.5*size_y+0.5+y),
                                    unit*(-0.5*size_z+0.5+z)])
                        rotate([0,90,0])
                        Cylinder(   diameter=hole,
                                    height=unit*size_x+2,
                                    angular_resolution=ang_res);
        }
        if(holes_y)
        {
            for(x = [0 : size_x-1])
                    for(z = [0 : size_z-1])
                        translate([ unit*(-0.5*size_x+0.5+x),
                                    0,
                                    unit*(-0.5*size_z+0.5+z)])
                        rotate([90,0,0])
                        Cylinder(   diameter=hole,
                                    height=unit*size_y+2,
                                    angular_resolution=ang_res);
        }
        if(holes_z)
        {
            for(x = [0 : size_x-1])
                    for(y = [0 : size_y-1])
                        translate([ unit*(-0.5*size_x+0.5+x),
                                    unit*(-0.5*size_y+0.5+y),
                                    0])
                        Cylinder(   diameter=hole,
                                    height=unit*size_z+2,
                                    angular_resolution=ang_res);
        }
                
    }
}