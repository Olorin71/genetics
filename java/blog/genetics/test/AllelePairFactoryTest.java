package blog.genetics.test;

import org.junit.Test;

import blog.genetics.AllelePairFactory;

public final class AllelePairFactoryTest {

	@Test(expected = IllegalArgumentException.class)
	public void createDominantHomozygousWithNullThrowsArgumentNullException() {
		AllelePairFactory.createDominantHomozygous(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createDominantHomozygousWithEmptyStringThrowsArgumentNullException() {
		AllelePairFactory.createDominantHomozygous("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void createRecessiveHomozygousWithNullThrowsArgumentNullException() {
		AllelePairFactory.createRecessiveHomozygous(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createRecessiveHomozygousWithEmptyStringThrowsArgumentNullException() {
		AllelePairFactory.createRecessiveHomozygous("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void createHeterozygousWithNullThrowsArgumentNullException() {
		AllelePairFactory.createDominantHomozygous(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createHeterozygousWithEmptyStringThrowsArgumentNullException() {
		AllelePairFactory.createDominantHomozygous("");
	}
}