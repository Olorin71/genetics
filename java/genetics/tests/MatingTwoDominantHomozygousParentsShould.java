package genetics.tests;

import genetics.Calculator;
import genetics.LocusOccurrence;
import genetics.MateResult;

import java.util.List;

import org.junit.Test;

public class MatingTwoDominantHomozygousParentsShould extends CalculatorTestBase {

    @Test
    public void Returns100PercentDominantHomozygous() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator
                        .mate(LocusOccurrence.DominantHomozygous, LocusOccurrence.DominantHomozygous);
        assertProbability(mates, 1.0, LocusOccurrence.DominantHomozygous);
    }
}
