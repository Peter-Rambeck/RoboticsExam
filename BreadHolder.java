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


public class BreadHolder {

    private Geometry3D geometry3D;
    double radiusDiameter = 2*(5.5+0.4) / sqrt(3);

    // Main cube
    int mainCubeX = 110;
    int mainCubeY = 70;
    int mainHeight = 12;

    // Breadholder cube
    int BreadholderCubeX = 83;
    int BreadholderCubeY = 55;
    int BreadholderHeight = 9;

    // Sideholes cube
    int SideholesCubeX = 3;
    int SideholesCubeY = 3;
    double SideholesHeight = 9.9;

    // Sidewing cubes
    int SidewingCubeX = 10;
    int SidewingCubeY = 30;
    double SidewingHeight = 12;

    // Bottom Cylinder holes
    double bottomHeight = 124;
    double bottomRadus = 3.4;
    int bottomFragments = 64;

    // Top Cylinder holes
    double topHeight = 4;
    double topRadiusDiameter = radiusDiameter;
    int topFragments = 6;


    public BreadHolder() throws IOException {

        Node3D res = Core.difference3D();
        Node3D wingRight = Core.difference3D();
        Node3D wingLeft = Core.difference3D();

        // Main cube
        Geometry3D Maincube = Core.box3D(
                mainCubeX,
                mainCubeY,
                mainHeight);
        res.add(Maincube);

        // Breadholder cube
        Geometry3D Breadholdercube = Core.box3D(
                BreadholderCubeX,
                BreadholderCubeY,
                BreadholderHeight);

        Node3D translateBreadholdercube = Core.translate3D(13.5, 7.5, -0.1);
        translateBreadholdercube.add(Breadholdercube);
        res.add(translateBreadholdercube);

        // Breadholder sideholes cube
        Geometry3D sideholesCube = Core.box3D(
                SideholesCubeX,
                SideholesCubeY,
                SideholesHeight);
        Node3D translateSideholesCube1 = Core.translate3D(80.5,62.4,-1);
        Node3D translateSideholesCube2 = Core.translate3D(26.5,62.4,-1);
        Node3D translateSideholesCube3 = Core.translate3D(96,11,-1);
        Node3D translateSideholesCube4 = Core.translate3D(96,33.5,-1);
        Node3D translateSideholesCube5 = Core.translate3D(96,56,-1);
        translateSideholesCube1.add(sideholesCube);
        res.add(translateSideholesCube1);
        translateSideholesCube2.add(sideholesCube);
        res.add(translateSideholesCube2);
        translateSideholesCube3.add(sideholesCube);
        res.add(translateSideholesCube3);
        translateSideholesCube4.add(sideholesCube);
        res.add(translateSideholesCube4);
        translateSideholesCube5.add(sideholesCube);
        res.add(translateSideholesCube5);

        // Bottom cylinder holes Right and Left
        Geometry3D bottomCylinderHoles = Core.cylinder3D(bottomRadus, bottomHeight, bottomFragments);

        Node3D translateBottomCylinderHolesRight1 = Core.translate3D(5,5,-0.1);
        translateBottomCylinderHolesRight1.add(bottomCylinderHoles);
        res.add(translateBottomCylinderHolesRight1);

        Node3D translateBottomCylinderHolesRight2 = Core.translate3D(5,35,-0.1);
        translateBottomCylinderHolesRight2.add(bottomCylinderHoles);
        res.add(translateBottomCylinderHolesRight2);

        Node3D translateBottomCylinderHolesRight3 = Core.translate3D(5,65,-0.1);
        translateBottomCylinderHolesRight3.add(bottomCylinderHoles);
        res.add(translateBottomCylinderHolesRight3);

        Node3D translateBottomCylinderHolesLeft1 = Core.translate3D(105,5,-0.1);
        translateBottomCylinderHolesLeft1.add(bottomCylinderHoles);
        res.add(translateBottomCylinderHolesLeft1);

        Node3D translateBottomCylinderHolesLeft2 = Core.translate3D(105,35,-0.1);
        translateBottomCylinderHolesLeft2.add(bottomCylinderHoles);
        res.add(translateBottomCylinderHolesLeft2);

        Node3D translateBottomCylinderHolesLeft3 = Core.translate3D(105,65,-0.1);
        translateBottomCylinderHolesLeft3.add(bottomCylinderHoles);
        res.add(translateBottomCylinderHolesLeft3);

        // Top cylinder holes Right and left
        Geometry3D topCylinderHoles = Core.cylinder3D(topRadiusDiameter, topHeight, topFragments);

        Node3D translateTopCylinderHolesRight1 = Core.translate3D(5,5,-0.1);
        translateTopCylinderHolesRight1.add(topCylinderHoles);
        res.add(translateTopCylinderHolesRight1);

        Node3D translateTopCylinderHolesRight2 = Core.translate3D(5,35,-0.1);
        translateTopCylinderHolesRight2.add(topCylinderHoles);
        res.add(translateTopCylinderHolesRight2);

        Node3D translateTopCylinderHolesRight3 = Core.translate3D(5,65,-0.1);
        translateTopCylinderHolesRight3.add(topCylinderHoles);
        res.add(translateTopCylinderHolesRight3);

        Node3D translateTopCylinderHolesLeft1 = Core.translate3D(105,5,-0.1);
        translateTopCylinderHolesLeft1.add(topCylinderHoles);
        res.add(translateTopCylinderHolesLeft1);

        Node3D translateTopCylinderHolesLeft2 = Core.translate3D(105,35,-0.1);
        translateTopCylinderHolesLeft2.add(topCylinderHoles);
        res.add(translateTopCylinderHolesLeft2);

        Node3D translateTopCylinderHolesLeft3 = Core.translate3D(105,65,-0.1);
        translateTopCylinderHolesLeft3.add(topCylinderHoles);
        res.add(translateTopCylinderHolesLeft3);

        // Sidewing cube right
        Geometry3D SidewingCubeRight = Core.box3D(
                SidewingCubeX,
                SidewingCubeY,
                SidewingHeight);
        Node3D translateSidewingCubeRight = Core.translate3D(-9.99,0,0);
        translateSidewingCubeRight.add(SidewingCubeRight);
        wingRight.add(translateSidewingCubeRight);

        // Top cylinder hole Wing right
        Geometry3D topCylinderHoleWingRight = Core.cylinder3D(radiusDiameter, 4, 6);
        Node3D translateTopCylinderHoleWingRight = Core.translate3D(-4.99,30.01,7);
        Node3D rotateTopCylinderHoleWingRight = Core.rotate3D(90, 0, 0);
        rotateTopCylinderHoleWingRight.add(topCylinderHoleWingRight);
        translateTopCylinderHoleWingRight.add(rotateTopCylinderHoleWingRight);
        wingRight.add(translateTopCylinderHoleWingRight);

        // Bottom cylinder hole Wing right
        Geometry3D bottomCylinderHoleWingRight = Core.cylinder3D(3.4, 100, 64);
        Node3D translateBottomCylinderHoleWingRight = Core.translate3D(-4.99,30.01,7);
        Node3D rotateBottomCylinderHoleWingRight = Core.rotate3D(90, 0, 0);
        rotateBottomCylinderHoleWingRight.add(bottomCylinderHoleWingRight);
        translateBottomCylinderHoleWingRight.add(rotateBottomCylinderHoleWingRight);
        wingRight.add(translateBottomCylinderHoleWingRight);

        // Sidewing cube left
        Geometry3D SidewingCubeLeft = Core.box3D(
                SidewingCubeX,
                SidewingCubeY,
                SidewingHeight);
        Node3D translateSidewingCubeLeft = Core.translate3D(109.99,0,0);
        translateSidewingCubeLeft.add(SidewingCubeLeft);
        wingLeft.add(translateSidewingCubeLeft);

        // Top cylinder hole Wing left
        Geometry3D topCylinderHoleWingLeft = Core.cylinder3D(radiusDiameter, 4, 6);
        Node3D translateTopCylinderHoleWingLeft = Core.translate3D(114.99,30.01,7);
        Node3D rotateTopCylinderHoleWingLeft = Core.rotate3D(90, 0, 0);
        rotateTopCylinderHoleWingLeft.add(topCylinderHoleWingLeft);
        translateTopCylinderHoleWingLeft.add(rotateTopCylinderHoleWingLeft);
        wingLeft.add(translateTopCylinderHoleWingLeft);

        // Bottom cylinder hole Wing right
        Geometry3D bottomCylinderHoleWingLeft = Core.cylinder3D(3.4, 100, 64);
        Node3D translateBottomCylinderHoleWingLeft = Core.translate3D(114.99,30.01,7);
        Node3D rotateBottomCylinderHoleWingLeft = Core.rotate3D(90, 0, 0);
        rotateBottomCylinderHoleWingLeft.add(bottomCylinderHoleWingLeft);
        translateBottomCylinderHoleWingLeft.add(rotateBottomCylinderHoleWingLeft);
        wingLeft.add(translateBottomCylinderHoleWingLeft);

        codeBuilder(res, wingLeft, wingRight);
}


        public void codeBuilder(Geometry3D res, Geometry3D wingLeft, Geometry3D wingRight) throws IOException {
            geometry3D = res;
            CodeBuilder cb = new CodeBuilder();
            OpenSCADGenerator.generate(cb, res);
            OpenSCADGenerator.generate(cb, wingLeft);
            OpenSCADGenerator.generate(cb, wingRight);

            Path path = Paths.get("BreadHolder.scad");
            Files.writeString(path, cb.toString());
        }



    public static void main(String[] args) throws IOException {
        BreadHolder breadHolder = new BreadHolder();
        }
    }






