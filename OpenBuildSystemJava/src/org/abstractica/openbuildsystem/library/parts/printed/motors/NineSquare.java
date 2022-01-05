package org.abstractica.openbuildsystem.library.parts.printed.motors;

import org.abstractica.openbuildsystem.core.*;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Math.sqrt;

public class NineSquare {

    private final Geometry3D geometry3D;

    int sides = 30;
    int height = 10;
    Double cylinder_small = 3.4;
    Double cylinder_big = 2*(5.5+0.4) / sqrt(3);
    int screw_head_height = 1;
    int edges = 6;



    public NineSquare() throws IOException {

        Geometry3D cube = Core.box3D(sides, sides, height);
        Geometry3D bigHoles = Core.cylinder3D(cylinder_big, 20, edges);
        Geometry3D smallHoles = Core.cylinder3D(cylinder_small, 20, 64);

        Node3D res = Core.difference3D();
        res.add(cube);

        for (int x = 5; x <= 25; x +=10) {
            for (int y = 5; y <= 25; y +=10) {
                Node3D translateBig = Core.translate3D(x, y, screw_head_height);
                translateBig.add(bigHoles);
                res.add(translateBig);

                Node3D translateSmall = Core.translate3D(x, y, -5);
                translateSmall.add(smallHoles);
                res.add(translateSmall);
            }
        }

        geometry3D = res;

        CodeBuilder cb = new CodeBuilder();
        OpenSCADGenerator.generate(cb, res);
        Path path = Paths.get("nineSquare.scad");
        Files.writeString(path, cb.toString());

    }

    public static void main(String[] args) throws IOException {

        NineSquare nineSquare = new NineSquare();

    }
}
