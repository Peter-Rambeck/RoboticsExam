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


public class SevenLongPropellerSquare {

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

    // Main long cube
    int mainCubeX = 70;
    int mainCubeY = 10;
    int mainHeight = 10;

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


    /*

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

     */


    public SevenLongPropellerSquare() throws IOException {

        Node3D res = Core.difference3D();

        // Main long cube
        Geometry3D MainLongCube = Core.box3D(
                mainCubeX,
                mainCubeY,
                mainHeight);
        Node3D translateMainLongCube = Core.translate3D(-35, 0-5, -10);
        translateMainLongCube.add(MainLongCube);
        res.add(translateMainLongCube);

        // Hull start
        // Cylinder center hole for hull function
        Geometry3D centerHole = Core.cylinder3D(centerHoleRadus, centerHoleHeight, centerHoleFragments);
        Node3D translateCenterHole = Core.translate3D(0, 0, -1.5-(2.5));
        translateCenterHole.add(centerHole);

        // Cylinder hole left side
        Geometry3D holeLeft = Core.cylinder3D(leftAndRightHoleDiameter, leftAndRightHoleHeight, leftAndRightHoleFragments);
        Node3D translateholeLeft = Core.translate3D(14, 0, -1.5-(2.5));
        translateholeLeft.add(holeLeft);

        // Cylinder hole right side
        Geometry3D holeRight = Core.cylinder3D(leftAndRightHoleDiameter, leftAndRightHoleHeight, leftAndRightHoleFragments);
        Node3D translateholeRight = Core.translate3D(-14, 0, -1.5-(2.5));
        translateholeRight.add(holeRight);

        Node3D hullLeftCenterAndRightHoles = Core.hull3D();
        hullLeftCenterAndRightHoles.add(translateCenterHole);
        hullLeftCenterAndRightHoles.add(translateholeLeft);
        hullLeftCenterAndRightHoles.add(translateholeRight);
        res.add(hullLeftCenterAndRightHoles);
        // Hull end

        // Cylinder center hole for motor fit
        Geometry3D centerMotorHole = Core.cylinder3D(centerHoleMotorRadius, centerHoleHeight, centerHoleMotorFragments);
        Node3D translateCenterMotorHole = Core.translate3D(0, 0, -1.5-(2.5));
        translateCenterMotorHole.add(centerMotorHole);
        res.add(translateCenterMotorHole);

        // Cylinder center holes for screws
        Geometry3D centerSmallScrewHoles = Core.cylinder3D(screwSmallSize, screwLength, screwFragments);

        Node3D translateCenterSmallScrewHolesFirstLeft = Core.translate3D(30, 0, -11);
        translateCenterSmallScrewHolesFirstLeft.add(centerSmallScrewHoles);
        res.add(translateCenterSmallScrewHolesFirstLeft);

        Node3D translateCenterSmallScrewHolesSecondLeft = Core.translate3D(20, 0, -11);
        translateCenterSmallScrewHolesSecondLeft.add(centerSmallScrewHoles);
        res.add(translateCenterSmallScrewHolesSecondLeft);

        Node3D translateCenterSmallScrewHolesThirdLeft = Core.translate3D(-20, 0, -11);
        translateCenterSmallScrewHolesThirdLeft.add(centerSmallScrewHoles);
        res.add(translateCenterSmallScrewHolesThirdLeft);

        Node3D translateCenterSmallScrewHolesFourthLeft = Core.translate3D(-30, 0, -11);
        translateCenterSmallScrewHolesFourthLeft.add(centerSmallScrewHoles);
        res.add(translateCenterSmallScrewHolesFourthLeft);
        // Cylinder center holes for screws ends

        // Nut holes for screws
        Geometry3D nutHolesForScrews = Core.cylinder3D(screwM3Size, screwM3Length, 6);

        Node3D translateNutHolesForScrewsFirstLeft = Core.translate3D(30, 0, -2);
        translateNutHolesForScrewsFirstLeft.add(nutHolesForScrews);
        res.add(translateNutHolesForScrewsFirstLeft);

        Node3D translateNutHolesForScrewsSecondLeft = Core.translate3D(20, 0, -2);
        translateNutHolesForScrewsSecondLeft.add(nutHolesForScrews);
        res.add(translateNutHolesForScrewsSecondLeft);

        Node3D translateNutHolesForScrewsThirdLeft = Core.translate3D(-20, 0, -2);
        translateNutHolesForScrewsThirdLeft.add(nutHolesForScrews);
        res.add(translateNutHolesForScrewsThirdLeft);

        Node3D translateNutHolesForScrewsFourthLeft = Core.translate3D(-30, 0, -2);
        translateNutHolesForScrewsFourthLeft.add(nutHolesForScrews);
        res.add(translateNutHolesForScrewsFourthLeft);
        // Nut holes for screws ends


        // Small screwholes for motorarms
        Geometry3D smallScrewholesForMotorarms = Core.cylinder3D(1.5, 12, 64);

        Node3D translateSmallScrewholesForMotorarmsFirstLeft = Core.translate3D(12, 0, -6);
        translateSmallScrewholesForMotorarmsFirstLeft.add(smallScrewholesForMotorarms);
        res.add(translateSmallScrewholesForMotorarmsFirstLeft);

        Node3D translateSmallScrewholesForMotorarmsSecondLeft = Core.translate3D(8.5, 0, -6);
        translateSmallScrewholesForMotorarmsSecondLeft.add(smallScrewholesForMotorarms);
        res.add(translateSmallScrewholesForMotorarmsSecondLeft);

        Node3D translateSmallScrewholesForMotorarmsThirdLeft = Core.translate3D(-8.5, 0, -6);
        translateSmallScrewholesForMotorarmsThirdLeft.add(smallScrewholesForMotorarms);
        res.add(translateSmallScrewholesForMotorarmsThirdLeft);

        Node3D translateSmallScrewholesForMotorarmsFourthLeft = Core.translate3D(-12, 0, -6);
        translateSmallScrewholesForMotorarmsFourthLeft.add(smallScrewholesForMotorarms);
        res.add(translateSmallScrewholesForMotorarmsFourthLeft);
        // Small screwholes for motorarms ends





        codeBuilder(res);
}











        public void codeBuilder(Geometry3D res) throws IOException {
            geometry3D = res;
            CodeBuilder cb = new CodeBuilder();
            OpenSCADGenerator.generate(cb, res);
            Path path = Paths.get("SevenLongPropellerSquare.scad");
            Files.writeString(path, cb.toString());
        }

    public static void main(String[] args) throws IOException {
        SevenLongPropellerSquare sevenLongPropellerSquare = new SevenLongPropellerSquare();
        }
    }






