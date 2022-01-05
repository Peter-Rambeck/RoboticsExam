package org.abstractica.openbuildsystem.openscad;

import org.abstractica.openbuildsystem.core.*;
import org.abstractica.openbuildsystem.core.Module;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OpenSCADGenerator
{
	public static void generate(CodeBuilder res, Geometry geometry)
	{
		Map<String, Module> usedModules = new HashMap<>();
		generateGeometry(usedModules, res, geometry);
		res.addLine("\n");
		Map<String, Module> generatedModules = new HashMap<>();
		generateModules(generatedModules, usedModules, res);
	}

	private static void generateGeometry(Map<String, Module> usedModules, CodeBuilder cb, Geometry geometry)
	{
		if(geometry instanceof Geometry2D)
		{
			generateGeometry2D(usedModules, cb, (Geometry2D) geometry);
		}
		else if(geometry instanceof Geometry3D)
		{
			generateGeometry3D(usedModules, cb, (Geometry3D) geometry);
		}
		else
		{
			throw new RuntimeException("Unkown geometry: " + geometry);
		}
	}

	private static void generateModules(Map<String, Module> generatedModules, Map<String, Module> modules, CodeBuilder cb)
	{
		Map<String, Module> usedModules = new HashMap<>();
		for(Module m : modules.values())
		{
			cb.addLine("module " + m.getName() + "()");
			cb.addLine("{");
			cb.indent();
			if(m instanceof Module2D)
			{
				generateGeometry2D(usedModules, cb, ((Module2D) m).getGeometry2D());
			}
			else if(m instanceof Module3D)
			{
				generateGeometry3D(usedModules, cb, ((Module3D) m).getGeometry3D());
			}
			else
			{
				throw new RuntimeException("Unknown module!");
			}
			cb.undent();
			cb.addLine("}\n");
			generatedModules.put(m.getName(), m);
		}
		if(usedModules.size() > 0)
		{
			Map<String, Module> newModules = new HashMap<>();
			for (Module m : usedModules.values())
			{
				if (!generatedModules.containsKey(m.getName()))
				{
					newModules.put(m.getName(), m);
				}
			}
			if (newModules.size() > 0)
			{
				generateModules(generatedModules, newModules, cb);
			}
		}
	}

	private static void generateModule(Map<String, Module> usedModules, CodeBuilder cb, Module module)
	{
		cb.addLine(module.getName() + "();");
		usedModules.put(module.getName(), module);
	}

	private static void generateGeometry2D(Map<String, Module> usedModules, CodeBuilder cb, Geometry2D geometry2D)
	{
		if(geometry2D instanceof Module)
		{
			generateModule(usedModules, cb, (Module) geometry2D);
		}
		else if(geometry2D instanceof Union2D)
		{
			generateUnion2D(usedModules, cb,(Union2D) geometry2D);
		}
		else if(geometry2D instanceof Intersection2D)
		{
			generateIntersection2D(usedModules, cb,(Intersection2D) geometry2D);
		}
		else if(geometry2D instanceof Difference2D)
		{
			generateDifference2D(usedModules, cb,(Difference2D) geometry2D);
		}
		else if(geometry2D instanceof Hull2D)
		{
			generateHull2D(usedModules, cb,(Hull2D) geometry2D);
		}
		else if(geometry2D instanceof Translate2D)
		{
			generateTranslate2D(usedModules, cb,(Translate2D) geometry2D);
		}
		else if(geometry2D instanceof Rotate2D)
		{
			generateRotate2D(usedModules, cb,(Rotate2D) geometry2D);
		}
		else if(geometry2D instanceof Scale2D)
		{
			generateScale2D(usedModules, cb,(Scale2D) geometry2D);
		}
		else if(geometry2D instanceof Mirror2D)
		{
			generateMirror2D(usedModules, cb,(Mirror2D) geometry2D);
		}
		else if(geometry2D instanceof ProjectedGeometry2D)
		{
			generateProjectedGeometry2D(usedModules, cb,(ProjectedGeometry2D) geometry2D);
		}
		else if(geometry2D instanceof Circle2D)
		{
			generateCircle2D(cb,(Circle2D) geometry2D);
		}
		else if(geometry2D instanceof Rect2D)
		{
			generateRect2D(cb,(Rect2D) geometry2D);
		}
		else if(geometry2D instanceof Polygon2D)
		{
			generatePolygon2D(cb,(Polygon2D) geometry2D);
		}

		else
		{
			throw new RuntimeException("Unknown Geometry2D: " + geometry2D);
		}
	}

	private static void generateUnion2D(Map<String, Module> usedModules, CodeBuilder cb, Union2D union2D)
	{
		cb.addLine("union()");
		generateNode2D(usedModules, cb, union2D);
	}

	private static void generateIntersection2D(Map<String, Module> usedModules, CodeBuilder cb, Intersection2D intersection2D)
	{
		cb.addLine("intersection()");
		generateNode2D(usedModules, cb, intersection2D);
	}


	private static void generateDifference2D(Map<String, Module> usedModules, CodeBuilder cb, Difference2D difference2D)
	{
		cb.addLine("difference()");
		generateNode2D(usedModules, cb, difference2D);
	}

	private static void generateHull2D(Map<String, Module> usedModules, CodeBuilder cb, Hull2D hull2D)
	{
		cb.addLine("hull()");
		generateNode2D(usedModules, cb, hull2D);
	}

	private static void generateTranslate2D(Map<String, Module> usedModules, CodeBuilder cb, Translate2D translate2D)
	{
		cb.addLine("translate([" + d(translate2D.getX()) + ", " + d(translate2D.getY()) + "])");
		generateNode2D(usedModules, cb, translate2D);
	}

	private static void generateRotate2D(Map<String, Module> usedModules, CodeBuilder cb, Rotate2D rotate2D)
	{
		cb.addLine("rotate([" + d(rotate2D.getX()) + ", " + d(rotate2D.getY()) + ", " + d(rotate2D.getZ()) + "])");
		generateNode2D(usedModules, cb, rotate2D);
	}

	private static void generateScale2D(Map<String, Module> usedModules, CodeBuilder cb, Scale2D scale2D)
	{
		cb.addLine("scale([" + d(scale2D.getX()) + ", " + d(scale2D.getY()) + ", 1])");
		generateNode2D(usedModules, cb, scale2D);
	}

	private static void generateMirror2D(Map<String, Module> usedModules, CodeBuilder cb, Mirror2D mirror2D)
	{
		cb.addLine("mirror([" + d(mirror2D.getNormX()) + ", " + d(mirror2D.getNormY()) + ", 0])");
		generateNode2D(usedModules, cb, mirror2D);
	}

	private static void generateProjectedGeometry2D(Map<String, Module> usedModules, CodeBuilder cb, ProjectedGeometry2D projectedGeometry2D)
	{
		if(projectedGeometry2D.getCut())
		{
			cb.addLine("projection(cut = true)");
		}
		else
		{
			cb.addLine("projection(cut = false)");
		}
		cb.addLine("{");
		cb.indent();
		generateGeometry3D(usedModules, cb, projectedGeometry2D.getGeometry3D());
		cb.undent();
		cb.addLine("}");
	}

	private static void generateCircle2D(CodeBuilder cb, Circle2D circle2D)
	{
		cb.addLine("circle(d = " + d(circle2D.getDiameter()) + ", $fn = " + d(circle2D.getAngularResolution()) + ");");
	}

	private static void generateRect2D(CodeBuilder cb, Rect2D rect2D)
	{
		cb.addLine("square([" + d(rect2D.getX()) + ", " + d(rect2D.getY()) + "]);");
	}

	private static void generatePolygon2D(CodeBuilder cb, Polygon2D polygon2D)
	{
		StringBuilder line = new StringBuilder();
		line.append("polygon(points = [");
		boolean first = true;
		for(Vector2 v : polygon2D.getVertices())
		{
			if(first)
			{
				first = false;
			}
			else
			{
				line.append(", ");
			}
			line.append("[").append(d(v.x)).append(", ").append(d(v.y)).append("]");
		}
		line.append("]");
		if(polygon2D.getPaths() != null && polygon2D.getPaths().size() > 0)
		{
			line.append(", paths = [");
			boolean first2 = true;
			for(Path2D path : polygon2D.getPaths())
			{
				if(first2)
				{
					first2 = false;
				}
				else
				{
					line.append(", ");
				}
				line.append("[");
				boolean first3 = true;
				for(Integer i : path)
				{
					if(first3)
					{
						first3 = false;
					}
					else
					{
						line.append(", ");
					}
					line.append(i);
				}
				line.append("[");
			}
			line.append("]");
		}
		line.append(");");
		cb.addLine(line.toString());
	}


	private static void generateNode2D(Map<String, Module> usedModules, CodeBuilder cb, Node2D node2D)
	{
		cb.addLine("{");
		cb.indent();
		for(Geometry2D geometry2D : node2D)
		{
			generateGeometry2D(usedModules, cb, geometry2D);
		}
		cb.undent();
		cb.addLine("}\n");
	}


	private static void generateGeometry3D(Map<String, Module> usedModules, CodeBuilder cb, Geometry3D geometry3D)
	{
		if(geometry3D instanceof Module)
		{
			generateModule(usedModules, cb, (Module) geometry3D);
		}
		else if(geometry3D instanceof Union3D)
		{
			generateUnion3D(usedModules, cb,(Union3D) geometry3D);
		}
		else if(geometry3D instanceof Intersection3D)
		{
			generateIntersection3D(usedModules, cb,(Intersection3D) geometry3D);
		}
		else if(geometry3D instanceof Difference3D)
		{
			generateDifference3D(usedModules, cb,(Difference3D) geometry3D);
		}
		else if(geometry3D instanceof Hull3D)
		{
			generateHull3D(usedModules, cb,(Hull3D) geometry3D);
		}
		else if(geometry3D instanceof Translate3D)
		{
			generateTranslate3D(usedModules, cb,(Translate3D) geometry3D);
		}
		else if(geometry3D instanceof Rotate3D)
		{
			generateRotate3D(usedModules, cb,(Rotate3D) geometry3D);
		}
		else if(geometry3D instanceof Scale3D)
		{
			generateScale3D(usedModules, cb,(Scale3D) geometry3D);
		}
		else if(geometry3D instanceof Mirror3D)
		{
			generateMirror3D(usedModules, cb,(Mirror3D) geometry3D);
		}
		else if(geometry3D instanceof LinearExtrude3D)
		{
			generateLinearExtrude(usedModules, cb,(LinearExtrude3D) geometry3D);
		}
		else if(geometry3D instanceof RotateExtrude3D)
		{
			generateRotateExtrude(usedModules, cb,(RotateExtrude3D) geometry3D);
		}
		else if(geometry3D instanceof ColorName)
		{
			generateColorName(usedModules, cb,(ColorName) geometry3D);
		}
		else if(geometry3D instanceof ColorRGBA)
		{
			generateColorRGBA(usedModules, cb, (ColorRGBA) geometry3D);
		}
		else if(geometry3D instanceof Box3D)
		{
			generateBox3D(cb,(Box3D) geometry3D);
		}
		else if(geometry3D instanceof Cylinder3D)
		{
			generateCylinder3D(cb,(Cylinder3D) geometry3D);
		}
		else if(geometry3D instanceof Cone3D)
		{
			generateCone3D(cb,(Cone3D) geometry3D);
		}

		else
		{
			throw new RuntimeException("Unknown Geometry3D: " + geometry3D);
		}
	}

	private static void generateUnion3D(Map<String, Module> usedModules, CodeBuilder cb, Union3D union3D)
	{
		cb.addLine("union()");
		generateNode3D(usedModules, cb, union3D);
	}

	private static void generateIntersection3D(Map<String, Module> usedModules, CodeBuilder cb, Intersection3D intersection3D)
	{
		cb.addLine("intersection()");
		generateNode3D(usedModules, cb, intersection3D);
	}


	private static void generateDifference3D(Map<String, Module> usedModules, CodeBuilder cb, Difference3D difference3D)
	{
		cb.addLine("difference()");
		generateNode3D(usedModules, cb, difference3D);
	}

	private static void generateHull3D(Map<String, Module> usedModules, CodeBuilder cb, Hull3D hull3D)
	{
		cb.addLine("hull()");
		generateNode3D(usedModules, cb, hull3D);
	}

	private static void generateTranslate3D(Map<String, Module> usedModules, CodeBuilder cb, Translate3D translate3D)
	{
		cb.addLine("translate([" + d(translate3D.getX()) + ", " + d(translate3D.getY()) + ", " + d(translate3D.getZ()) + "])");
		generateNode3D(usedModules, cb, translate3D);
	}

	private static void generateRotate3D(Map<String, Module> usedModules, CodeBuilder cb, Rotate3D rotate3D)
	{
		cb.addLine("rotate([" + d(rotate3D.getX()) + ", " + d(rotate3D.getY()) + ", " + d(rotate3D.getZ()) + "])");
		generateNode3D(usedModules, cb, rotate3D);
	}

	private static void generateScale3D(Map<String, Module> usedModules, CodeBuilder cb, Scale3D scale3D)
	{
		cb.addLine("scale([" + d(scale3D.getX()) + ", " + d(scale3D.getY()) + ", "+ d(scale3D.getZ()) + "])");
		generateNode3D(usedModules, cb, scale3D);
	}

	private static void generateMirror3D(Map<String, Module> usedModules, CodeBuilder cb, Mirror3D mirror3D)
	{
		cb.addLine("mirror([" + d(mirror3D.getNormX()) + ", " + d(mirror3D.getNormY()) + ", " + d(mirror3D.getNormZ()) + "])");
		generateNode3D(usedModules, cb, mirror3D);
	}

	private static void generateLinearExtrude(Map<String, Module> usedModules, CodeBuilder cb, LinearExtrude3D linearExtrude3D)
	{
		StringBuilder line = new StringBuilder();
		line.append("linear_extrude(height = ");
		line.append(d(linearExtrude3D.getHeight()));
		line.append(", twist = ");
		line.append(d(linearExtrude3D.getTwist()));
		line.append(", scale = ");
		line.append(d(linearExtrude3D.getScale()));
		line.append(", slices = ");
		line.append(linearExtrude3D.getSlices());
		line.append(", convexity = ");
		line.append(linearExtrude3D.getConvexity());
		line.append(")");
		cb.addLine(line.toString());
		cb.addLine("{");
		cb.indent();
		generateGeometry2D(usedModules, cb, linearExtrude3D.getGeometry2D());
		cb.undent();
		cb.addLine("}");
	}

	private static void generateRotateExtrude(Map<String, Module> usedModules, CodeBuilder cb, RotateExtrude3D rotateExtrude3D)
	{
		StringBuilder line = new StringBuilder();
		line.append("rotate_extrude(angle = ");
		line.append(d(rotateExtrude3D.getAngle()));
		line.append(", convexity = ");
		line.append(rotateExtrude3D.getConvexity());
		line.append(", $fn = ");
		line.append(rotateExtrude3D.getAngularResolution());
		line.append(")");
		cb.addLine(line.toString());
		cb.addLine("{");
		cb.indent();
		generateGeometry2D(usedModules, cb, rotateExtrude3D.getGeometry2D());
		cb.undent();
		cb.addLine("}");
	}

	private static void generateColorName(Map<String, Module> usedModules, CodeBuilder cb, ColorName colorName)
	{
		cb.addLine("color(\"" + colorName.getColorName() + "\")");
		generateNode3D(usedModules, cb, colorName);
	}

	private static void generateColorRGBA(Map<String, Module> usedModules, CodeBuilder cb, ColorRGBA colorRGBA)
	{
		cb.addLine("color([" + (colorRGBA.getR() / 255.0)  + ", " +
				(colorRGBA.getG() / 255.0)+ ", " +
				(colorRGBA.getB() / 255.0) + "], " +
				(colorRGBA.getA() / 255.0) + ")");
		generateNode3D(usedModules, cb, colorRGBA);
	}

	private static void generateBox3D(CodeBuilder cb, Box3D box3D)
	{
		cb.addLine("cube([" + d(box3D.getX()) + ", " + d(box3D.getY()) + ", " + d(box3D.getZ()) + "]);");
	}

	private static void generateCylinder3D(CodeBuilder cb, Cylinder3D cylinder3D)
	{
		cb.addLine("cylinder(d = " + d(cylinder3D.getDiameter()) +
				", h = " + d(cylinder3D.getHeight()) +
				", $fn = " + cylinder3D.getAngularResolution() + ");");
	}

	private static void generateCone3D(CodeBuilder cb, Cone3D cone3D)
	{
		cb.addLine("cylinder(d1 = " + d(cone3D.getBottomDiameter()) +
				", d2 = " + d(cone3D.getTopDiameter()) +
				", h = " + d(cone3D.getHeight()) +
				", $fn = " + cone3D.getAngularResolution() + ");");
	}

	private static void generateNode3D(Map<String, Module> usedModules, CodeBuilder cb, Node3D node3D)
	{
		cb.addLine("{");
		cb.indent();
		for(Geometry3D geometry3D : node3D)
		{
			generateGeometry3D(usedModules, cb, geometry3D);
		}
		cb.undent();
		cb.addLine("}");
	}

	private static String d(double d)
	{
		return String.format(Locale.ENGLISH,"%.4f", d);
	}
}
