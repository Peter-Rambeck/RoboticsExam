package org.abstractica.openbuildsystem.core;

public class ProjectedGeometry2D implements Geometry2D
{
	private final Geometry3D geometry;
	private final boolean cut;

	public ProjectedGeometry2D(Geometry3D geometry, boolean cut)
	{
		this.geometry = geometry;
		this.cut = cut;
	}

	public Geometry3D getGeometry3D()
	{
		return geometry;
	}

	public boolean getCut()
	{
		return cut;
	}
}
