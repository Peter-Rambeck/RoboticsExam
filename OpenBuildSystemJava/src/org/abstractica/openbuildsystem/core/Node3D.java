package org.abstractica.openbuildsystem.core;

public interface Node3D extends Geometry3D, Iterable<Geometry3D>
{
		Node3D add(Geometry3D child);
}
