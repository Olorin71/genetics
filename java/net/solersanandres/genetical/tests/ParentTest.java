package net.solersanandres.genetical.tests;

import static org.junit.Assert.*;

import java.util.List;

import net.solersanandres.genetical.Allele;
import net.solersanandres.genetical.CombinationException;
import net.solersanandres.genetical.DefaultCombinedOccurrenceFactory;
import net.solersanandres.genetical.ICombinedOccurrence;
import net.solersanandres.genetical.IOccurrence;
import net.solersanandres.genetical.Occurrence;
import net.solersanandres.genetical.Parent;

import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class ParentTest {

	private Mockery context;
	private DefaultCombinedOccurrenceFactory factory;

	@Before
	public void setUp() {
		context = new Mockery();
		factory = new DefaultCombinedOccurrenceFactory();
	}
	
	@Test
	public void NewParentHasZeroCombinedOccurrences()
	{
		Parent parent = new Parent();
		assertEquals(0, parent.getCount());
	}
	
	@Test
	public void ParentWithOneCombinedOccurrence_CountIsOne() throws CombinationException
	{
		Parent parent = createParentWithOneCombinedOccurrence();
		assertEquals(1, parent.getCount());
	}
	
	@Test
	public void ParentWithOneCombinedOccurrence_RetunsCombinedOccurrenceCollectionWithOneItem() throws CombinationException
	{
		Parent parent = createParentWithOneCombinedOccurrence();
		List<ICombinedOccurrence> combinedOccurrences = parent.getCombinedOccurrences();
		assertEquals(1, combinedOccurrences.size());
	}

	@Test
	public void ParentWithOneCombinedOccurrence_TheItemAddedIsEqualsToTheReturnedInDerCollection() throws CombinationException
	{
		ICombinedOccurrence combinedOccurrence = createDominantHomozigoufOfA();
		Parent parent = createParentWithOneCombinedOccurrence(combinedOccurrence);
		List<ICombinedOccurrence> combinedOccurrences = parent.getCombinedOccurrences();
		assertTrue(combinedOccurrence.equals(combinedOccurrences.get(0)));
	}

	private Parent createParentWithOneCombinedOccurrence()
			throws CombinationException {
		Parent parent = new Parent();
		ICombinedOccurrence combinedOccurrence = createDominantHomozigoufOfA();
		parent.Add(combinedOccurrence);
		return parent;
	}

	private Parent createParentWithOneCombinedOccurrence(ICombinedOccurrence combinedOccurrence)
			throws CombinationException {
		Parent parent = new Parent();
		parent.Add(combinedOccurrence);
		return parent;
	}

	private ICombinedOccurrence createDominantHomozigoufOfA()
			throws CombinationException {
		IOccurrence firstOccurrence = Occurrence.CreateDominant(new Allele("A", "a"));
		IOccurrence secondOccurrence = Occurrence.CreateDominant(new Allele("A", "a"));
		return factory.Combine(firstOccurrence , secondOccurrence);
	}

}
