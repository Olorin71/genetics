package net.solersanandres.genetics.models.occurrence;

import lombok.Getter;

@Getter
public class AllelePairOccurrence {
    private final OccurrencePair occurrencePair;
    private final AllelePair allelePair;

    public AllelePairOccurrence(AllelePair allelePair, OccurrencePair occurrencePair) {
        this.allelePair = allelePair;
        this.occurrencePair = occurrencePair;
    }
}
