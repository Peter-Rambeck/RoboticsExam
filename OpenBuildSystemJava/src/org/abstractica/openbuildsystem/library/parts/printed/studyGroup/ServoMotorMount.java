package org.abstractica.openbuildsystem.library.parts.printed.studyGroup;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Math.sqrt;


public class ServoMotorMount {

    private Geometry3D geometry3D;
    double radiusDiameter = 2*(5.5+0.4) / sqrt(3);

    // For inf. when center=false
    int adjustX = -35;
    int adjustY = 5;
    double AdjustZ = -2.5;

    // Screw attachments
    int screwLength = 30;
    double screwSmallSize = 3.4;
    int screwM3Length = 4;
    double screwM3Size = 2*(5.5+0.4) / sqrt(3);
    int screwFragments = 64;

    // Main cube
    int mainCubeX = 10;
    int mainCubeY = 60;
    int mainHeight = 20;

    /*

    // Cylinder center hole for hull function
    double centerHoleHeight = 5;
    double centerHoleRadus = 6;
    int centerHoleFragments = 64;

    // Cylinder left and right cone
    double leftAndRightHoleHeight = 5;
    double leftAndRightHoleDiameter = 4;
    int leftAndRightHoleFragments = 64;

    // Cylinder center hole for motor fit
    double centerHoleMotorHeight = 5;
    double centerHoleMotorRadius = 7.4;
    int centerHoleMotorFragments = 64;


     */


    public ServoMotorMount() throws IOException {

        Node3D res = Core.difference3D();

        // Main long cube
        Geometry3D mainCube = Core.box3D(
                mainCubeX,
                mainCubeY,
                mainHeight);
        Node3D translateMainCube = Core.translate3D(-5, -30, -10);
        translateMainCube.add(mainCube);
        res.add(translateMainCube);

        Geometry3D exertMainCube = Core.box3D(
                11,
                23.1,
                12.2);
        Node3D translateExertMainCube = Core.translate3D(-11/2.0, -23.1/2, -1.2);
        translateExertMainCube.add(exertMainCube);
        res.add(translateExertMainCube);

        Geometry3D exertMotorWings = Core.box3D(
                1.9,
                32.4,
                12.2);
        Node3D translateExertMotorWings = Core.translate3D(4.2, -32.4/2, -1.2);
        translateExertMotorWings.add(exertMotorWings);
        res.add(translateExertMotorWings);

        // Cylinder hole left side
        Geometry3D holeLeft = Core.cylinder3D(radiusDiameter, 5, 6);
        Node3D translateholeLeft = Core.translate3D(0, -25, 7.5);
        translateholeLeft.add(holeLeft);
        res.add(translateholeLeft);

        // Cylinder Screw hole left side
        Geometry3D ScrewHoleLeft = Core.cylinder3D(3.4, 70, 64);
        Node3D translateScrewHoleLeft = Core.translate3D(0, -25, -11);
        translateScrewHoleLeft.add(ScrewHoleLeft);
        res.add(translateScrewHoleLeft);

        // Cylinder Screw hole for Motorarm left side
        Geometry3D ScrewHoleMotorarmLeft = Core.cylinder3D(1.9, 7, 6);
        Node3D translateScrewHoleMotorarmLeft = Core.translate3D(-4.5, -14.8, 0);
        translateScrewHoleMotorarmLeft.add(ScrewHoleMotorarmLeft);

        Node3D rotateScrewHoleMotorarmLeft = Core.rotate3D(0, 90, 0);
        rotateScrewHoleMotorarmLeft.add(translateScrewHoleMotorarmLeft);
        res.add(rotateScrewHoleMotorarmLeft);


        // Cylinder hole right side
        Geometry3D holeRight = Core.cylinder3D(radiusDiameter, 5, 6);
        Node3D translateholeRight = Core.translate3D(0, 25, 7.5);
        translateholeRight.add(holeRight);
        res.add(translateholeRight);

        // Cylinder Screw hole left side
        Geometry3D ScrewHoleRight = Core.cylinder3D(3.4, 70, 64);
        Node3D translateScrewHoleRight = Core.translate3D(0,    25, -11);
        translateScrewHoleRight.add(ScrewHoleRight);
        res.add(translateScrewHoleRight);

        // Cylinder Screw hole for Motorarm right side
        Geometry3D ScrewHoleMotorarmRight = Core.cylinder3D(1.9, 7, 6);
        Node3D translateScrewHoleMotorarmRight = Core.translate3D(-4.5, 14.8, 0);
        translateScrewHoleMotorarmRight.add(ScrewHoleMotorarmRight);

        Node3D rotateScrewHoleMotorarmRight = Core.rotate3D(0, 90, 0);
        rotateScrewHoleMotorarmRight.add(translateScrewHoleMotorarmRight);
        res.add(rotateScrewHoleMotorarmRight);


        codeBuilder(res);
}

        public void codeBuilder(Geometry3D res) throws IOException {
            geometry3D = res;
            CodeBuilder cb = new CodeBuilder();
            OpenSCADGenerator.generate(cb, res);
            Path path = Paths.get("ServoMotorMount.scad");
            Files.writeString(path, cb.toString());
        }

    public static void main(String[] args) throws IOException {
        ServoMotorMount servoMotorMount = new ServoMotorMount();
        }
    }






