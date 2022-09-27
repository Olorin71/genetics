package net.solersanandres.genetics.locusoccurrence;

final class CommonLocusOccurrencePair implements LocusOccurrencePair {
    private final LocusOccurrence firstOccurrence;
    private final LocusOccurrence secondOccurrence;

    public CommonLocusOccurrencePair(LocusOccurrence firstOccurrence,
                                     LocusOccurrence secondOccurrence) {
        this.firstOccurrence = firstOccurrence;
        this.secondOccurrence = secondOccurrence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommonLocusOccurrencePair locusPair = (CommonLocusOccurrencePair) o;

        return (firstOccurrence == locusPair.firstOccurrence && secondOccurrence == locusPair.secondOccurrence)
                || (firstOccurrence == locusPair.secondOccurrence && secondOccurrence == locusPair.firstOccurrence);
    }

    @Override
    public int hashCode() {
        return 31 * (firstOccurrence.hashCode() + secondOccurrence.hashCode());
    }

    @Override
    public String toString() {
        return "LocusPair[" + firstOccurrence + ", " + secondOccurrence + ']';
    }

}
