package blog.genetics;

import java.util.Map;

public interface AllelePair {

	Map<Class<?>, Double> combineWith(AllelePair otherAllele);
}
