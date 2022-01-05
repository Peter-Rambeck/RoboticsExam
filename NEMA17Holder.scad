sink_hole_head = 5.8;
sink_hole_depth = 2.8;
sink_hole_pos = 10.1 - sink_hole_depth;
seks_komma_otte = 2*(5.5+0.4) / sqrt(3);

        
//Side Holders
difference(){
translate([30,-9.999,0])
cube([20,10,10]);
//Side Ho'es
rotate([90,0,90])
    translate([-5,5,0])
        cylinder(h=51,d=3.4,$fn=64);
rotate([90,0,90])
    translate([-5,5,-21])
        cylinder(h=55,d=seks_komma_otte,$fn=6);
}
difference(){
translate([30,49.999,0])
cube([20,10,10]);
//Side Ho'es
rotate([90,0,90])
    translate([55,5,0])
        cylinder(h=51,d=3.4,$fn=64);
rotate([90,0,90])
    translate([55,5,-21])
        cylinder(h=55,d=seks_komma_otte,$fn=6);
}


//Main Attraction
difference(){
cube([50,50,10]);
translate([25,25,0])
cylinder(h=23,d=6,center=true,$fn=64);  
translate([25,25,0])
cylinder(h=8,d=22.5,center=true,$fn=64);
translate([25,25,0])
cube([42.5,42.5,4],center=true);


//Screw Holes
    translate([9.5,9.5,10])
    cylinder(h=25,d=3.4,center=true,$fn=64);
    translate([9.5,40.5,10])
    cylinder(h=25,d=3.4,center=true,$fn=64);
    translate([40.5,9.5,10])
    cylinder(h=25,d=3.4,center=true,$fn=64);
    translate([40.5,40.5,10])
    cylinder(h=25,d=3.4,center=true,$fn=64);
    
//Sink holes
    translate([9.5,9.5,sink_hole_pos])
    cylinder(h=sink_hole_depth,d=sink_hole_head,$fn=64);
    translate([9.5,40.5,sink_hole_pos])
    cylinder(h=sink_hole_depth,d=sink_hole_head,$fn=64);
    translate([40.5,9.5,sink_hole_pos])
    cylinder(h=sink_hole_depth,d=sink_hole_head,$fn=64);
    translate([40.5,40.5,sink_hole_pos])
    cylinder(h=sink_hole_depth,d=sink_hole_head,$fn=64);
}