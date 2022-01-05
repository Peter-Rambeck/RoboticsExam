package core

interface Component2Dto3D : Component3D
{
    fun add(child: Component2D) : Component2Dto3D
}