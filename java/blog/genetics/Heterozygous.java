package blog.genetics;

import java.util.HashMap;
import java.util.Map;

public class Heterozygous extends AllelePairImpl implements AllelePair {

	public Heterozygous(String allele) {
		super(allele.toUpperCase(), allele.toLowerCase());
	}

	@Override
	public boolean isHeterozygous() {
		return true;
	}

	@Override
	public Map<String, Double> combineWith(AllelePair otherAllele) {
		Map<String, Double> results = new HashMap<String, Double>();
		if (otherAllele.isDominantHomozygous()) {
			results.put(getFirstAllele() + getSecondAllele(), 0.5);
			results.put(getFirstAllele() + otherAllele.getSecondAllele(), 0.5);
		} else {
			if (otherAllele.isRecessiveHomozygous()) {
				results.put(getFirstAllele() + getSecondAllele(), 0.5);
				results.put(
						otherAllele.getFirstAllele()
								+ otherAllele.getSecondAllele(), 0.5);
			} else {
				results.put(getFirstAllele() + getSecondAllele(), 0.5);
				results.put(getFirstAllele() + getSecondAllele().toUpperCase(),
						0.25);
				results.put(getFirstAllele().toLowerCase() + getSecondAllele(),
						0.25);
			}
		}
		return results;

	}

}
