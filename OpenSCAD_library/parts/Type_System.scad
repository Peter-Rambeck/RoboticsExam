//Part layout:
//[Full_Name, type, values]
// Full name of type: "sources/fasteners/bolts/allen_bolts/M3x25"
// Type: ["]


function _rec_get_first_name(i, stop, res, part_name) = 
    i == stop ? part_name :
        part_name[i] == "/" ? 

// Type system helper functions

part_name = "sourced/fasteners/bolts/hex_bolts/M3x25";

first = _get_first_name(part_name);


echo(first);