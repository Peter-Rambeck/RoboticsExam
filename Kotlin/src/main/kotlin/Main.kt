import core.Component3D
import core.CoreImpl
import obs.HexBolt
import java.io.File

fun main()
{
    val M3x22 = HexBolt(3.0,
            22.0,
            22.0,
            5.5,
            3.0)
    val lib = CoreImpl()
    val bolt = M3x22.build(lib)
    val cb = CodeBuilderImp()
    bolt.getCode(cb)
    val fileName = "C:/tmp/output.scad"
    val file = File(fileName)
    file.writeText(cb.getCode())
    println(fileName)
    print(cb.getCode())
}