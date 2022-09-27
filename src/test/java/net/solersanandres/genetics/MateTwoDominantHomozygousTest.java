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

public class MateTwoDominantHomozygousTest {
    @Test
    void getDominantHomozygousWithProbabilityOneDotZero() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        AlleleOccurrencePair alleleOccurrencePair = new AlleleOccurrencePair("Schwarz", "Anery",
                OccurrencePairFactory.TwoDominantHomozygous());


        MateResults results = mateCalculator.forLocus(alleleOccurrencePair);

        assertThat(results.size()).isEqualTo(1);
        Optional<Double> dominantHomozygous = results.getProbability(Occurrence.DOMINANT_HOMOZYGOUS);
        assertThat(dominantHomozygous).isPresent();
        assertThat(dominantHomozygous.get()).isEqualTo(1.0);
    }


}
