package net.solersanandres.genetical.tests;

import static org.junit.Assert.*;
import net.solersanandres.genetical.Allele;
import net.solersanandres.genetical.CombinationException;
import net.solersanandres.genetical.CombinedOccurrenceFactory;
import net.solersanandres.genetical.DefaultCombinedOccurrenceFactory;
import net.solersanandres.genetical.ICombinedOccurrence;
import net.solersanandres.genetical.IOccurrence;
import net.solersanandres.genetical.Occurrence;

import org.junit.Before;
import org.junit.Test;

public class CombinedOccurrenceFactoryTest
{
	private IOccurrence oneOccurrenceOfADominant;
	private IOccurrence oneOccurrenceOfARecessive;
	private CombinedOccurrenceFactory combinator;

	@Before
	public void initializeTest()
	{
		Allele allelA = new Allele("A","a");
		oneOccurrenceOfADominant = Occurrence.CreateDominant(allelA);
		oneOccurrenceOfARecessive = Occurrence.CreateRecessive(allelA);
		combinator = new DefaultCombinedOccurrenceFactory();
	}

	@Test
	public void CombineTwoDominantOccurrences_ReturnsDominantHomozigous()
			throws CombinationException
	{
		ICombinedOccurrence pair = combinator.Combine(oneOccurrenceOfADominant,
				oneOccurrenceOfADominant);
		assertTrue(pair.isDominantHomozigous());
		assertFalse(pair.isHeterezigous());
		assertFalse(pair.isRecessiveHomozigous());
	}

	@Test
	public void CombineTwoRecessiveOccurrences_ReturnsRecessiveHomozigous()
			throws CombinationException
	{
		ICombinedOccurrence pair = combinator.Combine(
				oneOccurrenceOfARecessive, oneOccurrenceOfARecessive);
		assertFalse(pair.isDominantHomozigous());
		assertFalse(pair.isHeterezigous());
		assertTrue(pair.isRecessiveHomozigous());
	}

	@Test
	public void CombineDominantPlusRecessiveOccurrence_ReturnsHeterozigous()
			throws CombinationException
	{
		ICombinedOccurrence pair = combinator.Combine(oneOccurrenceOfADominant,
				oneOccurrenceOfARecessive);
		assertFalse(pair.isDominantHomozigous());
		assertTrue(pair.isHeterezigous());
		assertFalse(pair.isRecessiveHomozigous());
	}

	@Test
	public void CombineRecessivePlusDominantOccurrence_ReturnsHeterozigous()
			throws CombinationException
	{
		ICombinedOccurrence pair = combinator.Combine(
				oneOccurrenceOfARecessive, oneOccurrenceOfADominant);
		assertFalse(pair.isDominantHomozigous());
		assertTrue(pair.isHeterezigous());
		assertFalse(pair.isRecessiveHomozigous());
	}
}