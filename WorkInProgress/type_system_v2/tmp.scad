module unit_translate(vector)
{
    translate([vector[0]*10, vector[1]*10, vector[2]*10])
        children();
}

module test()
{
    sphere(d=20);
}

unit_translate([2,5,3])
test();

{
    translate([20.0,0.0,0.0])
        sphere(d = 20.0, $fn=64);
    translate([-20.0,0.0,0.0])
        sphere(d = 20.0, $fn=64);
}