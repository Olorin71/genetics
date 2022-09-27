package net.solersanandres.genetics.models;

import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateResults;
import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;

import java.util.List;

public class Mating {

    private final MateCalculator calculator;

    public Mating(MateCalculator calculator) {
        this.calculator = calculator;
    }

    public void calculate(Parent firstParent, Parent secondParent) {
        List<AllelePairOccurrence> balancedOccurrences = firstParent.balanceWith(secondParent);
        List<MateResults> locusMateResults = calculator.forLoci(balancedOccurrences);
        combineMateResults(locusMateResults);
    }

    private void combineMateResults(List<MateResults> locusMateResults) {

    }
}
