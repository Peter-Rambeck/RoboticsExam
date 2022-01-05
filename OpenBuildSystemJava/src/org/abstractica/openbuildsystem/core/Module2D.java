package org.abstractica.openbuildsystem.core;

public class Module2D extends AModule implements Geometry2D
{
	private final Geometry2D geometry2D;

	public Module2D(String name, Geometry2D geometry2D)
	{
		super(name);
		this.geometry2D = geometry2D;
	}
	public Geometry2D getGeometry2D()
	{
		return geometry2D;
	}
}
