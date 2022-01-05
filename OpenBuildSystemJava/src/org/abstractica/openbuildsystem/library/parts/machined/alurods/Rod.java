package org.abstractica.openbuildsystem.library.parts.machined.alurods;

import org.abstractica.openbuildsystem.library.assemblies.Component;

public interface Rod extends Component
{
	double getUnitSize();
	double getHoleDiameter();
	int getLength();
}
