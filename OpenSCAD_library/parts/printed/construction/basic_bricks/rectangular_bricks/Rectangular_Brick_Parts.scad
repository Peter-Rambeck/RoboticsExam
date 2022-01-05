use <parts/Part_Functions.scad>

// Data values
//[size_x, size_y, size_z, x holes, y holes, z holes, unit size, hole diameter]

function Rectangular_Brick_Parts() = 
Add_Part_Type("Rectangular_Brick",
[
    //          ID                      Values
    [   "Rectangular_Brick_1x1x5",  [1, 1, 5, true, true, false, 10, 3]],
]);  