package org.abstractica.openbuildsystem.library.parts;

import org.abstractica.openbuildsystem.core.Geometry3D;

public interface Cutout
{
	Geometry3D getCutout(double fittingXY, double fittingZ, boolean fixOverhang);
}
