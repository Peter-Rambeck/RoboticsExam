package org.abstractica.openbuildsystem.openscad;

public class CodeBuilder
{
	private int indent;
	private final StringBuilder res;

	public CodeBuilder()
	{
		this.indent = 0;
		this.res = new StringBuilder();
	}

	public void indent()
	{
		++indent;
	}

	public void addLine(String line)
	{
		res.append("    ".repeat(indent));
		res.append(line);
		res.append(System.lineSeparator());
	}

	public void undent()
	{
		--indent;
	}

	@Override
	public String toString()
	{
		return res.toString();
	}
}
