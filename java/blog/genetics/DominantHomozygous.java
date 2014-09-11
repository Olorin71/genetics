package blog.genetics;

import java.util.HashMap;
import java.util.Map;

public class DominantHomozygous extends AllelePairImpl implements AllelePair {

	public DominantHomozygous(String allele) {
		super(allele.toUpperCase(), allele.toUpperCase());
	}

	@Override
	public boolean isDominantHomozygous() {
		return true;
	}

	@Override
	public Map<String, Double> combineWith(AllelePair otherAllele) {
		Map<String, Double> results = new HashMap<String, Double>();
		if (otherAllele.isRecessiveHomozygous()) {
			results.put(getFirstAllele() + otherAllele.getSecondAllele(), 1.0);
		} else {
			if (otherAllele.isHeterozygous()) {
				results.put(getFirstAllele() + getSecondAllele(), 0.5);
				results.put(getFirstAllele() + otherAllele.getSecondAllele(),
						0.5);

			} else {
				results.put(getFirstAllele() + getSecondAllele(), 1.0);
			}
		}

		return results;
	}

}
