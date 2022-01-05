package org.abstractica.openbuildsystem.core;

public class Cone3D implements Geometry3D
{
	private final double bottomDiameter;
	private final double topDiameter;
	private final double height;
	private final int angularResolution;

	Cone3D(double bottomDiameter, double topDiameter, double height, int angularResolution)
	{
		this.bottomDiameter = bottomDiameter;
		this.topDiameter = topDiameter;
		this.height = height;
		this.angularResolution = angularResolution;
	}

	public double getBottomDiameter()
	{
		return bottomDiameter;
	}

	public double getTopDiameter()
	{
		return topDiameter;
	}

	public double getHeight()
	{
		return height;
	}

	public int getAngularResolution()
	{
		return angularResolution;
	}
}
