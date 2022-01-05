package org.abstractica.openbuildsystem.library.parts.sourced.fasteners.bolts.hexbolts;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.parts.ACutoutPart;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.bolts.Bolt;
import org.abstractica.openbuildsystem.library.util.math.HexMath;

public class HexBolt extends ACutoutPart implements Bolt
{
	private final double diameter, length, threadLength, headWidth, headHeight;

	public HexBolt(String sizeName,
	               double diameter,
	               double length,
	               double threadLength,
	               double headWidth,
	               double headHeight)
	{
		super("HexBolt_" + sizeName);
		this.diameter = diameter;
		this.length = length;
		this.threadLength = threadLength;
		this.headWidth = headWidth;
		this.headHeight = headHeight;
	}

	@Override
	public double getDiameter()
	{
		return diameter;
	}

	@Override
	public double getLength()
	{
		return length;
	}

	@Override
	public double getThreadLength()
	{
		return threadLength;
	}

	@Override
	public double getHeadDiameter()
	{
		return HexMath.hexagon_Diameter(headWidth);
	}

	@Override
	public double getHeadHeight()
	{
		return headHeight;
	}

	@Override
	protected Geometry3D doGenerateGeometry()
	{
		Node3D res = Core.union3D();
		//Head
		Node3D headColor = Core.color("silver");
		Node3D headTranslate = Core.translate3D(0, 0, -headHeight);
		Geometry3D head = Core.cylinder3D(HexMath.hexagon_Diameter(headWidth), headHeight, 6);
		headColor.add(head);
		headTranslate.add(headColor);
		res.add(headTranslate);

		//Non threaded part
		if (length > threadLength)
		{
			Geometry3D nonThreaded = Core.cylinder3D(diameter, length - threadLength, 32);
			Node3D nonThreadedColor = Core.color("silver");
			nonThreadedColor.add(nonThreaded);
			res.add(nonThreadedColor);
		}
		//Threaded part
		Node3D threadedTranslate = Core.translate3D(0, 0, length - threadLength);
		Geometry3D threaded = Core.cylinder3D(diameter, threadLength, 32);
		Node3D threadedColor = Core.color("grey");
		threadedColor.add(threaded);
		threadedTranslate.add(threadedColor);
		res.add(threadedTranslate);

		return res;
	}

	@Override
	protected Geometry3D doGenerateCutout(double fittingXY, double fittingZ, boolean fixOverhang)
	{
		Node3D res = Core.union3D();
		//Head
		Node3D headTranslate = Core.translate3D(0, 0, -headHeight - fittingZ);
		Geometry3D head = Core.cylinder3D(HexMath.hexagon_Diameter(headWidth + 2 * fittingXY), headHeight + 2 * fittingZ, 6);
		headTranslate.add(head);

		//Body
		Geometry3D body = Core.cylinder3D(diameter + 2 * fittingXY, length + fittingZ, 64);
		res.add(body);

		//fix overhang
		if (fixOverhang)
		{
			Node3D hull = Core.hull3D();
			hull.add(headTranslate);
			double height = 0.5 * (HexMath.hexagon_Diameter(headWidth - diameter));
			Geometry3D cyl = Core.cylinder3D(diameter + 2 * fittingXY, height, 64);
			hull.add(cyl);
			res.add(hull);
		} else
		{
			res.add(headTranslate);
		}
		return res;
	}
}
