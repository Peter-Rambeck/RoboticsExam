package org.abstractica.openbuildsystem.library.parts.printed.gears;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.util.gears.GearData;
import org.abstractica.openbuildsystem.library.util.gears.InvoluteGears;

public class BallBearing_Gear_3x10x4_24t_12t
{
	private final Geometry3D geometry3D;

	public BallBearing_Gear_3x10x4_24t_12t()
	{
		GearData gearData12 = new GearData(8, 20, 16, Math.toRadians(20),  Math.toRadians(0));
		GearData gearData24 = new GearData(24, 20, 16, Math.toRadians(20),  Math.toRadians(0));

		//Gear24
		Node3D gear12Translate = Core.translate3D(0,0,4);
		Geometry3D gear12 = InvoluteGears.involuteGear3D(gearData12, 4,0.1);
		gear12Translate.add(gear12);

		//Gear24
		Geometry3D gear24 = InvoluteGears.involuteGear3D(gearData24, 4,0.1);

		//Gears
		Node3D gears = Core.union3D();
		gears.add(gear12Translate);
		gears.add(gear24);

		//AxelHole
		Node3D holeTranslate = Core.translate3D(0,0,-1);
		Geometry3D axelHole = Core.cylinder3D(10.2, 10, 64);
		holeTranslate.add(axelHole);

		//Result
		Node3D res = Core.difference3D();
		res.add(gears);
		res.add(holeTranslate);

		geometry3D = res;
	}

	public Geometry3D getGeometry3D()
	{
		return geometry3D;
	}
}
