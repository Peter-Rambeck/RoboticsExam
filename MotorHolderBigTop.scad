union() {



difference() {
sidex=30;
sidey=50;
height=10;
cylinder_small=3.4;
cylinder_big=2*(5.5+0.4) / sqrt(3);
screw_head_height=1 ;
edges=6;
screw_head_m3 = 5.8;
    //Base Foot
cube([sidex,sidey,height], center=true);    
   //Difference Small Cube
translate([-5,-30,-5.1])
    cube([10.2,15.2,10.2]);    

  //Difference Long Cube
translate([-16,5,-5.1])
    cube([31.2,20.2,10.2]);
  
//Strange Hole 1
translate([-20.1,-20,0])
    rotate([0,90,0])
   cylinder(d=cylinder_big, h=20,$fn=edges, center=true);   
  
  
  //Motor Hole 1
translate([-8.5,0,0])
   cylinder(d=cylinder_small, h=20,$fn=64,center=true);
  //Motor Hole 2
translate([8.5,0,0])
   cylinder(d=cylinder_small, h=20,$fn=64,center=true);
  //Motor Big Hole 1
translate([-8.5,0,0])
   cylinder(d=screw_head_m3, h=20,$fn=64);
  //Motor Big Hole 1  
translate([8.5,0,0])
   cylinder(d=screw_head_m3, h=20,$fn=64); 
  
  
  
  
  //Motor Center Hole
translate([0,0,-10])
    cylinder(d=9.0, h=20, $fn=64);
    
    

  
  
  //Side holes Middle
translate([10,-20,0])
  rotate([90,0,90])
   cylinder(d=cylinder_small, h=70,$fn=64,center=true);  
       //Big Holes
translate([10,-20,0])
  rotate([90,0,90])
   cylinder(d=screw_head_m3, h=20,$fn=64);

  
 
 
}

difference() {
//Feet
translate([0,-20,-10])
    cube([30,10,10],center=true);
translate([0.1,-20,-10])
    cube([10.2,10.2,10.2],center=true);
    
    
  //Feet Side holes Middle
  translate([10,-20,-10])
  rotate([90,0,90])
   cylinder(d=3.4, h=70,$fn=64,center=true); 
       //Feet Big Hole
translate([10,-20,-10])
  rotate([90,0,90])
   cylinder(d=5.8, h=20,$fn=64);
//Feet Strange Hole
translate([-20.1,-20,-10])
    rotate([0,90,0])
   cylinder(d=2*(5.5+0.4) / sqrt(3), h=20,$fn=6, center=true);   

}

/**
difference(){
    //Top Cylinder Bue
    cylinder(d=15,h=10,center=true);
    translate([0,-10,0])
    cube([25,29,10.5],center=true);
}
 **/  

difference()
//Top Cube
translate([0,10,0])
cube([30,10,10],center=true);

}
