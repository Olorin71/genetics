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

public class MateTwoHeterozygousTest {
    MateCalculator mateCalculator;

    @BeforeEach
    void setUp() {
        mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
    }
    @Test
    void get25PercentDominantHomozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.TwoHeterozygous());

        Optional<Double> dominantHomozygous = results.getProbability(LocusOccurrence.DOMINANT_HOMOZYGOUS);
        assertThat(dominantHomozygous).isPresent();
        assertThat(dominantHomozygous.get()).isEqualTo(0.25);
    }

    @Test
    void get25PercentRecessiveHomozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.TwoHeterozygous());

        Optional<Double> recessiveHomozygous = results.getProbability(LocusOccurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(0.25);
    }

    @Test
    void getHeterozygousWithProbabilityZeroDotFive() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.TwoHeterozygous());

        Optional<Double> heterozygous = results.getProbability(LocusOccurrence.HETEROZYGOUS);
        assertThat(heterozygous).isPresent();
        assertThat(heterozygous.get()).isEqualTo(0.50);
    }


}
