package net.solersanandres.genetics;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.mating.MateResults;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateTwoDominantHomozygousTest {
    @Test
    void getDominantHomozygousWithProbabilityOneDotZero() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();


        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.TwoDominantHomozygous());

        assertThat(results.size()).isEqualTo(1);
        Optional<Double> dominantHomozygous = results.getProbability(LocusOccurrence.DOMINANT_HOMOZYGOUS);
        assertThat(dominantHomozygous).isPresent();
        assertThat(dominantHomozygous.get()).isEqualTo(1.0);
    }


}
