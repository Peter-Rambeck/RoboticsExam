package org.abstractica.openbuildsystem.library.parts.printed.gears;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.util.gears.GearData;
import org.abstractica.openbuildsystem.library.util.gears.InvoluteGears;

public class RF370_Motor_Gear_8t
{
	private final Geometry3D geometry3D;

	public RF370_Motor_Gear_8t()
	{
		GearData gearData = new GearData(8, 20, 16, Math.toRadians(20),  Math.toRadians(0));
		//GearAndHubUnion
		Node3D gearAndHub = Core.union3D();

		//Gear
		Geometry3D gear = InvoluteGears.involuteGear3D(gearData, 4,0.1);
		gearAndHub.add(gear);

		//Hub
		Node3D hubTranslate = Core.translate3D(0,0,4);
		Geometry3D hub = Core.cylinder3D(7, 10, 64);
		hubTranslate.add(hub);
		gearAndHub.add(hubTranslate);

		//AxelHole
		Node3D holeTranslate = Core.translate3D(0,0,4);
		Geometry3D axelHole = Core.cylinder3D(2.2, 11, 32);
		holeTranslate.add(axelHole);

		//Result
		Node3D res = Core.difference3D();
		res.add(gearAndHub);
		res.add(holeTranslate);

		geometry3D = res;
	}

	public Geometry3D getGeometry3D()
	{
		return geometry3D;
	}
}
