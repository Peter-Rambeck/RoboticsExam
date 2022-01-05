use <parts/Part_Functions.scad>
use <basic_bricks/Basic_Brick_Parts.scad>

function Construction_Parts() = Flatten
(
    [
        Extend_Part_Type("Construction", Basic_Brick_Parts())
    ]    
);