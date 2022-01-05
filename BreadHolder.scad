dumb_number = 2*(5.5+0.4) / sqrt(3);


//Main Cube
difference(){
cube([110,70,12]);
    translate([13.5,7.5,-0.1])
cube([83,55,9]);
    
    //cylinder holes tiny
translate([80.5,62.4,-1])
    cube([3,3,9.9]);
translate([26.5,62.4,-1])
    cube([3,3,9.9]);

translate([96,11,-1])
    cube([3,3,9.9]);
translate([96,33.5,-1])
    cube([3,3,9.9]);
translate([96,56,-1])
    cube([3,3,9.9]);


//Mange huller
translate([5,5,-0.1])
    cylinder(h=124,d=3.4,$fn=64);
translate([5,35,-0.1])
    cylinder(h=124,d=3.4,$fn=64);
translate([5,65,-0.1])
    cylinder(h=124,d=3.4,$fn=64);
      
translate([5,5,-0.1])
    cylinder(h=4,d=dumb_number,$fn=6);
translate([5,35,-0.1])
    cylinder(h=4,d=dumb_number,$fn=6);
translate([5,65,-0.1])
    cylinder(h=4,d=dumb_number,$fn=6); 
   
translate([105,5,-0.1])
    cylinder(h=124,d=3.4,$fn=64);
translate([105,35,-0.1])
    cylinder(h=124,d=3.4,$fn=64);
translate([105,65,-0.1])
    cylinder(h=124,d=3.4,$fn=64);

translate([105,5,-0.1])
    cylinder(h=4,d=dumb_number,$fn=6);
translate([105,35,-0.1])
    cylinder(h=4,d=dumb_number,$fn=6);
translate([105,65,-0.1])
    cylinder(h=4,d=dumb_number,$fn=6);  
}

//Wings
difference(){
translate([-9.99,0,0])
cube([10,30,12]);
translate([-4.99,30.01,7])
    rotate([90,0,0])
    cylinder(h=4,d=dumb_number,$fn=6);
translate([-4.99,30.01,7])
    rotate([90,0,0])
    cylinder(h=100,d=3.4,$fn=64);
}

difference(){ 
translate([109.99,0,0])
cube([10,30,12]);
translate([114.99,30.01,7])
    rotate([90,0,0])
    cylinder(h=4,d=dumb_number,$fn=6);
translate([114.99,30.01,7])
    rotate([90,0,0])
        cylinder(h=100,d=3.4,$fn=64);
}

