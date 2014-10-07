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
		probabilities.put(Heterozygous.class, Constants.HUNDREDPERCENT);
		return probabilities;
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithRecessiveHomozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(RecessiveHomozygous.class, Constants.HUNDREDPERCENT);
		return probabilities;
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithHeterozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(RecessiveHomozygous.class, Constants.FIFTYPERCENT);
		probabilities.put(Heterozygous.class, Constants.FIFTYPERCENT);
		return probabilities;
	}
}
