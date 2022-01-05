difference() {
sides=30;
height=10;
cylinder_small=3.4;
cylinder_big=2*(5.5+0.4) / sqrt(3);
screw_head_height=1 ;
edges=6;
    //Base Foot
cube([sides,sides,height], center=true);    
    
    //Small Holes
    for(x=[-10:10:10]){ 
      for(y=[-10:10:10]){
translate([x,y,-5])
   cylinder(d=cylinder_small, h=20,$fn=64,center=true);    
    }    
  }

    //Big Holes
    for(x=[-10:10:10]){ 
      for(y=[-10:10:10]){
translate([x,y,screw_head_height])
   cylinder(d=cylinder_big, h=20,$fn=edges);    
    }  
  }

}