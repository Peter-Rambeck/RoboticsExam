difference() {
sidex=30;
sidey=30;
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
cube([10.2,14.9,10.5]);
    //Small Holes
    for(x=[-10:10:10]){    

translate([x,20,-5])    
   cylinder(d=cylinder_small, h=20,$fn=64,center=true);   
  }
  
  
    //Big Holes
    for(x=[-10:10:10]){   
   
translate([x,20,screw_head_height])
   cylinder(d=cylinder_big, h=20,$fn=edges);       
  }
  
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
  translate([10,-10,0])
  rotate([90,0,90])
   cylinder(d=cylinder_small, h=70,$fn=64,center=true);
  translate([10,-20,0])
  rotate([90,0,90])
   cylinder(d=cylinder_small, h=70,$fn=64,center=true);

translate([10,10,0])    
rotate([90,0,90])
   cylinder(d=cylinder_small, h=70,$fn=64,center=true); 
  
   
       //Big Holes
translate([10,-10,0])
  rotate([90,0,90])
   cylinder(d=screw_head_m3, h=20,$fn=64);
translate([10,-20,0])
  rotate([90,0,90])
   cylinder(d=screw_head_m3, h=20,$fn=64);
   
translate([10,10,0])
  rotate([90,0,90])
   cylinder(d=screw_head_m3, h=20,$fn=64);       

//Strange Hole 1
translate([-20.1,-20,0])
    rotate([0,90,0])
   cylinder(d=cylinder_big, h=20,$fn=edges, center=true);  
   
}