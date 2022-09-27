package net.solersanandres.genetics.models.occurrence;

import lombok.Getter;
import net.solersanandres.genetics.models.Allele;

@Getter
public class AlleleOccurrence {
    private final Allele allele;
    private final Occurrence occurrence;

    public AlleleOccurrence(Allele allele, Occurrence occurrence) {
        this.allele = allele;
        this.occurrence = occurrence;
    }
}
