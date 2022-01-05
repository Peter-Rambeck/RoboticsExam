package org.abstractica.openbuildsystem.core;

public class Vector2
{
	public final double x,y;

	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double sqrLength()
	{
		return x*x + y*y;
	}

	public double length()
	{
		return Math.sqrt(sqrLength());
	}
}
