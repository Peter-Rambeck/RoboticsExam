package org.abstractica.openbuildsystem.core;

public class Translate2D extends ANode2D
{
	private final double x;
	private final double y;

	public Translate2D(double x, double y)
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
