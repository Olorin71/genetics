package blog.genetics.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import blog.genetics.AllelePair;

public class AllelePairTest {
    private AllelePair pair;

    @Before
    public void InitializeTest() {
        pair = new AllelePair("A", "b");
    }

    @Test
    public void gettingTheFirstAllele_ReturnsTheCorrectValue() {
        assertEquals("A", pair.getFirstAllele());
    }

    @Test
    public void gettingTheSecondAllele_ReturnsTheCorrectValue() {
        assertEquals("b", pair.getSecondAllele());
    }
}
