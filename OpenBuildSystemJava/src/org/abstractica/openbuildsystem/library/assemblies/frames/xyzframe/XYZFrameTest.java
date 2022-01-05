package org.abstractica.openbuildsystem.library.assemblies.frames.xyzframe;

import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.library.assemblies.BOM;
import org.abstractica.openbuildsystem.library.assemblies.fasteners.BoltNutAndWashers;
import org.abstractica.openbuildsystem.library.parts.machined.alurods.AluRods;
import org.abstractica.openbuildsystem.library.parts.machined.alurods.Rod;
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

public class XYZFrameTest
{
	public static void main(String[] args) throws IOException
	{
		BOM bom = new BOM();
		BoltNutAndWashers bolt = new BoltNutAndWashers(AllenBolts.M3x25, HexNuts.M3, FlatWashers.M3_big, 20);
		Rod xRod = AluRods.aluRod10(20);
		Rod yRod = AluRods.aluRod10(10);
		Rod zRod = AluRods.aluRod10(6);

		XYZFrame frame = new XYZFrame(xRod, yRod, zRod, bolt);
		frame.collectBOM(bom);
		System.out.println(frame.getName() + " BOM:");
		System.out.println(bom);

		CodeBuilder cb = new CodeBuilder();
		Geometry3D geometry3D = frame.generateGeometry();
		OpenSCADGenerator.generate(cb, geometry3D);

		Path path = Paths.get("output.scad");
		Files.writeString(path, cb.toString());
	}
}
