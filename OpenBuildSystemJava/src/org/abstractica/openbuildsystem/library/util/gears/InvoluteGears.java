package org.abstractica.openbuildsystem.library.util.gears;

import org.abstractica.openbuildsystem.core.*;
import org.abstractica.openbuildsystem.library.util.math.LinAlg;

import java.util.ArrayList;
import java.util.List;

public class InvoluteGears
{

	public static Geometry2D rack2D(GearData gearData, double pitchHeight, double fitting)
	{
		double height = 2 * gearData.module;
		double slopeWidth = Math.tan(gearData.pressureAngle) * height;
		double topBottomWidth = (gearData.pitch - 2 * slopeWidth) * 0.5;
		List<Vector2> points = new ArrayList<>();
		double x = -(slopeWidth + 0.5 * topBottomWidth);
		double y = -pitchHeight;
		points.add(new Vector2(x, y));
		y += pitchHeight - gearData.module;
		points.add(new Vector2(x, y));
		x += slopeWidth;
		y += 2.0 * gearData.module;
		points.add(new Vector2(x, y));
		x += topBottomWidth;
		points.add(new Vector2(x, y));
		x += slopeWidth;
		y -= 2.0 * gearData.module;
		points.add(new Vector2(x, y));
		for (int i = 1; i < gearData.numberOfTeeth; ++i)
		{
			x += topBottomWidth;
			points.add(new Vector2(x, y));
			x += slopeWidth;
			y += 2.0 * gearData.module;
			points.add(new Vector2(x, y));
			x += topBottomWidth;
			points.add(new Vector2(x, y));
			x += slopeWidth;
			y -= 2.0 * gearData.module;
			points.add(new Vector2(x, y));
		}
		y -= pitchHeight - gearData.module;
		points.add(new Vector2(x, y));
		return Core.polygon2D(points);
	}

	public static Geometry3D involuteGear3D(GearData gearData, double height, double fitting)
	{
		Geometry2D gear2D = involuteGear2D(gearData, fitting);
		return Core.linearExtrude(gear2D, height, 0, 1, 2, 10);
	}

	public static Geometry2D involuteGear2D(GearData gearData, double fitting)
	{
		Node2D union = Core.union2D();
		InvoluteTooth tooth = involuteTooth2D(gearData, fitting);
		List<Vector2> center = new ArrayList<>();
		for (int i = 0; i < gearData.numberOfTeeth; ++i)
		{
			Vector2 nextRight = rotate(tooth.connectionPointRight, i * gearData.pitchAngle);
			Vector2 nextLeft = rotate(tooth.connectionPointLeft, i * gearData.pitchAngle);
			center.add(nextRight);
			center.add(nextLeft);
			Node2D rot = Core.rotate2D(Math.toDegrees(i * gearData.pitchAngle));
			rot.add(tooth.toothGeometry);
			union.add(rot);
		}
		Geometry2D centerGeometry = Core.polygon2D(center);
		union.add(centerGeometry);
		return Core.module2D("InvoluteGear2D" + gearData.getStringID(), union);
	}

	public static InvoluteTooth involuteTooth2D(GearData gearData, double fitting)
	{
		//Cutout
		List<Vector2> cutoutPoints = cutout(gearData, fitting);
		//Find closest to origo
		double minSqrDist = Double.MAX_VALUE;
		Vector2 minPoint = null;
		for (Vector2 point : cutoutPoints)
		{
			double x = point.x;
			double y = point.y;
			double sqrDist = x * x + y * y;
			if (sqrDist < minSqrDist)
			{
				minSqrDist = sqrDist;
				minPoint = point;
			}
		}
		double minDist = Math.sqrt(minSqrDist);
		Vector2 polarMinPoint = cartesianToPolar(minPoint);
		//Involute
		List<Vector2> polarPoints = new ArrayList<>();
		int involuteSteps = 32;
		double maxRollOffAngle = Math.acos(gearData.baseRadius / (gearData.tipRadius - fitting));//-2*fitting
		double stepSize = maxRollOffAngle / involuteSteps;
		Vector2 last = null;
		for (int i = 0; i <= involuteSteps; ++i)
		{
			if (last == null)
			{
				last = new Vector2(0, 0);
			}
			Vector2 ci = circleInvolute(last, gearData.baseRadius, i * stepSize, fitting);
			Vector2 polar = new Vector2(ci.x, ci.y - gearData.baseToothAngle * 0.5); //+fittingAngle
			if (polar.x < minDist)
			{
				minDist = polar.x;
				polarMinPoint = polar;
			}
			polarPoints.add(polar);
			last = polarToCartesian(polar);
		}


		List<Vector2> halfToothPoints = new ArrayList<>();
		halfToothPoints.add(new Vector2(0, 0));
		Vector2 polarRight = polarMinPoint;
		Vector2 polarLeft = new Vector2(polarRight.x, -polarRight.y);
		halfToothPoints.add(polarToCartesian(polarMinPoint));
		for (Vector2 polar : polarPoints)
		{
			halfToothPoints.add(polarToCartesian(polar.x, polar.y));
		}
		halfToothPoints.add(new Vector2(gearData.tipRadius - 2 * fitting, 0));
		Geometry2D halfTooth = Core.polygon2D(halfToothPoints);
		Node2D diff = Core.difference2D();
		diff.add(halfTooth);
		diff.add(Core.polygon2D(cutoutPoints));
		Node2D mirror = Core.mirror2D(0, 1);
		mirror.add(diff);
		Node2D union = Core.union2D();
		union.add(mirror);
		union.add(diff);
		Geometry2D tooth = Core.module2D("Tooth" + gearData.getStringID(), union);
		return new InvoluteTooth(tooth, polarToCartesian(polarRight), polarToCartesian(polarLeft));
	}

	public static List<Vector2> cutout(GearData gearData, double fitting)
	{
		//cutout polygon
		List<Vector2> points = new ArrayList<>();
		int steps = 64;
		Vector2 lastPoint = cornerPath(0.0, gearData, fitting);
		for (int i = 1; i <= steps; ++i)
		{
			double t = i * (3.0 / steps);
			double rotAngle = -t * gearData.pitchAngle;
			Vector2 point = cornerPath(t, gearData, fitting);
			Vector2 rotatedPoint = rotate(point.x, point.y, rotAngle);
			points.add(rotatedPoint);
		}
		return points;
	}

	private static Vector2 cornerPath(double t, GearData gearData, double fitting)
	{
		double slopeWidth = Math.tan(gearData.pressureAngle) * 2 * gearData.module;
		double topBottomWidth = (gearData.pitch - 2 * slopeWidth) * 0.5;
		double x = gearData.pitchRadius - gearData.module - 2 * fitting;
		double y = t * gearData.pitch - (slopeWidth + 0.5 * topBottomWidth) + fitting;
		return new Vector2(x, y);

	}

	//    Circle involute function:
	//    Returns the polar coordinates of an involute of a circle
	//    r = radius of the base circle
	//    rho = roll-off angle in radians
	private static Vector2 circleInvolute(Vector2 last, double r, double rho, double fitting)
	{
		Vector2 pointPolar = new Vector2(r / Math.cos(rho), Math.tan(rho) - rho);
		Vector2 pointCartesian = polarToCartesian(pointPolar);
		Vector2 dir = LinAlg.normalized(LinAlg.fromTo(last, pointCartesian));
		Vector2 normal = LinAlg.perpendicularCCW(dir);
		Vector2 adjust = LinAlg.times(normal, fitting);
		return cartesianToPolar(LinAlg.plus(pointCartesian, adjust));
	}


	//Conversions

	private static Vector2 polarToCartesian(Vector2 polar)
	{
		return polarToCartesian(polar.x, polar.y);
	}

	private static Vector2 polarToCartesian(double r, double angle)
	{
		return new Vector2(r * Math.cos(angle), r * Math.sin(angle));
	}

	private static Vector2 cartesianToPolar(Vector2 cartesian)
	{
		return cartesianToPolar(cartesian.x, cartesian.y);
	}

	private static Vector2 cartesianToPolar(double x, double y)
	{
		double r = Math.sqrt(x * x + y * y);
		double angle = Math.atan(y / x);
		return new Vector2(r, angle);
	}

	private static Vector2 rotate(Vector2 point, double angle)
	{
		return rotate(point.x, point.y, angle);
	}

	private static Vector2 rotate(double x, double y, double angle)
	{
		double ca = Math.cos(angle);
		double sa = Math.sin(angle);
		double resX = ca * x - sa * y;
		double resY = sa * x + ca * y;
		return new Vector2(resX, resY);
	}

	private static Vector2 normalized(Vector2 v)
	{
		double f = 1.0 / v.length();
		return new Vector2(f * v.x, f * v.y);
	}
}
