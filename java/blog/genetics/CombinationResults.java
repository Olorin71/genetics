package blog.genetics;

import java.util.ArrayList;
import java.util.List;

public class CombinationResults {
	private final List<CombinationResult> combinations;
	
	public CombinationResults() {
		combinations = new ArrayList<CombinationResult>();
	}

	public void add(CombinationResult combinationResultToBeAdded) {
		combinations.add(combinationResultToBeAdded);
		
	}

	public int size() {
		return combinations.size();
	}

	public boolean containsCombination(AlleleCombination combination) {
		return false;
	}

	public CombinationResult GetCombination(AlleleCombination combination) {
		return null;
	}

}
