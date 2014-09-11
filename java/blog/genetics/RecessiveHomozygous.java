package blog.genetics;

import java.util.HashMap;
import java.util.Map;

public class RecessiveHomozygous extends AllelePairImpl implements AllelePair {

	public RecessiveHomozygous(String allele) {
		super(allele.toLowerCase(), allele.toLowerCase());
	}

	@Override
	public boolean isRecessiveHomozygous() {
		return true;
	}

	@Override
	public Map<String, Double> combineWith(AllelePair otherAllele) {
		Map<String, Double> results = new HashMap<String, Double>();

		if (otherAllele.isDominantHomozygous()) {
			results.put(otherAllele.getFirstAllele() + getSecondAllele(), 1.0);
		} else {
			if (otherAllele.isHeterozygous()) {
				results.put(getFirstAllele() + getSecondAllele(), 0.5);
				results.put(otherAllele.getFirstAllele() + getSecondAllele(),
						0.5);
			} else {
				results.put(getFirstAllele() + getSecondAllele(), 1.0);
			}
		}

		return results;
	}

}
