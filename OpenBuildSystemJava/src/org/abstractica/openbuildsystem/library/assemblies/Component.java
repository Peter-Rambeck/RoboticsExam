package org.abstractica.openbuildsystem.library.assemblies;

import org.abstractica.openbuildsystem.core.Geometry3D;

public interface Component
{
	Geometry3D generateGeometry();
	void collectBOM(BOM bom);
}
