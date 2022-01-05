// Data values
function XYZ_Frame_Parts() = Make_Part_List
( "XYZ_Frame",
        ["unit","rod_x","size_x", "rod_y", "size_y", "rod_z", "size_z", "bolt", "washer", "washer_height", "nut"],
[
    [   "XYZ_Frame_Alu10_20x20x20",
        [
            10,                         // unit
            "Alu10_Rect_Rod_1x1x20",    // rod_x
            20,                         // size_x
            "Alu10_Rect_Rod_1x1x20",    // rod_y
            20,                         // size_y
            "Alu10_Rect_Rod_1x1x20",    // rod_z
            20,                         // size_z
            "Hex_Bolt_M3x25",           // bolt (must be able to span 2 * unit)
            "M3_Small_Washer",          // Washer
            0.5,                        // Washer height
            "M3_Hex_Nut"                // Nut
        ]
    ],
    [   "XYZ_Frame_Alu10_20x12x6",
        [
            10,                         // unit
            "Alu10_Rect_Rod_1x1x20",    // rod_x
            20,                         // size_x
            "Alu10_Rect_Rod_1x1x12",    // rod_y
            12,                         // size_y
            "Alu10_Rect_Rod_1x1x6",     // rod_z
            6,                          // size_z
            "Allen_Bolt_M3x25",         // bolt (must be able to span 2 * unit)
            "M3_Small_Washer",          // Washer
            0.5,                        // Washer height
            "M3_Hex_Nut"                // Nut
        ]
    ],
    [   "XYZ_Frame_Alu10_10x20x30",
        [
            10,                         // unit
            "Alu10_Rect_Rod_1x1x10",    // rod_x
            10,                         // size_x
            "Alu10_Rect_Rod_1x1x20",    // rod_y
            20,                         // size_y
            "Alu10_Rect_Rod_1x1x30",    // rod_z
            30,                         // size_z
            "Hex_Bolt_M3x25",           // bolt (must be able to span 2 * unit)
            "M3_Small_Washer",          // Washer
            0.5,                        // Washer height
            "M3_Hex_Nut"                // Nut
        ]
    ]
]);  