package net.solersanandres.genetics;

import net.solersanandres.genetics.models.occurrence.AlleleOccurrencePair;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.mating.MateResults;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateRecessiveHomozygousAndHeterozygousTest {
    MateCalculator mateCalculator;
    private AlleleOccurrencePair alleleOccurrencePair;

    @BeforeEach
    void setUp() {
        mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        alleleOccurrencePair = new AlleleOccurrencePair("Schwarz", "Anery",
                OccurrencePairFactory.RecessiveHomozygousAndHeterozygous());

    }

    @Test
    void RecHomAndHetGetRecessiveHomozygousWithProbabilityZeroDotSeventFive() {
        MateResults results = mateCalculator.forLocus(alleleOccurrencePair);

        Optional<Double> recessiveHomozygous = results.getProbability(Occurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(0.75);
    }

    @Test
    void RecHomAndHetGetHeterozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(alleleOccurrencePair);

        Optional<Double> heterozygous = results.getProbability(Occurrence.HETEROZYGOUS);
        assertThat(heterozygous.isPresent()).isTrue();
        assertThat(heterozygous.get()).isEqualTo(0.25);
    }
}
