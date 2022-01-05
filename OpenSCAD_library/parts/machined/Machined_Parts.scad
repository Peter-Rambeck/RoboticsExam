use <parts/Part_Functions.scad>
use <alu_rods/Alu_Rod_Parts.scad>

function Machined_Parts() = Flatten
(
    [
        Extend_Part_Type("Machined", Alu_Rod_Parts()),
    ]   
);