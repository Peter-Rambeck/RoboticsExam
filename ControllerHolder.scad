seks_komma_otte = 2*(5.5+0.4) / sqrt(3);


//forhøjning 1
difference(){
translate([6,5,6.9])
    cylinder(h=3,d=7,$fn=64);
translate([6,5,0])
    cylinder(h=100,d=3.4,$fn=64);
}

//forhøjning 2
difference(){
translate([49.5,5,6.9])
    cylinder(h=3,d=7,$fn=64);
translate([49.5,5,0])
    cylinder(h=100,d=3.4,$fn=64);
}

//forhøjning 3
difference(){
translate([49.5,33.5,6.9])
    cylinder(h=3,d=7,$fn=64);
translate([49.5,33.5,0])
    cylinder(h=100,d=3.4,$fn=64);
}

//forhøjning 4
difference(){
translate([6,20.5,6.9])
    cylinder(h=3,d=7,$fn=64);
translate([6,20.5,0])
    cylinder(h=100,d=3.4,$fn=64);
}

difference(){
cube([60,50,7]);

//Skrue huller

    translate([5,45,-0.1])
cylinder(h=10,d=3.4,$fn=64);
    
    translate([55,45,-0.1])
cylinder(h=10,d=3.4,$fn=64);
    
  
  
  //SekS Komma Otte Huller  

    
    translate([5,45,4.1])
cylinder(h=3,d=seks_komma_otte,$fn=6);
    
    translate([55,45,4.1])
cylinder(h=3,d=seks_komma_otte,$fn=6);

    
    //plade huller
        translate([6,5,-0.1])
cylinder(h=3,d=seks_komma_otte,$fn=6);
        translate([6,5,0])
cylinder(h=100,d=3.4,$fn=64);

        translate([49.5,5,-0.1])
cylinder(h=3,d=seks_komma_otte,$fn=6);
        translate([49.5,5,0])
cylinder(h=100,d=3.4,$fn=64);
    
         translate([49.5,33.5,-0.1])
cylinder(h=3,d=seks_komma_otte,$fn=6);
        translate([49.5,33.5,0])
cylinder(h=100,d=3.4,$fn=64);
    
         translate([6,20.5,-0.1])
cylinder(h=3,d=seks_komma_otte,$fn=6);
        translate([6,20.5,0])
cylinder(h=100,d=3.4,$fn=64);
}