package org.abstractica.openbuildsystem.library.assemblies;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;

import java.util.ArrayList;
import java.util.List;

public class ASM
{

	public static Node rotation(double x, double y, double z)
	{
		return new Rotation(x, y, z);
	}

	public static Node translation(double x, double y, double z)
	{
		return new Translation(x,y,z);
	}

	private static class Rotation implements Node
	{
		private final double x, y, z;
		private final List<Component> children;

		public Rotation(double x, double y, double z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
			this.children = new ArrayList<>();
		}

		@Override
		public void addChild(Component component)
		{
			children.add(component);
		}

		@Override
		public Geometry3D generateGeometry()
		{
			Node3D rot = Core.rotate3D(x, y, z);
			for(Component child : children)
			{
				rot.add(child.generateGeometry());
			}
			return rot;
		}

		@Override
		public void collectBOM(BOM bom)
		{
			for(Component child : children)
			{
				child.collectBOM(bom);
			}
		}
	}

	private static class Translation implements Node
	{
		private final double x, y, z;
		private final List<Component> children;

		public Translation(double x, double y, double z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
			this.children = new ArrayList<>();
		}

		@Override
		public void addChild(Component component)
		{
			children.add(component);
		}

		@Override
		public Geometry3D generateGeometry()
		{
			Node3D trans = Core.translate3D(x, y, z);
			for(Component child : children)
			{
				trans.add(child.generateGeometry());
			}
			return trans;
		}

		@Override
		public void collectBOM(BOM bom)
		{
			for(Component child : children)
			{
				child.collectBOM(bom);
			}
		}
	}
}
