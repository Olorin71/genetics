package blog.genetics;

import java.util.HashMap;
import java.util.Map;

class DominantHomozygous extends AllelePairImpl implements AllelePair {

    public DominantHomozygous(final String allele) {
	super(allele.toUpperCase(), allele.toUpperCase());
    }

    @Override
    public Map<String, Double> combineWith(final AllelePair otherAllele) {
	final Map<String, Double> genotypeProbablilities = new HashMap<String, Double>();
	if (otherAllele.isRecessiveHomozygous()) {
	    genotypeProbablilities.put(
		    getFirstAllele() + otherAllele.getSecondAllele(),
		    Constants.HUNDREDPERCENT);
	} else {
	    if (otherAllele.isHeterozygous()) {
		genotypeProbablilities.put(
			getFirstAllele() + getSecondAllele(),
			Constants.FIFTYPERCENT);
		genotypeProbablilities.put(
			getFirstAllele() + otherAllele.getSecondAllele(),
			Constants.FIFTYPERCENT);

	    } else {
		genotypeProbablilities.put(
			getFirstAllele() + getSecondAllele(),
			Constants.HUNDREDPERCENT);
	    }
	}

	return genotypeProbablilities;
    }

    @Override
    public boolean isDominantHomozygous() {
	return true;
    }

}
