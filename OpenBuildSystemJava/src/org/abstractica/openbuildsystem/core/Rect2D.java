package org.abstractica.openbuildsystem.core;

public class Rect2D implements Geometry2D
{
	private final double x;
	private final double y;

	public Rect2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}
}
