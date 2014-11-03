package blog.genetics;

import java.util.Map;

abstract class AllelePairImpl implements AllelePair {

	private final String locus;

	public AllelePairImpl(final String theLocus) {
		locus = theLocus.toUpperCase();
	}

	@Override
	public final Map<Class<?>, Double> combineWith(final AllelePair otherAllele) {
		if (otherAllele instanceof RecessiveHomozygous) {
			return combinationsWithRecessiveHomozygous();
		}
		if (otherAllele instanceof Heterozygous) {
			return combinationsWithHeterozygous();
		}
		if (otherAllele instanceof DominantHomozygous) {
			return combinationsWithDominantHomozygous();
		}

		return null;
	}

	protected abstract Map<Class<?>, Double> combinationsWithDominantHomozygous();

	protected abstract Map<Class<?>, Double> combinationsWithHeterozygous();

	protected abstract Map<Class<?>, Double> combinationsWithRecessiveHomozygous();

	protected String getLocus() {
		return locus;
	}

}