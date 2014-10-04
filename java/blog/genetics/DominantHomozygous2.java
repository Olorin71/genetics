package blog.genetics;

import java.util.HashMap;
import java.util.Map;

class DominantHomozygous2 extends AllelePairImpl2 implements AllelePair2 {

    public DominantHomozygous2(final String theLocus) {
	super(theLocus.toUpperCase());
    }

    @Override
    public Map<String, Double> combineWith(final AllelePair2 otherAllele) {
	if (otherAllele instanceof DominantHomozygous2) {
	    return getCombinationsWith((DominantHomozygous2) otherAllele);
	}
	return null;
	/*
	 * final Map<String, Double> genotypeProbablilities = new
	 * HashMap<String, Double>(); if (otherAllele.isRecessiveHomozygous()) {
	 * genotypeProbablilities.put( getFirstAllele() +
	 * otherAllele.getSecondAllele(), Constants.HUNDREDPERCENT); } else { if
	 * (otherAllele.isHeterozygous()) { genotypeProbablilities.put(
	 * getFirstAllele() + getSecondAllele(), Constants.FIFTYPERCENT);
	 * genotypeProbablilities.put( getFirstAllele() +
	 * otherAllele.getSecondAllele(), Constants.FIFTYPERCENT);
	 * 
	 * } else { genotypeProbablilities.put( getFirstAllele() +
	 * getSecondAllele(), Constants.HUNDREDPERCENT); } }
	 * 
	 * return genotypeProbablilities;
	 */
    }

    private Map<String, Double> getCombinationsWith(
	    final DominantHomozygous2 otherAllele) {
	final Map<String, Double> probabilities = new HashMap<String, Double>();
	probabilities.put(getDominantHomozygousKey(), Constants.HUNDREDPERCENT);
	return probabilities;
    }

    @Override
    public boolean isDominantHomozygous() {
	return true;
    }

    @Override
    public String getFirstAllele() {
	return getLocus();
    }

    @Override
    public String getSecondAllele() {
	return getLocus();
    }

}