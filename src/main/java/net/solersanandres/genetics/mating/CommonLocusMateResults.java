package net.solersanandres.genetics.mating;

import net.solersanandres.genetics.models.occurrence.Occurrence;

import java.util.Map;
import java.util.Optional;

class CommonLocusMateResults implements LocusMateResults {
    private final Map<Occurrence, Double> mateResultsMap;

    public CommonLocusMateResults(Map<Occurrence, Double> mateResults) {
        this.mateResultsMap = mateResults;
    }

    @Override
    public int size() {
        return mateResultsMap.size();
    }

    @Override
    public Optional<Double> getProbability(Occurrence Occurrence) {
        return Optional.ofNullable(mateResultsMap.get(Occurrence));
    }
}
