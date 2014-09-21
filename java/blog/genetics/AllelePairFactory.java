package blog.genetics;

public final class AllelePairFactory {
    public static AllelePair createDominantHomozygous(final String allele) {
	throwExceptionIfNullOrEmpty(allele);
	return new DominantHomozygous(allele);
    }

    private static void throwExceptionIfNullOrEmpty(final String allele) {
	if (allele == null || allele.equals("")) {
	    throw new IllegalArgumentException("Allele is null or empty string.");
	}
    }
    
    public static AllelePair createRecessiveHomozygous(final String allele) {
	throwExceptionIfNullOrEmpty(allele);
	return new RecessiveHomozygous(allele);
    }
    
    public static AllelePair createHeterozygous(final String allele) {
	throwExceptionIfNullOrEmpty(allele);
	return new Heterozygous(allele);
    }
    
    private AllelePairFactory() {
	
    }
}