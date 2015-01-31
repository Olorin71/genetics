package genetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combinator {

    private HashMap<Combination, List<CombinationResult>> availableCombinations;

    public Combinator() {
        availableCombinations = new HashMap<Combination, List<CombinationResult>>();       
        fillAvailableCombinations();
    }

    private void fillAvailableCombinations() {
        Combination bothDominantHomozygous = new Combination(AllelePair.DominantHomozygous, AllelePair.DominantHomozygous);
        List<CombinationResult> list = new ArrayList<CombinationResult>();
        list.add(new CombinationResult(AllelePair.DominantHomozygous, 1.0));
        availableCombinations.put(bothDominantHomozygous, list);
        
        Combination bothRecessiveHomozygous = new Combination(AllelePair.RecessiveHomozygous, AllelePair.RecessiveHomozygous);
        List<CombinationResult> list2 = new ArrayList<CombinationResult>();
        list.add(new CombinationResult(AllelePair.RecessiveHomozygous, 1.0));
        availableCombinations.put(bothRecessiveHomozygous, list2);

        Combination bothHeterozygous = new Combination(AllelePair.Heterozygous, AllelePair.Heterozygous);
        List<CombinationResult> list3 = new ArrayList<CombinationResult>();
        list.add(new CombinationResult(AllelePair.Heterozygous, 0.5));
        list.add(new CombinationResult(AllelePair.DominantHomozygous, 0.25));
        list.add(new CombinationResult(AllelePair.RecessiveHomozygous, 0.25));
        availableCombinations.put(bothHeterozygous, list3);
 
        Combination recessiveHomozygousAndHeterozygous = new Combination(AllelePair.RecessiveHomozygous, AllelePair.Heterozygous);
        List<CombinationResult> list4 = new ArrayList<CombinationResult>();
        list.add(new CombinationResult(AllelePair.RecessiveHomozygous, 0.5));
        list.add(new CombinationResult(AllelePair.Heterozygous, 0.5));
        availableCombinations.put(recessiveHomozygousAndHeterozygous, list4);

        Combination dominantHomozygousAndHeterozygous = new Combination(AllelePair.DominantHomozygous, AllelePair.Heterozygous);
        List<CombinationResult> list5 = new ArrayList<CombinationResult>();
        list.add(new CombinationResult(AllelePair.DominantHomozygous, 0.5));
        list.add(new CombinationResult(AllelePair.Heterozygous, 0.5));
        availableCombinations.put(dominantHomozygousAndHeterozygous, list5);

        Combination dominantHomozygousAndRecessiveHomozygous = new Combination(AllelePair.DominantHomozygous, AllelePair.RecessiveHomozygous);
        List<CombinationResult> list6 = new ArrayList<CombinationResult>();
        list.add(new CombinationResult(AllelePair.Heterozygous, 1.0));
        availableCombinations.put(dominantHomozygousAndRecessiveHomozygous, list6);
    }
    
    public List<CombinationResult> GetCombinations(AllelePair firstPair, AllelePair secondPair) {
        Combination c = new Combination(firstPair, secondPair);
        if (availableCombinations.containsKey(c)) {
            return availableCombinations.get(c);
        }
        return null;
    }
}
