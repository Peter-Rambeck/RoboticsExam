include <Common/Util/Shapes.scad>
use <Common/Gears/GearUtil.scad>
use <Common/Gears/TimingBeltGears.scad>
use <Common/Gears/InvoluteGears.scad>
use <Common/Motors/StepperMotors/StepperMotors.scad>


Gear_2mm_shaft_lt(teeth=8);

module Gear_2mm_shaft_st(teeth=8)
{
    difference()
    {
        rotate([0,0,360/16])
        Involute_Gear(  width = 8,
                        number_of_teeth = teeth,
                        gear_dist = 10,
                        total_teeth = 16,
                        pressure_angle=10,
                        helix_angle=0,
                        t_x="center",
                        t_y="center",
                        t_z="pos",
                        fitting=0.2);
        translate([0,0,1.6])
        Cylinder(diameter=2.1, height=8, t_z="pos", angular_resolution=32);
    }
}

module Gear_2mm_shaft_lt(teeth=8)
{
    difference()
    {
        rotate([0,0,360/16])
        Involute_Gear(  width = 8,
                        number_of_teeth = teeth,
                        gear_dist = 20,
                        total_teeth = 16,
                        pressure_angle=10,
                        helix_angle=0,
                        t_x="center",
                        t_y="center",
                        t_z="pos",
                        fitting=0.2);
        translate([0,0,1.6])
        Cylinder(diameter=2.1, height=8, t_z="pos", angular_resolution=32);
    }
}

//module 

 /*
        axis_with_fastener_cutout(   axis_dia=3.4,
                                     gear_height=8,
                                     gear_dia=20,
                                     fastener_dia=3.4,
                                     sq_nut_width=5.9,
                                     sq_nut_height=2,
                                     angular_resolution=32);

        axis_with_double_fastener_cutout(   axis_dia=2,
                                     gear_height=8,
                                     gear_dia=20,
                                     fastener_dia=3.4,
                                     sq_nut_width=5.9,
                                     sq_nut_height=2,
                                     angular_resolution=32);
        */