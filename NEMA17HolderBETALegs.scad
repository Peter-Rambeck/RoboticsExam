sink_hole_head = 5.8;
sink_hole_depth = 2.8;
sink_hole_pos = 10.1 - sink_hole_depth;
seks_komma_otte = 2*(5.5+0.4) / sqrt(3);

        

//LEGS
difference(){
translate([-19.99,20,-40])
cube([20,10,50]);

translate([-5,25,-40.1])
cylinder(h=145,d=3.4,$fn=64);
translate([-5,25,-6])
cylinder(h=30,d=seks_komma_otte,$fn=6);
}

difference(){
translate([49.99,20,-40])
cube([20,10,50]);
    
translate([55,25,-40.1])
cylinder(h=145,d=3.4,$fn=64);        
translate([55,25,-6])
cylinder(h=30,d=seks_komma_otte,$fn=6);
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