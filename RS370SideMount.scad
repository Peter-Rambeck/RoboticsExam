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
   
      //Difference Long Cube
translate([-16,5,-5.1])
    cube([31.2,20.2,10.2]);
    
    //Small Holes
    for(x=[-10:10:10]){    
translate([x,-20,-5])
   cylinder(d=cylinder_small, h=20,$fn=64,center=true);
translate([x,20,-5])    
   cylinder(d=cylinder_small, h=20,$fn=64,center=true);   
  }
    //Big Holes
    for(x=[-10:10:10]){   
translate([x,-20,screw_head_height])
   cylinder(d=cylinder_big, h=20,$fn=edges);    
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
  
  
      
  
   
}

difference(){
    //Top Cylinder Bue
    cylinder(d=14,h=10,center=true);
    translate([0,-10,0])
    cube([25,29,10.5],center=true);
}