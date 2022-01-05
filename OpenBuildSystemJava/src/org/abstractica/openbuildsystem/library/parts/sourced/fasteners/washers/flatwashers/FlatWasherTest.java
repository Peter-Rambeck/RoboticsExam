package org.abstractica.openbuildsystem.library.parts.sourced.fasteners.washers.flatwashers;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.nuts.hexnuts.HexNut;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.nuts.hexnuts.HexNuts;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FlatWasherTest
{
	public static void main(String[] args) throws IOException
	{
		FlatWasher w1 = FlatWashers.M3_small;
		FlatWasher w2 = FlatWashers.M3_big;
		Node3D res = Core.union3D();
		Node3D t1 = Core.translate3D(-10, 0, 0);
		Node3D t2 = Core.translate3D(10, 0, 0);
		t1.add(w1.generateGeometry());
		t2.add(w2.generateGeometry());
		res.add(t1).add(t2);


		CodeBuilder cb = new CodeBuilder();
		OpenSCADGenerator.generate(cb, res);

		Path path = Paths.get("output.scad");
		Files.writeString(path, cb.toString());
	}
}
