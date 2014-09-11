package blog.genetics.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import blog.genetics.AllelePair;
import blog.genetics.DominantHomozygous;
import blog.genetics.Heterozygous;
import blog.genetics.RecessiveHomozygous;

public class AllelePairImplTest {

	@Test
	public void combineDominantHomozygousWithDominantHomozygousReturnsOnlyDominantHomozygous() {
		AllelePair paternalAllelePair = new DominantHomozygous("A");
		AllelePair maternalAllelePair = new DominantHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(1.0, results.get("AA").doubleValue(), 0.001);

	}

	@Test
	public void combineRecessiveHomozygousWithRecessiveHomozygousReturnsOnlyRecessiveHomozygous() {
		AllelePair paternalAllelePair = new RecessiveHomozygous("A");
		AllelePair maternalAllelePair = new RecessiveHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(1.0, results.get("aa").doubleValue(), 0.001);

	}

	@Test
	public void combineDominantHomozygousWithRecessiveHomozygousReturnsOnlyHeterozygous() {
		AllelePair paternalAllelePair = new DominantHomozygous("A");
		AllelePair maternalAllelePair = new RecessiveHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(1.0, results.get("Aa").doubleValue(), 0.001);

	}

	@Test
	public void combineRecessiveHomozygousWithDominantHomozygousReturnsOnlyHeterozygous() {
		AllelePair paternalAllelePair = new RecessiveHomozygous("A");
		AllelePair maternalAllelePair = new DominantHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(1.0, results.get("Aa").doubleValue(), 0.001);

	}

	@Test
	public void combineDominantHomozygousWithHeterozygousReturnsFiftyPercentDominantHomozygous() {
		AllelePair paternalAllelePair = new DominantHomozygous("A");
		AllelePair maternalAllelePair = new Heterozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("AA").doubleValue(), 0.001);

	}

	@Test
	public void combineDominantHomozygousWithHeterozygousReturnsFiftyPercentHeterozygous() {
		AllelePair paternalAllelePair = new DominantHomozygous("A");
		AllelePair maternalAllelePair = new Heterozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("Aa").doubleValue(), 0.001);

	}

	@Test
	public void combineHeterozygousWithDominantHomozygousReturnsFiftyPercentDominantHomozygous() {
		AllelePair paternalAllelePair = new Heterozygous("A");
		AllelePair maternalAllelePair = new DominantHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("AA").doubleValue(), 0.001);

	}

	@Test
	public void combineHeterozygousWithDominantHomozygousReturnsFiftyPercentHeterozygous() {
		AllelePair paternalAllelePair = new Heterozygous("A");
		AllelePair maternalAllelePair = new DominantHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("Aa").doubleValue(), 0.001);

	}

	@Test
	public void combineRecessiveHomozygousWithHeterozygousReturnsFiftyPercentRecessiveHomozygous() {
		AllelePair paternalAllelePair = new RecessiveHomozygous("A");
		AllelePair maternalAllelePair = new Heterozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("aa").doubleValue(), 0.001);

	}

	@Test
	public void combineRecessiveHomozygousWithHeterozygousReturnsFiftyPercentHeterozygous() {
		AllelePair paternalAllelePair = new RecessiveHomozygous("A");
		AllelePair maternalAllelePair = new Heterozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("Aa").doubleValue(), 0.001);

	}

	@Test
	public void combineHeterozygousWithRecessiveHomozygousReturnsFiftyPercentRecessiveHomozygous() {
		AllelePair paternalAllelePair = new Heterozygous("A");
		AllelePair maternalAllelePair = new RecessiveHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("aa").doubleValue(), 0.001);

	}

	@Test
	public void combineHeterozygousWithRecessiveHomozygousReturnsFiftyPercentHeterozygous() {
		AllelePair paternalAllelePair = new Heterozygous("A");
		AllelePair maternalAllelePair = new RecessiveHomozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("Aa").doubleValue(), 0.001);

	}

	@Test
	public void combineHeterozygousWithHeterozygousReturnsFiftyPercentHeterozygous() {
		AllelePair paternalAllelePair = new Heterozygous("A");
		AllelePair maternalAllelePair = new Heterozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.5, results.get("Aa").doubleValue(), 0.001);

	}

	@Test
	public void combineHeterozygousWithHeterozygousReturnsTwentyFivePercentDominantHomozygous() {
		AllelePair paternalAllelePair = new Heterozygous("A");
		AllelePair maternalAllelePair = new Heterozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.25, results.get("AA").doubleValue(), 0.001);

	}

	@Test
	public void combineHeterozygousWithHeterozygousReturnsTwentyFivePercentRecessiveHomozygous() {
		AllelePair paternalAllelePair = new Heterozygous("A");
		AllelePair maternalAllelePair = new Heterozygous("A");

		Map<String, Double> results = paternalAllelePair
				.combineWith(maternalAllelePair);

		assertEquals(0.25, results.get("aa").doubleValue(), 0.001);

	}

}