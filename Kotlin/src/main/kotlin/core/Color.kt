package core

import CodeBuilder

class Color(val colorStr : String) :Component3Dto3D
{
    private val children = mutableListOf<Component3D>()

    override fun add(child: Component3D): Component3Dto3D
    {
        children.add(child)
        return this
    }

    override fun getCode(cb: CodeBuilder)
    {
        cb.addLine("color(\"$colorStr\")")
        cb.addLine("{")
        cb.indent()
        for (child in children)
        {
            child.getCode(cb)
        }
        cb.undent()
        cb.addLine("}")
    }
}