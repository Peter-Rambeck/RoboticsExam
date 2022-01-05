package org.abstractica.openbuildsystem.core;

public interface Node2D extends Geometry2D, Iterable<Geometry2D>
{
	Node2D add(Geometry2D child);
}
