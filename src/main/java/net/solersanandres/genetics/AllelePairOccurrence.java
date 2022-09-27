package net.solersanandres.genetics;

import lombok.Getter;
import net.solersanandres.genetics.locusoccurrence.LocusOccurrencePair;

@Getter
public class AllelePairOccurrence {
    private final String locusId;
    private final String alleleId;
    private final LocusOccurrencePair occurrencePair;

    public AllelePairOccurrence(String locusId, String alleleId, LocusOccurrencePair occurrencePair) {
        this.locusId = locusId;
        this.alleleId = alleleId;
        this.occurrencePair = occurrencePair;
    }
}
