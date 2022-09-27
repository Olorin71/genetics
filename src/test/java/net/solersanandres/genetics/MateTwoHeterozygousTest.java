package net.solersanandres.genetics;

import net.solersanandres.genetics.mating.MateResults;
import net.solersanandres.genetics.models.Allele;
import net.solersanandres.genetics.models.occurrence.AllelePair;
import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateTwoHeterozygousTest {
    MateCalculator mateCalculator;
    private AllelePairOccurrence allelePairOccurrence;

    @BeforeEach
    void setUp() {
        Allele allele = new Allele("Schwarz", "s", "Anery");
        mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        allelePairOccurrence = new AllelePairOccurrence(new AllelePair(allele, allele),
                OccurrencePairFactory.TwoHeterozygous());

    }
    @Test
    void get25PercentDominantHomozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(allelePairOccurrence);

        Optional<Double> dominantHomozygous = results.getProbability(Occurrence.DOMINANT_HOMOZYGOUS);
        assertThat(dominantHomozygous).isPresent();
        assertThat(dominantHomozygous.get()).isEqualTo(0.25);
    }

    @Test
    void get25PercentRecessiveHomozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(allelePairOccurrence);

        Optional<Double> recessiveHomozygous = results.getProbability(Occurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(0.25);
    }

    @Test
    void getHeterozygousWithProbabilityZeroDotFive() {
        MateResults results = mateCalculator.forLocus(allelePairOccurrence);

        Optional<Double> heterozygous = results.getProbability(Occurrence.HETEROZYGOUS);
        assertThat(heterozygous).isPresent();
        assertThat(heterozygous.get()).isEqualTo(0.50);
    }


}
