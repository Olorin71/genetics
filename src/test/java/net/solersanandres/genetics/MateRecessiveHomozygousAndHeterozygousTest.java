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

public class MateRecessiveHomozygousAndHeterozygousTest {
    MateCalculator mateCalculator;

    @BeforeEach
    void setUp() {
        mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
    }

    @Test
    void RecHomAndHetGetRecessiveHomozygousWithProbabilityZeroDotSeventFive() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.RecessiveHomozygousAndHeterozygous());

        Optional<Double> recessiveHomozygous = results.getProbability(LocusOccurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(0.75);
    }

    @Test
    void RecHomAndHetGetHeterozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.RecessiveHomozygousAndHeterozygous());

        Optional<Double> heterozygous = results.getProbability(LocusOccurrence.HETEROZYGOUS);
        assertThat(heterozygous.isPresent()).isTrue();
        assertThat(heterozygous.get()).isEqualTo(0.25);
    }
}
