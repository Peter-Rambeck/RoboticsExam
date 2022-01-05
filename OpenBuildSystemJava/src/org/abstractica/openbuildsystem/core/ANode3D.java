package org.abstractica.openbuildsystem.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ANode3D implements Node3D
{
	private final List<Geometry3D> children;

	public ANode3D()
	{
		children = new ArrayList<>(1);
	}

	@Override
	public Node3D add(Geometry3D geometry3D)
	{
		children.add(geometry3D);
		return this;
	}

	@Override
	public Iterator<Geometry3D> iterator()
	{
		return Collections.unmodifiableList(children).iterator();
	}
}
