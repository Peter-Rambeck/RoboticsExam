package org.abstractica.openbuildsystem.library.parts.sourced.fasteners.nuts.hexnuts;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.parts.ACutoutPart;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.nuts.Nut;
import org.abstractica.openbuildsystem.library.util.math.HexMath;

public class HexNut extends ACutoutPart implements Nut
{
	private final double threadDiameter, nutWidth, nutHeight;
	private Geometry3D geo;

	public HexNut(String sizeName, double threadDiameter, double nutWidth, double headHeight)
	{
		super("HexNut_" + sizeName);
		this.threadDiameter = threadDiameter;
		this.nutWidth = nutWidth;
		this.nutHeight = headHeight;
	}

	@Override
	public double getThreadDiameter()
	{
		return threadDiameter;
	}

	@Override
	public double getDiameter()
	{
		return HexMath.hexagon_Diameter(nutWidth);
	}

	@Override
	public double getWidth()
	{
		return nutWidth;
	}

	@Override
	public double getHeight()
	{
		return nutHeight;
	}

	@Override
	protected Geometry3D doGenerateGeometry()
	{
		//Nut
		Node3D color = Core.color("silver");
		Geometry3D body = Core.cylinder3D(HexMath.hexagon_Diameter(nutWidth), nutHeight, 6);
		Geometry3D hole = Core.cylinder3D(threadDiameter, nutHeight + 2, 32);
		Node3D holeTranslate = Core.translate3D(0,0,-1);
		holeTranslate.add(hole);
		Node3D diff = Core.difference3D();
		diff.add(body);
		diff.add(holeTranslate);
		color.add(diff);
		return color;
	}

	@Override
	protected Geometry3D doGenerateCutout(double fittingXY, double fittingZ, boolean fixOverhang)
	{
		//Nut
		Geometry3D nut = Core.cylinder3D(HexMath.hexagon_Diameter(nutWidth + 2 * fittingXY), nutHeight + 2 * fittingZ, 6);

		if(fixOverhang)
		{
			//Thread
			double h = 0.5*(getDiameter() - threadDiameter);
			Geometry3D thread = Core.cylinder3D(threadDiameter + 2 * fittingXY, nutHeight + 2*fittingZ + 2*h, 64);
			Node3D threadTranslate = Core.translate3D(0,0,-h);
			threadTranslate.add(thread);
			Node3D hull = Core.hull3D();
			hull.add(nut).add(threadTranslate);
			nut = hull;
		}

		Node3D res = Core.translate3D(0,0,-fittingZ);
		res.add(nut);
		return res;
	}
}
