package org.abstractica.openbuildsystem.library.assemblies.fasteners;

import org.abstractica.openbuildsystem.library.assemblies.AAssembly;
import org.abstractica.openbuildsystem.library.assemblies.ASM;
import org.abstractica.openbuildsystem.library.assemblies.Node;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.bolts.Bolt;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.nuts.Nut;
import org.abstractica.openbuildsystem.library.parts.sourced.fasteners.washers.Washer;

public class BoltNutAndWashers extends AAssembly
{
	private final Bolt bolt;
	private final Nut nut;
	private final Washer washer;
	private final double dist;


	public BoltNutAndWashers(Bolt bolt, Nut nut, Washer washer, double dist)
	{
		super(bolt.getName() + "_With_" + nut.getName() + "_And_" + washer.getName());
		this.bolt = bolt;
		this.nut = nut;
		this.washer = washer;
		this.dist = dist;
	}

	@Override
	protected void assemble()
	{
		Node t1 = ASM.translation(0,0,-washer.getThickness());
		t1.addChild(bolt);
		t1.addChild(washer);
		Node t2 = ASM.translation(0,0, dist);
		t2.addChild(washer);
		Node t3 = ASM.translation(0,0, dist + washer.getThickness());
		t3.addChild(nut);
		add(t1);
		add(t2);
		add(t3);
	}
}
