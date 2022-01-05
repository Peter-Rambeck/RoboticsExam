package org.abstractica.openbuildsystem.library.geometry;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;

public class Geometry
{
	public static Geometry3D flatRing(double innerDiameter, double outerDiameter, double thickness, int angularResolution)
	{
		Geometry3D ring = Core.cylinder3D(outerDiameter, thickness, angularResolution);
		Geometry3D hole = Core.translate3D(0,0,-1)
				.add(Core.cylinder3D(innerDiameter, thickness + 2, angularResolution));
		Node3D res = Core.difference3D();
		res.add(ring).add(hole);
		return res;
	}
}
