package blog.genetics.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import blog.genetics.AllelePair;
import blog.genetics.AllelePairProbability;

public class AllelePairProbabilityTest {
    private AllelePairProbability probability;
    
    @Before
    public void InitializeTest() {
        probability = new AllelePairProbability(
                new AllelePair("A", "b"), 0.5);
    }
    
    @Test
    public void gettingTheFirstAllele_ReturnsTheCorrectValue() {
        assertEquals("A", probability.getFirstAllele());
    }

    @Test
    public void gettingTheSecondAllele_ReturnsTheCorrectValue() {
        assertEquals("b", probability.getSecondAllele());
    }

    @Test
    public void gettingTheProbability_ReturnsTheCorrectValue() {
        assertEquals(0.5, probability.getProbability(), 0.01);
    }
}
