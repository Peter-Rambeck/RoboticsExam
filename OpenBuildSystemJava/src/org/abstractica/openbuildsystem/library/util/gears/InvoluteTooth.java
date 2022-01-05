package org.abstractica.openbuildsystem.library.util.gears;

import org.abstractica.openbuildsystem.core.Geometry2D;
import org.abstractica.openbuildsystem.core.Vector2;

public class InvoluteTooth
{
	public final  Geometry2D toothGeometry;
	public final Vector2 connectionPointRight;
	public final Vector2 connectionPointLeft;

	public InvoluteTooth(Geometry2D toothGeometry, Vector2 connectionPointRight, Vector2 connectionPointLeft)
	{
		this.toothGeometry = toothGeometry;
		this.connectionPointRight = connectionPointRight;
		this.connectionPointLeft = connectionPointLeft;
	}
}
