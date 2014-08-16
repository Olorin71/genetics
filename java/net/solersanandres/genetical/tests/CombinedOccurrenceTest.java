package net.solersanandres.genetical.tests;

import static org.junit.Assert.*;
import net.solersanandres.genetical.Allele;
import net.solersanandres.genetical.CombinationException;
import net.solersanandres.genetical.CombinedOccurrence;
import net.solersanandres.genetical.IOccurrence;
import net.solersanandres.genetical.Occurrence;

import org.junit.Before;
import org.junit.Test;

public class CombinedOccurrenceTest
{
	private Allele alleleA;
	private Allele alleleB;

	@Before
	public void initializeTest()
	{
		alleleA = new Allele("A","a");
		alleleB = new Allele("B","c");
	}

	@Test(expected=CombinationException.class)
	public void CreateCombinedOccurrenceWithDifferentAlleles_ThrowsCombinationException() throws CombinationException
	{
		IOccurrence createDominant = Occurrence.CreateDominant(alleleA);
		IOccurrence createDominant2 = Occurrence.CreateDominant(alleleB);
		new TestableCombinedOccurrence(createDominant, createDominant2);
		fail("Expected exception not thrown.");
	}

	@Test
	public void CreateCombinedOccurrenceWithSameAllele_DoNotThrowExceptions() throws CombinationException
	{
			new TestableCombinedOccurrence(Occurrence.CreateDominant(alleleA),
					Occurrence.CreateDominant(alleleA));
	}
	
	@Test
	public void ToStringTestDominantHomozigous() throws CombinationException
	{
		CombinedOccurrence occurrence = new TestableCombinedOccurrence(Occurrence.CreateDominant(alleleA),
				Occurrence.CreateDominant(alleleA));
		assertEquals("A(+)A(+)", occurrence.toString());
	}	
	
	@Test
	public void ToStringTestHeterozigous1() throws CombinationException
	{
		CombinedOccurrence occurrence = new TestableCombinedOccurrence(Occurrence.CreateDominant(alleleA),
				Occurrence.CreateRecessive(alleleA));
		assertEquals("A(+)A(a)", occurrence.toString());
	}	
	
	@Test
	public void ToStringTestHeterozigous2() throws CombinationException
	{
		CombinedOccurrence occurrence = new TestableCombinedOccurrence(Occurrence.CreateRecessive(alleleA),
				Occurrence.CreateDominant(alleleA));
		assertEquals("A(+)A(a)", occurrence.toString());
	}	
	
	@Test
	public void ToStringTestRecessiveHomozigous() throws CombinationException
	{
		CombinedOccurrence occurrence = new TestableCombinedOccurrence(Occurrence.CreateRecessive(alleleA),
				Occurrence.CreateRecessive(alleleA));
		assertEquals("A(a)A(a)", occurrence.toString());
	}	
	
	@Test
	public void CombinedOcurrenceGetAllele_ReturnsCorrectAllele() throws CombinationException
	{
		IOccurrence anotherRecessiveA = Occurrence.CreateRecessive(new Allele("A","a"));
		CombinedOccurrence occurrence = new TestableCombinedOccurrence(Occurrence.CreateRecessive(alleleA),
				anotherRecessiveA);
		Allele allele = occurrence.getAllele();
		boolean equalsResult = alleleA.equals(allele);
		assertTrue(equalsResult);
	}	
	
}
