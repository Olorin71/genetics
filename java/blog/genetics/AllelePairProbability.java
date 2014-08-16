package blog.genetics;


public class AllelePairProbability {
	private final AllelePair allelePair;
	private final float probability;

	public AllelePairProbability(AllelePair allelePair, float probability) {
		this.allelePair = allelePair;
		this.probability = probability;
	}

	public AllelePair getAllelePair() {
		return allelePair;
	}

	public float getProbability() {
		return probability;
	}
}
