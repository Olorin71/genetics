package blog.genetics;

import java.util.Map;

public interface AllelePair {

    Map<String, Double> combineWith(AllelePair otherAllele);

    String getFirstAllele();

    String getSecondAllele();

    boolean isDominantHomozygous();

    boolean isHeterozygous();

    boolean isRecessiveHomozygous();

}
