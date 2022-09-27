package net.solersanandres.genetics.models.occurrence;


public final class OccurrencePairFactory {
    public static OccurrencePair TwoDominantHomozygous() {
        return create(Occurrence.DOMINANT_HOMOZYGOUS, Occurrence.DOMINANT_HOMOZYGOUS);
    }

    public static OccurrencePair TwoRecessiveHomozygous() {
        return create(Occurrence.RECESSIVE_HOMOZYGOUS, Occurrence.RECESSIVE_HOMOZYGOUS);
    }

    public static OccurrencePair TwoHeterozygous() {
        return create(Occurrence.HETEROZYGOUS, Occurrence.HETEROZYGOUS);
    }

    public static OccurrencePair DominantHomozygousAndHeterozygous() {
        return create(Occurrence.DOMINANT_HOMOZYGOUS, Occurrence.HETEROZYGOUS);
    }

    public static OccurrencePair RecessiveHomozygousAndHeterozygous() {
        return create(Occurrence.RECESSIVE_HOMOZYGOUS, Occurrence.HETEROZYGOUS);
    }

    public static OccurrencePair RecessiveHomozygousAndDominantHomozygous() {
        return create(Occurrence.RECESSIVE_HOMOZYGOUS, Occurrence.DOMINANT_HOMOZYGOUS);
    }

    public static OccurrencePair create(Occurrence firstOccurrence, Occurrence secondOccurrence) {
        return new CommonOccurrencePair(firstOccurrence, secondOccurrence);
    }
}
