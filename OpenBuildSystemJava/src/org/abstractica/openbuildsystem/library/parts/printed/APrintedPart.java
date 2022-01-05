package org.abstractica.openbuildsystem.library.parts.printed;

import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.library.parts.APart;

public abstract class APrintedPart extends APart implements Printable
{
	private Geometry3D printGeometry = null;

	public APrintedPart(String name)
	{
		super(name);
	}

	@Override
	public Geometry3D getPrintGeometry()
	{
		if(printGeometry == null)
		{
			printGeometry = doGeneratePrintGeometry();
		}
		return printGeometry;
	}

	protected abstract Geometry3D doGeneratePrintGeometry();
}
