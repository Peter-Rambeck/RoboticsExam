include <core/Core.scad>

function Hexagon_Diameter(width) = 2*width/sqrt(3);
function Hexagon_Width(diameter) = (diameter*sqrt(3))/2;