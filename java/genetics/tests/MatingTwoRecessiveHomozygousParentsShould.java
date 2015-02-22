package genetics.tests;

import genetics.Calculator;
import genetics.LocusOccurrence;
import genetics.MateResult;

import java.util.List;

import org.junit.Test;

public class MatingTwoRecessiveHomozygousParentsShould extends CalculatorTestBase {

    @Test
    public void Returns100PercentRecessiveHomozygous() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator.mate(LocusOccurrence.RecessiveHomozygous,
                        LocusOccurrence.RecessiveHomozygous);
        assertProbability(mates, 1.0, LocusOccurrence.RecessiveHomozygous);
    }
}