package genetics.tests;

import genetics.Calculator;
import genetics.LocusOccurrence;
import genetics.MateResult;

import java.util.List;

import org.junit.Test;

public class MatingOneDominantHomozygousAndOneHeterozygousParentShould extends CalculatorTestBase {

    @Test
    public void Returns50PercentDominantHomozygousByDomHet() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator.mate(LocusOccurrence.DominantHomozygous, LocusOccurrence.Heterozygous);
        assertProbability(mates, 0.5, LocusOccurrence.DominantHomozygous);
    }

    @Test
    public void Returns50PercentDominantHomozygousByHetDom() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator.mate(LocusOccurrence.Heterozygous, LocusOccurrence.DominantHomozygous);
        assertProbability(mates, 0.5, LocusOccurrence.DominantHomozygous);
    }

    @Test
    public void Returns50PercentHeterozygousByDomHet() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator.mate(LocusOccurrence.DominantHomozygous, LocusOccurrence.Heterozygous);
        assertProbability(mates, 0.5, LocusOccurrence.Heterozygous);
    }

    @Test
    public void Returns50PercentHeterozygousByHetDom() {
        Calculator calculator = new Calculator();
        List<MateResult> mates = calculator.mate(LocusOccurrence.Heterozygous, LocusOccurrence.DominantHomozygous);
        assertProbability(mates, 0.5, LocusOccurrence.Heterozygous);
    }

}