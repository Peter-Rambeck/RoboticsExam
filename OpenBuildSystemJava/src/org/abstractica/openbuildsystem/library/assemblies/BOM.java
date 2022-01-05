package org.abstractica.openbuildsystem.library.assemblies;

import java.util.*;

public class BOM
{
	private final Map<String, Integer> bom;

	public BOM()
	{
		bom = new HashMap<>();
	}

	public void addPart(String partName)
	{
		Integer count = bom.get(partName);
		if(count == null)
		{
			count = 0;
		}
		++count;
		bom.put(partName, count);
	}

	@Override
	public String toString()
	{
		StringBuilder res = new StringBuilder();
		Object[] array = bom.keySet().toArray();
		Arrays.sort(array);
		for(Object obj : array)
		{
			String key = (String) obj;
			Integer value = bom.get(key);
			res.append(key);
			res.append(": ");
			res.append(value);
			res.append('\n');
		}
		return res.toString();
	}
}
