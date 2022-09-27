package net.solersanandres.genetics.mating;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;

import java.util.Map;
import java.util.Optional;

class CommonMateResults implements MateResults {
    private final Map<LocusOccurrence, Double> mateResultsMap;

    public CommonMateResults(Map<LocusOccurrence, Double> mateResults) {
        this.mateResultsMap = mateResults;
    }

    @Override
    public int size() {
        return mateResultsMap.size();
    }

    @Override
    public Optional<Double> getProbability(LocusOccurrence locusOccurrence) {
        return Optional.ofNullable(mateResultsMap.get(locusOccurrence));
    }
}
