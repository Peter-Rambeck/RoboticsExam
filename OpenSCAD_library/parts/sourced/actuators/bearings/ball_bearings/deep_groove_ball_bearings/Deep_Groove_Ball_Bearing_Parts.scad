use <parts/Part_Functions.scad>

// Data values
//[ d, D, B, d1, D1, clearance]
// d = inner diameter
// D = outer diameter
// B = width
// d1 = inner shoulder outer diameter
// D1 = outer shoulder inner diameter
// clearance = distance from seal up to shoulder
function Deep_Groove_Ball_Bearing_Parts() = 
Add_Type("Deep_Groove_Ball_Bearing",
[
    //          ID                Values
    [   "DGBB_3x8x3",  [   3,  8,  3,  4,  7,  0.2 ]],
]);  