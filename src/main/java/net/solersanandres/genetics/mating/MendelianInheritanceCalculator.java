package net.solersanandres.genetics.mating;


import net.solersanandres.genetics.models.occurrence.AlleleOccurrencePair;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePair;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class MendelianInheritanceCalculator implements MateCalculator {
    private static final Map<OccurrencePair, MateResults> matingTableForLocusPairs = new HashMap<>();

    public MendelianInheritanceCalculator() {
        matingTableForLocusPairs.put(
                OccurrencePairFactory.TwoDominantHomozygous(),
                new CommonMateResults(Map.of(Occurrence.DOMINANT_HOMOZYGOUS, 1.0)));

        matingTableForLocusPairs.put(
                OccurrencePairFactory.TwoRecessiveHomozygous(),
                new CommonMateResults(Map.of(Occurrence.RECESSIVE_HOMOZYGOUS, 1.0)));

        matingTableForLocusPairs.put(
                OccurrencePairFactory.DominantHomozygousAndHeterozygous(),
                new CommonMateResults(Map.of(
                        Occurrence.DOMINANT_HOMOZYGOUS, 0.75,
                        Occurrence.HETEROZYGOUS, 0.25)
                ));
        matingTableForLocusPairs.put(
                OccurrencePairFactory.RecessiveHomozygousAndHeterozygous(),
                new CommonMateResults(Map.of(
                        Occurrence.RECESSIVE_HOMOZYGOUS, 0.75,
                        Occurrence.HETEROZYGOUS, 0.25)
                ));
        matingTableForLocusPairs.put(
                OccurrencePairFactory.TwoHeterozygous(),
                new CommonMateResults(Map.of(
                        Occurrence.DOMINANT_HOMOZYGOUS, 0.25,
                        Occurrence.RECESSIVE_HOMOZYGOUS, 0.25,
                        Occurrence.HETEROZYGOUS, 0.5)
                ));

        matingTableForLocusPairs.put(
                OccurrencePairFactory.RecessiveHomozygousAndDominantHomozygous(),
                new CommonMateResults(Map.of(Occurrence.HETEROZYGOUS, 1.0)));

    }

    @Override
    public MateResults forLocus(AlleleOccurrencePair alleleOccurrencePair) {
        return matingTableForLocusPairs.get(alleleOccurrencePair.getOccurrencePair());
    }

    @Override
    public List<MateResults> forLoci(List<AlleleOccurrencePair> alleleOccurrencePairs) {
        return alleleOccurrencePairs.parallelStream()
                .map(key -> matingTableForLocusPairs.get(key.getOccurrencePair()))
                .collect(Collectors.toList());
    }
}
