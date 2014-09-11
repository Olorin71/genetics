package blog.genetics;

import java.util.Map;

public abstract class AllelePairImpl implements AllelePair {

	private String firstAllele;
	private String secondAllele;

	public AllelePairImpl(String firstAllele, String secondAllele) {
		this.firstAllele = firstAllele;
		this.secondAllele = secondAllele;
	}

	@Override
	public String getFirstAllele() {
		return firstAllele;
	}

	@Override
	public String getSecondAllele() {
		return secondAllele;
	}

	@Override
	public boolean isDominantHomozygous() {
		return false;
	}

	@Override
	public boolean isRecessiveHomozygous() {
		return false;
	}

	@Override
	public boolean isHeterozygous() {
		return false;
	}

	@Override
	public abstract Map<String, Double> combineWith(AllelePair otherAllele);

}