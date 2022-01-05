use <./Parts.scad>
use <parts/Parts_Functions.scad>

Echo_Part_Type("Allen_Bolt_M3x25");
Echo_Part_Values("Allen_Bolt_M3x25");

echo(Project_Parts());

part = Find_Part("Allen_Bolt_M3x25", Project_Parts());

echo(Full_Name(part));

Part("Allen_Bolt_M3x25");

echo(Part_To_Str(part));