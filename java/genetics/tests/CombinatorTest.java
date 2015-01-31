package genetics.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import genetics.AllelePair;
import genetics.CombinationResult;
import genetics.Combinator;

import org.junit.Test;

public class CombinatorTest {

    @Test
    public void BothDominantHomozygous_OneResult_100PercentDominantHomozygous() {
        Combinator combinator = new Combinator();
        List<CombinationResult> results = 
                combinator.GetCombinations(AllelePair.DominantHomozygous, 
                AllelePair.DominantHomozygous);
        
        assertEquals("The list contains more than one result.", 1, results.size());
        Optional<CombinationResult> result = results.stream().findFirst();
        assertTrue("No result available.", result.isPresent());
        CombinationResult r = result.get();
        assertEquals("", AllelePair.DominantHomozygous, r.getAllelePair());
        assertEquals("", 1.0, r.getProbability(), 0.0);
    }
}
