use <rectangular_bricks/Rectangular_Brick_Generator.scad>

module Basic_Brick_Generator(type, values, params)
{
    if(type[0] == "Rectangular_Brick")
    {
        Rectangular_Brick_Generator(type[1], values, params);
    }
    else
    {
        echo("Could not regconize basic brick part type: ", type);
    }
}