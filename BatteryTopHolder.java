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


public class BatteryTopHolder {

    private final Geometry3D geometry3D;

    // Middle cube
    int middleCubeX = 120;
    int middleCubeY = 10;
    int middleCubeHeight = 20;

    //  Positioning Middle cube
    double translateMiddleCubeX = (120-93.3)/2;
    double translateMiddleCubeY = -29.8+5.8;
    double translateMiddleCubeZ = 4.2;

    // Translate middle cube
    double translateCubeX = 93.3;
    double translateCubeY = 57.3;
    double translateCubeZ = 20;

    // Diagonal cubes, first and second
    double diagonalCubeX = 9.6;
    double diagonalCubeY = 69.6;
    double diagonalCubeHeight = 20.0;

    // Position first diagonal cube
    double positionFirstDiagonalCubeX = -30;
    double positionFirstDiagonalCubeY = 0;
    double positionFirstDiagonalCubeHeight = 0;

    // Position second diagonal cube
    double positionSecondDiagonalCubeX = 30;
    double positionSecondDiagonalCubeY = 0;
    double positionSecondDiagonalCubeHeight = 0;

    // Position adjustments due to no 'center=true' option
    double adjustmentPositionFirstDiagonalCubeX = positionFirstDiagonalCubeX + 55.0;
    double adjustmentPositionSecondDiagonalCubeX = positionSecondDiagonalCubeX + 55.0;
    double adjustmentPositionDiagonalCubeY = (-diagonalCubeY/2) + (middleCubeY/2.0);


    // Cylinder holes bottom cylinder(d=3.4, h=70,$fn=64)
    double bottomD = 3.4;
    double bottomH = 70;
    int bottomFn = 64;

    // Cylinder holes top cylinder
    double topD = 2*(5.5+0.4) / sqrt(3);
    double topH = 5+10;
    int topFn = 6;



    public BatteryTopHolder() throws IOException {



        Node3D middleAndDiagionalCubes = Core.union3D();

        // Long middle cube
        Geometry3D longMiddlecube = Core.box3D(
                middleCubeX,
                middleCubeY,
                middleCubeHeight);
        // Union
        middleAndDiagionalCubes.add(longMiddlecube);
        Node3D res = Core.difference3D();
        res.add(middleAndDiagionalCubes);


        // Translate middle cube
        Geometry3D translateMiddlecube = Core.box3D(
                translateCubeX,
                translateCubeY,
                translateCubeZ);

        // Translate cube
        Node3D translateCube = Core.translate3D(
                translateMiddleCubeX,
                translateMiddleCubeY,
                translateMiddleCubeZ
                );
        // Add to Iterable<Geometry3D>
        translateCube.add(translateMiddlecube);
        res.add(translateCube);
        // Stop Translate middle cube

        // Cylinder, holes bottom
        Geometry3D cylinderHoleBottom = Core.cylinder3D(bottomD, bottomH, bottomFn);
        // Translate cylinder, hole bottom
        Node3D firstTranslateCylinderHoleBottom = Core.translate3D(-55+60, 5, 0);
        Node3D secondTranslateCylinderHoleBottom = Core.translate3D(55+60, 5, 0);
        firstTranslateCylinderHoleBottom.add(cylinderHoleBottom);
        secondTranslateCylinderHoleBottom.add(cylinderHoleBottom);
        res.add(firstTranslateCylinderHoleBottom);
        res.add(secondTranslateCylinderHoleBottom);
        // Stop Cylinder, holes bottom

        // Cylinder, holes top
        Geometry3D cylinderHoleTop = Core.cylinder3D(topD, topH, topFn);
        // Translate cylinder, hole bottom
        Node3D firstTranslateCylinderHoleTop = Core.translate3D(-55+60, 5, -10);
        Node3D secondTranslateCylinderHoleTop = Core.translate3D(55+60, 5, -10);
        firstTranslateCylinderHoleTop.add(cylinderHoleTop);
        secondTranslateCylinderHoleTop.add(cylinderHoleTop);
        res.add(firstTranslateCylinderHoleTop);
        res.add(secondTranslateCylinderHoleTop);
        // Stop Cylinder, holes top


        // First diagonal cube
        Geometry3D firstDiagonalcube = Core.box3D(
                diagonalCubeX,
                diagonalCubeY,
                diagonalCubeHeight);
        // Position first diagonal cube
        Node3D positionfirstDiagonalcube = Core.translate3D(
                adjustmentPositionFirstDiagonalCubeX,
                adjustmentPositionDiagonalCubeY,
                positionFirstDiagonalCubeHeight);
        // Add to Iterable<Geometry3D>
        positionfirstDiagonalcube.add(firstDiagonalcube);
        // Union
        middleAndDiagionalCubes.add(positionfirstDiagonalcube);

        // Second diagonal cube
        Geometry3D secondDiagonalcube = Core.box3D(
                diagonalCubeX,
                diagonalCubeY,
                diagonalCubeHeight);
        // Position second diagonal cube
        Node3D translatesecondDiagonalcube = Core.translate3D(
                adjustmentPositionSecondDiagonalCubeX,
                adjustmentPositionDiagonalCubeY,
                positionSecondDiagonalCubeHeight);
        // Add to Iterable<Geometry3D>
        translatesecondDiagonalcube.add(secondDiagonalcube);
        // Union
        middleAndDiagionalCubes.add(translatesecondDiagonalcube);

        //SCAD Code builder
        geometry3D = res;
        CodeBuilder cb = new CodeBuilder();
        OpenSCADGenerator.generate(cb, res);
        Path path = Paths.get("BatteryTopHolder.scad");
        Files.writeString(path, cb.toString());

}

    public static void main(String[] args) throws IOException {

        BatteryTopHolder batteryTopHolder = new BatteryTopHolder();

    }

    }









