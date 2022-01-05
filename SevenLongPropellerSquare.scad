
screw_length = 30;
screw_small_size = 3.4;
screw_m3_length = 4;
screw_m3_size = 2*(5.5+0.4) / sqrt(3);

difference(){
    
translate([0,0,-5])
    cube([70,10,10], center=true);
    
hull(){

translate([0,0,-1.5])
cylinder(d=6,h=5,center=true, $fn=64);
    translate([14,0,-1.5])
    cylinder(d=4,h=5,center=true, $fn=64);
    translate([-14,0,-1.5])
    cylinder(d=4,h=5,center=true, $fn=64);
}

translate([0,0,-1.5])
cylinder(d=7.4,h=5,center=true, $fn=64);

//Small Holes
translate([20,0,0])
cylinder(d=screw_small_size,h=screw_length,center=true, $fn=64);
translate([30,0,0])
cylinder(d=screw_small_size,h=screw_length,center=true, $fn=64);
translate([-20,0,0])
cylinder(d=screw_small_size,h=screw_length,center=true, $fn=64);
translate([-30,0,0])
cylinder(d=screw_small_size,h=screw_length,center=true, $fn=64);

//Nut holes
translate([20,0,0])
cylinder(d=screw_m3_size,h=screw_m3_length,center=true, $fn=6);
translate([30,0,0])
cylinder(d=screw_m3_size,h=screw_m3_length,center=true, $fn=6);
translate([-20,0,0])
cylinder(d=screw_m3_size,h=screw_m3_length,center=true, $fn=6);
translate([-30,0,0])
cylinder(d=screw_m3_size,h=screw_m3_length,center=true, $fn=6);


//Fire små huller
translate([12,0,0])
cylinder(d=1.5, h=12, center = true, $fn=64);
translate([-12,0,0])
cylinder(d=1.5, h=12, center = true, $fn=64);
translate([8.5,0,0])
cylinder(d=1.5, h=12, center = true, $fn=64);
translate([-8.5,0,0])
cylinder(d=1.5, h=12, center = true, $fn=64);

}