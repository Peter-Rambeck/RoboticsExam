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

public class RS370SideMount {

    private final Geometry3D geometry3D;

    int sidex=30;
    int sidey=30;
    int height=10;
    double cylinder_small=3.4;
    double cylinder_big=2*(5.5+0.4) / sqrt(3);
    int screw_head_height=1 ;
    int edges=6;
    double screw_head_m3 = 5.8;



    public RS370SideMount() throws IOException {

        CodeBuilder cb = new CodeBuilder();

        //Main Cube
        Node3D unity = Core.union3D();
        // DeezNutz DZ = 69.420
        Geometry3D cube = Core.box3D(sidex, sidey, height);
        Node3D res = Core.difference3D();
        Node3D res3 = Core.difference3D();
        unity.add(res);
        unity.add(res3);
        Node3D cubePos = Core.translate3D(-15, -25, -5);
        cubePos.add(cube);
        res.add(cubePos);

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

        //Top Strange Holes :\/
        Geometry3D cylinderStr = Core.cylinder3D(cylinder_big, 20, edges);
        Node3D strangePos1 = Core.translate3D(-10, -20, 1);
        Node3D strangePos2 = Core.translate3D(0, -20, 1);
        Node3D strangePos3 = Core.translate3D(10, -20, 1);
        strangePos1.add(cylinderStr);
        strangePos2.add(cylinderStr);
        strangePos3.add(cylinderStr);
        res.add(strangePos1);
        res.add(strangePos2);
        res.add(strangePos3);

        //Side Holes
        Geometry3D sideholeMiddle = Core.cylinder3D(cylinder_small, 70, 64);
        Node3D sideHolMidPos1 = Core.translate3D(-10, -20, -10);
        Node3D sideHolMidPos2 = Core.translate3D(0, -20, -10);
        Node3D sideHolMidPos3 = Core.translate3D(10, -20, -10);
        sideHolMidPos1.add(sideholeMiddle);
        sideHolMidPos2.add(sideholeMiddle);
        sideHolMidPos3.add(sideholeMiddle);
        res.add(sideHolMidPos1);
        res.add(sideHolMidPos2);
        res.add(sideHolMidPos3);



        //Bue
    Geometry3D bue = Core.cylinder3D(14, 10, 64);
    Geometry3D bueHul = Core.box3D(25, 29, 10.5);
    Node3D buePos = Core.translate3D(0, 0, -5);
    Node3D buePosHul = Core.translate3D(-10, -24, -5.1);

    buePos.add(bue);
    buePosHul.add(bueHul);
    res3.add(buePos);
    res3.add(buePosHul);
            
            //Top Cylinder Bue
           /* cylinder(d=14,h=10,center=true);
            translate([0,-10,0])
            cube([25,29,10.5],center=true);
        
*/
        geometry3D = unity;
        OpenSCADGenerator.generate(cb, unity);
        Path path = Paths.get("rs370sidemount.scad");
        Files.writeString(path, cb.toString());

    }

    public static void main(String[] args) throws IOException {

        RS370SideMount sidemount = new RS370SideMount();

    }
}