package org.abstractica.openbuildsystem.library.parts.sourced.ballbearings.deepgroove;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.geometry.Geometry;
import org.abstractica.openbuildsystem.library.parts.ACutoutPart;
import org.abstractica.openbuildsystem.library.util.math.HexMath;

public class DeepGrooveBallBearing extends ACutoutPart
{
	private final double innerDiameter, outerDiameter, height, innerShoulderWidth, outerShoulderWidth, shoulderHeight;

	public DeepGrooveBallBearing(String sizeName, double innerDiameter, double outerDiameter, double height, double innerShoulderWidth, double outerShoulderWidth, double shoulderHeight)
	{
		super("DeepGrooveBallBearing_" + sizeName);
		this.innerDiameter = innerDiameter;
		this.outerDiameter = outerDiameter;
		this.height = height;
		this.innerShoulderWidth = innerShoulderWidth;
		this.outerShoulderWidth = outerShoulderWidth;
		this.shoulderHeight = shoulderHeight;
	}

	public double getInnerDiameter()
	{
		return innerDiameter;
	}

	public double getOuterDiameter()
	{
		return outerDiameter;
	}

	public double getHeight()
	{
		return height;
	}

	public double getInnerShoulderWidth()
	{
		return innerShoulderWidth;
	}

	public double getOuterShoulderWidth()
	{
		return outerShoulderWidth;
	}

	public double getShoulderHeight()
	{
		return shoulderHeight;
	}

	@Override
	protected Geometry3D doGenerateGeometry()
	{
		Node3D res = Core.union3D();
		Geometry3D outerShoulder = Core.color("silver")
				.add(Geometry.flatRing(outerDiameter-outerShoulderWidth,
										outerDiameter,
										height,
							64));
		Geometry3D innerShoulder = Core.color("silver")
				.add(Geometry.flatRing(innerDiameter,
							innerDiameter + innerShoulderWidth,
										height,
							64));
		Geometry3D middle = Core.color("blue")
				.add(Core.translate3D(0,0,shoulderHeight)
					.add(Geometry.flatRing(innerDiameter + innerShoulderWidth,
								outerDiameter-outerShoulderWidth,
									height - 2 * shoulderHeight,
								64)));
		res.add(innerShoulder).add(middle).add(outerShoulder);
		return res;
	}

	@Override
	protected Geometry3D doGenerateCutout(double fittingXY, double fittingZ, boolean fixOverhang)
	{
		return Core.translate3D(0,0, -fittingZ)
				.add(Core.cylinder3D(outerDiameter + 2 * fittingXY, height + 2*fittingZ, 256 ));
	}

	public Geometry3D getEmbeddedCutout(double playRoom, double fittingZ, double axelFitting)
	{
		Node3D res = common(playRoom, fittingZ);
		res.add(Core.translate3D(0,0,-0.5*height-playRoom-1)
				.add(Core.cylinder3D(innerDiameter+2*axelFitting,
						height+2*playRoom+2,
						256)));
		return res;
	}

	public Geometry3D getEmbeddedCutoutWithAxelCutout(double playRoom, double fittingZ, double axelFitting, double axelLength)
	{
		Node3D res = Core.union3D();
		res.add(common(playRoom, fittingZ));
		res.add(Core.translate3D(0,0,-0.5*axelLength)
				.add(Core.cylinder3D(innerDiameter+2*axelFitting, axelLength, 256)));
		return res;
	}

	private Node3D common(double playRoom, double fittingZ)
	{
		Geometry3D cyl = Core.translate3D(0,0,-0.5*height-playRoom)
				.add(Core.cylinder3D(outerDiameter + 2*playRoom, height + 2*playRoom, 256));
		Geometry3D base = Core.translate3D(0,0,-playRoom-0.5*height-fittingZ)
				.add(Core.cone3D(innerDiameter+innerShoulderWidth+2*playRoom,
						innerDiameter+innerShoulderWidth,
						playRoom,
						256));
		Node3D res = Core.difference3D();
		res.add(cyl);
		res.add(base);
		res.add(Core.rotate3D(0,180, 0).add(base));
		return res;
	}
}
