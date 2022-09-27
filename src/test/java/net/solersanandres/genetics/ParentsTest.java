package net.solersanandres.genetics;

import net.solersanandres.genetics.models.occurrence.AlleleOccurrence;
import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
import net.solersanandres.genetics.models.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ParentsTest {
    @Test
    void TwoParentWithOneAndTheSameAlleleOccurrence_BalancedContainsOnlyTheOneAlleleOccurrence() {
        Parent p1 = new Parent();
        AlleleOccurrence occurrence = new AlleleOccurrence(new Allele("Anery", "A", "Schwarz"), Occurrence.DOMINANT_HOMOZYGOUS);
        p1.addAlleleOccurrence(occurrence);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(occurrence);

        List<AllelePairOccurrence> alleleOccurrences = p1.balanceWith(p2);
        assertThat(alleleOccurrences).isNotNull();
        assertThat(alleleOccurrences.size()).isEqualTo(1);
        assertThat(alleleOccurrences.get(0).getOccurrencePair())
                .isEqualTo(OccurrencePairFactory.TwoDominantHomozygous());
    }

    @Test
    void TwoParentWithTwoAndTheSameAlleleOccurrence_BalancedContainsOnlyTheTwoAlleleOccurrence() {
        AlleleOccurrence alleleOccurrenceOne = new AlleleOccurrence(new Allele("Anery", "A", "Schwarz"), Occurrence.RECESSIVE_HOMOZYGOUS);
        AlleleOccurrence alleleOccurrenceTwo = new AlleleOccurrence(new Allele("Blue", "B", "Blau"), Occurrence.HETEROZYGOUS);
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
                .isEqualTo(OccurrencePairFactory.TwoRecessiveHomozygous());

        assertThat(alleleOccurrences.get(1).getOccurrencePair())
                .isEqualTo(OccurrencePairFactory.TwoHeterozygous());
    }

    @Test
    void TwoParentWithOneAlleleOccurrenceForDifferentLocus_BalancedContainsOccurrencesForBothLocus() {
        AlleleOccurrence alleleOccurrenceOne = new AlleleOccurrence(new Allele("Anery", "A", "Schwarz"), Occurrence.RECESSIVE_HOMOZYGOUS);
        AlleleOccurrence alleleOccurrenceTwo = new AlleleOccurrence(new Allele("Blue", "B", "Blau"), Occurrence.HETEROZYGOUS);
        Parent p1 = new Parent();
        p1.addAlleleOccurrence(alleleOccurrenceOne);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(alleleOccurrenceTwo);

        List<AllelePairOccurrence> alleleOccurrences = p1.balanceWith(p2);
        assertThat(alleleOccurrences).isNotNull();
        assertThat(alleleOccurrences.size()).isEqualTo(2);

        assertThat(alleleOccurrences.get(0).getOccurrencePair())
                .isEqualTo(OccurrencePairFactory.RecessiveHomozygousAndDominantHomozygous());

        assertThat(alleleOccurrences.get(1).getOccurrencePair())
                .isEqualTo(OccurrencePairFactory.DominantHomozygousAndHeterozygous());
    }

    @Test
    void OneParentWithTwoOccurrences_TheOtherOneNoOccurrences_BalancedContainsTheTwoOccurrence() {
        AlleleOccurrence alleleOccurrenceOne = new AlleleOccurrence(new Allele("Anery", "A", "Schwarz"), Occurrence.RECESSIVE_HOMOZYGOUS);
        AlleleOccurrence alleleOccurrenceTwo = new AlleleOccurrence(new Allele("Blue", "B", "Blau"), Occurrence.HETEROZYGOUS);
        Parent p1 = new Parent();
        p1.addAlleleOccurrence(alleleOccurrenceOne);
        p1.addAlleleOccurrence(alleleOccurrenceTwo);
        Parent p2 = new Parent();

        List<AllelePairOccurrence> alleleOccurrences = p1.balanceWith(p2);
        assertThat(alleleOccurrences).isNotNull();
        assertThat(alleleOccurrences.size()).isEqualTo(2);

        assertThat(alleleOccurrences.get(0).getOccurrencePair())
                .isEqualTo(OccurrencePairFactory.RecessiveHomozygousAndDominantHomozygous());

        assertThat(alleleOccurrences.get(1).getOccurrencePair())
                .isEqualTo(OccurrencePairFactory.DominantHomozygousAndHeterozygous());
    }


}
