package net.solersanandres.genetics.mating;

import net.solersanandres.genetics.models.occurrence.Occurrence;

import java.util.Optional;

public interface MateResults {
    int size();

    Optional<Double> getProbability(Occurrence Occurrence);
}
