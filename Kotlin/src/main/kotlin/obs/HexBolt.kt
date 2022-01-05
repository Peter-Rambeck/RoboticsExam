package obs

import CodeBuilder
import core.Builder3D
import core.Component3D
import core.Core

class HexBolt(val diameter: Double,
              val length: Double,
              val thread_length: Double,
              val head_width: Double,
              val head_height: Double) : Builder3D<Core>
{
    override fun build(lib: Core): Component3D
    {
        val res = lib.union()
        //Non-threaded part
        if (thread_length < length)
        {
            var non_thread = lib.cylinder(diameter, length - thread_length, 32)
            non_thread = lib.color("silver").add(non_thread)
            res.add(non_thread)
        }
        //Threaded part
        var thread =  lib.cylinder(diameter, thread_length, 32)
        thread = lib.color("grey").add(thread)
        thread = lib.translate(0.0, 0.0, length - thread_length).add(thread)
        //Head
        var head = lib.cylinder(lib.hex_width_to_diameter(head_width), head_height, 6)
        head = lib.color("silver").add(head)
        head =  lib.translate(0.0, 0.0, -head_height).add(head)
        res.add(thread)
        res.add(head)
        return res
    }
/*
    override fun build(lib: Core): Component3D
    {
        val res = lib.union()
        //Non-threaded part
        if (thread_length < length)
        {
            res.add(
                    lib.color("silver").add(
                            lib.cylinder(diameter, length - thread_length, 32)
                    )
            )
        }
        //Threaded part
        res.add(
                lib.translate(0.0, 0.0, length - thread_length).add(
                        lib.color("grey").add(
                                lib.cylinder(diameter, thread_length, 32)
                        )
                )
        )
        //Head
        res.add(
                lib.translate(0.0, 0.0, -head_height).add(
                        lib.color("silver").add(
                                lib.cylinder(lib.hex_width_to_diameter(head_width), head_height, 6)
                        )
                )
        )
        return res
    }
    */
}