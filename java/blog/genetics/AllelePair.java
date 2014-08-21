package blog.genetics;

public class AllelePair {
	private final String firstAllele;
	private final String secondAllele;

	public static AllelePair Create(String firstAllele, String secondAllele) {
		if (stringIsNullOrEmpty(firstAllele)) {
			throw new IllegalArgumentException("The first allele is null or Empty.");
		}
		if (stringIsNullOrEmpty(secondAllele)) {
			throw new IllegalArgumentException("The second allele is null or Empty.");
		}
		return new AllelePair(firstAllele, secondAllele);
	}
	
	private static boolean stringIsNullOrEmpty(String allele) {
		return allele == null || allele == "";
	}
	
	public AllelePair(String firstAllele, String secondAllele) {
		this.firstAllele = firstAllele;
		this.secondAllele = secondAllele;
	}

	public String getFirstAllele() {
		return firstAllele;
	}

	public String getSecondAllele() {
		return secondAllele;
	} 
}
