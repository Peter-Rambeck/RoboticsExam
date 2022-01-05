package org.abstractica.openbuildsystem.core;

public class LinearExtrude3D implements Geometry3D
{
	private final Geometry2D geometry2D;
	private final double height;
	private final double twist;
	private final double scale;
	private final int slices;
	private final int convexity;

	public LinearExtrude3D(Geometry2D geometry2D, double height, double twist, double scale, int slices, int convexity)
	{
		this.geometry2D = geometry2D;
		this.height = height;
		this.twist = twist;
		this.scale = scale;
		this.slices = slices;
		this.convexity = convexity;
	}

	public Geometry2D getGeometry2D()
	{
		return geometry2D;
	}

	public double getHeight()
	{
		return height;
	}

	public double getTwist()
	{
		return twist;
	}

	public double getScale()
	{
		return scale;
	}

	public int getSlices()
	{
		return slices;
	}

	public int getConvexity()
	{
		return convexity;
	}
}
