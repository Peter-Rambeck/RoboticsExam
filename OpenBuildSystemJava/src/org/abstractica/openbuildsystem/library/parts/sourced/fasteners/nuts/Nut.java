package org.abstractica.openbuildsystem.library.parts.sourced.fasteners.nuts;

import org.abstractica.openbuildsystem.library.assemblies.NamedComponent;
import org.abstractica.openbuildsystem.library.parts.Cutout;

public interface Nut extends NamedComponent, Cutout
{
	double getThreadDiameter();
	double getDiameter();
	double getWidth();
	double getHeight();
}
