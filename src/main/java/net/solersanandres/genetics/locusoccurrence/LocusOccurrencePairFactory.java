package net.solersanandres.genetics.locusoccurrence;

public final class LocusOccurrencePairFactory {
    public static LocusOccurrencePair TwoDominantHomozygous() {
        return create(LocusOccurrence.DOMINANT_HOMOZYGOUS, LocusOccurrence.DOMINANT_HOMOZYGOUS);
    }
    public static LocusOccurrencePair TwoRecessiveHomozygous() {
        return create(LocusOccurrence.RECESSIVE_HOMOZYGOUS, LocusOccurrence.RECESSIVE_HOMOZYGOUS);
    }
    public static LocusOccurrencePair TwoHeterozygous() {
        return create(LocusOccurrence.HETEROZYGOUS, LocusOccurrence.HETEROZYGOUS);
    }
    public static LocusOccurrencePair DominantHomozygousAndHeterozygous() {
        return create(LocusOccurrence.DOMINANT_HOMOZYGOUS, LocusOccurrence.HETEROZYGOUS);
    }
    public static LocusOccurrencePair RecessiveHomozygousAndHeterozygous() {
        return create(LocusOccurrence.RECESSIVE_HOMOZYGOUS, LocusOccurrence.HETEROZYGOUS);
    }
    public static LocusOccurrencePair RecessiveHomozygousAndDominantHomozygous() {
        return create(LocusOccurrence.RECESSIVE_HOMOZYGOUS, LocusOccurrence.DOMINANT_HOMOZYGOUS);
    }
    public static LocusOccurrencePair create(LocusOccurrence firstOccurrence, LocusOccurrence secondOccurrence) {
        return new CommonLocusOccurrencePair(firstOccurrence, secondOccurrence);
    }
}
