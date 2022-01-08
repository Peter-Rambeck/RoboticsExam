package org.abstractica.openbuildsystem.library.parts.printed.Motors;

import org.abstractica.openbuildsystem.core.*;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Math.sqrt;

public class ControllerHolder {

    private final Geometry3D geometry3D;

    int sidex = 60;
    int sidey = 50;
    int height= 7;
    Double cylinder_small=3.4;
    int screw_head_height=1 ;
    int edges=6;
    Double screw_head_m3 = 5.8;
    Double seks_komma_otte = 2*(5.5+0.4) / sqrt(3);



    public ControllerHolder() throws IOException {

        CodeBuilder cb = new CodeBuilder();

        //Main Cube
        
        Geometry3D cube = Core.box3D(sidex, sidey, height);
        Node3D unity = Core.union3D();
        Node3D res = Core.difference3D();
        Node3D cubePos = Core.translate3D(0, 0, 0);
        cubePos.add(cube);
        res.add(cubePos);
        unity.add(res);

        // Forhøjning 1
        Node3D res2 = Core.difference3D();
        Geometry3D cylinder = Core.cylinder3D(7, 3, 64); 
        Node3D cylinderPos = Core.translate3D(6, 5, 6.9);

        Geometry3D hole = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos = Core.translate3D(6, 5,     0);
    
        cylinderPos.add(cylinder);
        res2.add(cylinderPos); 
        holepos.add(hole);
        res2.add(holepos);
        unity.add(res2);

        // Forhøjning 2
        Node3D res3 = Core.difference3D();
        Geometry3D cylinder2 = Core.cylinder3D(7, 3, 64); 
        Node3D cylinderPos2 = Core.translate3D(49.5, 5, 6.9);

        Geometry3D hole2 = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos2 = Core.translate3D(49.5, 5, 0);

        cylinderPos2.add(cylinder2);
        res3.add(cylinderPos2);
        holepos2.add(hole2);
        res3.add(holepos2);
        unity.add(res3);

        // Forhøjning 3
        Node3D res4 = Core.difference3D();
        Geometry3D cylinder3 = Core.cylinder3D(7, 3, 64); 
        Node3D cylinderPos3 = Core.translate3D(49.5, 33.5, 6.9);

        Geometry3D hole3 = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos3 = Core.translate3D(49.5, 33.5, 0);

        cylinderPos3.add(cylinder3);
        res4.add(cylinderPos3);
        holepos3.add(hole3);
        res4.add(holepos3);
        unity.add(res4);
        
        // Forhøjning 4
        Node3D res5 = Core.difference3D();
        Geometry3D cylinder4 = Core.cylinder3D(7, 3, 64); 
        Node3D cylinderPos4 = Core.translate3D(6, 20.5, 6.9);

        Geometry3D hole4 = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos4 = Core.translate3D(6,20.5,0);

        cylinderPos4.add(cylinder4);
        res5.add(cylinderPos4);
        holepos4.add(hole4);
        res5.add(holepos4);
        unity.add(res5);


        //Skruehul 1

        Geometry3D hole5 = Core.cylinder3D(3.4, 10, 64);
        Node3D holepos5 = Core.translate3D(5, 45, -0.1);

        holepos5.add(hole5);
        res.add(holepos5);


        //Skruehul 2

        Geometry3D hole6 = Core.cylinder3D(3.4, 10, 64);
        Node3D holepos6 = Core.translate3D(55, 45, -0.1);

        holepos6.add(hole6);
        res.add(holepos6);

        //6 komma otte hular
        
        Geometry3D hole7 = Core.cylinder3D(seks_komma_otte, 3, 6);
        Node3D holepos7 = Core.translate3D(5, 45, 4.1);
        holepos7.add(hole7);
        res.add(holepos7);

        Geometry3D hole8 = Core.cylinder3D(seks_komma_otte, 3, 6);
        Node3D holepos8 = Core.translate3D(55, 45, 4.1);
        holepos8.add(hole8);
        res.add(holepos8);
        
        //Plader huller 1&2 
        Geometry3D hole9 = Core.cylinder3D(seks_komma_otte, 3, 6);
        Node3D holepos9 = Core.translate3D(6, 5, -0.1);
        holepos9.add(hole9);
        res.add(holepos9);

        Geometry3D hole10 = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos10 = Core.translate3D(6, 5, 0);
        holepos10.add(hole10);
        res.add(holepos10);

        //Plader huller 3&4 
        Geometry3D hole11 = Core.cylinder3D(seks_komma_otte, 3, 6);
        Node3D holepos11 = Core.translate3D(49.5, 5, -0.1);
        holepos11.add(hole11);
        res.add(holepos11);

        Geometry3D hole12 = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos12 = Core.translate3D(49.5, 5, 0);
        holepos12.add(hole12);
        res.add(holepos12);

        //Plader huller 5&6 
        Geometry3D hole13 = Core.cylinder3D(seks_komma_otte, 3, 6);
        Node3D holepos13 = Core.translate3D(49.5, 33.5, -0.1);
        holepos13.add(hole13);
        res.add(holepos13);

        Geometry3D hole14 = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos14 = Core.translate3D(49.5, 33.5, 0);
        holepos14.add(hole14);
        res.add(holepos14);

        //Plader huller 7&8
        Geometry3D hole15 = Core.cylinder3D(seks_komma_otte, 3, 6);
        Node3D holepos15 = Core.translate3D(6, 20.5, -0.1);
        holepos15.add(hole15);
        res.add(holepos15);

        Geometry3D hole16 = Core.cylinder3D(3.4, 100, 64);
        Node3D holepos16 = Core.translate3D(6, 20.5, 0);
        holepos16.add(hole16);
        res.add(holepos16);


        geometry3D = unity;

        OpenSCADGenerator.generate(cb, unity);
        Path path = Paths.get("controllerholder.scad");
        Files.writeString(path, cb.toString());

        
        


    }
   

    public static void main(String[] args) throws IOException {

        ControllerHolder controllerholder = new ControllerHolder();

    }
}