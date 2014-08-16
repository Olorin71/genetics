/*
 * CombinedOccurrence.java
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

public abstract class CombinedOccurrence implements ICombinedOccurrence {
	private IOccurrence firstOccurrence;
	private IOccurrence secondOccurrence;

	protected CombinedOccurrence(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence) throws CombinationException {
		ThrowIfDifferentAlleles(firstOccurrence, secondOccurrence);
		this.firstOccurrence = firstOccurrence;
		this.secondOccurrence = secondOccurrence;
	}

	private void ThrowIfDifferentAlleles(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence) throws CombinationException {
		if (!firstOccurrence.getAllele().equals(secondOccurrence.getAllele())) {
			throw new CombinationException(CreateCombinationExceptionMessage(
					firstOccurrence, secondOccurrence));
		}
	}

	private String CreateCombinationExceptionMessage(
			IOccurrence firstOccurrence, IOccurrence secondOccurrence) {
		return firstOccurrence.getAllele().getLocusIdentification() + " != "
				+ secondOccurrence.getAllele().getLocusIdentification();
	}

	public Allele getAllele() {
		return firstOccurrence.getAllele();
	}

	public abstract Boolean isDominantHomozigous();

	public abstract Boolean isRecessiveHomozigous();

	public abstract Boolean isHeterezigous();

	@Override
	public String toString() {
		if (firstOccurrence.isRecessive() && secondOccurrence.isDominant())
			return secondOccurrence.toString() + firstOccurrence.toString();
		else
			return firstOccurrence.toString() + secondOccurrence.toString();
	}

}
