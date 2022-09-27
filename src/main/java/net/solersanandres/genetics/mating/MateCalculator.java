package net.solersanandres.genetics.mating;


import net.solersanandres.genetics.models.occurrence.AllelePairOccurrence;

import java.util.List;

public interface MateCalculator {
    MateResults forLocus(AllelePairOccurrence allelePairOccurrence);

    List<MateResults> forLoci(List<AllelePairOccurrence> allelePairOccurrences);
}
