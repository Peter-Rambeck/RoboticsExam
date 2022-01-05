package org.abstractica.openbuildsystem.library.util.math;

public class Transform2D
{
	//  m00 m10 tx
	//  m01 m11 ty
	//    0   0  1
	public final double m00, m10, m01, m11;
	public final double tx, ty;

	public Transform2D(double m00, double m10, double m01, double m11, double tx, double ty)
	{
		this.m00 = m00;
		this.m10 = m10;
		this.m01 = m01;
		this.m11 = m11;
		this.tx = tx;
		this.ty = ty;
	}
}
