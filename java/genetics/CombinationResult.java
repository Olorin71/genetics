package genetics;

public class CombinationResult {
    private final AllelePair allelePair;
    private final double probability;
    
    public CombinationResult(AllelePair allelePair, double probability) {
        this.allelePair = allelePair;
        this.probability = probability;
    }

    public AllelePair getAllelePair() {
        return allelePair;
    }

    public double getProbability() {
        return probability;
    }
}
