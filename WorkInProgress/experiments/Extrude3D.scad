Sweep_Z(20)
{
    translate([30,0,0])
    sphere(10);
    cube([60,5,3], center=true);
    translate([-30,0,0])
    sphere(10);
}
 
 
 
 module Sweep_Z(distance)
 {
     union()
     {
        children();
        linear_extrude(distance)
            projection()
                children();
        translate([0,0,distance])
            children();
     }
 }
 
 module cylinder_outer(height,radius,fn){
   fudge = 1/cos(180/fn);
   echo(radius*fudge);
   cylinder(h=height,r=radius*fudge,$fn=fn);}
   
   cylinder_outer(radius=3, height=15, fn=32);