package net.solersanandres.genetics;


import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePairFactory;

import java.util.ArrayList;
import java.util.List;

public class Parent {
    private final List<AlleleOccurrence> alleleOccurrences;

    public Parent() {
        this.alleleOccurrences = new ArrayList<>();
    }

    public void addAlleleOccurrence(AlleleOccurrence occurrence){
            this.alleleOccurrences.add(occurrence);
    }

    public AlleleOccurrence getOccurrenceForLocusID(String locusId) {
        return this.alleleOccurrences.stream().filter(x -> x.getLocusId().equals(locusId)).findFirst()
                .orElseGet(() -> new AlleleOccurrence("wild", locusId, LocusOccurrence.DOMINANT_HOMOZYGOUS));

    }

    public ArrayList<AllelePairOccurrence> balanceWith(Parent otherParent) {
        ArrayList<AllelePairOccurrence> balancedOccurrences = new ArrayList<>();
        this.alleleOccurrences.forEach(x -> {
            AlleleOccurrence p2Occurrence = otherParent.getOccurrenceForLocusID(x.getLocusId());
            AllelePairOccurrence allelePairOccurrence = new AllelePairOccurrence(x.getAlleleId(), x.getLocusId(),
                    LocusOccurrencePairFactory.create(x.getOccurrence(), p2Occurrence.getOccurrence()));
            balancedOccurrences.add(allelePairOccurrence);
        });
        otherParent.alleleOccurrences.forEach(x-> {
            String currentLocusId = x.getLocusId();
            boolean locusAlreadyAdded = balancedOccurrences.stream().anyMatch(item -> item.getLocusId().equals(currentLocusId));
            if(!locusAlreadyAdded) {
                AllelePairOccurrence allelePairOccurrence = new AllelePairOccurrence(x.getAlleleId(), x.getLocusId(),
                        LocusOccurrencePairFactory.create(LocusOccurrence.DOMINANT_HOMOZYGOUS, x.getOccurrence()));
                balancedOccurrences.add(allelePairOccurrence);
            }
        });
        return balancedOccurrences;
    }
}
