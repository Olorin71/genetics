package blog.genetics;

import java.util.HashMap;
import java.util.Map;

public class Breeding {

	public static Map<String, Double> calculateOutcome(
			AllelePair parentalAllelePair, AllelePair maternalAllelePair) {

		Map<String, Double> results = new HashMap<String, Double>();

		results.put(
				parentalAllelePair.getFirstAllele()
						+ parentalAllelePair.getSecondAllele(), 1.0);

		return results;
	}
}
