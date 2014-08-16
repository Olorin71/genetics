/*
 * RecessiveHomozigous.java
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

class RecessiveHomozigous extends CombinedOccurrence
{
	public RecessiveHomozigous(IOccurrence firstOccurrence,
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
		return true;
	}

	@Override
	public Boolean isHeterezigous()
	{
		return false;
	}
}