package net.solersanandres.genetics.models;


import net.solersanandres.genetics.models.occurrence.AlleleOccurrence;
import net.solersanandres.genetics.models.occurrence.AlleleOccurrencePair;
import net.solersanandres.genetics.models.occurrence.Occurrence;
import net.solersanandres.genetics.models.occurrence.OccurrencePairFactory;

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

    public ArrayList<AlleleOccurrencePair> balanceWith(Parent otherParent) {
        ArrayList<AlleleOccurrencePair> balancedOccurrences = new ArrayList<>();
        this.alleleOccurrences.forEach(x -> {
            AlleleOccurrence p2Occurrence = otherParent.getOccurrenceForLocusName(x.getAllele().getLocusName());
            AlleleOccurrencePair alleleOccurrencePair = new AlleleOccurrencePair(
                    x.getAllele().getLocusName(), x.getAllele().getName(),
                    OccurrencePairFactory.create(x.getOccurrence(), p2Occurrence.getOccurrence()));
            balancedOccurrences.add(alleleOccurrencePair);
        });
        otherParent.alleleOccurrences.forEach(x -> {
            String currentLocusId = x.getAllele().getLocusName();
            boolean locusAlreadyAdded = balancedOccurrences.stream().anyMatch(item -> item.getLocusName().equals(currentLocusId));
            if (!locusAlreadyAdded) {
                AlleleOccurrencePair alleleOccurrencePair = new AlleleOccurrencePair(
                        x.getAllele().getLocusName(), x.getAllele().getName(),
                        OccurrencePairFactory.create(Occurrence.DOMINANT_HOMOZYGOUS, x.getOccurrence()));
                balancedOccurrences.add(alleleOccurrencePair);
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
