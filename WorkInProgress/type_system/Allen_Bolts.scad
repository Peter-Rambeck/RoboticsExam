use <type_system.scad>

/////////////////////////////////////////////////////////////////////////////////////////
// Definition of allen_bolts
/////////////////////////////////////////////////////////////////////////////////////////

name = "allen_bolts";

description = "Metric bolts with a round head with a hole for an allen key";

value_types = // name, type, description
[
    ["diameter", "number", "diameter of the bolt"],
    ["length", "number", "length of the bolt (whitout the head)"],
    ["thread_length", "number", "the length of the thread"],
    ["head_diameter","number", "the diameter of the head"],
    ["head_height", "number", "the height of the head"],
    ["key_hole_width", "number", "the width of the key hole (allen key size)"],
    ["key_hole_depth", "number", "the depth of the key hole"],
];

instances =
[
    ["M3x4",    [3, 4, 4, 5.5, 2, 2.5, 2]   ],
    ["M3x5",    [3, 5, 5, 5.5, 2, 2.5, 2]   ],
    ["M3x6",    [3, 6, 6, 5.5, 2, 2.5, 2]   ],
    ["M3x8",    [3, 8, 8, 5.5, 2, 2.5, 2]   ],
    ["M3x10",   [3, 10, 10, 5.5, 2, 2.5, 2] ],
    ["M3x12",   [3, 12, 12, 5.5, 2, 2.5, 2] ],
    ["M3x14",   [3, 14, 14, 5.5, 2, 2.5, 2] ],
    ["M3x16",   [3, 16, 16, 5.5, 2, 2.5, 2] ],
    ["M3x18",   [3, 18, 18, 5.5, 2, 2.5, 2] ],
    ["M3x20",   [3, 20, 20, 5.5, 2, 2.5, 2] ],
    ["M3x22",   [3, 22, 22, 5.5, 2, 2.5, 2] ],
    ["M3x25",   [3, 25, 15, 5.5, 2, 2.5, 2] ],
    ["M3x30",   [3, 30, 15, 5.5, 2, 2.5, 2] ],
    ["M3x35",   [3, 35, 15, 5.5, 2, 2.5, 2] ],
    ["M3x40",   [3, 40, 15, 5.5, 2, 2.5, 2] ],
    ["M3x45",   [3, 45, 15, 5.5, 2, 2.5, 2] ],
    ["M3x50",   [3, 50, 15, 5.5, 2, 2.5, 2] ],
];

////////////////////////////////////////////////////////////////////////////////////
// Tasks
////////////////////////////////////////////////////////////////////////////////////
// List of tasks [task_name, parameters]
// parameters are provided when the instance is created for a specific task.
////////////////////////////////////////////////////////////////////////////////////
// examples of tasks:
// RENDER               - Just show the item 
// ASSEMBLE             - Generate for use in an assembly and make BOM
// PRINT                - Create 3D geometry for 3D printing
// LASER_CUT            - Create 2D geometry for laser cutting
// GEOMETRY             - create 3d geometry of this component to use in 3D printed components.   


Tasks =
[
    [
        "RENDER",
        [
            ["angular_resolution", "number", 32, "the angular resolution of the rendering"],
            ["create_thread", "boolean", true, "set to false to skip creation of the thread"]  
        ]
    ],
    
    [
        "ASSEMBLE",
        [
            ["assembly_path", "string", "", "Path from where this item is requested"],
            ["detail_level", "number", 100, "0 is missing, anything above 10 is full detail"],  
        ]
    ],
    
    [
        "PRINT",
        [
            ["angular_resolution", "number", 32, "the angular resolution of the rendering"],
            ["create_thread", "boolean", true, "set to false to skip creation of the thread"],  
            ["line_width", "number", 0.4, "the printing line width"],
            ["layer_height", "number", 0.2, "the printing layer height"],
            ["fit_diameter", "number", 0.0, "extra fitting"],
            ["fit_length", "number", 0.0, "extra fitting"],
            ["fit_head_diameter", "number", 0.0, "extra fitting"],
            ["fit_key_hole_diameter", "number", 0.0, "extra fitting"],
            ["fit_key_hole_depth", "number", 0.0, "extra fitting"],
            ["create_thread", "boolean", true, "set to false to skip creation of the thread"],
            ["fit_thread_depth", "number", 0.0, "extra fitting"],
            ["fit_thread_width", "number", 0.0, "extra fitting"]
        ]
    ],

    [
        "GEOMETRY",
        [
            ["angular_resolution", "number", 32, "the angular resolution of the rendering"],
            ["create_thread", "boolean", true, "set to false to skip creation of the thread"],  
            ["fit_diameter", "number", 0.0, "extra fitting"],
            ["fit_length", "number", 0.0, "extra fitting"],
            ["fit_head_diameter", "number", 0.0, "extra fitting"],
            ["fit_key_hole_diameter", "number", 0.0, "extra fitting"],
            ["fit_key_hole_depth", "number", 0.0, "extra fitting"],   
            ["fix_overhang", "boolean", false, "creates a cone under the head of the bolt"],
            ["fix_overhang_angle", "number", 45, "steepness of the overhang fix"], 
            ["head_extend", "number", 0, "extends the head by this amount"],
            ["thread extend", "number", 0, "extends the thread by this amount"],
            
        ]
    ]
];
    


/////////////////////////////////////////////////////////////////////////////////////////
// End of definition
/////////////////////////////////////////////////////////////////////////////////////////

function Allen_Bolts() =
    create_type(name, description, value_types, tasks, instances);
    