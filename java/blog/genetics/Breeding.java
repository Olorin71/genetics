package blog.genetics;

import java.util.HashMap;
import java.util.Map;

public class Breeding {

    public static Map<String, Double> calculateOutcome(
            AllelePair parentalAllelePair, AllelePair maternalAllelePair) {

        Map<String, Double> results = new HashMap<String, Double>();
        if (parentalAllelePair.isDominantHomozygous()
                && maternalAllelePair.isRecessiveHomozygous()) {
            results.put(parentalAllelePair.getFirstAllele()
                    + maternalAllelePair.getFirstAllele(), 1.0);
        } 
        else  if (maternalAllelePair.isDominantHomozygous()
                && parentalAllelePair.isRecessiveHomozygous()){
            results.put(maternalAllelePair.getFirstAllele()
                    + parentalAllelePair.getSecondAllele(), 1.0);
        }
        else {
                results.put(parentalAllelePair.getFirstAllele()
                        + parentalAllelePair.getSecondAllele(), 1.0);
            }

        return results;
    }

}
