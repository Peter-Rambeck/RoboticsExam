package org.abstractica.openbuildsystem.library.parts.machined.alurods;

import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AluRodTest
{
	public static void main(String[] args) throws IOException
	{
		AluRod rod = AluRods.aluRod10(5);
		CodeBuilder cb = new CodeBuilder();
		OpenSCADGenerator.generate(cb, rod.generateGeometry());

		Path path = Paths.get("output.scad");
		Files.writeString(path, cb.toString());
	}
}
