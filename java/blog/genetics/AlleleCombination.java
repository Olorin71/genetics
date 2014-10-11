package blog.genetics;

import java.util.ArrayList;
import java.util.List;

public class AlleleCombination {
	private final List<AllelePair> allelePairs;

	public AlleleCombination() {
		allelePairs = new ArrayList<AllelePair>();
	}

	public List<AllelePair> getAllelePairs() {
		return allelePairs;
	}

	public void AddAllelePair(AllelePair allelePair) {
		allelePairs.add(allelePair);
	}
}
