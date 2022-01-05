use <alu_rect_rods/Alu_Rect_Rod_Generator.scad>

module Part_Alu_Rod(type, values, params)
{
    if(type[0] == "Alu_Rect_Rod")
    {
        Alu_Rect_Rod_Generator(type[1], values, params);
    }
    else
    {
        echo("Counld not find type: ", type);
    }
}

