/*
 * Occurrence.java
 * @author: Alexandre Soler Sanandres
 * 
 * Copyright (c) 2014 Alexandre Soler Sanandres
 * All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the BSD-2 License (see license file).
 *
 */
package net.solersanandres.genetical;

public abstract class Occurrence implements IOccurrence
{
	private Allele allele;
	
	protected Occurrence(Allele allele)
	{
		this.allele = allele;
	}

	public static IOccurrence CreateDominant(Allele allele)
	{
		return new Dominant(allele);
	}

	public static IOccurrence CreateRecessive(Allele allele)
	{
		return new Recessive(allele);
	}

	@Override
	public abstract Boolean isDominant();

	@Override
	public Boolean isRecessive()
	{
		return !isDominant();
	}

	@Override
	public Allele getAllele()
	{
		return allele;
	}
	
	@Override
	public String toString()
	{
		String returnValue = allele.getLocusIdentification();
		if (isDominant())
		{
			returnValue += "(+)";
		}
		else
		{
			returnValue += "(" + allele.getSymbol() + ")";
		}
		return returnValue;
	}
}