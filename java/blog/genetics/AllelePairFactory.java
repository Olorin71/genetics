package blog.genetics;

public final class AllelePairFactory {
	public static AllelePair createDominantHomozygous(final String locus) {
		throwExceptionIfNullOrEmpty(locus);
		return new DominantHomozygous(locus);
	}

	public static AllelePair createHeterozygous(final String locus) {
		throwExceptionIfNullOrEmpty(locus);
		return new Heterozygous(locus);
	}

	public static AllelePair createRecessiveHomozygous(final String locus) {
		throwExceptionIfNullOrEmpty(locus);
		return new RecessiveHomozygous(locus);
	}

	private static void throwExceptionIfNullOrEmpty(final String locus) {
		if (locus == null || locus.equals("")) {
			throw new IllegalArgumentException(
					"locus is null or empty string.");
		}
	}

	private AllelePairFactory() {

	}
}