package blog.genetics;

import java.util.HashMap;
import java.util.Map;

class RecessiveHomozygous extends AllelePairImpl implements AllelePair {

    public RecessiveHomozygous(final String allele) {
	super(allele.toLowerCase(), allele.toLowerCase());
    }

    @Override
    public Map<String, Double> combineWith(final AllelePair otherAllele) {
	final Map<String, Double> genotypeProbabilities = new HashMap<String, Double>();

	if (otherAllele.isDominantHomozygous()) {
	    genotypeProbabilities.put(otherAllele.getFirstAllele()
		    + getSecondAllele(), Constants.HUNDREDPERCENT);
	} else {
	    if (otherAllele.isHeterozygous()) {
		genotypeProbabilities.put(getFirstAllele() + getSecondAllele(),
			Constants.FIFTYPERCENT);
		genotypeProbabilities.put(otherAllele.getFirstAllele()
			+ getSecondAllele(), Constants.FIFTYPERCENT);
	    } else {
		genotypeProbabilities.put(getFirstAllele() + getSecondAllele(),
			Constants.HUNDREDPERCENT);
	    }
	}

	return genotypeProbabilities;
    }

    @Override
    public boolean isRecessiveHomozygous() {
	return true;
    }

}
