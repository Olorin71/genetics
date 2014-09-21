package blog.genetics;

import java.util.Map;

abstract class AllelePairImpl implements AllelePair {

    private final String firstAllele;
    private final String secondAllele;

    public AllelePairImpl(final String theFirstAllele,
	    final String theSecondAllele) {
	this.firstAllele = theFirstAllele;
	this.secondAllele = theSecondAllele;
    }

    @Override
    public abstract Map<String, Double> combineWith(AllelePair otherAllele);

    @Override
    public final String getFirstAllele() {
	return firstAllele;
    }

    @Override
    public final String getSecondAllele() {
	return secondAllele;
    }

    @Override
    public boolean isDominantHomozygous() {
	return false;
    }

    @Override
    public boolean isHeterozygous() {
	return false;
    }

    @Override
    public boolean isRecessiveHomozygous() {
	return false;
    }

}