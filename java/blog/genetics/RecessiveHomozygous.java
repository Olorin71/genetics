package blog.genetics;

import java.util.HashMap;
import java.util.Map;

public class RecessiveHomozygous extends AllelePairImpl implements AllelePair {

	public RecessiveHomozygous(final String locus) {
		super(locus);
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithDominantHomozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(Heterozygous.class, Constants.HUNDRED_PERCENT);
		return probabilities;
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithHeterozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(RecessiveHomozygous.class, Constants.FIFTY_PERCENT);
		probabilities.put(Heterozygous.class, Constants.FIFTY_PERCENT);
		return probabilities;
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithRecessiveHomozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(RecessiveHomozygous.class, Constants.HUNDRED_PERCENT);
		return probabilities;
	}
}
