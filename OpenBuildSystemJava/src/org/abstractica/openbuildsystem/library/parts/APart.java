package org.abstractica.openbuildsystem.library.parts;

import org.abstractica.openbuildsystem.library.assemblies.ANamedComponent;
import org.abstractica.openbuildsystem.library.assemblies.BOM;

public abstract class APart extends ANamedComponent
{

	public APart(String name)
	{
		super(name);
	}

	@Override
	public void collectBOM(BOM bom)
	{
		bom.addPart(getName());
	}
}
