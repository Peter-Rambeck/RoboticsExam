package org.abstractica.openbuildsystem.library.parts.machined.alurods;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;

public class AluRods
{
	public static AluRod aluRod10(int length)
	{
		return new AluRod(10, 3.0, 1.0, length);
	}
}
