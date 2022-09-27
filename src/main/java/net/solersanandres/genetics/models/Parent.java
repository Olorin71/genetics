package net.solersanandres.genetics.models;

import net.solersanandres.genetics.models.occurrence.AllelePair;
import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;

import java.util.ArrayList;
import java.util.List;

public class Parent {
    private final List<LocusOccurrence> locusOccurrences;

    public Parent() {
        this.locusOccurrences = new ArrayList<>();
    }

    public void addAlleleOccurrence(LocusOccurrence occurrence) {
        this.locusOccurrences.add(occurrence);
    }

    public ArrayList<AllelePairOccurrence> balanceWith(Parent otherParent) {
        ArrayList<AllelePairOccurrence> balancedOccurrences = new ArrayList<>();
        this.locusOccurrences.forEach(x -> {
            LocusOccurrence p2Occurrence = otherParent.getOccurrenceForLocusName(x.getLocus());
            AllelePairOccurrence allelePairOccurrence = new AllelePairOccurrence(
                    new AllelePair(x.getAllele(), p2Occurrence.getAllele()),
                    OccurrencePairFactory.create(x.getOccurrence(), p2Occurrence.getOccurrence()));
            balancedOccurrences.add(allelePairOccurrence);
        });
        otherParent.locusOccurrences.forEach(x -> {
            String locusName = x.getLocus().getName();
            boolean locusAlreadyAdded = balancedOccurrences.stream().anyMatch(item -> item.getAllelePair()
                    .getFirstAllele().getLocusName().equals(locusName));
            if (!locusAlreadyAdded) {
                AllelePairOccurrence allelePairOccurrence = new AllelePairOccurrence(
                        new AllelePair(x.getAllele(), new Allele("wild", "", x.getAllele().getLocusName())),
                        OccurrencePairFactory.create(Occurrence.DOMINANT_HOMOZYGOUS, x.getOccurrence()));
                balancedOccurrences.add(allelePairOccurrence);
            }
        });
        return balancedOccurrences;
    }

    private LocusOccurrence getOccurrenceForLocusName(Locus locus) {
        return this.locusOccurrences.stream().filter(x -> x.getAllele().getLocusName()
                        .equals(locus.getName())).findFirst()
                .orElseGet(() ->
                        new LocusOccurrence(locus, new Allele("wild", "", locus.getName()),
                                Occurrence.DOMINANT_HOMOZYGOUS));
    }
}
