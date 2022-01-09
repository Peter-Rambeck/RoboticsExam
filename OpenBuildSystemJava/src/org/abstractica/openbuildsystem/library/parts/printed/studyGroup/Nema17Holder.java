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


public class Nema17Holder {

    private Geometry3D geometry3D;
    double radiusDiameter = 2*(5.5+0.4) / sqrt(3);

    // Main cube
    int mainCubeX = 50;
    int mainCubeY = 50;
    int mainHeight = 10;

    // Hole in Main cube for motor head
    double holeForMotorHeadX = 42.5;
    double holeForMotorHeadY = 42.5;
    double holeForMotorHeadZ = 2;

    // Large cylinder center hole for motor
    double largeCenterHoleHeight = 8;
    double largeCenterHoleRadus = 22.5;
    int largeCenterHoleFragments = 64;

    // Small cylinder center hole for motor rotate-arm
    double smallCenterHoleRotateArmHeight = 23;
    double smallCenterHoleRotateArmHoleRadus = 6;
    int smallCenterHoleRotateArmFragments = 64;

    // Cylinder screw hole main cube sides
    double screwHoleMainCubeSidesHeight = 25;
    double screwHoleMainCubeSidesRadus = 3.4;
    int screwHoleMainCubeSidesFragments = 64;

    // Sink holes to attach screws
    double sinkHoleHead = 2.8;
    double sinkHoleDepth = 5.8;
    double sinkHolePos = 10.1 - sinkHoleDepth;

    // Supporting legs for main cube
    double legsX = 20;
    double legsY = 10;
    double legsZ = 50;

    // Cylinder screw holes legs
    double cylinderScrewHolesLegsHeight = 145;
    double cylinderScrewHolesLegsRadus = 3.4;
    int cylinderScrewHolesLegsFragments = 64;

    // Cylinder screw holes attachments legs
    double cylinderScrewHolesatAttachmentsLegsHeight = 30;
    double cylinderScrewHolesAttachmentsLegsRadus = radiusDiameter;
    int cylinderScrewHolesAttachmentsLegsFragments = 6;

    public Nema17Holder() throws IOException {



        // Main Cube difference
        Node3D mainCube = Core.difference3D();
        // Leg Cube difference right
        Node3D legCubeRight = Core.difference3D();
        // Leg Cube difference left
        Node3D legCubeLeft = Core.difference3D();

        // Main long cube
        Geometry3D MainCube = Core.box3D(
                mainCubeX,
                mainCubeY,
                mainHeight);
        mainCube.add(MainCube);

        // Hole in Main cube for motor head
        Geometry3D holeForMotorHead = Core.box3D(holeForMotorHeadX, holeForMotorHeadY, holeForMotorHeadZ);
        Node3D translateHoleForMotorHead = Core.translate3D((50-42.5)/2,(50-42.5)/2,-0.01);
        translateHoleForMotorHead.add(holeForMotorHead);
        mainCube.add(translateHoleForMotorHead);

        // Large cylinder center hole for motor
        Geometry3D largeCenterHoleMotor = Core.cylinder3D(largeCenterHoleRadus, largeCenterHoleHeight, largeCenterHoleFragments);
        Node3D translateLargeCenterHoleMotor = Core.translate3D(25, 25, -4);
        translateLargeCenterHoleMotor.add(largeCenterHoleMotor);
        mainCube.add(translateLargeCenterHoleMotor);

        // Small cylinder center hole for motor rotate-arm
        Geometry3D smallCenterHoleRotateArm = Core.cylinder3D(smallCenterHoleRotateArmHoleRadus, smallCenterHoleRotateArmHeight, smallCenterHoleRotateArmFragments);
        Node3D translatesmallCenterHoleRotateArm = Core.translate3D(25, 25, 0);
        translatesmallCenterHoleRotateArm.add(smallCenterHoleRotateArm);
        mainCube.add(translatesmallCenterHoleRotateArm);

        // Cylinder screw hole main cube sides
        Geometry3D screwHoleMainCubeSides = Core.cylinder3D(screwHoleMainCubeSidesRadus, screwHoleMainCubeSidesHeight, smallCenterHoleRotateArmFragments);

        Node3D translateScrewHoleMainCubeSidesTopLeft = Core.translate3D(40.5, 40.5, 0);
        translateScrewHoleMainCubeSidesTopLeft.add(screwHoleMainCubeSides);
        mainCube.add(translateScrewHoleMainCubeSidesTopLeft);

        Node3D translateScrewHoleMainCubeSidesTopRight = Core.translate3D(9.5, 40.5, 0);
        translateScrewHoleMainCubeSidesTopRight.add(screwHoleMainCubeSides);
        mainCube.add(translateScrewHoleMainCubeSidesTopRight);

        Node3D translateScrewHoleMainCubeSidesBottomLeft = Core.translate3D(40.5, 9.5, 0);
        translateScrewHoleMainCubeSidesBottomLeft.add(screwHoleMainCubeSides);
        mainCube.add(translateScrewHoleMainCubeSidesBottomLeft);

        Node3D translateScrewHoleMainCubeSidesBottomRight = Core.translate3D(9.5, 9.5, 0);
        translateScrewHoleMainCubeSidesBottomRight.add(screwHoleMainCubeSides);
        mainCube.add(translateScrewHoleMainCubeSidesBottomRight);

        // Sink holes to attach screws
        Geometry3D SinkHolesToAttachScrews = Core.cylinder3D(sinkHoleDepth, sinkHoleHead, 64);

        Node3D translateSinkHolesToAttachScrewsTopLeft = Core.translate3D(40.5, 40.5, 10.1-2.8);
        translateSinkHolesToAttachScrewsTopLeft.add(SinkHolesToAttachScrews);
        mainCube.add(translateSinkHolesToAttachScrewsTopLeft);

        Node3D translateSinkHolesToAttachScrewsTopRight = Core.translate3D(9.5, 40.5, 10.1-2.8);
        translateSinkHolesToAttachScrewsTopRight.add(SinkHolesToAttachScrews);
        mainCube.add(translateSinkHolesToAttachScrewsTopRight);

        Node3D translateSinkHolesToAttachScrewsBottomLeft = Core.translate3D(40.5, 9.5, 10.1-2.8);
        translateSinkHolesToAttachScrewsBottomLeft.add(SinkHolesToAttachScrews);
        mainCube.add(translateSinkHolesToAttachScrewsBottomLeft);

        Node3D translateSinkHolesToAttachScrewsBottomRight = Core.translate3D(9.5, 9.5, 10.1-2.8);
        translateSinkHolesToAttachScrewsBottomRight.add(SinkHolesToAttachScrews);
        mainCube.add(translateSinkHolesToAttachScrewsBottomRight);

        // Legs cube right
        Geometry3D LegCube = Core.box3D(
                legsX,
                legsY,
                legsZ);

        Geometry3D cylinderScrewHolesLegs = Core.cylinder3D(cylinderScrewHolesLegsRadus, cylinderScrewHolesLegsHeight, cylinderScrewHolesLegsFragments);
        Geometry3D cylinderScrewHolesAttachmentsLegs = Core.cylinder3D(cylinderScrewHolesAttachmentsLegsRadus, cylinderScrewHolesatAttachmentsLegsHeight, cylinderScrewHolesAttachmentsLegsFragments);

        // Right
        Node3D translateLegCubeRight = Core.translate3D(-19.99, 20, -40);
        translateLegCubeRight.add(LegCube);
        legCubeRight.add(translateLegCubeRight);

        Node3D translateCylinderScrewHolesLegsRight = Core.translate3D(-5, 25,-40.1);
        translateCylinderScrewHolesLegsRight.add(cylinderScrewHolesLegs);
        legCubeRight.add(translateCylinderScrewHolesLegsRight);

        Node3D translatecylinderScrewHolesAttachmentsLegsRight = Core.translate3D(-5, 25, -6);
        translatecylinderScrewHolesAttachmentsLegsRight.add(cylinderScrewHolesAttachmentsLegs);
        legCubeRight.add(translatecylinderScrewHolesAttachmentsLegsRight);


        // Left
        Node3D translateLegCubeLeft = Core.translate3D(49.99, 20, -40);
        translateLegCubeLeft.add(LegCube);
        legCubeLeft.add(translateLegCubeLeft);

        Node3D translateCylinderScrewHolesLegsLeft = Core.translate3D(55, 25, -40.1);
        translateCylinderScrewHolesLegsLeft.add(cylinderScrewHolesLegs);
        legCubeLeft.add(translateCylinderScrewHolesLegsLeft);

        Node3D translatecylinderScrewHolesAttachmentsLegsLeft = Core.translate3D(55, 25, -6);
        translatecylinderScrewHolesAttachmentsLegsLeft.add(cylinderScrewHolesAttachmentsLegs);
        legCubeLeft.add(translatecylinderScrewHolesAttachmentsLegsLeft);

        codeBuilder(mainCube, legCubeLeft, legCubeRight);
}

        public void codeBuilder(Geometry3D mainCube, Geometry3D legCubeLeft, Geometry3D legCubeRight) throws IOException {
            geometry3D = mainCube;
            geometry3D = legCubeLeft;
            geometry3D = legCubeRight;
            CodeBuilder cb = new CodeBuilder();
            OpenSCADGenerator.generate(cb, mainCube);
            OpenSCADGenerator.generate(cb, legCubeLeft);
            OpenSCADGenerator.generate(cb, legCubeRight);
            Path path = Paths.get("Nema17Holder.scad");
            Files.writeString(path, cb.toString());
        }

    public static void main(String[] args) throws IOException {
        Nema17Holder nema17Holder = new Nema17Holder();
        }
    }






