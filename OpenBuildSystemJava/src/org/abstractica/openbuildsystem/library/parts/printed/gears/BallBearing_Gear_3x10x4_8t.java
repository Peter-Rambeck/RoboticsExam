package org.abstractica.openbuildsystem.library.parts.printed.gears;


import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.util.gears.GearData;
import org.abstractica.openbuildsystem.library.util.gears.InvoluteGears;

public class BallBearing_Gear_3x10x4_8t
{
	private final Geometry3D geometry3D;

	public BallBearing_Gear_3x10x4_8t()
	{
		GearData gearData8 = new GearData(8, 20, 16, Math.toRadians(20),  Math.toRadians(0));


		//Gear24
		Geometry3D gear8 = InvoluteGears.involuteGear3D(gearData8, 8,0.1);

		//AxelHole
		Node3D holeTranslate = Core.translate3D(0,0,-1);
		Geometry3D axelHole = Core.cylinder3D(10.2, 10, 64);
		holeTranslate.add(axelHole);

		//Result
		Node3D res = Core.difference3D();
		res.add(gear8);
		res.add(holeTranslate);

		geometry3D = res;
	}

	public Geometry3D getGeometry3D()
	{
		return geometry3D;
	}
}
