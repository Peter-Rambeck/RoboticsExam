package org.abstractica.openbuildsystem.library.parts.sourced.fasteners.bolts;


import org.abstractica.openbuildsystem.library.assemblies.NamedComponent;
import org.abstractica.openbuildsystem.library.parts.Cutout;

public interface Bolt extends NamedComponent, Cutout
{
	double getDiameter();
	double getLength();
	double getThreadLength();
	double getHeadDiameter();
	double getHeadHeight();
}
