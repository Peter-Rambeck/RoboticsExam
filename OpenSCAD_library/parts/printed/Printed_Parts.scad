use <parts/Part_Functions.scad>
use <construction/Construction_Parts.scad>

function Printed_Parts() = Flatten
(
    [
        Extend_Part_Type("Printed", Construction_Parts())
    ]    
);