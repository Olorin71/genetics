package net.solersanandres.genetics.mating;

import net.solersanandres.genetics.models.occurrence.Occurrence;

import java.util.Optional;

public interface LocusMateResults {
    int size();

    Optional<Double> getProbability(Occurrence Occurrence);
}
