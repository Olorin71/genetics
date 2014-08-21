package blog.genetics;

public class AllelePairProbability {
    private final AllelePair allelePair;
    private final double probability;

    public AllelePairProbability(AllelePair allelePair,
            double probability) {
        this.allelePair = allelePair;
        this.probability = probability;
    }

    public String getFirstAllele() {
        return allelePair.getFirstAllele();
    }

    public String getSecondAllele() {
        return allelePair.getSecondAllele();
    }

    public double getProbability() {
        return probability;
    }
}
