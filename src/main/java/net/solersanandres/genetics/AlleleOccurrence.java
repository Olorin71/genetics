package net.solersanandres.genetics;

import lombok.Getter;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrence;

@Getter
public class AlleleOccurrence {
    private final String alleleId;
    private final String locusId;
    private final LocusOccurrence occurrence;

    public AlleleOccurrence(String alleleId, String locusId, LocusOccurrence occurrence) {
        this.alleleId = alleleId;
        this.locusId = locusId;
        this.occurrence = occurrence;
    }
}
