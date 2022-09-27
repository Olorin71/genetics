package net.solersanandres.genetics.mating;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePair;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePairFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class MendelianInheritanceCalculator implements MateCalculator {
    private static final Map<LocusOccurrencePair, MateResults> matingTableForLocusPairs = new HashMap<>();

    public MendelianInheritanceCalculator() {
        matingTableForLocusPairs.put(
                LocusOccurrencePairFactory.TwoDominantHomozygous(),
                new CommonMateResults(Map.of(LocusOccurrence.DOMINANT_HOMOZYGOUS, 1.0)));

        matingTableForLocusPairs.put(
                LocusOccurrencePairFactory.TwoRecessiveHomozygous(),
                new CommonMateResults(Map.of(LocusOccurrence.RECESSIVE_HOMOZYGOUS, 1.0)));

        matingTableForLocusPairs.put(
                LocusOccurrencePairFactory.DominantHomozygousAndHeterozygous(),
                new CommonMateResults(Map.of(
                        LocusOccurrence.DOMINANT_HOMOZYGOUS, 0.75,
                        LocusOccurrence.HETEROZYGOUS, 0.25)
                ));
        matingTableForLocusPairs.put(
                LocusOccurrencePairFactory.RecessiveHomozygousAndHeterozygous(),
                new CommonMateResults(Map.of(
                        LocusOccurrence.RECESSIVE_HOMOZYGOUS, 0.75,
                        LocusOccurrence.HETEROZYGOUS, 0.25)
                ));
        matingTableForLocusPairs.put(
                LocusOccurrencePairFactory.TwoHeterozygous(),
                new CommonMateResults(Map.of(
                        LocusOccurrence.DOMINANT_HOMOZYGOUS, 0.25,
                        LocusOccurrence.RECESSIVE_HOMOZYGOUS, 0.25,
                        LocusOccurrence.HETEROZYGOUS, 0.5)
                ));

        matingTableForLocusPairs.put(
                LocusOccurrencePairFactory.RecessiveHomozygousAndDominantHomozygous(),
                new CommonMateResults(Map.of(LocusOccurrence.HETEROZYGOUS, 1.0)));

    }

    @Override
    public MateResults forLocus(LocusOccurrencePair locusOccurrencePair) {
        return matingTableForLocusPairs.get(locusOccurrencePair);
    }

    @Override
    public List<MateResults> forLoci(List<LocusOccurrencePair> locusOccurrencePairs) {
        return locusOccurrencePairs.parallelStream()
                .map(matingTableForLocusPairs::get)
                .collect(Collectors.toList());
    }
}
