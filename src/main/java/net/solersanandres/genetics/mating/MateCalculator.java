package net.solersanandres.genetics.mating;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePair;

import java.util.List;

public interface MateCalculator {
    MateResults forLocus(LocusOccurrencePair locusOccurrencePair);
    List<MateResults> forLoci(List<LocusOccurrencePair> locusOccurrencePairs);
}
