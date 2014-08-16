package blog.genetics;

public class AllelePair {
	private final String firstAllele;
	private final String secondAllele;

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
