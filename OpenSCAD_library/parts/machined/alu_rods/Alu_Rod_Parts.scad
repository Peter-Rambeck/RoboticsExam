use <parts/Part_Functions.scad>
use <alu_rect_rods/Alu_Rect_Rod_Parts.scad>

function Alu_Rod_Parts() = Flatten
(
    [
        Extend_Part_Type("Alu_Rod", Alu_Rect_Rod_Parts()),
    ] 
    
);