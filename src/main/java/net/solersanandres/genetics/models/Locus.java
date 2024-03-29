package net.solersanandres.genetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.solersanandres.genetics.models.occurrence.Occurrence;

import java.util.List;

@Getter
@AllArgsConstructor
public class Locus {
    private final String name;
    private final String symbol;
    private final List<Allele> alleles;
}

