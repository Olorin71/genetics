package net.solersanandres.genetical.tests;

import net.solersanandres.genetical.CombinationException;
import net.solersanandres.genetical.CombinedOccurrence;
import net.solersanandres.genetical.IOccurrence;

public class TestableCombinedOccurrence extends CombinedOccurrence
{
	public TestableCombinedOccurrence(IOccurrence firstOccurrence,
			IOccurrence secondOccurrence) throws CombinationException
	{
		super(firstOccurrence, secondOccurrence);
		// TODO Auto-generated constructor stub
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
		return false;
	}
}
