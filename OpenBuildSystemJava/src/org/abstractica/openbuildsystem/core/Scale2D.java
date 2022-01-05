package org.abstractica.openbuildsystem.core;
public class Scale2D extends ANode2D
{
	private final double x;
	private final double y;

	public Scale2D(double x, double y)
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
