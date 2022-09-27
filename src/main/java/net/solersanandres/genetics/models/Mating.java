package net.solersanandres.genetics.models;

import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateResults;
import net.solersanandres.genetics.models.occurrence.AlleleOccurrencePair;

import java.util.ArrayList;
import java.util.List;

public class Mating {

    private final MateCalculator calculator;

    public Mating(MateCalculator calculator) {
        this.calculator = calculator;
    }

    public void calculate(Parent firstParent, Parent secondParent) {
        ArrayList<AlleleOccurrencePair> balancedOccurrences = firstParent.balanceWith(secondParent);
        List<MateResults> mateResults = calculator.forLoci(balancedOccurrences);
    }
}
