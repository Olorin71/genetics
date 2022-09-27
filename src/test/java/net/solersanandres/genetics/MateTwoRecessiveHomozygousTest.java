package net.solersanandres.genetics;

import net.solersanandres.genetics.models.occurrence.AlleleOccurrencePair;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.mating.MateResults;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateTwoRecessiveHomozygousTest {
    @Test
    void getRecessiveHomozygousWithProbabilityOneDotZero() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        AlleleOccurrencePair alleleOccurrencePair = new AlleleOccurrencePair("Schwarz", "Anery",
                OccurrencePairFactory.TwoRecessiveHomozygous());


        MateResults results = mateCalculator.forLocus(alleleOccurrencePair);

        assertThat(results.size()).isEqualTo(1);
        Optional<Double> recessiveHomozygous = results.getProbability(Occurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(1.0);
    }

}
