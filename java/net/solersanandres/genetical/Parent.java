package net.solersanandres.genetical;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parent {

	private List<ICombinedOccurrence> combinedOccurrences;

	public Parent() {
		super();
		combinedOccurrences = new LinkedList<ICombinedOccurrence>();
	}


	public int getCount() {
		return combinedOccurrences.size();
	}

	public void Add(ICombinedOccurrence combine) {
		combinedOccurrences.add(combine);
	}


	public List<ICombinedOccurrence> getCombinedOccurrences() {
		return Collections.unmodifiableList(combinedOccurrences);
	}
}
