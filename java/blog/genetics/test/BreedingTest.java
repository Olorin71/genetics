package blog.genetics.test;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import blog.genetics.AllelePair;
import blog.genetics.AllelePairProbability;
import blog.genetics.OutcomeCalculator;

public class BreedingTest {

	@Test
	public void GetTheOutcomeFromCrossingOneLocusHomozygousParents() {
		AllelePairProbability result = OutcomeCalculator.Calculate(
				new AllelePair("A", "A"), new AllelePair("A", "A"));

		assertThat("Incorrect first allele.", result.getAllelePair()
				.getFirstAllele() == "A");
		assertThat("Incorrect second allele.", result.getAllelePair()
				.getSecondAllele() == "A");
		assertThat("Incorrect percent.", result.getProbability() == 1);
	}

	@Test
	public void GetTheOutcomeFromCrossingOneLocusParents_WildTypeAndMutant() {
		AllelePairProbability result = OutcomeCalculator.Calculate(
				new AllelePair("A", "A"), new AllelePair("a", "a"));

		assertThat("Incorrect first allele.", result.getAllelePair()
				.getFirstAllele() == "A");
		assertThat("Incorrect second allele.", result.getAllelePair()
				.getSecondAllele() == "a");
		assertThat("Incorrect percent.", result.getProbability() == 1);
	}

}
