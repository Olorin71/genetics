package net.solersanandres.genetics;

import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.mating.MateResults;
import net.solersanandres.genetics.models.Allele;
import net.solersanandres.genetics.models.occurrence.AllelePair;
import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MateTwoRecessiveHomozygousTest {
    @Test
    void getRecessiveHomozygousWithProbabilityOneDotZero() {
        Allele allele = new Allele("Schwarz", "s", "Anery");
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        AllelePairOccurrence allelePairOccurrence = new AllelePairOccurrence(new AllelePair(allele, allele),
                OccurrencePairFactory.TwoRecessiveHomozygous());


        MateResults results = mateCalculator.forLocus(allelePairOccurrence);

        assertThat(results.size()).isEqualTo(1);
        Optional<Double> recessiveHomozygous = results.getProbability(Occurrence.RECESSIVE_HOMOZYGOUS);
        assertThat(recessiveHomozygous).isPresent();
        assertThat(recessiveHomozygous.get()).isEqualTo(1.0);
    }

}
