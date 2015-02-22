package genetics;

public class MateResult {

    private final double probability;
    private final LocusOccurrence locusOccurrence;

    public MateResult(double probability, LocusOccurrence locusOccurrence) {
        this.probability = probability;
        this.locusOccurrence = locusOccurrence;
    }

    public LocusOccurrence getLocusOccurrence() {
        return locusOccurrence;
    }

    public double getProbability() {
        return probability;
    }

}
