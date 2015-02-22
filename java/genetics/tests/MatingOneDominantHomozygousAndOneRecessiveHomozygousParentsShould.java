package genetics.tests;

import genetics.Calculator;
import genetics.LocusOccurrence;
import genetics.MateResult;

import java.util.List;

import org.junit.Test;

public class MatingOneDominantHomozygousAndOneRecessiveHomozygousParentsShould extends CalculatorTestBase {

    @Test
    public void Returns100PercentHeterozygousByDomRez() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator.mate(LocusOccurrence.DominantHomozygous,
                        LocusOccurrence.RecessiveHomozygous);
        assertProbability(mates, 1.0, LocusOccurrence.Heterozygous);

    }

    @Test
    public void Returns100PercentHeterozygousByRezDom() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator.mate(LocusOccurrence.RecessiveHomozygous,
                        LocusOccurrence.DominantHomozygous);
        assertProbability(mates, 1.0, LocusOccurrence.Heterozygous);
    }
}