package net.solersanandres.genetics.models.occurrence;

import lombok.Getter;

@Getter
public class AlleleOccurrencePair {
    private final String locusName;
    private final String alleleName;
    private final OccurrencePair occurrencePair;

    public AlleleOccurrencePair(String locusName, String alleleName, OccurrencePair occurrencePair) {
        this.locusName = locusName;
        this.alleleName = alleleName;
        this.occurrencePair = occurrencePair;
    }
}
