package blog.genetics;

import java.util.HashMap;
import java.util.Map;

public class DominantHomozygous extends AllelePairImpl implements AllelePair {

	public DominantHomozygous(final String locus) {
		super(locus);
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithDominantHomozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(DominantHomozygous.class, Constants.HUNDREDPERCENT);
		return probabilities;
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithRecessiveHomozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(Heterozygous.class, Constants.HUNDREDPERCENT);
		return probabilities;
	}

	@Override
	protected Map<Class<?>, Double> combinationsWithHeterozygous() {
		final Map<Class<?>, Double> probabilities = new HashMap<Class<?>, Double>();
		probabilities.put(DominantHomozygous.class, Constants.FIFTYPERCENT);
		probabilities.put(Heterozygous.class, Constants.FIFTYPERCENT);
		return probabilities;
	}
}
