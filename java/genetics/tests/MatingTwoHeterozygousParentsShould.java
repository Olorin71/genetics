package genetics.tests;

import genetics.Calculator;
import genetics.LocusOccurrence;
import genetics.MateResult;

import java.util.List;

import org.junit.Test;

public class MatingTwoHeterozygousParentsShould extends CalculatorTestBase {

    @Test
    public void Returns25PercentDominantHomozygous() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator
                        .mate(LocusOccurrence.Heterozygous, LocusOccurrence.Heterozygous);
        assertProbability(mates, 0.25, LocusOccurrence.DominantHomozygous);
    }
    
    @Test
    public void Returns25PercentRecessiveHomozygous() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator
                        .mate(LocusOccurrence.Heterozygous, LocusOccurrence.Heterozygous);
        assertProbability(mates, 0.25, LocusOccurrence.RecessiveHomozygous);
    }
    
    @Test
    public void Returns50PercentHeterozygous() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator
                        .mate(LocusOccurrence.Heterozygous, LocusOccurrence.Heterozygous);
        assertProbability(mates, 0.5, LocusOccurrence.Heterozygous);
    }
}