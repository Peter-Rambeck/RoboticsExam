package org.abstractica.openbuildsystem.library.parts.sourced.ballbearings.deepgroove;



import org.abstractica.openbuildsystem.openscad.CodeBuilder;
import org.abstractica.openbuildsystem.openscad.OpenSCADGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeepGrooveBallBearingTest
{
	public static void main(String[] args) throws IOException
	{
		DeepGrooveBallBearing ballBearing = new DeepGrooveBallBearing("8x22x5",
				8,
				22,
				5,
				1.5,
				1.5,
				0.5);

		CodeBuilder cb = new CodeBuilder();
		OpenSCADGenerator.generate(cb, ballBearing.getEmbeddedCutoutWithAxelCutout(1, 0.1, 0.1, 20));

		Path path = Paths.get("output.scad");
		Files.writeString(path, cb.toString());
	}
}
