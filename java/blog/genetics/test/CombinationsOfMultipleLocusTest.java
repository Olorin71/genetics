package blog.genetics.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import blog.genetics.CombinationResult;
import blog.genetics.CombinationResults;
import blog.genetics.Combinator;
import blog.genetics.DominantHomozygous;
import blog.genetics.Heterozygous;
import blog.genetics.AlleleCombination;
import blog.genetics.RecessiveHomozygous;

public class CombinationsOfMultipleLocusTest {

	@Test
	public void FirstExampleHasFourPossibleCombinations() {
		AlleleCombination parent1 = new AlleleCombination();
		parent1.AddAllelePair(new DominantHomozygous("A"));
		parent1.AddAllelePair(new RecessiveHomozygous("B"));

		AlleleCombination parent2 = new AlleleCombination();
		parent2.AddAllelePair(new Heterozygous("A"));
		parent2.AddAllelePair(new Heterozygous("B"));

		CombinationResults results = Combinator.Combine(parent1, parent2);
		assertNotNull(results);
		assertEquals(4, results.size());

	}

	@Test
	public void FirstExampleContainsResultA() {
		AlleleCombination parent1 = new AlleleCombination();
		parent1.AddAllelePair(new DominantHomozygous("A"));
		parent1.AddAllelePair(new RecessiveHomozygous("B"));

		AlleleCombination parent2 = new AlleleCombination();
		parent2.AddAllelePair(new Heterozygous("A"));
		parent2.AddAllelePair(new Heterozygous("B"));

		CombinationResults results = Combinator.Combine(parent1, parent2);

		AlleleCombination combination = new AlleleCombination();
		combination.AddAllelePair(new DominantHomozygous("A"));
		combination.AddAllelePair(new Heterozygous("B"));

		assertTrue(results.containsCombination(combination));
		
		CombinationResult containedCombination = results.GetCombination(combination);
		
		assertEquals(0.25, containedCombination.getProbability(), 0.001);
		
	}
}
