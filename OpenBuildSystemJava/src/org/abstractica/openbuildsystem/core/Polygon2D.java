package org.abstractica.openbuildsystem.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polygon2D implements Geometry2D
{
	private final List<Vector2> vertices;
	private final List<Path2D> paths;
	public Polygon2D(Iterable<Vector2> vertices, Iterable<Path2D> paths)
	{
		ArrayList<Vector2> newVertices = new ArrayList<>();
		ArrayList<Path2D> newPaths = new ArrayList<>();
		for(Vector2 v : vertices)
		{
			newVertices.add(v);
		}
		this.vertices = Collections.unmodifiableList(newVertices);
		for (Path2D path : paths)
		{
			newPaths.add(path);
		}
		this.paths = Collections.unmodifiableList(newPaths);
	}

	public Polygon2D(Iterable<Vector2> vertices)
	{
		ArrayList<Vector2> newPoints = new ArrayList<>();
		for(Vector2 v : vertices)
		{
			newPoints.add(v);
		}
		this.vertices = Collections.unmodifiableList(newPoints);
		this.paths = null;
	}

	public List<Vector2> getVertices()
	{
		return vertices;
	}

	public List<Path2D> getPaths()
	{
		return paths;
	}
}
