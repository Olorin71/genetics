package net.solersanandres.genetics.mating;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;

import java.util.Optional;

public interface MateResults {
    int size();

    Optional<Double> getProbability(LocusOccurrence locusOccurrence);
}
