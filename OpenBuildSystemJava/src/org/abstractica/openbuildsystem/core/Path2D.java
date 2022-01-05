package org.abstractica.openbuildsystem.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Path2D implements Iterable<Integer>
{
	private List<Integer> path;

	public Path2D(Iterable<Integer> path)
	{
		ArrayList<Integer> newList = new ArrayList<>();
		for(Integer i : path)
		{
			newList.add(i);
		}
		this.path = Collections.unmodifiableList(newList);
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return this.path.iterator();
	}
}
