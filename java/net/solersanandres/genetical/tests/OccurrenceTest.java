package net.solersanandres.genetical.tests;

import static org.junit.Assert.*;
import net.solersanandres.genetical.Allele;
import net.solersanandres.genetical.IOccurrence;
import net.solersanandres.genetical.Occurrence;

import org.junit.Before;
import org.junit.Test;

public class OccurrenceTest
{
	private IOccurrence oneOccurrenceOfADominant;
	private IOccurrence oneOccurrenceOfARecessive;
	private IOccurrence oneOccurrenceOfBRecessive;

	@Before
	public void initializeTest()
	{
		Allele allelA = new Allele("A","a");
		Allele allelB = new Allele("B","c");
		oneOccurrenceOfADominant = Occurrence.CreateDominant(allelA);
		oneOccurrenceOfBRecessive = Occurrence.CreateRecessive(allelB);
		oneOccurrenceOfARecessive = Occurrence.CreateRecessive(allelA);
	}


	@Test
	public void CreateAnOccurrenceObjectShoudNotBeNull()
	{
		assertNotNull(oneOccurrenceOfADominant);
	}

	@Test
	public void CreateDominantOccurrence_IsDominantIsTrue()
	{
		assertTrue(oneOccurrenceOfADominant.isDominant());
	}

	@Test
	public void CreateDominantOccurrence_IsRecessiveIsFalse()
	{
		assertFalse(oneOccurrenceOfADominant.isRecessive());
	}

	@Test
	public void CreateRecessiveOccurrence_IsDominantsIsFalse()
	{
		assertFalse(oneOccurrenceOfARecessive.isDominant());
	}

	@Test
	public void CreateRecessiveOccurrence_IsRecessiveIsTrue()
	{
		assertTrue(oneOccurrenceOfARecessive.isRecessive());
	}

	@Test
	public void GetTheAlleleIdentification_ReturnsTheCorrectValue()
	{
		assertEquals("A", oneOccurrenceOfADominant.getAllele().getLocusIdentification());
	}
	
	@Test
	public void DominantOccurrence_ReturnsTheCorrectStringRepresentation()
	{
		assertEquals("A(+)", oneOccurrenceOfADominant.toString());
	}
	
	@Test
	public void RecessiveOccurrenceOfA_ReturnsTheCorrectStringRepresentation()
	{
		assertEquals("A(a)", oneOccurrenceOfARecessive.toString());
	}
	
	@Test
	public void RecessiveOccurrenceOfB_ReturnsTheCorrectStringRepresentation()
	{
		assertEquals("B(c)", oneOccurrenceOfBRecessive.toString());
	}
}
