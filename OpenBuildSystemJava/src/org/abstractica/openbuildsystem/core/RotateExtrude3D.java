package org.abstractica.openbuildsystem.core;

public class RotateExtrude3D implements Geometry3D
{
	private final Geometry2D geometry2D;
	private final double angle;
	private final int angularResolution;
	private final int convexity;

	public RotateExtrude3D(Geometry2D geometry2D, double angle, int angularResolution, int convexity)
	{
		this.geometry2D = geometry2D;
		this.angle = angle;
		this.angularResolution = angularResolution;
		this.convexity = convexity;
	}

	public Geometry2D getGeometry2D()
	{
		return geometry2D;
	}

	public double getAngle()
	{
		return angle;
	}

	public int getAngularResolution()
	{
		return angularResolution;
	}

	public int getConvexity()
	{
		return convexity;
	}
}
