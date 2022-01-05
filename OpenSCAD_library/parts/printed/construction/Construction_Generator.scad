use <basic_bricks/Basic_Brick_Generator.scad>

module Construction_Generator(type, values, params)
{
    if(type[0] == "Basic_Brick")
    {
        Basic_Brick_Generator(type[1], values, params);
    }
    else
    {
        echo("Could not regconize construction part type: ", type);
    }
}