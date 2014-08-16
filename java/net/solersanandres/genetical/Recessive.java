/*
 * Recessive.java
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

class Recessive extends Occurrence
{
	public Recessive(Allele allele)
	{
		super(allele);
	}

	@Override
	public Boolean isDominant()
	{
		return false;
	}
}