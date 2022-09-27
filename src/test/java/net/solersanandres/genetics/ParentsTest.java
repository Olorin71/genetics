package net.solersanandres.genetics;

import net.solersanandres.genetics.models.LocusOccurrence;
import net.solersanandres.genetics.models.Parent;
import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.solersanandres.genetics.Data.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ParentsTest {

    @Test
    void TwoParentWithOneAndTheSameAlleleOccurrence_BalancedContainsOnlyTheOneAlleleOccurrence() {
        Parent p1 = new Parent();
        LocusOccurrence locusOccurrence = new LocusOccurrence(locusA, alleleA1, Occurrence.DOMINANT_HOMOZYGOUS);
        p1.addAlleleOccurrence(locusOccurrence);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(locusOccurrence);

        List<AllelePairOccurrence> alleleOccurrences = p1.balanceWith(p2);
        assertThat(alleleOccurrences).isNotNull();
        assertThat(alleleOccurrences.size()).isEqualTo(1);
        assertThat(alleleOccurrences.get(0).getOccurrencePair())
                .isEqualTo(OccurrencePairFactory.TwoDominantHomozygous());
    }

    @Test
    void TwoParentWithTwoAndTheSameAlleleOccurrence_BalancedContainsOnlyTheTwoAlleleOccurrence() {
        LocusOccurrence locusOccurrence1 = new LocusOccurrence(locusA, alleleA1, Occurrence.RECESSIVE_HOMOZYGOUS);
        LocusOccurrence locusOccurrence2 = new LocusOccurrence(locusZ, alleleZ1, Occurrence.HETEROZYGOUS);
        Parent p1 = new Parent();
        p1.addAlleleOccurrence(locusOccurrence1);
        p1.addAlleleOccurrence(locusOccurrence2);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(locusOccurrence1);
        p2.addAlleleOccurrence(locusOccurrence2);

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
        LocusOccurrence locusOccurrence1 = new LocusOccurrence(locusA, alleleA1, Occurrence.RECESSIVE_HOMOZYGOUS);
        LocusOccurrence locusOccurrence2 = new LocusOccurrence(locusZ, alleleZ1, Occurrence.HETEROZYGOUS);
        Parent p1 = new Parent();
        p1.addAlleleOccurrence(locusOccurrence1);
        Parent p2 = new Parent();
        p2.addAlleleOccurrence(locusOccurrence2);

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
        LocusOccurrence locusOccurrence1 = new LocusOccurrence(locusA, alleleA1, Occurrence.RECESSIVE_HOMOZYGOUS);
        LocusOccurrence locusOccurrence2 = new LocusOccurrence(locusZ, alleleZ1, Occurrence.HETEROZYGOUS);
        Parent p1 = new Parent();
        p1.addAlleleOccurrence(locusOccurrence1);
        p1.addAlleleOccurrence(locusOccurrence2);
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
