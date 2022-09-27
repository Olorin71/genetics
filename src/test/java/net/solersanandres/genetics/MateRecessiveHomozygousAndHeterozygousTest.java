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

public class MateRecessiveHomozygousAndHeterozygousTest {
    MateCalculator mateCalculator;
    private AllelePairOccurrence allelePairOccurrence;

    @BeforeEach
    void setUp() {
        Allele allele = new Allele("Schwarz", "s", "Anery");
        mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        allelePairOccurrence = new AllelePairOccurrence(new AllelePair(allele, allele),
                OccurrencePairFactory.RecessiveHomozygousAndHeterozygous());

    }

    @Test
    void RecHomAndHetGetRecessiveHomozygousWithProbabilityZeroDotSeventFive() {
        MateResults results = mateCalculator.forLocus(allelePairOccurrence);

        Optional<Double> recessiveHomozygous = results.getProbability(Occurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(0.75);
    }

    @Test
    void RecHomAndHetGetHeterozygousWithProbabilityZeroDotTwentyFive() {
        MateResults results = mateCalculator.forLocus(allelePairOccurrence);

        Optional<Double> heterozygous = results.getProbability(Occurrence.HETEROZYGOUS);
        assertThat(heterozygous.isPresent()).isTrue();
        assertThat(heterozygous.get()).isEqualTo(0.25);
    }
}
