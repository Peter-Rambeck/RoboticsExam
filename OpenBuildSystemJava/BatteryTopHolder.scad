difference()
{
    union()
    {
        cube([120.0000, 10.0000, 20.0000]);
        translate([25.0000, -29.8000, 0.0000])
        {
            cube([9.6000, 69.6000, 20.0000]);
        }
        translate([85.0000, -29.8000, 0.0000])
        {
            cube([9.6000, 69.6000, 20.0000]);
        }
    }
    translate([13.3500, -24.0000, 4.2000])
    {
        cube([93.3000, 57.3000, 20.0000]);
    }
    translate([5.0000, 5.0000, 0.0000])
    {
        cylinder(d = 3.4000, h = 70.0000, $fn = 64);
    }
    translate([115.0000, 5.0000, 0.0000])
    {
        cylinder(d = 3.4000, h = 70.0000, $fn = 64);
    }
    translate([5.0000, 5.0000, -2.0000])
    {
        cylinder(d = 6.8127, h = 5.0000, $fn = 6);
    }
    translate([115.0000, 5.0000, -2.0000])
    {
        cylinder(d = 6.8127, h = 5.0000, $fn = 6);
    }
}


