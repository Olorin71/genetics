package blog.genetics.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import blog.genetics.AllelePair;
import blog.genetics.AllelePairFactory;
import blog.genetics.Constants;
import blog.genetics.DominantHomozygous;
import blog.genetics.Heterozygous;
import blog.genetics.RecessiveHomozygous;

public final class AllelePairCombinationTest {

	private static final double ALLOWEDDELTA = 0.001;
	private static final int ONEITEMAVAILABLE = 1;
	private static final int THREEITEMSAVAILABLE = 3;
	private static final int TWOITEMSAVAILABLE = 2;
	private Class<DominantHomozygous> dominantHomozygousClass = DominantHomozygous.class;
	private Class<RecessiveHomozygous> recessiveHomozygousClass = RecessiveHomozygous.class;
	private Class<Heterozygous> heterozygousClass = Heterozygous.class;

	private void assertProbability(final double expected, final Double actual) {
		assertEquals(expected, actual.doubleValue(), ALLOWEDDELTA);

	}

	@Test
	public void combineDominantHomozygousAndHeterozygousReturns50PercentDominantHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(dominantHomozygousClass));

	}

	@Test
	public void combineDominantHomozygousAndHeterozygousReturnsTwoItems() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(TWOITEMSAVAILABLE, probabilities.size());

	}

	@Test
	public void combineDominantHomozygousAndHeterozygousReturns50PercentHeterozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(heterozygousClass));

	}

	@Test
	public void combineDominantHomozygousAndRecessiveHomozygousReturns100PercentHeterozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.HUNDREDPERCENT,
				probabilities.get(heterozygousClass));

	}

	@Test
	public void combineDominantHomozygousAndRecessiveHomozygousReturnsOnlyOneItem() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(ONEITEMAVAILABLE, probabilities.size());

	}

	@Test
	public void combineHeterozygousAndDominantHomozygousReturns50PercentDominantHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(dominantHomozygousClass));

	}

	@Test
	public void combineHeterozygousAndDominantHomozygousReturnsTwoItems() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(TWOITEMSAVAILABLE, probabilities.size());

	}

	@Test
	public void combineHeterozygousAndDominantHomozygousReturns50PercentHeterozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(heterozygousClass));

	}

	@Test
	public void combineHeterozygousAndHeterozygousReturns25PercentDominantHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.TWENTYFIVEPERCENT,
				probabilities.get(dominantHomozygousClass));

	}

	@Test
	public void combineHeterozygousAndHeterozygousReturnsThreeItems() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(THREEITEMSAVAILABLE, probabilities.size());

	}

	@Test
	public void combineHeterozygousAndHeterozygousReturns25PercentRecessiveHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.TWENTYFIVEPERCENT,
				probabilities.get(recessiveHomozygousClass));

	}

	@Test
	public void combineHeterozygousAndHeterozygousReturns50PercentHeterozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(heterozygousClass));

	}

	@Test
	public void combineHeterozygousAndRecessiveHomozygousReturns50PercentHeterozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(heterozygousClass));

	}

	@Test
	public void combineHeterozygousAndRecessiveHomozygousReturnsTwoItems() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(TWOITEMSAVAILABLE, probabilities.size());

	}

	@Test
	public void combineHeterozygousAndRecessiveHomozygousReturns50PercentRecessiveHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createHeterozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(recessiveHomozygousClass));

	}

	@Test
	public void combineRecessiveHomozygousAndDominantHomozygousReturns100PercentHeterozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.HUNDREDPERCENT,
				probabilities.get(heterozygousClass));

	}

	@Test
	public void combineRecessiveHomozygousAndDominantHomozygousReturnsOnlyOneItem() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(ONEITEMAVAILABLE, probabilities.size());

	}

	@Test
	public void combineRecessiveHomozygousAndHeterozygousReturns50PercentHeterozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(heterozygousClass));

	}

	@Test
	public void combineRecessiveHomozygousAndHeterozygousReturns50PercentRecessiveHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.FIFTYPERCENT,
				probabilities.get(recessiveHomozygousClass));

	}

	@Test
	public void combineRecessiveHomozygousAndHeterozygousReturnsTwoItems() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createHeterozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(TWOITEMSAVAILABLE, probabilities.size());

	}

	@Test
	public void combineTwoDominantHomozygousReturns100PercentDominantHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.HUNDREDPERCENT,
				probabilities.get(dominantHomozygousClass));

	}

	@Test
	public void combineTwoDominantHomozygousReturnsOnlyOneItem() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createDominantHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(ONEITEMAVAILABLE, probabilities.size());

	}

	@Test
	public void combineTwoRecessiveHomozygousReturns100PercentRecessiveHomozygous() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertProbability(Constants.HUNDREDPERCENT,
				probabilities.get(recessiveHomozygousClass));

	}

	@Test
	public void combineTwoRecessiveHomozygousReturnsOnlyOneItem() {
		final AllelePair paternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");
		final AllelePair maternalAllelePair = AllelePairFactory
				.createRecessiveHomozygous("A");

		final Map<Class<?>, Double> probabilities = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(ONEITEMAVAILABLE, probabilities.size());

	}

}