package blog.genetics;

import java.util.Map;

abstract class AllelePairImpl implements AllelePair {

    private final String locus;

    public AllelePairImpl(final String theLocus) {
	locus = theLocus.toUpperCase();
    }

    protected String getLocus() {
	return locus;
    }
    
    @Override
    public abstract Map<String, Double> combineWith(AllelePair otherAllele);

    @Override
    public abstract String getFirstAllele();

    @Override
    public abstract String getSecondAllele();

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