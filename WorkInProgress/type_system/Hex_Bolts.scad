use <type_system.scad>

/////////////////////////////////////////////////////////////////////////////////////////
// Definition of metric hex bolts
/////////////////////////////////////////////////////////////////////////////////////////

name = "hex_bolts";

description = "Standard metric bolts with a hexagonal head";

value_types = // name, type, description
[
    ["diameter", "number", "diameter of the bolt"],
    ["length", "number", "length of the bolt (whitout the head)"],
    ["thread_length", "number", "the length of the thread"],
    ["head_width","number", "the width of the head (wrench size)"],
    ["head_height", "number", "the height of the head"],
];

// parameters are provided when the instance is created.
param_types = // name, type, default value, description]
[
    ["angular_resolution", "number", "32", "the angular resolution of the rendering"],
    ["create_thread", "boolean", "true", "set to false to skip creation of the thread"]  
];

instances =
[
    ["M3x4",    [3, 4, 4, 5.5, 2]   ],
    ["M3x5",    [3, 5, 5, 5.5, 2]   ],
    ["M3x6",    [3, 6, 6, 5.5, 2]   ],
    ["M3x8",    [3, 8, 8, 5.5, 2]   ],
    ["M3x10",   [3, 10, 10, 5.5, 2] ],
    ["M3x12",   [3, 12, 12, 5.5, 2] ],
    ["M3x14",   [3, 14, 14, 5.5, 2] ],
    ["M3x16",   [3, 16, 16, 5.5, 2] ],
    ["M3x18",   [3, 18, 18, 5.5, 2] ],
    ["M3x20",   [3, 20, 20, 5.5, 2] ],
    ["M3x22",   [3, 22, 22, 5.5, 2] ],
    ["M3x25",   [3, 25, 15, 5.5, 2] ],
    ["M3x30",   [3, 30, 15, 5.5, 2] ],
    ["M3x35",   [3, 35, 15, 5.5, 2] ],
    ["M3x40",   [3, 40, 15, 5.5, 2] ],
    ["M3x45",   [3, 45, 15, 5.5, 2] ],
    ["M3x50",   [3, 50, 15, 5.5, 2] ],
];

/////////////////////////////////////////////////////////////////////////////////////////
// End of definition
/////////////////////////////////////////////////////////////////////////////////////////

function Hex_Bolts() =
    create_type(name, description, value_types, param_types, instances);
    