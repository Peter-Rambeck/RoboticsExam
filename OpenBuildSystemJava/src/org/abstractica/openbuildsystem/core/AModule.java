package org.abstractica.openbuildsystem.core;

public abstract class AModule implements Module
{
	private final String name;

	public AModule(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}
}
