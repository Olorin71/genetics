package blog.genetics;

import java.util.HashMap;
import java.util.Map;

class Heterozygous extends AllelePairImpl implements AllelePair {
    public Heterozygous(final String allele) {
	super(allele.toUpperCase(), allele.toLowerCase());
    }

    @Override
    public Map<String, Double> combineWith(final AllelePair otherAllele) {
	final Map<String, Double> genotypeProbablilities = new HashMap<String, Double>();
	if (otherAllele.isDominantHomozygous()) {
	    genotypeProbablilities.put(getFirstAllele() + getSecondAllele(),
		    Constants.FIFTYPERCENT);
	    genotypeProbablilities.put(
		    getFirstAllele() + otherAllele.getSecondAllele(),
		    Constants.FIFTYPERCENT);
	} else {
	    if (otherAllele.isRecessiveHomozygous()) {
		genotypeProbablilities.put(
			getFirstAllele() + getSecondAllele(),
			Constants.FIFTYPERCENT);
		genotypeProbablilities
			.put(otherAllele.getFirstAllele()
				+ otherAllele.getSecondAllele(),
				Constants.FIFTYPERCENT);
	    } else {
		genotypeProbablilities.put(
			getFirstAllele() + getSecondAllele(),
			Constants.FIFTYPERCENT);
		genotypeProbablilities.put(getFirstAllele()
			+ getSecondAllele().toUpperCase(),
			Constants.TWENTYFIVEPERCENT);
		genotypeProbablilities.put(getFirstAllele().toLowerCase()
			+ getSecondAllele(), Constants.TWENTYFIVEPERCENT);
	    }
	}
	return genotypeProbablilities;

    }

    @Override
    public boolean isHeterozygous() {
	return true;
    }

}
