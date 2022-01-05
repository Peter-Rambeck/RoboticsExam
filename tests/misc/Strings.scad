use <parts/Parts_Functions.scad>

function _frame_text(text) = [];

function Count_Char(char, text) = rec_count_char(0, len(text), 0, char, text);

function rec_count_char(i, stop, sum, char, text) =
    i == stop ? sum : 
        char == text[i] ?   rec_count_char(i + 1, stop, sum + 1, char, text) :
                            rec_count_char(i + 1, stop, sum, char, text);
                           
text = "\n\n\naababf\ngbrfa\nhjgaaa\n\n\n";                           
echo(Count_Char("\n", text));
echo(text);

