package net.solersanandres.genetics.mating;


import net.solersanandres.genetics.models.occurrence.AlleleOccurrencePair;

import java.util.List;

public interface MateCalculator {
    MateResults forLocus(AlleleOccurrencePair alleleOccurrencePair);

    List<MateResults> forLoci(List<AlleleOccurrencePair> alleleOccurrencePairs);
}
