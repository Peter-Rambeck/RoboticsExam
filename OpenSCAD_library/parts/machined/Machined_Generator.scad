include <core/Core.scad>
use <alu_rods/Alu_Rod_Generator.scad>
  
module Machined_Generator(type, values)
{
    if(type[0] == "Alu_Rod")
    {
        Alu_Rod_Generator(type[1], values, params);
    }
    else
    {
        echo("Counld not find machined type: ", type);
    }
}