use <type_system.scad>
use <Hex_Bolts.scad>
use <Allen_Bolts.scad>

function Bolts() =
    extend_type
    (   "bolts",
        [
            Hex_Bolts(),
            Allen_Bolts()
        ]
    );
