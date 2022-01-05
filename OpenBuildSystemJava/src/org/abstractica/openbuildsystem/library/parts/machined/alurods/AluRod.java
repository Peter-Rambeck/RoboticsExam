package org.abstractica.openbuildsystem.library.parts.machined.alurods;

import org.abstractica.openbuildsystem.core.Core;
import org.abstractica.openbuildsystem.core.Geometry3D;
import org.abstractica.openbuildsystem.core.Node3D;
import org.abstractica.openbuildsystem.library.parts.APart;

public class AluRod extends APart implements Rod
{
	private final double unitSize;
	private final double holeDiameter;
	private final double materialThickness;
	private final int length;

	public AluRod(double unitSize, double holeDiameter, double materialThickness,  int length)
	{
		super("AluRod_U" + ((int) unitSize) + "_L" + length);
		if (length < 2 || length > 40)
		{
			throw new RuntimeException("Alu rod length must be between 2 and 40. Was " + length);
		}
		this.materialThickness = materialThickness;
		this.unitSize = unitSize;
		this.holeDiameter = holeDiameter;
		this.length = length;
	}

	@Override
	protected Geometry3D doGenerateGeometry()
	{
		Geometry3D outerBody = Core.box3D(unitSize, unitSize, length * unitSize);
		Geometry3D innerBody = Core.box3D(unitSize - 2 * materialThickness, unitSize - 2 * materialThickness, length * unitSize + 2);
		Node3D innerTranslate = Core.translate3D(materialThickness, materialThickness, -1);
		innerTranslate.add(innerBody);
		Node3D body = Core.difference3D();
		body.add(outerBody);
		body.add(innerTranslate);
		Node3D bodyTranslate = Core.translate3D(-0.5 * unitSize, -0.5 * unitSize, -0.5 * unitSize);
		bodyTranslate.add(body);

		Node3D rod = Core.difference3D();
		rod.add(bodyTranslate);

		Geometry3D hole = Core.cylinder3D(holeDiameter, unitSize + 2, 32);
		Node3D holeTranslate = Core.translate3D(0, 0, -1 - 0.5 * unitSize);
		holeTranslate.add(hole);
		Node3D xHole = Core.rotate3D(0, 90, 0);
		xHole.add(holeTranslate);
		Node3D yHole = Core.rotate3D(90, 0, 0);
		yHole.add(holeTranslate);
		Node3D holeCutoutGeometry = Core.union3D();
		holeCutoutGeometry.add(xHole);
		holeCutoutGeometry.add(yHole);
		Geometry3D holeCutout = Core.module3D("AluRod_" + ((int) unitSize) + "_HoleCutout", holeCutoutGeometry);

		for (int i = 0; i < length; ++i)
		{
			Node3D holes = Core.translate3D(0, 0, i * unitSize);
			holes.add(holeCutout);
			rod.add(holes);
		}
		return Core.color("silver").add(rod);
	}

	@Override
	public double getUnitSize()
	{
		return unitSize;
	}

	@Override
	public double getHoleDiameter()
	{
		return holeDiameter;
	}

	@Override
	public int getLength()
	{
		return length;
	}
}
