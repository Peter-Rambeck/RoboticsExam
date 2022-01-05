package org.abstractica.openbuildsystem.library.parts.sourced.fasteners.washers;

import org.abstractica.openbuildsystem.library.assemblies.NamedComponent;

public interface Washer extends NamedComponent
{
	double getOuterDiameter();
	double getInnerDiameter();
	double getThickness();
}
