package org.abstractica.openbuildsystem.library.parts;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.library.assemblies.ANamedComponent;

import java.util.HashMap;
import java.util.Map;

public abstract class ACutoutPart extends APart implements Cutout
{
	private Map<String, Geometry3D> cutoutMap = new HashMap<>();

	public ACutoutPart(String name)
	{
		super(name);
	}

	@Override
	public Geometry3D getCutout(double fittingXY, double fittingZ, boolean fixOverhang)
	{
		String postFix = getCutoutPostFix(fittingXY, fittingZ, fixOverhang);
		Geometry3D res = cutoutMap.get(postFix);
		if(res == null)
		{
			res = Core.module3D(getName() + "_Cutout_" + postFix,
					doGenerateCutout(fittingXY, fittingZ, fixOverhang));
			cutoutMap.put(postFix, res);
		}
		return res;
	}

	protected abstract Geometry3D doGenerateCutout(double fittingXY, double fittingZ, boolean fixOverhang);

	private static String getCutoutPostFix(double fittingXY, double fittingZ,  boolean fixOverhang)
	{
		StringBuilder res = new StringBuilder();
		res.append((int) (fittingXY * 100));
		res.append('_');
		res.append((int) (fittingZ * 100));
		if(fixOverhang)
		{
			res.append("_FO");
		}
		return res.toString();
	}
}
