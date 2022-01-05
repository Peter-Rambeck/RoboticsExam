include <core/Core.scad>
use <parts/sourced/fasteners/nuts/hex_nuts/Hex_Nuts.scad>
use <generators/sourced/fasteners/nuts/hex_nuts/Hex_Nut.scad>


function Nut_Parts() = Flatten
(
    [
        Extend_Type("Nut", Hex_Nut_Parts()),
    ] 
    
);

  
module Part_Nut(type, values)
{
    if(type == "Hex_Nut")
    {
        Hex_Nut(values);
    }
}
