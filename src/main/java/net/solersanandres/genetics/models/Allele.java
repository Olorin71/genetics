package net.solersanandres.genetics.models;

import lombok.Getter;

@Getter
public class Allele {
    private final String name;
    private final String symbol;
    private final String locusName;

    public Allele(String name, String symbol, String locusName) {
        this.name = name;
        this.symbol = symbol;
        this.locusName = locusName;
    }
}
