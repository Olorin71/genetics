package net.solersanandres.genetics;

import net.solersanandres.genetics.models.occurrence.AlleleOccurrencePair;
import net.solersanandres.genetics.models.occurrence.OccurrencePair;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
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
        List<AlleleOccurrencePair> pairs = new ArrayList<>();
        pairs.add(new AlleleOccurrencePair("a", "a",  OccurrencePairFactory.TwoRecessiveHomozygous()));
        pairs.add(new AlleleOccurrencePair("b", "b",  OccurrencePairFactory.RecessiveHomozygousAndHeterozygous()));

        List<MateResults> results = mateCalculator.forLoci(pairs);

        assertThat(results.size()).isEqualTo(2);
    }

    @Test
    void ThreePairsGetThreeMateResults() {
        MateCalculator mateCalculator = MateCalculatorFactory.createMendelianInheritanceCalculator();
        List<AlleleOccurrencePair> pairs = new ArrayList<>();
        pairs.add(new AlleleOccurrencePair("a", "a",  OccurrencePairFactory.TwoRecessiveHomozygous()));
        pairs.add(new AlleleOccurrencePair("b", "b",  OccurrencePairFactory.RecessiveHomozygousAndHeterozygous()));
        pairs.add(new AlleleOccurrencePair("x", "h",  OccurrencePairFactory.TwoRecessiveHomozygous()));

        List<MateResults> results = mateCalculator.forLoci(pairs);

        assertThat(results.size()).isEqualTo(3);
    }

}
