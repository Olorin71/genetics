package genetics;

public enum LocusOccurrence {
    DominantHomozygous(0), RecessiveHomozygous(1), Heterozygous(2);

    private int value;

    private LocusOccurrence(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
