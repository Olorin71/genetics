package blog.genetics;

import java.util.Map;

abstract class AllelePairImpl2 implements AllelePair2 {

    private final String locus;

    public AllelePairImpl2(final String theLocus) {
	this.locus = theLocus;
    }

    @Override
    public abstract Map<String, Double> combineWith(AllelePair2 otherAllele);

    
    protected abstract String getFirstAllele();


    protected abstract String getSecondAllele();

    protected boolean isDominantHomozygous() {
	return false;
    }

    protected boolean isHeterozygous() {
	return false;
    }

    protected boolean isRecessiveHomozygous() {
	return false;
    }

    protected final String getLocus() {
	return locus;
    }

    protected String getDominantHomozygousKey() {
        return getLocus().toUpperCase() + getLocus().toLowerCase();
    }

    protected String getRecessiveHomozygousKey() {
        return getLocus().toLowerCase() + getLocus().toUpperCase();
    }

    protected String getHeterozygousKey() {
        return getLocus().toUpperCase() + getLocus().toLowerCase();
    }

}