package org.abstractica.openbuildsystem.core;

public class Vector3
{
	public final double x,y,z;

	public Vector3(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double sqrLength()
	{
		return x*x + y*y + z*z;
	}

	public double length()
	{
		return Math.sqrt(sqrLength());
	}
}
