


sidex=120;
sidey=10;
height=20;

difference() {
// Long side
union() {

cube([sidex,sidey,height], center=true);    
// Short side
translate([30, 0, 0])
    cube([9.6, 69.6, 20], center=true);   
translate([-30, 0, 0])
    cube([9.6, 69.6, 20], center=true);   

    }
    
translate([0, 0, 5.2])
    cube([93.3, 57.3, 20], center=true);  
translate([-55, 0, 0])
    cylinder(d=3.4, h=70,$fn=64,center=true); 

translate([55, 0, 0])
    cylinder(d=3.4, h=70,$fn=64,center=true); 
translate([55, 0, -10])
    cylinder(d=2*(5.5+0.4) / sqrt(3), h=5,$fn=6, center=true);
 
translate([-55, 0, -10])
    cylinder(d=2*(5.5+0.4) / sqrt(3), h=5,$fn=6, center=true);

}