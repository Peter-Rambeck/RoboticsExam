use <parts/Part_Functions.scad>
use <parts/assembled/Assembler_Part_Provider.scad>

//The instances has been seperated out in a seperate file
include <XYZ_Frames_Parts.scad>

module __XYZ_Frames_Request_Handler(type, request, part_id, values, params, allowed_parts_list)
{
    if(type != "END")
    {
        echo("__XYZ_Frames__Request_Handler got wrong type:", type);
    }
    else
    {
        __XYZ_Frame_Generator(request, part_id, values, params, allowed_parts_list)
    }
}

module __XYZ_Frame_Generator(request, part_id, values, params, allowed_parts_list)
{

    unit = Get_Value("unit", values);
    rod_x = Get_Value("rod_x", values);
    rod_y = Get_Value("rod_y", values);
    rod_z = Get_Value("rod_z", values);
    bolt = Get_Value("bolt", values);
    washer = Get_Value("washer", values);
    nut = Get_Value("nut", values);
    rod_x_part = Find_Part(rod_x, allowed_parts_list);
    rod_y_part = Find_Part(rod_y, allowed_parts_list);
    rod_z_part = Find_Part(rod_z, allowed_parts_list);
    washer_part = Find_Part(washer, allowed_parts_list);
    size_x = Get_Value("length", __values(rod_x_part));
    size_y = Get_Value("length", __values(rod_y_part));
    size_z = Get_Value("length", __values(rod_z_part));
    washer_height = Get_Value("height", __values(rod_z_part))
    echo("Building frame", size_x, size_y, size_z);
  
    union()
    {
        translate([0,unit,0])
        __make_frame(   size_x = size_x,
                        size_y = size_y,
                        size_z = size_z,
                        unit = unit)
        {
            translate([0,0,-0.5*unit])
            Get_Part(allowed_parts_list, rod_x_part);
            translate([0,0,-0.5*unit])
            Get_Part(allowed_parts_list, rod_y_part);
            translate([0,0,-0.5*unit])
            Get_Part(allowed_parts_list, rod_z_part);
            
            translate([0,0,0.5*unit])
            {
                //Bolt
                translate([0,0,washer_height])
                Get_Part_From_ID(allowed_parts_list, bolt);
                
                //Top washer
                Get_Part(allowed_parts_list, washer_part);
                
                //Bottom washer
                translate([0,0,-2*unit])
                rotate([180,0,0])
                Get_Part(allowed_parts_list, washer_part);
                
                //Nut
                translate([0,0,-2*unit-washer_height])
                rotate([180,0,0])
                Get_Part_From_ID(allowed_parts_list, nut);
            }
        }
    }
}


module __make_frame(size_x, size_y, size_z, unit)
{
    /////////////////////////////////////////////////
    translate([0.5*unit,0,0])
    rotate([0,90,0])
    children(0);
    
    translate([0.5*unit,unit*(size_y-3),0])
    rotate([0,90,0])
    children(0);
    
    translate([0.5*unit,0,unit*(size_z-1)])
    rotate([0,90,0])
    children(0);
    
    translate([0.5*unit,unit*(size_y-3),unit*(size_z-1)])
    rotate([0,90,0])
    children(0);
    
    
    //////////////////////////////////////////////////
    translate([unit,-0.5*unit,unit])
    rotate([-90,0,0])
    children(1);
    
    translate([unit*(size_x-2),-0.5*unit,unit])
    rotate([-90,0,0])
    children(1);
    
    translate([unit,-0.5*unit,unit*(size_z-2)])
    rotate([-90,0,0])
    children(1);
    
    translate([unit*(size_x-2),-0.5*unit,unit*(size_z-2)])
    rotate([-90,0,0])
    children(1);
    
    //////////////////////////////////////////////////////
    translate([0,-unit,0.5*unit])
    children(2);
    
    translate([unit*(size_x-1),-unit, 0.5*unit])
    children(2);
    
    translate([0,unit*(size_y-2),0.5*unit])
    children(2);
    
    translate([unit*(size_x-1),unit*(size_y-2),0.5*unit])
    children(2);
    
    ////////////////////////////////////////
    translate([unit,0,0])
    rotate([180,0,0])
    children(3);
    
    translate([unit*(size_x-2),0,0])
    rotate([180,0,0])
    children(3);
    
    translate([unit,unit*(size_y-3),0])
    rotate([180,0,0])
    children(3);
    
    translate([unit*(size_x-2),unit*(size_y-3),0])
    rotate([180,0,0])
    children(3);
    
    ///////////////////////////////////////////7
    translate([unit,0,unit*(size_z-1)])
    children(3);
    
    translate([unit*(size_x-2),0,unit*(size_z-1)])
    children(3);
    
    translate([unit,unit*(size_y-3),unit*(size_z-1)])
    children(3);
    
    translate([unit*(size_x-2),unit*(size_y-3),unit*(size_z-1)])
    children(3);
    
    ////////////////////////////////////////
    translate([0,-unit,0])
    rotate([90,0,0])
    children(3);
    
    translate([unit*(size_x-1),-unit,0])
    rotate([90,0,0])
    children(3);
    
    translate([0,-unit,unit*(size_z-1)])
    rotate([90,0,0])
    children(3);
    
    translate([unit*(size_x-1),-unit,unit*(size_z-1)])
    rotate([90,0,0])
    children(3);
    
    //////////////////////////////////////
    
    translate([0,unit*(size_y-2),0])
    rotate([-90,0,0])
    children(3);
    
    translate([unit*(size_x-1),unit*(size_y-2),0])
    rotate([-90,0,0])
    children(3);
    
    translate([0,unit*(size_y-2),unit*(size_z-1)])
    rotate([-90,0,0])
    children(3);
    
    translate([unit*(size_x-1),unit*(size_y-2),unit*(size_z-1)])
    rotate([-90,0,0])
    children(3);
    
    //////////////////////////////////////
    
    translate([0,-unit,unit])
    rotate([0,-90,0])
    children(3);
    
    translate([0,unit*(size_y-2),unit])
    rotate([0,-90,0])
    children(3);
    
    translate([0,-unit,unit*(size_z-2)])
    rotate([0,-90,0])
    children(3);
    
    translate([0,unit*(size_y-2),unit*(size_z-2)])
    rotate([0,-90,0])
    children(3);
    
    //////////////////////////////////////
    
    translate([unit*(size_x-1),-unit,unit])
    rotate([0,90,0])
    children(3);
    
    translate([unit*(size_x-1),unit*(size_y-2),unit])
    rotate([0,90,0])
    children(3);
    
    translate([unit*(size_x-1),-unit,unit*(size_z-2)])
    rotate([0,90,0])
    children(3);
    
    translate([unit*(size_x-1),unit*(size_y-2),unit*(size_z-2)])
    rotate([0,90,0])
    children(3);
}