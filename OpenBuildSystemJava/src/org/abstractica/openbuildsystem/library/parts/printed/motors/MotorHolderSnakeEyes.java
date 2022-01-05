package org.abstractica.openbuildsystem.library.parts.printed.Motors;

import org.abstractica.openbuildsystem.core.*;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Math.sqrt;

public class MotorHolderSnakeEyes {

    private final Geometry3D geometry3D;

    int sidex = 30;
    int sidey = 10;
    int height= 10;
    Double cylinder_small=3.4;
    Double cylinder_big=2*(5.5+0.4) / sqrt(3);
    int screw_head_height=1 ;
    int edges=6;
    Double screw_head_m3 = 5.8;



    public MotorHolderSnakeEyes() throws IOException {

        CodeBuilder cb = new CodeBuilder();

        //Main Cube
        Geometry3D cube = Core.box3D(sidex, sidex, sidey);
        Node3D res = Core.difference3D();
        Node3D cubePos = Core.translate3D(-15, -15, -5);
        cubePos.add(cube);
        res.add(cubePos);

        //Middle Hole
        Geometry3D bigMiddleHole = Core.cylinder3D(9, 20, 64);
        Node3D holePos = Core.translate3D(0, 0, -5.1);
        holePos.add(bigMiddleHole);
        res.add(holePos);

        //Small Middle Holes
        Geometry3D smallTopsideHole = Core.cylinder3D(cylinder_small, 20, 64);
        Node3D fowrPos = Core.translate3D(-8.5, 0, -5.1);
        Node3D backPos = Core.translate3D(8.5, 0, -5.1);
        fowrPos.add(smallTopsideHole);
        backPos.add(smallTopsideHole);
        res.add(fowrPos);
        res.add(backPos);

        //Bigger Middle Holes
        Geometry3D smallTopBigHole = Core.cylinder3D(screw_head_m3, 20, 64);
        Node3D fowrPosB = Core.translate3D(-8.5, 0, 0);
        Node3D backPosB = Core.translate3D(8.5, 0, 0);
        fowrPosB.add(smallTopBigHole);
        backPosB.add(smallTopBigHole);
        res.add(fowrPosB);
        res.add(backPosB);

        //Big Side Holes
        Geometry3D bigSideHoles = Core.cylinder3D(screw_head_m3, 20, 64);
        Node3D rotating = Core.rotate3D(90, 0, 90);
        Node3D right = Core.translate3D(10, -10, 0);
        Node3D left = Core.translate3D(10, 10, 0);
        rotating.add(bigSideHoles);
        right.add(rotating);
        left.add(rotating);
        res.add(right);
        res.add(left);
        
        //Small Side Holes
        Geometry3D smallSideHoles = Core.cylinder3D(cylinder_small, 70, 64);
        Node3D rotatingSmall = Core.rotate3D(90, 0, 90);
        Node3D rightSmall = Core.translate3D(-50, -10, 0);
        Node3D leftSmall = Core.translate3D(-50, 10, 0);
        rotatingSmall.add(smallSideHoles);
        rightSmall.add(rotatingSmall);
        leftSmall.add(rotatingSmall);
        res.add(rightSmall);
        res.add(leftSmall);
        


        geometry3D = res;
        
        OpenSCADGenerator.generate(cb, res);
        Path path = Paths.get("motorholdersnakeeyes.scad");
        Files.writeString(path, cb.toString());

    }

    public static void main(String[] args) throws IOException {

        MotorHolderSnakeEyes snakeEyes = new MotorHolderSnakeEyes();

    }
}