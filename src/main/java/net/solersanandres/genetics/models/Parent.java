package net.solersanandres.genetics.models;


import net.solersanandres.genetics.models.occurrence.*;

import java.util.ArrayList;
import java.util.List;

public class Parent {
    private final List<AlleleOccurrence> alleleOccurrences;

    public Parent() {
        this.alleleOccurrences = new ArrayList<>();
    }

    public void addAlleleOccurrence(AlleleOccurrence occurrence) {
        this.alleleOccurrences.add(occurrence);
    }

    public ArrayList<AllelePairOccurrence> balanceWith(Parent otherParent) {
        ArrayList<AllelePairOccurrence> balancedOccurrences = new ArrayList<>();
        this.alleleOccurrences.forEach(x -> {
            AlleleOccurrence p2Occurrence = otherParent.getOccurrenceForLocusName(x.getAllele().getLocusName());
            AllelePairOccurrence allelePairOccurrence = new AllelePairOccurrence(
                    new AllelePair(x.getAllele(), p2Occurrence.getAllele()),
                    OccurrencePairFactory.create(x.getOccurrence(), p2Occurrence.getOccurrence()));
            balancedOccurrences.add(allelePairOccurrence);
        });
        otherParent.alleleOccurrences.forEach(x -> {
            String locusName = x.getAllele().getLocusName();
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

    private AlleleOccurrence getOccurrenceForLocusName(String locusName) {
        return this.alleleOccurrences.stream().filter(x -> x.getAllele().getLocusName().equals(locusName)).findFirst()
                .orElseGet(() ->
                        new AlleleOccurrence(new Allele("wild", "", locusName), Occurrence.DOMINANT_HOMOZYGOUS));
    }
}
