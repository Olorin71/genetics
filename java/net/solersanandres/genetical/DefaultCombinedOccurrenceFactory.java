/*
 * CombinedOccurrenceFactory.java
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

public class DefaultCombinedOccurrenceFactory implements CombinedOccurrenceFactory
{
	public ICombinedOccurrence Combine(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence) throws CombinationException
	{
		ICombinedOccurrence result = null;
		if (bothOcurrencesAreDominant(firstOccurrence, secondOccurrence))
		{
			result = new DominantHomozigous(firstOccurrence, secondOccurrence);
		} else if (bothOccurrencesAreRecessive(firstOccurrence,
				secondOccurrence))
		{
			result = new RecessiveHomozigous(firstOccurrence, secondOccurrence);

		} else
		{
			result = new Heterozigous(firstOccurrence, secondOccurrence);
		}
		return result;
	}

	private boolean bothOccurrencesAreRecessive(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence)
	{
		return firstOccurrence.isRecessive() && secondOccurrence.isRecessive();
	}

	private boolean bothOcurrencesAreDominant(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence)
	{
		return firstOccurrence.isDominant() && secondOccurrence.isDominant();
	}
}
