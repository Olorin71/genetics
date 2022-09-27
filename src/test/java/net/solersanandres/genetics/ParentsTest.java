package net.solersanandres.genetics;

import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePairFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ParentsTest {
    @Test
    void TwoParentWithOneAndTheSameAlleleOccurrence_BalancedContainsOnlyTheOneAlleleOccurrence() {
        Parent p1 = new Parent();
        AlleleOccurrence occurrence = new AlleleOccurrence("A", "A", LocusOccurrence.DOMINANT_HOMOZYGOUS);
        p1.addAlleleOccurrence(occurrence);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(occurrence);

        List<AllelePairOccurrence> alleleOccurrences = p1.balanceWith(p2);
        assertThat(alleleOccurrences).isNotNull();
        assertThat(alleleOccurrences.size()).isEqualTo(1);
        assertThat(alleleOccurrences.get(0).getOccurrencePair())
                .isEqualTo(LocusOccurrencePairFactory.TwoDominantHomozygous());
        assertThat(alleleOccurrences.get(0).getLocusId()).isEqualTo("A");
        assertThat(alleleOccurrences.get(0).getAlleleId()).isEqualTo("A");
    }

    @Test
    void TwoParentWithTwoAndTheSameAlleleOccurrence_BalancedContainsOnlyTheTwoAlleleOccurrence() {
        AlleleOccurrence alleleOccurrenceOne = new AlleleOccurrence("A", "A", LocusOccurrence.RECESSIVE_HOMOZYGOUS);
        AlleleOccurrence alleleOccurrenceTwo = new AlleleOccurrence("B", "B", LocusOccurrence.HETEROZYGOUS);
        Parent p1 = new Parent();
        p1.addAlleleOccurrence(alleleOccurrenceOne);
        p1.addAlleleOccurrence(alleleOccurrenceTwo);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(alleleOccurrenceOne);
        p2.addAlleleOccurrence(alleleOccurrenceTwo);

        List<AllelePairOccurrence> alleleOccurrences = p1.balanceWith(p2);
        assertThat(alleleOccurrences).isNotNull();
        assertThat(alleleOccurrences.size()).isEqualTo(2);

        assertThat(alleleOccurrences.get(0).getOccurrencePair())
                .isEqualTo(LocusOccurrencePairFactory.TwoRecessiveHomozygous());
        assertThat(alleleOccurrences.get(0).getLocusId()).isEqualTo("A");
        assertThat(alleleOccurrences.get(0).getAlleleId()).isEqualTo("A");

        assertThat(alleleOccurrences.get(1).getOccurrencePair())
                .isEqualTo(LocusOccurrencePairFactory.TwoHeterozygous());
        assertThat(alleleOccurrences.get(1).getLocusId()).isEqualTo("B");
        assertThat(alleleOccurrences.get(1).getAlleleId()).isEqualTo("B");
    }

    @Test
    void TwoParentWithOneAlleleOccurrenceForDifferentLocus_BalancedContainsOccurrencesForBothLocus() {
        AlleleOccurrence alleleOccurrenceOne = new AlleleOccurrence("A", "A", LocusOccurrence.RECESSIVE_HOMOZYGOUS);
        AlleleOccurrence alleleOccurrenceTwo = new AlleleOccurrence("B", "B", LocusOccurrence.HETEROZYGOUS);
        Parent p1 = new Parent();
        p1.addAlleleOccurrence(alleleOccurrenceOne);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(alleleOccurrenceTwo);

        List<AllelePairOccurrence> alleleOccurrences = p1.balanceWith(p2);
        assertThat(alleleOccurrences).isNotNull();
        assertThat(alleleOccurrences.size()).isEqualTo(2);

        assertThat(alleleOccurrences.get(0).getOccurrencePair())
                .isEqualTo(LocusOccurrencePairFactory.RecessiveHomozygousAndDominantHomozygous());
        assertThat(alleleOccurrences.get(0).getLocusId()).isEqualTo("A");
        assertThat(alleleOccurrences.get(0).getAlleleId()).isEqualTo("A");

        assertThat(alleleOccurrences.get(1).getOccurrencePair())
                .isEqualTo(LocusOccurrencePairFactory.DominantHomozygousAndHeterozygous());
        assertThat(alleleOccurrences.get(1).getLocusId()).isEqualTo("B");
        assertThat(alleleOccurrences.get(1).getAlleleId()).isEqualTo("B");
    }

}
