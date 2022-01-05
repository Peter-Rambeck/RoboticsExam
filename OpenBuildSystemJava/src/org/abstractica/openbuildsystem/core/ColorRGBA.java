package org.abstractica.openbuildsystem.core;

public class ColorRGBA extends ANode3D
{
	private final double r,g,b,a;

	ColorRGBA(double r, double g, double b, double a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public double getR()
	{
		return r;
	}

	public double getG()
	{
		return g;
	}

	public double getB()
	{
		return b;
	}

	public double getA()
	{
		return a;
	}
}
