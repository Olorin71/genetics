package net.solersanandres.genetics;

import net.solersanandres.genetics.mating.MateResults;
import net.solersanandres.genetics.models.Allele;
import net.solersanandres.genetics.models.occurrence.AllelePair;
import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateMultiplePairsTest {
    private final Allele alleleA = new Allele("a", "a", "locusA");
    private final Allele alleleB = new Allele("b", "b", "locusB");
    private final Allele alleleX = new Allele("x", "h", "locusX");
    @Test
    void TwoPairsGetTwoMateResults() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        List<AllelePairOccurrence> pairs = new ArrayList<>();
        pairs.add(new AllelePairOccurrence(new AllelePair(alleleA, alleleA),  OccurrencePairFactory.TwoRecessiveHomozygous()));
        pairs.add(new AllelePairOccurrence(new AllelePair(alleleB, alleleB),  OccurrencePairFactory.RecessiveHomozygousAndHeterozygous()));

        List<MateResults> results = mateCalculator.forLoci(pairs);

        assertThat(results.size()).isEqualTo(2);
        Optional<MateResults> locusA = results.stream().filter(result -> result.getAllelePair().getFirstAllele().getLocusName().equals("locusA")).findFirst();
        assertThat(locusA).isPresent();
        Optional<MateResults> locusB = results.stream().filter(result -> result.getAllelePair().getFirstAllele().getLocusName().equals("locusB")).findFirst();
        assertThat(locusB).isPresent();
    }

    @Test
    void ThreePairsGetThreeMateResults() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        List<AllelePairOccurrence> pairs = new ArrayList<>();
        pairs.add(new AllelePairOccurrence(new AllelePair(alleleA, alleleA),  OccurrencePairFactory.TwoRecessiveHomozygous()));
        pairs.add(new AllelePairOccurrence(new AllelePair(alleleB, alleleB),  OccurrencePairFactory.RecessiveHomozygousAndHeterozygous()));
        pairs.add(new AllelePairOccurrence(new AllelePair(alleleX, alleleX),  OccurrencePairFactory.TwoRecessiveHomozygous()));

        List<MateResults> results = mateCalculator.forLoci(pairs);

        assertThat(results.size()).isEqualTo(3);
    }

}
