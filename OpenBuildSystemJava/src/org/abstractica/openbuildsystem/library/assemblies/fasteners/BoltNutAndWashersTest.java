package org.abstractica.openbuildsystem.library.assemblies.fasteners;



import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.library.assemblies.BOM;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.bolts.allenbolts.AllenBolts;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.bolts.hexbolts.HexBolts;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.nuts.hexnuts.HexNuts;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.washers.flatwashers.FlatWashers;
import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BoltNutAndWashersTest
{
	public static void main(String[] args) throws IOException
	{
		BOM bom = new BOM();
		BoltNutAndWashers bolt = new BoltNutAndWashers(HexBolts.M3x25, HexNuts.M3, FlatWashers.M3_big, 20);
		bolt.collectBOM(bom);
		System.out.println(bolt.getName() + " BOM:");
		System.out.println(bom);

		CodeBuilder cb = new CodeBuilder();
		Geometry3D geometry3D = bolt.generateGeometry();
		OpenSCADGenerator.generate(cb, geometry3D);

		Path path = Paths.get("output.scad");
		Files.writeString(path, cb.toString());
	}
}
