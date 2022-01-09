union()
{
    difference()
    {
        translate([0.0000, 0.0000, 0.0000])
        {
            cube([60.0000, 50.0000, 7.0000]);
        }
        translate([5.0000, 45.0000, -0.1000])
        {
            cylinder(d = 3.4000, h = 10.0000, $fn = 64);
        }
        translate([55.0000, 45.0000, -0.1000])
        {
            cylinder(d = 3.4000, h = 10.0000, $fn = 64);
        }
        translate([5.0000, 45.0000, 4.1000])
        {
            cylinder(d = 6.8127, h = 3.0000, $fn = 6);
        }
        translate([55.0000, 45.0000, 4.1000])
        {
            cylinder(d = 6.8127, h = 3.0000, $fn = 6);
        }
        translate([6.0000, 5.0000, -0.1000])
        {
            cylinder(d = 6.8127, h = 3.0000, $fn = 6);
        }
        translate([6.0000, 5.0000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
        translate([49.5000, 5.0000, -0.1000])
        {
            cylinder(d = 6.8127, h = 3.0000, $fn = 6);
        }
        translate([49.5000, 5.0000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
        translate([49.5000, 33.5000, -0.1000])
        {
            cylinder(d = 6.8127, h = 3.0000, $fn = 6);
        }
        translate([49.5000, 33.5000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
        translate([6.0000, 20.5000, -0.1000])
        {
            cylinder(d = 6.8127, h = 3.0000, $fn = 6);
        }
        translate([6.0000, 20.5000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
    }
    difference()
    {
        translate([6.0000, 5.0000, 6.9000])
        {
            cylinder(d = 7.0000, h = 3.0000, $fn = 64);
        }
        translate([6.0000, 5.0000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
    }
    difference()
    {
        translate([49.5000, 5.0000, 6.9000])
        {
            cylinder(d = 7.0000, h = 3.0000, $fn = 64);
        }
        translate([49.5000, 5.0000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
    }
    difference()
    {
        translate([49.5000, 33.5000, 6.9000])
        {
            cylinder(d = 7.0000, h = 3.0000, $fn = 64);
        }
        translate([49.5000, 33.5000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
    }
    difference()
    {
        translate([6.0000, 20.5000, 6.9000])
        {
            cylinder(d = 7.0000, h = 3.0000, $fn = 64);
        }
        translate([6.0000, 20.5000, 0.0000])
        {
            cylinder(d = 3.4000, h = 100.0000, $fn = 64);
        }
    }
}


