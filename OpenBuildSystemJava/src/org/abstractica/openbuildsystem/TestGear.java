package org.abstractica.openbuildsystem;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry2D;
import org.abstractica.openbuildsystem.core.Node2D;
import org.abstractica.openbuildsystem.library.util.gears.GearData;
import org.abstractica.openbuildsystem.library.util.gears.InvoluteGears;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestGear
{
	public static void main(String[] args) throws IOException
	{
		//Generate geometry

		GearData g = new GearData(8, 20, 8, Math.toRadians(20),  Math.toRadians(0));

		Geometry2D gear = InvoluteGears.involuteGear2D(g, 0);

		Geometry2D rack = InvoluteGears.rack2D(g, 10, 0);

		int half = g.numberOfTeeth / 2;
		double x = (0.5-half)*g.pitch;
		double y = -g.pitchRadius;
		//Output file
		CodeBuilder cb = new CodeBuilder();
		cb.addLine("translate([" + x + " + $t * " + g.pitch + ", " + y + ", 0])");
		OpenSCADGenerator.generate(cb, rack);
		cb.addLine("rotate([0, 0, $t * " + Math.toDegrees(g.pitchAngle) + "])");
		Node2D rot = Core.rotate2D(-90).add(gear);
		/*
		Node2D gear2 = Core.translate2D(0, (((double)(g.numberOfTeeth*2)) / g.totalTeeth) * g.gearDist)
				.add(gear);*/
		OpenSCADGenerator.generate(cb, rot);
		Path path = Paths.get("output.scad");
		Files.writeString(path, cb.toString());
	}
}
