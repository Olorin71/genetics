package net.solersanandres.genetics;

import java.util.ArrayList;

public class Mating {

    private final ArrayList<AllelePairOccurrence> balancedOccurrences;
    private final Parent firstParent;
    private final Parent secondParent;

    public Mating(Parent firstParent, Parent secondParent) {
        this.firstParent = firstParent;
        this.secondParent = secondParent;
        balancedOccurrences = new ArrayList<>();
    }
}
