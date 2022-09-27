package net.solersanandres.genetics;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.mating.MateResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateDominantHomozygousAndHeterozygousTest {
    MateCalculator mateCalculator;

    @BeforeEach
    void setUp() {
        mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
    }

    @Test
    void DomHomAndHetGetDominantHomozygousWithProbabilityZeroDotSeventFive() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.DominantHomozygousAndHeterozygous());

        Optional<Double> dominantHomozygous = results.getProbability(LocusOccurrence.DOMINANT_HOMOZYGOUS);
        assertThat(dominantHomozygous).isPresent();
        assertThat(dominantHomozygous).get().isEqualTo(0.75);
    }

    @Test
    void DomHomAndHetGetHeterozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.DominantHomozygousAndHeterozygous());

        Optional<Double> heterozygous = results.getProbability(LocusOccurrence.HETEROZYGOUS);
        assertThat(heterozygous.isPresent()).isTrue();
        assertThat(heterozygous.get()).isEqualTo(0.25);
    }

}
