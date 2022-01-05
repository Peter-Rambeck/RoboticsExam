package core

class CoreImpl : Core
{
    override fun cylinder(diameter: Double, height: Double, angular_resolution: Int): Component3D
    {
        return Cylinder(diameter, height, angular_resolution)
    }

    override fun translate(x: Double, y: Double, z: Double): Component3Dto3D
    {
        return Translate3D(x,y,z)
    }

    override fun union(): Component3Dto3D
    {
        return Union()
    }

    override fun color(color: String): Component3Dto3D
    {
        return Color(color)
    }

    override fun hex_width_to_diameter(width: Double): Double
    {
        return 2*width/Math.sqrt(3.0)
    }
}