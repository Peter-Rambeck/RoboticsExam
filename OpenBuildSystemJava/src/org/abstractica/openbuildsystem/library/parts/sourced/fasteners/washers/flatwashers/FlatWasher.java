package org.abstractica.openbuildsystem.library.parts.sourced.fasteners.washers.flatwashers;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.library.geometry.Geometry;
import org.abstractica.openbuildsystem.library.parts.APart;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.washers.Washer;

public class FlatWasher extends APart implements Washer
{
	private final double innerDiameter;
	private final double outerDiameter;
	private final double thickness;

	public FlatWasher(String sizeName, double innerDiameter, double outerDiameter, double thickness)
	{
		super("Flat_Washer_" + sizeName);
		this.innerDiameter = innerDiameter;
		this.outerDiameter = outerDiameter;
		this.thickness = thickness;
	}

	@Override
	protected Geometry3D doGenerateGeometry()
	{
		return Core.color("silver")
				.add(Geometry.flatRing(innerDiameter, outerDiameter, thickness, 32));
	}

	@Override
	public double getOuterDiameter()
	{
		return outerDiameter;
	}

	@Override
	public double getInnerDiameter()
	{
		return innerDiameter;
	}

	@Override
	public double getThickness()
	{
		return thickness;
	}
}
