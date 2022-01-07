package org.abstractica.openbuildsystem.library.parts.printed.Motors;

import org.abstractica.openbuildsystem.core.*;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import static java.lang.Math.sqrt;

public class MotorHolderBigTop {

    private final Geometry3D geometry3D;

    int sidex=30;
    int sidey=30;
    int height=10;
    double cylinder_small=3.4;
    double cylinder_big=2*(5.5+0.4) / sqrt(3);
    int screw_head_height=1 ;
    int edges=6;
    double screw_head_m3 = 5.8;



    public MotorHolderBigTop() throws IOException {

        CodeBuilder cb = new CodeBuilder();

        //Main Cube
        Node3D unity = Core.union3D();
        // DeezNutz DZ = 69.420
        Geometry3D cube = Core.box3D(sidex, sidey, height);
        Node3D res = Core.difference3D();
        Node3D res2 = Core.difference3D();
        Node3D res3 = Core.difference3D();
        unity.add(res);
        unity.add(res2);
        unity.add(res3);
        Node3D cubePos = Core.translate3D(-15, -25, -5);
        cubePos.add(cube);
        res.add(cubePos);

        //Top Strange Hole :\/
        Geometry3D cylinderStr = Core.cylinder3D(cylinder_big, 20, edges);
        Node3D rotationStrangeHole = Core.rotate3D(0, 90, 0);
        Node3D strangePos = Core.translate3D(-30.1, -20, 0);
        rotationStrangeHole.add(cylinderStr);
        strangePos.add(rotationStrangeHole);
        res.add(strangePos);

        //Big Motor Hole
        Geometry3D motorHole = Core.cylinder3D(9.0, 20, 64);
        Node3D motorHolePos = Core.translate3D(0, 0, -10);
        motorHolePos.add(motorHole);
        res.add(motorHolePos);

        //Jenks.isGaming

        //Motor Holes
        Geometry3D motorHoleSmall = Core.cylinder3D(cylinder_small, 100, 64);
        Geometry3D motorHoleBig = Core.cylinder3D(screw_head_m3, 100, 64);
        Node3D right = Core.translate3D(8.5, 0, 0);
        Node3D left = Core.translate3D(-8.5, 0, 0);
        Node3D rightSMall = Core.translate3D(8.5, 0, -5.1);
        Node3D leftSMall = Core.translate3D(-8.5, 0, -5.1);
        rightSMall.add(motorHoleSmall);
        leftSMall.add(motorHoleSmall);
        right.add(motorHoleBig);
        left.add(motorHoleBig);
        res.add(rightSMall);
        res.add(leftSMall);
        res.add(right);
        res.add(left);

        //Side Holes
        Geometry3D sideholeMiddle = Core.cylinder3D(cylinder_small, 70, 64);
        Node3D sideHolMidPos = Core.translate3D(-12, -20, 0);
        Node3D rotateMidHol = Core.rotate3D(90, 0, 90);
        rotateMidHol.add(sideholeMiddle);
        sideHolMidPos.add(rotateMidHol);
        res.add(sideHolMidPos);
        //Big hole
        Geometry3D bigFeetHole = Core.cylinder3D(screw_head_m3, height, 64);
        Node3D feetHolPos = Core.translate3D(10, -20, 0);
        Node3D feetRot = Core.rotate3D(90, 0, 90); 
        feetRot.add(bigFeetHole);
        feetHolPos.add(feetRot);
        res.add(feetHolPos);

        //Feet
        Geometry3D feet = Core.box3D(30, 10, 10);
        Node3D feetPos = Core.translate3D(-15, -25, -14.9999);
        feetPos.add(feet);
        res2.add(feetPos);
        Geometry3D feetSpace2 = Core.box3D(10.2, 16.2, 25.2);
        Node3D feetSpPos2 = Core.translate3D(-5.0000, -31.150, -18);
        feetSpPos2.add(feetSpace2);
        res.add(feetSpPos2);
        Geometry3D feetSpace = Core.box3D(10.2, 20.2, 20.2);
        Node3D feetSpPos = Core.translate3D(-5.0000, -31.150, -18);
        feetSpPos.add(feetSpace);
        res2.add(feetSpPos);


        //Feet Holes
        //
        Geometry3D cylinderStr2 = Core.cylinder3D(cylinder_big, 20, edges);
        Node3D rotationStrangeHole2 = Core.rotate3D(0, 90, 0);
        Node3D strangePos2 = Core.translate3D(-30.1, -20, -10);
        rotationStrangeHole2.add(cylinderStr2);
        strangePos2.add(rotationStrangeHole2);
        res2.add(strangePos2);
        //
        Geometry3D bigFeetHole2 = Core.cylinder3D(screw_head_m3, height, 64);
        Node3D feetHolPos2 = Core.translate3D(10, -20, -10);
        Node3D feetRot2 = Core.rotate3D(90, 0, 90); 
        feetRot2.add(bigFeetHole2);
        feetHolPos2.add(feetRot2);
        res2.add(feetHolPos2);
        //        
        Geometry3D sideholeMiddle2 = Core.cylinder3D(cylinder_small, 70, 64);
        Node3D sideHolMidPos2 = Core.translate3D(-12, -20, -10);
        Node3D rotateMidHol2 = Core.rotate3D(90, 0, 90);
        rotateMidHol2.add(sideholeMiddle2);
        sideHolMidPos2.add(rotateMidHol2);
        res2.add(sideHolMidPos2);


        geometry3D = unity;
        OpenSCADGenerator.generate(cb, unity);
        Path path = Paths.get("motorholderbigtop.scad");
        Files.writeString(path, cb.toString());

    }

    public static void main(String[] args) throws IOException {

        MotorHolderBigTop bigtop = new MotorHolderBigTop();

    }
}