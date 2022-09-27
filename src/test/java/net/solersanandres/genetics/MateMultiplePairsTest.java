package net.solersanandres.genetics;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePair;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePairFactory;
import net.solersanandres.genetics.mating.MateCalculator;
import net.solersanandres.genetics.mating.MateCalculatorFactory;
import net.solersanandres.genetics.mating.MateResults;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MateMultiplePairsTest {
    @Test
    void TwoPairsGetTwoMateResults() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        List<LocusOccurrencePair> pairs = new ArrayList<>();
        pairs.add(LocusOccurrencePairFactory.TwoRecessiveHomozygous());
        pairs.add(LocusOccurrencePairFactory.RecessiveHomozygousAndHeterozygous());

        List<MateResults> results = mateCalculator.forLoci(pairs);

        assertThat(results.size()).isEqualTo(2);
    }

    @Test
    void ThreePairsGetThreeMateResults() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        List<LocusOccurrencePair> pairs = new ArrayList<>();
        pairs.add(LocusOccurrencePairFactory.TwoRecessiveHomozygous());
        pairs.add(LocusOccurrencePairFactory.RecessiveHomozygousAndHeterozygous());
        pairs.add(LocusOccurrencePairFactory.TwoRecessiveHomozygous());

        List<MateResults> results = mateCalculator.forLoci(pairs);

        assertThat(results.size()).isEqualTo(3);
    }

}
