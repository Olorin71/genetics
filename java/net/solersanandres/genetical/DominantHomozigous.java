/*
 * DominantHomozigous.java
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

class DominantHomozigous extends CombinedOccurrence
{
	public DominantHomozigous(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence) throws CombinationException
	{
		super(firstOccurrence, secondOccurrence);
	}

	@Override
	public Boolean isDominantHomozigous()
	{
		return true;
	}

	@Override
	public Boolean isRecessiveHomozigous()
	{
		return false;
	}

	@Override
	public Boolean isHeterezigous()
	{
		return false;
	}
}