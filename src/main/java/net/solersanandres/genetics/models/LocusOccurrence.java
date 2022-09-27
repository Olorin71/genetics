package net.solersanandres.genetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.solersanandres.genetics.models.occurrence.Occurrence;

@Getter
@AllArgsConstructor
public class LocusOccurrence {
    private final Locus locus;
    private final Allele allele;
    private final Occurrence occurrence;
}
