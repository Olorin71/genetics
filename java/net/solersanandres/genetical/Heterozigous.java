/*
 * Heterozigous.java
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

class Heterozigous extends CombinedOccurrence
{
	public Heterozigous(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence) throws CombinationException
	{
		super(firstOccurrence, secondOccurrence);
	}

	@Override
	public Boolean isDominantHomozigous()
	{
		return false;
	}

	@Override
	public Boolean isRecessiveHomozigous()
	{
		return false;
	}

	@Override
	public Boolean isHeterezigous()
	{
		return true;
	}
}
