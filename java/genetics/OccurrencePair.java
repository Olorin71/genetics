package genetics;

public class OccurrencePair {

    private LocusOccurrence firstParent;
    private LocusOccurrence secondParent;

    public OccurrencePair(LocusOccurrence firstParent, LocusOccurrence secondParent) {
        this.firstParent = firstParent;
        this.secondParent = secondParent;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        OccurrencePair temp = (OccurrencePair) other;
        if (temp == null) {
            return false;
        } else {
            return (firstParent == temp.firstParent && secondParent == temp.secondParent)
                            || (firstParent == temp.secondParent && secondParent == temp.firstParent);
        }
    }

    public LocusOccurrence getFirstParent() {
        return firstParent;
    }

    public LocusOccurrence getSecondParent() {
        return secondParent;
    }

    @Override
    public int hashCode() {
        return (getFirstParent().getValue() + secondParent.getValue()) * 317;
    }

}
