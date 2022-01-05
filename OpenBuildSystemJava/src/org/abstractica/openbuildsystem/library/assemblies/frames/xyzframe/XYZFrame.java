package org.abstractica.openbuildsystem.library.assemblies.frames.xyzframe;

import org.abstractica.openbuildsystem.library.assemblies.AAssembly;
import org.abstractica.openbuildsystem.library.assemblies.ASM;
import org.abstractica.openbuildsystem.library.assemblies.Node;
import org.abstractica.openbuildsystem.library.assemblies.fasteners.BoltNutAndWashers;
import org.abstractica.openbuildsystem.library.parts.machined.alurods.Rod;

import java.security.InvalidParameterException;

public class XYZFrame extends AAssembly
{
	private final Rod xRod;
	private final Rod yRod;
	private final Rod zRod;
	private final BoltNutAndWashers bolt;
	private final double unitSize;

	public XYZFrame(Rod xRod, Rod yRod, Rod zRod, BoltNutAndWashers bolt)
	{
		super("XYZFrame_" + xRod.getLength() + "x" + yRod.getLength() + "x" + zRod.getLength());
		this.xRod = xRod;
		this.yRod = yRod;
		this.zRod = zRod;
		this.bolt = bolt;
		if(xRod.getUnitSize() != yRod.getUnitSize() || xRod.getUnitSize() != zRod.getUnitSize())
		{
			throw new InvalidParameterException("Unit size must be the same for all the rods");
		}
		this.unitSize = xRod.getUnitSize();
	}

	@Override
	protected void assemble()
	{
		//ZRods
		Node zT1 = unitTranslate(1,1,0);
		zT1.addChild(zRod);
		Node zT2 = unitTranslate(xRod.getLength()-2, 1, 0);
		zT2.addChild(zRod);
		Node zT3 = unitTranslate(1, yRod.getLength()-2, 0);
		zT3.addChild(zRod);
		Node zT4 = unitTranslate(xRod.getLength()-2, yRod.getLength()-2, 0);
		zT4.addChild(zRod);

		add(zT1);
		add(zT2);
		add(zT3);
		add(zT4);

		//XRods
		Node rXRod = ASM.rotation(0,90,0);
		rXRod.addChild(xRod);

		Node xT1 = unitTranslate(0, 0, 1);
		xT1.addChild(rXRod);
		Node xT2 = unitTranslate(0, 0, zRod.getLength()-2);
		xT2.addChild(rXRod);
		Node xT3 = unitTranslate(0, yRod.getLength()-1, 1);
		xT3.addChild(rXRod);
		Node xT4 = unitTranslate(0, yRod.getLength()-1, zRod.getLength()-2);
		xT4.addChild(rXRod);

		add(xT1);
		add(xT2);
		add(xT3);
		add(xT4);

		//YRods
		Node rYRod = ASM.rotation(-90,0,0);
		rYRod.addChild(yRod);

		Node yT1 = unitTranslate(0, 0, 0);
		yT1.addChild(rYRod);
		Node yT2 = unitTranslate(0, 0, zRod.getLength()-1);
		yT2.addChild(rYRod);
		Node yT3 = unitTranslate(xRod.getLength()-1,0, 0);
		yT3.addChild(rYRod);
		Node yT4 = unitTranslate(xRod.getLength()-1, 0,zRod.getLength()-1);
		yT4.addChild(rYRod);

		add(yT1);
		add(yT2);
		add(yT3);
		add(yT4);

		//Bolts
		Node tBolt = ASM.translation(0,0,0.5*unitSize);
		tBolt.addChild(bolt);

		//XBolts
		Node rXBolt1= ASM.rotation(0,90,0);
		rXBolt1.addChild(tBolt);

		Node bXT1 = unitTranslate(-1,1,0);
		bXT1.addChild(rXBolt1);
		Node bXT2 = unitTranslate(-1, yRod.getLength()-2, 0);
		bXT2.addChild(rXBolt1);
		Node bXT3 = unitTranslate(-1,1, zRod.getLength()-1);
		bXT3.addChild(rXBolt1);
		Node bXT4 = unitTranslate(-1, yRod.getLength()-2, zRod.getLength()-1);
		bXT4.addChild(rXBolt1);

		add(bXT1);
		add(bXT2);
		add(bXT3);
		add(bXT4);

		Node rXBolt2= ASM.rotation(0,-90,0);
		rXBolt2.addChild(tBolt);

		Node bXT5 = unitTranslate(xRod.getLength(),1,0);
		bXT5.addChild(rXBolt2);
		Node bXT6 = unitTranslate(xRod.getLength(), yRod.getLength()-2, 0);
		bXT6.addChild(rXBolt2);
		Node bXT7 = unitTranslate(xRod.getLength(),1, zRod.getLength()-1);
		bXT7.addChild(rXBolt2);
		Node bXT8 = unitTranslate(xRod.getLength(), yRod.getLength()-2, zRod.getLength()-1);
		bXT8.addChild(rXBolt2);

		add(bXT5);
		add(bXT6);
		add(bXT7);
		add(bXT8);

		//YBolts
		Node rYBolt1= ASM.rotation(90,0,0);
		rYBolt1.addChild(tBolt);

		Node bYT1 = unitTranslate(1,yRod.getLength(),1);
		bYT1.addChild(rYBolt1);
		Node bYT2 = unitTranslate(xRod.getLength()-2, yRod.getLength(),1);
		bYT2.addChild(rYBolt1);
		Node bYT3 = unitTranslate(1,yRod.getLength(),zRod.getLength()-2);
		bYT3.addChild(rYBolt1);
		Node bYT4 = unitTranslate(xRod.getLength()-2, yRod.getLength(),zRod.getLength()-2);
		bYT4.addChild(rYBolt1);

		add(bYT1);
		add(bYT2);
		add(bYT3);
		add(bYT4);

		Node rYBolt2= ASM.rotation(-90,0,0);
		rYBolt2.addChild(tBolt);

		Node bYT5 = unitTranslate(1,-1,1);
		bYT5.addChild(rYBolt2);
		Node bYT6 = unitTranslate(xRod.getLength()-2, -1,1);
		bYT6.addChild(rYBolt2);
		Node bYT7 = unitTranslate(1,-1,zRod.getLength()-2);
		bYT7.addChild(rYBolt2);
		Node bYT8 = unitTranslate(xRod.getLength()-2, -1,zRod.getLength()-2);
		bYT8.addChild(rYBolt2);

		add(bYT5);
		add(bYT6);
		add(bYT7);
		add(bYT8);

		//ZBolts
		Node bZT1 = unitTranslate(0,0,-1);
		bZT1.addChild(tBolt);
		Node bZT2 = unitTranslate(xRod.getLength()-1, 0,-1);
		bZT2.addChild(tBolt);
		Node bZT3 = unitTranslate(0, yRod.getLength()-1, -1);
		bZT3.addChild(tBolt);
		Node bZT4 = unitTranslate(xRod.getLength()-1, yRod.getLength()-1, -1);
		bZT4.addChild(tBolt);

		add(bZT1);
		add(bZT2);
		add(bZT3);
		add(bZT4);

		Node rZBolt2 = ASM.rotation(180,0,0);
		rZBolt2.addChild(tBolt);


		Node bZT5 = unitTranslate(0,0,zRod.getLength());
		bZT5.addChild(rZBolt2);
		Node bZT6 = unitTranslate(xRod.getLength()-1, 0,zRod.getLength());
		bZT6.addChild(rZBolt2);
		Node bZT7 = unitTranslate(0, yRod.getLength()-1, zRod.getLength());
		bZT7.addChild(rZBolt2);
		Node bZT8 = unitTranslate(xRod.getLength()-1, yRod.getLength()-1, zRod.getLength());
		bZT8.addChild(rZBolt2);

		add(bZT5);
		add(bZT6);
		add(bZT7);
		add(bZT8);
	}

	private Node unitTranslate(int x, int y, int z)
	{
		return ASM.translation(x*unitSize, y*unitSize, z*unitSize);
	}
}
