package net.solersanandres.genetics.mating;

import lombok.Getter;
import net.solersanandres.genetics.models.occurrence.AllelePair;
import net.solersanandres.genetics.models.occurrence.Occurrence;

import java.util.Optional;


public class MateResults implements LocusMateResults {
    @Getter
    private final AllelePair allelePair;
    private final LocusMateResults results;

    public MateResults(AllelePair allelePair, LocusMateResults results) {
        this.allelePair = allelePair;
        this.results = results;
    }

    @Override
    public int size() {
        return results.size();
    }

    @Override
    public Optional<Double> getProbability(Occurrence occurrence) {
        return results.getProbability(occurrence);
    }

}
