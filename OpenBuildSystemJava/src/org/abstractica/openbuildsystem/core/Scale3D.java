package org.abstractica.openbuildsystem.core;

public class Scale3D extends ANode3D
{
	private final double x;
	private final double y;
	private final double z;

	public Scale3D(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getZ()
	{
		return z;
	}
}
