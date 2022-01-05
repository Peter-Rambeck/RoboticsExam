package org.abstractica.openbuildsystem.library.assemblies;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;

import java.util.ArrayList;
import java.util.List;

public abstract class AAssembly extends ANamedComponent
{
	private List<Component> children;


	public AAssembly(String name)
	{
		super(name);
		this.children = null;
	}

	protected void add(Component child)
	{
		children.add(child);
	}

	protected abstract void assemble();

	@Override
	public Geometry3D doGenerateGeometry()
	{
		if(children == null)
		{
			children = new ArrayList<>();
			assemble();
		}
		Node3D union = Core.union3D();
		for (Component component : children)
		{
			union.add(component.generateGeometry());
		}
		return union;
	}

	@Override
	public void collectBOM(BOM bom)
	{
		if(children == null)
		{
			children = new ArrayList<>();
			assemble();
		}
		for(Component component : children)
		{
			component.collectBOM(bom);
		}
	}
}
