package core

interface Core
{

    //2D shapes
    //fun circle(diameter: Double, angular_resolution: Double) : Component2D
    //fun rectangle(size_x: Double, size_y:Double)

    //2D transformations
    //fun translate(size_x: Double, size_y: Double) : Component2Dto2D
    //fun translate(v : Vector2) : Component2Dto2D

    //2D to 3D
    //ToDo: linear_extrude()
    //ToDo: rotate_extrude()

    //2D text
    //ToDo: text()


    //3D shapes
    //fun sphere(diameter: Double, angular_resolution: Int) : Component3D
    //fun box(size_x: Double, size_y: Double, size_z: Double) : Component3D
    fun cylinder(diameter: Double, height: Double, angular_resolution: Int) : Component3D
    //fun cone(bottom_diameter: Double, top_diameter: Double, angular_resolution: Int) : Component3D
    //fun torus(diameter: Double, tube_diameter: Double, angular_resolution: Int) : Component3D

    //3D transformations
    fun translate(x: Double, y: Double, z: Double) : Component3Dto3D
    //fun translate(v: Vector3) : Component3Dto3D
    //fun rotate(x: Double, y: Double, z: Double) : Component3Dto3D
    //fun scale(x: Double, y: Double, z: Double) : Component3Dto3D

    //3D CSG
    fun union() : Component3Dto3D
    //fun difference() : Component3Dto3D
    //fun intersection() : Component3Dto3D

    //color
    fun color(color: String) : Component3Dto3D
    //fun color(r: Int, g: Int, b: Int) : Component3Dto3D
    //fun color(r: Int, g: Int, b: Int, a: Int) : Component3Dto3D

    //3D to 2D
    //fun project(cut: Boolean) : Component3Dto2D
    //ToDo: fun mirror()

    //Helper functions
    //fun hex_diameter_to_width(diameter: Double) : Double
    fun hex_width_to_diameter(width : Double) : Double

}