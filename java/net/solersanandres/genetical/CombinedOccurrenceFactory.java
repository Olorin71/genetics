package net.solersanandres.genetical;

public interface CombinedOccurrenceFactory {

	public ICombinedOccurrence Combine(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence) throws CombinationException;

}