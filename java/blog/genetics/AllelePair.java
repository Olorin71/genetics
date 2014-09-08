package blog.genetics;

public interface AllelePair {

    String getFirstAllele();

    String getSecondAllele();

    boolean isDominantHomozygous();

    boolean isRecessiveHomozygous();

    boolean isHeterozygous();

}
