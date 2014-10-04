package blog.genetics;

import java.util.Map;

interface AllelePair2 {

    Map<String, Double> combineWith(AllelePair2 otherAllele);

}