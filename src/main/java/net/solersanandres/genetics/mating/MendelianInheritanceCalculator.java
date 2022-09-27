package net.solersanandres.genetics.mating;


import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePair;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class MendelianInheritanceCalculator implements MateCalculator {
    private static final Map<OccurrencePair, LocusMateResults> matingTableForLocusPairs = new HashMap<>();

    public MendelianInheritanceCalculator() {
        matingTableForLocusPairs.put(
                OccurrencePairFactory.TwoDominantHomozygous(),
                new CommonLocusMateResults(Map.of(Occurrence.DOMINANT_HOMOZYGOUS, 1.0)));

        matingTableForLocusPairs.put(
                OccurrencePairFactory.TwoRecessiveHomozygous(),
                new CommonLocusMateResults(Map.of(Occurrence.RECESSIVE_HOMOZYGOUS, 1.0)));

        matingTableForLocusPairs.put(
                OccurrencePairFactory.DominantHomozygousAndHeterozygous(),
                new CommonLocusMateResults(Map.of(
                        Occurrence.DOMINANT_HOMOZYGOUS, 0.75,
                        Occurrence.HETEROZYGOUS, 0.25)
                ));
        matingTableForLocusPairs.put(
                OccurrencePairFactory.RecessiveHomozygousAndHeterozygous(),
                new CommonLocusMateResults(Map.of(
                        Occurrence.RECESSIVE_HOMOZYGOUS, 0.75,
                        Occurrence.HETEROZYGOUS, 0.25)
                ));
        matingTableForLocusPairs.put(
                OccurrencePairFactory.TwoHeterozygous(),
                new CommonLocusMateResults(Map.of(
                        Occurrence.DOMINANT_HOMOZYGOUS, 0.25,
                        Occurrence.RECESSIVE_HOMOZYGOUS, 0.25,
                        Occurrence.HETEROZYGOUS, 0.5)
                ));

        matingTableForLocusPairs.put(
                OccurrencePairFactory.RecessiveHomozygousAndDominantHomozygous(),
                new CommonLocusMateResults(Map.of(Occurrence.HETEROZYGOUS, 1.0)));

    }

    @Override
    public MateResults forLocus(AllelePairOccurrence allelePairOccurrence) {
        return new MateResults(allelePairOccurrence.getAllelePair(),
                matingTableForLocusPairs.get(allelePairOccurrence.getOccurrencePair()));
    }

    @Override
    public List<MateResults> forLoci(List<AllelePairOccurrence> allelePairOccurrences) {
        return allelePairOccurrences.parallelStream()
                .map(key -> new MateResults(key.getAllelePair(),
                        matingTableForLocusPairs.get(key.getOccurrencePair())))
                .collect(Collectors.toList());
    }
}
