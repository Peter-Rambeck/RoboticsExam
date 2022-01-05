<<<<<<< HEAD

Lang_Nummer = 2*(5.5+0.4) / sqrt(3);

difference(){

//MiniMøiser

translate([0,0,0])
cube([10,60,20],center=true);
translate([0,-6,-5])
    cube([11,23.1,12.2],center=true);

//In'ak
translate([4.2,-6,-5])
    cube([1.9,32.4,12.2],center=true);

//Måtrik'åller
translate([0,-25,-10])
   cylinder(d=Lang_Nummer, h=5.4,$fn=6, center=true); 
translate([0,15,-10])
   cylinder(d=Lang_Nummer, h=5.4,$fn=6, center=true); 
    translate([0,25,-10])
   cylinder(d=Lang_Nummer, h=5.4,$fn=6, center=true); 
    
  //Små'åller
    translate([0,-25,0])
   cylinder(d=3.4, h=70,$fn=64,center=true); 
    translate([0,15,0])
   cylinder(d=3.4, h=70,$fn=64,center=true); 
       translate([0,25,0])
   cylinder(d=3.4, h=70,$fn=64,center=true); 
   
   
   //Små in'ak 'uller
rotate([0,90,0])
translate([4.5,8.5,0])
    cylinder(d=1.9, h=7,$fn=64,center=true);
rotate([0,90,0])
translate([4.5,-20.3,0])
    cylinder(d=1.9, h=7,$fn=64,center=true);
}

=======

Lang_Nummer = 2*(5.5+0.4) / sqrt(3);

difference(){

//MiniMøiser

translate([0,0,0])
cube([10,60,20],center=true);
translate([0,-1,-5])
    cube([11,23.1,12.2],center=true);

//In'ak
translate([4.2,-1,-5])
    cube([1.9,32.4,12.2],center=true);

//Måtrik'åller
translate([0,-25,-10])
   cylinder(d=Lang_Nummer, h=5.4,$fn=6, center=true); 

    translate([0,25,-10])
   cylinder(d=Lang_Nummer, h=5.4,$fn=6, center=true); 
    
  //Små'åller
    translate([0,-25,0])
   cylinder(d=3.4, h=70,$fn=64,center=true); 
   

   
       translate([0,25,0])
   cylinder(d=3.4, h=70,$fn=64,center=true); 
   
   
   //Små in'ak 'uller
rotate([0,90,0])
translate([4.5,13.5,0])
    cylinder(d=1.9, h=7,$fn=64,center=true);
    
rotate([0,90,0])
translate([4.5,-14.8,0])
    cylinder(d=1.9, h=7,$fn=64,center=true);
}

>>>>>>> 6ba4f831a47f9250e554edcb417541663869e740
