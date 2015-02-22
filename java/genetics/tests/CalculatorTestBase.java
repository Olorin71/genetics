package genetics.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import genetics.LocusOccurrence;
import genetics.MateResult;

import java.util.List;
import java.util.Optional;

public class CalculatorTestBase {

    public CalculatorTestBase() {
        super();
    }

    public void assertProbability(List<MateResult> mates, double probability, LocusOccurrence locusOccurrence) {
        Optional<MateResult> optionalMate = mates.stream().filter(e -> e.getLocusOccurrence() == locusOccurrence)
                        .findFirst();
        assertTrue(optionalMate.isPresent());
        MateResult mate = optionalMate.get();
        assertEquals(probability, mate.getProbability(), 0.001);
    }

}