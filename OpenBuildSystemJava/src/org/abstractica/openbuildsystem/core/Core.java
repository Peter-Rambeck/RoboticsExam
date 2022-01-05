package org.abstractica.openbuildsystem.core;

import java.util.ArrayList;

public class Core
{
	public static Module2D module2D(String name, Geometry2D geometry2D)
	{
		return new Module2D(name, geometry2D);
	}

	public static Module3D module3D(String name, Geometry3D geometry3D)
	{
		return new Module3D(name, geometry3D);
	}

	public static Vector2 vector2(double x, double y)
	{
		return new Vector2(x,y);
	}

	public static Vector3 vector3(double x, double y, double z)
	{
		return new Vector3(x, y, z);
	}

	public static Path2D path2D(Iterable<Integer> path)
	{
		return new Path2D(path);
	}

	public static Geometry2D polygon2D(Iterable<Vector2> vertices)
	{
		return new Polygon2D(vertices);
	}

	public static Geometry2D polygon2DMultiPaths(Iterable<Vector2> points, Iterable<Path2D> paths)
	{
		return new Polygon2D(points, paths);
	}

	public static Geometry2D polygon2D(Iterable<Vector2> points, Iterable<Integer> path)
	{
		ArrayList<Path2D> paths = new ArrayList<>();
		paths.add(path2D(path));
		return polygon2DMultiPaths(points, paths);
	}

	public static Geometry2D circle2D(double diameter, int angularResolution)
	{
		return new Circle2D(diameter, angularResolution);
	}

	public static Geometry2D rect2D(double x, double y)
	{
		return new Rect2D(x,y);
	}

	public static Node2D translate2D(double x, double y)
	{
		return new Translate2D(x,y);
	}

	public static Node2D rotate2D(double x, double y, double z)
	{
		return new Rotate2D(x,y,z);
	}

	public static Node2D rotate2D(double angle)
	{
		return new Rotate2D(0,0,angle);
	}

	public static Node2D scale2D(double x, double y)
	{
		return new Scale2D(x, y);
	}

	public static Node2D mirror2D(Vector2 vector)
	{
		return new Mirror2D(vector.x, vector.y);
	}

	public static Node2D mirror2D(double x, double y)
	{
		return new Mirror2D(x,y);
	}

	public static Node2D union2D()
	{
		return new Union2D();
	}

	public static Node2D intersection2D()
	{
		return new Intersection2D();
	}

	public static Node2D difference2D()
	{
		return new Difference2D();
	}

	public static Node2D hull2D()
	{
		return new Hull2D();
	}

	public static Geometry3D sphere3D(double diameter, int angularResolution)
	{
		return new Sphere3D(diameter, angularResolution);
	}

	public static Geometry3D cylinder3D(double diameter, double height, int angularResolution)
	{
		return new Cylinder3D(diameter, height, angularResolution);
	}

	public static Geometry3D cone3D(double bottomDiameter, double topDiameter, double height, int angularResolution)
	{
		return new Cone3D(bottomDiameter, topDiameter, height, angularResolution);
	}

	public static Geometry3D box3D(double sizeX, double sizeY, double sizeZ)
	{
		return new Box3D(sizeX, sizeY, sizeZ);
	}

	public static Node3D translate3D(double x, double y, double z)
	{
		return new Translate3D(x,y,z);
	}

	public static Node3D rotate3D(double x, double y, double z)
	{
		return new Rotate3D(x,y,z);
	}

	public static Node3D scale3D(double x, double y, double z)
	{
		return new Scale3D(x,y,z);
	}

	public static Node3D mirror3D(double x, double y, double z)
	{
		return new Mirror3D(x,y,z);
	}

	public static Node3D union3D()
	{
		return new Union3D();
	}

	public static Node3D intersection3D()
	{
		return new Intersection3D();
	}

	public static Node3D difference3D()
	{
		return new Difference3D();
	}

	public static Node3D hull3D()
	{
		return new Hull3D();
	}

	public static Node3D color(String name)
	{
		return new ColorName(name);
	}

	public static Node3D color(int r, int g, int b)
	{
		double dr = r / 255.0;
		double dg = g / 255.0;
		double db = b / 255.0;
		return new ColorRGBA(r,g,b,1.0);
	}

	public static Node3D color(int r, int g, int b, int a)
	{
		double dr = r / 255.0;
		double dg = g / 255.0;
		double db = b / 255.0;
		double da = a / 255.0;
		return new ColorRGBA(r,g,b,a);
	}

	public static Geometry3D linearExtrude(Geometry2D geometry2D, double height, double twist, double scale, int slices, int convexity)
	{
		return new LinearExtrude3D(geometry2D, height, twist, scale, slices, convexity);
	}

	public static Geometry3D rotateExtrude(Geometry2D geometry2D, double angle, int angularResolution, int convexity)
	{
		return new RotateExtrude3D(geometry2D, angle, angularResolution, convexity);
	}

	public static Geometry2D project(Geometry3D geometry3D, boolean cut)
	{
		return new ProjectedGeometry2D(geometry3D, cut);
	}
}
