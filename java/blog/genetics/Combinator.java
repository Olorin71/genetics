package blog.genetics;

public class Combinator {

	public static CombinationResults Combine(AlleleCombination parent1, AlleleCombination parent2) {
		/*
		CombinationResults results = new CombinationResults();
		CombinationResult result1 = new CombinationResult();
		result1.setProbability(0.25);
		AllelePair ap1 = new DominantHomozygous("A");
		AllelePair ap2 = new Heterozygous("B");
		result1.AddAllelePair(ap1);
		result1.AddAllelePair(ap2);
		results.add(result1);
		
		CombinationResult result2 = new CombinationResult();
		result1.setProbability(0.25);
		AllelePair ap3 = new DominantHomozygous("A");
		AllelePair ap4 = new RecessiveHomozygous("B");
		result1.AddAllelePair(ap3);
		result1.AddAllelePair(ap4);
		results.add(result2);
		
		CombinationResult result3 = new CombinationResult();
		result1.setProbability(0.25);
		AllelePair ap5 = new Heterozygous("A");
		AllelePair ap6 = new Heterozygous("B");
		result1.AddAllelePair(ap5);
		result1.AddAllelePair(ap6);
		results.add(result3);
		
		CombinationResult result4 = new CombinationResult();
		result1.setProbability(0.25);
		AllelePair ap7 = new Heterozygous("A");
		AllelePair ap8 = new RecessiveHomozygous("B");
		result1.AddAllelePair(ap7);
		result1.AddAllelePair(ap8);
		results.add(result4);
		
		return results;
		*/
		CombinationResults results = new CombinationResults();
		results.add(new CombinationResult());
		results.add(new CombinationResult());
		results.add(new CombinationResult());
		results.add(new CombinationResult());
		return results;
	}

}
