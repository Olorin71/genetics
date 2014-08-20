package blog.genetics.test;

import static org.junit.Assert.*;

import org.junit.Test;

import blog.genetics.AllelePair;

public class AllelePairTest {
	
	@Test
	public void gettingTheFirstAllele_ReturnsTheCorrectValue() {
		AllelePair pair = new AllelePair("A", "b");
		assertEquals("A", pair.getFirstAllele());
	}

	@Test
	public void gettingTheSecondAllele_ReturnsTheCorrectValue() {
		AllelePair pair = new AllelePair("A", "b");
		assertEquals("b", pair.getSecondAllele());
	}

}
