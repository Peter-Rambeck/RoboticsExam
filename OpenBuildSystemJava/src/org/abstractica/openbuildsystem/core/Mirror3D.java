package org.abstractica.openbuildsystem.core;

public class Mirror3D extends ANode3D
{
	private final double normX;
	private final double normY;
	private final double normZ;

	public Mirror3D(double normX, double normY, double normZ)
	{
		this.normX = normX;
		this.normY = normY;
		this.normZ = normZ;
	}

	public double getNormX()
	{
		return normX;
	}

	public double getNormY()
	{
		return normY;
	}

	public double getNormZ()
	{
		return normZ;
	}
}
