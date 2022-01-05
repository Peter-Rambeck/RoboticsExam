package org.abstractica.openbuildsystem.core;

public class Sphere3D implements Geometry3D
{
	private final double diameter;
	private final int angularResolution;

	Sphere3D(double diameter, int angularResolution)
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
