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

public class MateDominantHomozygousAndRecessiveHomozygousTest {
    MateCalculator mateCalculator;

    @BeforeEach
    void setUp() {
        mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
    }

    @Test
    void RecHomAndDomHomGet100PercentHeterozygous() {
        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.RecessiveHomozygousAndDominantHomozygous());

        Optional<Double> heterozygous = results.getProbability(LocusOccurrence.HETEROZYGOUS);
        assertThat(heterozygous).isPresent();
        assertThat(heterozygous.get()).isEqualTo(1.0);
    }
}
