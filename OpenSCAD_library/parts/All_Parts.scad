use <parts/Parts_Functions.scad>
use <sourced/Sourced.scad>

//Collect the parts
function All_Parts() = Flatten
    (
        [
            //Assembled_Parts(),
            //Laser_Cut_Parts(),
            //Machined_Parts(),
            //Printed_Parts(),
            Sourced_Parts()
        ]
    );
