package core

import CodeBuilder

class Cylinder(val diameter: Double, val height:Double, val angular_resolution: Int) : Component3D
{
    override fun getCode(cb: CodeBuilder)
    {
        cb.addLine("cylinder(d = $diameter, h = $height, \$fn=$angular_resolution);")
    }
}
