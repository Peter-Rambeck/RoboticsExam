use <construction/Construction_Generator.scad>

module Printed_Generator(type, values, params)
{
    if(type[0] == "Construction")
    {
        Construction_Generator(type[1], values, params);
    }
    else
    {
        echo("Could not regconize printed part type: ", type);
    }
}