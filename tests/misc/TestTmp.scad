use <TestTmp2.scad>


    
function Assembled_Parts() = Flatten
(
    [
        //Extend_Part_Type("Assembled", Frame_Parts())
    ]  
);

function All_Parts() = Flatten
    (
        [
            Assembled_Parts(),
            //Laser_Cut_Parts(),
            //Machined_Parts(),
            //Printed_Parts(),
            //Sourced_Parts()
        ]
    );

__all_parts_list = All_Parts();
    
echo(__all_parts_list);