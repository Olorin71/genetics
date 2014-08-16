package blog.genetics;


public class OutcomeCalculator {
	public static AllelePairProbability Calculate(AllelePair paternal,
			AllelePair maternal) {
		return new AllelePairProbability(new AllelePair("A", "A"), 1);
	}
}
