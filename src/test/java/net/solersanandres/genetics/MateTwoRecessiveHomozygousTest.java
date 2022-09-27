package net.solersanandres.genetics;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.mating.MateResults;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateTwoRecessiveHomozygousTest {
    @Test
    void getRecessiveHomozygousWithProbabilityOneDotZero() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();

        MateResults results = mateCalculator.forLocus(LocusOccurrencePairFactory.TwoRecessiveHomozygous());

        assertThat(results.size()).isEqualTo(1);
        Optional<Double> recessiveHomozygous = results.getProbability(LocusOccurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(1.0);
    }

}
