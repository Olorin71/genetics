package net.solersanandres.genetics.models.occurrence;

import lombok.Getter;
import net.solersanandres.genetics.models.Allele;

@Getter
public class AllelePair {
    private final Allele firstAllele;
    private final Allele secondAllele;

    public AllelePair(Allele firstAllele, Allele secondAllele) {
        this.firstAllele = firstAllele;
        this.secondAllele = secondAllele;
    }
}
