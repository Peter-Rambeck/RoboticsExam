package org.abstractica.openbuildsystem.library.util.math;

import org.abstractica.openbuildsystem.core.Vector2;

public class LinAlg
{
	public static Transform3D mul(Transform3D a, Transform3D b)
	{
		//                      m00 m10 m20 tx
		//                    b m01 m11 m21 ty
		//                      m02 m12 m22 tz
		//                       0   0   0  1
		//         a
		//  m00 m10 m20 tx      m00 m10 m20 tx
		//  m01 m11 m21 ty      m01 m11 m21 ty
		//  m02 m12 m22 tz      m02 m12 m22 tz
		//    0   0   0  1

		double m00 = a.m00*b.m00 + a.m10*b.m01 + a.m20 * b.m02;
		double m10 = a.m00*b.m10 + a.m10*b.m11 + a.m20 * b.m12;
		double m20 = a.m00*b.m20 + a.m10*b.m21 + a.m20 * b.m22;

		double m01 = a.m01*b.m00 + a.m11*b.m01 + a.m21 * b.m02;
		double m11 = a.m01*b.m10 + a.m11*b.m11 + a.m21 * b.m12;
		double m21 = a.m01*b.m20 + a.m11*b.m21 + a.m21 * b.m22;

		double m02 = a.m02*b.m00 + a.m12*b.m01 + a.m22 * b.m02;
		double m12 = a.m02*b.m10 + a.m12*b.m11 + a.m22 * b.m12;
		double m22 = a.m02*b.m20 + a.m12*b.m21 + a.m22 * b.m22;

		double tx = a.m00*b.tx + a.m10*b.ty + a.m20*b.tz + a.tx;
		double ty = a.m01*b.tx + a.m11*b.ty + a.m21*b.tz + a.ty;
		double tz = a.m02*b.tx + a.m12*b.ty + a.m22*b.tz + a.tz;

		return new Transform3D(m00, m10, m20, m01, m11, m21, m02, m12, m22, tx, ty, tz);
	}

	public static Vector2 times(Vector2 v, double d)
	{
		return new Vector2(d*v.x, d*v.y);
	}

	public static Vector2 plus(Vector2 a, Vector2 b)
	{
		return new Vector2(a.x+b.x, a.y+b.y);
	}

	public static Vector2 minus(Vector2 a, Vector2 b)
	{
		return new Vector2(a.x-b.x, a.y-b.y);
	}

	public static Vector2 fromTo(Vector2 a, Vector2 b)
	{
		return minus(b, a);
	}

	public static Vector2 normalized(Vector2 v)
	{
		double f = 1.0 / v.length();
		return new Vector2(f*v.x, f*v.y);
	}

	public static Vector2 perpendicularCW(Vector2 v)
	{
		return new Vector2(v.y, -v.x);
	}

	public static Vector2 perpendicularCCW(Vector2 v)
	{
		return new Vector2(-v.y, v.x);
	}

}
