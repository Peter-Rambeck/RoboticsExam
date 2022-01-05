use <parts/Part_Functions.scad>
use <rectangular_bricks/Rectangular_Brick_Parts.scad>

function Basic_Brick_Parts() = Flatten
(
    [
        Extend_Part_Type("Basic_Brick", Rectangular_Brick_Parts())
    ]    
);