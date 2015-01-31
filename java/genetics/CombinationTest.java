package genetics;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CombinationTest {

    @Test
    public void CombinationsWithSameComponentsAreEquals() {
        Combination c1 = new Combination(AllelePair.DominantHomozygous, AllelePair.Heterozygous);
        Combination c2 = new Combination(AllelePair.Heterozygous, AllelePair.DominantHomozygous);
        assertTrue(c1.equals(c2));
    }
}
