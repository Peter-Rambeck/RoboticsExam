package org.abstractica.openbuildsystem.library.assemblies;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;

public abstract class ANamedComponent implements NamedComponent
{
	private final String name;
	private Geometry3D geo = null;

	public ANamedComponent(String name)
	{
		this.name = name;
	}

	@Override
	public Geometry3D generateGeometry()
	{
		if(geo == null)
		{
			geo = Core.module3D(getName(), doGenerateGeometry());
		}
		return geo;
	}

	protected abstract Geometry3D doGenerateGeometry();

	@Override
	public String getName()
	{
		return name;
	}
}
