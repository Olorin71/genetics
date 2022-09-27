package net.solersanandres.genetics;

import net.solersanandres.genetics.models.Allele;
import net.solersanandres.genetics.models.Locus;

import static java.util.Arrays.asList;

public class Data {
    public static final Allele alleleA1 = new Allele("A1", "A1", "LocusA");
    public static final Allele alleleA2 = new Allele("A2", "A2", "LocusA");
    public static final Locus locusA = new Locus("LocusA", "A", asList(alleleA1, alleleA2));

    public static final Allele alleleZ1 = new Allele("Z1", "Z1", "LocusZ");
    public static final Allele alleleZ2 = new Allele("Z2", "Z2Y", "LocusZ");
    public static final Locus locusZ = new Locus("LocusZ", "Z", asList(alleleZ1, alleleZ2));

    public static final Allele alleleX1 = new Allele("X1", "X1", "LocusX");
    public static final Allele alleleX2 = new Allele("X2", "X2", "LocusX");
    public static final Locus locusX = new Locus("LocusX", "A", asList(alleleX1, alleleX2));

}
