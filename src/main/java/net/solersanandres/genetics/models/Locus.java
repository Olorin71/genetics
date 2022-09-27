package net.solersanandres.genetics.models;

import lombok.Getter;

@Getter
public class Locus {
    private final String name;
    private final String symbol;

    public Locus(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
