include <core/Core.scad>
use <parts/sourced/actuators/smooth_rods/Smooth_Rods.scad>
use <generators/sourced/actuators/smooth_rod/Smooth_Rod.scad>

function Actuator_Parts() = Flatten
(
    [
        Extend_Type("Actuator", Smooth_Rod_Parts())
    ] 
    
);

  
module Part_Actuator(type, values)
{
    if(type == "Smooth_Rod")
    {
        Smooth_Rod(values);
    }
    else
    {
        echo("No generator found for type: ", type);
    }
}

