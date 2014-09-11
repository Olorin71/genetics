package blog.genetics;

import java.util.Map;

public interface AllelePair {

	String getFirstAllele();

	String getSecondAllele();

	boolean isDominantHomozygous();

	boolean isRecessiveHomozygous();

	boolean isHeterozygous();

	Map<String, Double> combineWith(AllelePair otherAllele);

}
