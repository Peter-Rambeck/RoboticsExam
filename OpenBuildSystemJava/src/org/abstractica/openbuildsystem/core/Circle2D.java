package org.abstractica.openbuildsystem.core;

public class Circle2D implements Geometry2D
{
	private final double diameter;
	private final int angularResolution;

	Circle2D(double diameter, int angularResolution)
	{
		this.diameter = diameter;
		this.angularResolution = angularResolution;
	}

	public double getDiameter()
	{
		return diameter;
	}

	public int getAngularResolution()
	{
		return angularResolution;
	}
}
