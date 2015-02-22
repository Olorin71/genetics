package genetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Calculator {
    private static OccurrencePair createBothDominantHomozygousOccurrencePair() {
        return new OccurrencePair(LocusOccurrence.DominantHomozygous, LocusOccurrence.DominantHomozygous);
    }

    private static List<MateResult> createBothDominantHomozygousResultsList() {
        List<MateResult> list = new ArrayList<MateResult>();
        list.add(new MateResult(1.0, LocusOccurrence.DominantHomozygous));
        return list;
    }

    private static OccurrencePair createBothHeterozygousOccurrencePair() {
        return new OccurrencePair(LocusOccurrence.Heterozygous, LocusOccurrence.Heterozygous);
    }

    private static List<MateResult> createBothHeterozygousResultsList() {
        List<MateResult> list = new ArrayList<MateResult>();
        list.add(new MateResult(0.5, LocusOccurrence.Heterozygous));
        list.add(new MateResult(0.25, LocusOccurrence.DominantHomozygous));
        list.add(new MateResult(0.25, LocusOccurrence.RecessiveHomozygous));
        return list;
    }

    private static OccurrencePair createBothRecessiveHomozygousOccurrencePair() {
        return new OccurrencePair(LocusOccurrence.RecessiveHomozygous, LocusOccurrence.RecessiveHomozygous);
    }

    private static List<MateResult> createBothRecessiveHomozygousResultsList() {
        List<MateResult> list = new ArrayList<MateResult>();
        list.add(new MateResult(1.0, LocusOccurrence.RecessiveHomozygous));
        return list;
    }

    private static OccurrencePair createDominantHomozygousAndHeterozygousOccurrencePair() {
        return new OccurrencePair(LocusOccurrence.DominantHomozygous, LocusOccurrence.Heterozygous);
    }

    private static List<MateResult> CreateDominantHomozygousAndHeterozygousResultsList() {
        List<MateResult> list = new ArrayList<MateResult>();
        list.add(new MateResult(0.5, LocusOccurrence.Heterozygous));
        list.add(new MateResult(0.5, LocusOccurrence.DominantHomozygous));
        return list;
    }

    private static OccurrencePair createDominantHomozygousAndRecessiveHomozygousOccurrencePair() {
        return new OccurrencePair(LocusOccurrence.DominantHomozygous, LocusOccurrence.RecessiveHomozygous);
    }

    private static List<MateResult> createDominantHomozygousAndRecessiveHomozygousResultsList() {
        List<MateResult> list = new ArrayList<MateResult>();
        list.add(new MateResult(1.0, LocusOccurrence.Heterozygous));
        return list;
    }

    private static OccurrencePair createRecessiveHomozygousAndHeterozygousOccurrencePair() {
        return new OccurrencePair(LocusOccurrence.RecessiveHomozygous, LocusOccurrence.Heterozygous);
    }

    private static List<MateResult> CreateRecessiveHomozygousAndHeterozygousResultsList() {
        List<MateResult> list = new ArrayList<MateResult>();
        list.add(new MateResult(0.5, LocusOccurrence.Heterozygous));
        list.add(new MateResult(0.5, LocusOccurrence.RecessiveHomozygous));
        return list;
    }

    private static HashMap<OccurrencePair, List<MateResult>> fillResultsMap() {
        HashMap<OccurrencePair, List<MateResult>> theMap = new HashMap<OccurrencePair, List<MateResult>>();

        theMap.put(createBothDominantHomozygousOccurrencePair(), createBothDominantHomozygousResultsList());
        theMap.put(createBothRecessiveHomozygousOccurrencePair(), createBothRecessiveHomozygousResultsList());
        theMap.put(createDominantHomozygousAndRecessiveHomozygousOccurrencePair(),
                        createDominantHomozygousAndRecessiveHomozygousResultsList());
        theMap.put(createDominantHomozygousAndHeterozygousOccurrencePair(),
                        CreateDominantHomozygousAndHeterozygousResultsList());
        theMap.put(createRecessiveHomozygousAndHeterozygousOccurrencePair(),
                        CreateRecessiveHomozygousAndHeterozygousResultsList());
        theMap.put(createBothHeterozygousOccurrencePair(), createBothHeterozygousResultsList());

        return theMap;
    }

    private final static HashMap<OccurrencePair, List<MateResult>> resultsMap = fillResultsMap();

    public List<MateResult> mate(LocusOccurrence firstParent, LocusOccurrence secondParent) {
        return resultsMap.get(new OccurrencePair(firstParent, secondParent));
    }

}