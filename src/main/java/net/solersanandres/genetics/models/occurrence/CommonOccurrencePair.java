package net.solersanandres.genetics.models.occurrence;

final class CommonOccurrencePair implements OccurrencePair {
    private final Occurrence firstOccurrence;
    private final Occurrence secondOccurrence;

    public CommonOccurrencePair(Occurrence firstOccurrence,
                                Occurrence secondOccurrence) {
        this.firstOccurrence = firstOccurrence;
        this.secondOccurrence = secondOccurrence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommonOccurrencePair locusPair = (CommonOccurrencePair) o;

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
