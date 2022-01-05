function str_index_of(string, char) =
    _rec_str_index_of(0, len(string), string, char);
function _rec_str_index_of(i, stop, string, char) = 
  i == stop ? -1 :
    char == string[i] ? i :
        _rec_str_index_of(i+1, stop, string, char);
        
function str_rest(string, from) = _rec_str_rest(from, len(string), "", string);
function _rec_str_rest(i, stop, acc, string) =
    i >= stop ? acc :
        _rec_str_rest(i+1, stop, str(acc, string[i]), string);

function str_first(string, char) = _rec_str_first(0, len(string), "", string, char);
function _rec_str_first(i, stop, acc, string, char) =
    i == stop ? string :
        char == string[i] ? acc :
            _rec_str_first(i+1, stop, str(acc, string[i]), string, char);
 
function str_split_first(string, char) =
    let(pos = str_index_of(string, char))
        pos < 0 ? [string, ""] :
        [str_first(string, char), str_rest(string, pos + 1)];
        
function build_tree_from_name(part_name) =
    part_name == "" ? [] :
        let(pair = str_split_first(part_name,"/"))
        [pair[0], build_tree_from_name(pair[1])];
        
function build_name_from_tree(name_tree) =
    name_tree == [] ? "" :
        name_tree[1] == [] ? name_tree[0] :
        str(name_tree[0], "/", build_name_from_tree(name_tree[1]));

echo(str_split_first("adghds/djkdak/bcjs/gdshs", "/"));



name = "sourced/fasteners/bolts/allen_bolts/M3x25";
tree = build_tree_from_name(name);
echo(tree);

name2 = build_name_from_tree(tree);
echo(name2);


        