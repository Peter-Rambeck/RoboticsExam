package org.abstractica.openbuildsystem.library.util.math;

public class Transform3D
{
	//  m00 m10 m20 tx
	//  m01 m11 m21 ty
	//  m02 m12 m22 tz
	//    0   0   0  1
	public final double m00, m10, m20, m01, m11, m21, m02, m12, m22;
	public final double tx, ty, tz;

	public Transform3D(double m00, double m10, double m20, double m01, double m11, double m21, double m02, double m12, double m22, double tx, double ty, double tz)
	{
		this.m00 = m00;
		this.m10 = m10;
		this.m20 = m20;
		this.m01 = m01;
		this.m11 = m11;
		this.m21 = m21;
		this.m02 = m02;
		this.m12 = m12;
		this.m22 = m22;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
	}
}
