package strings.similarity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CharacterPairsSimilarity implements StringSimilarityCalculator {

    public double similarityScore(String s1, String s2) {
        Collection<String> pairs1 = extractPairs(s1.toLowerCase());
        Collection<String> pairs2 = extractPairs(s2.toLowerCase());
        int union, intersection = 0;
        union = pairs1.size() + pairs2.size();
        for(String pair1 : pairs1) {
            for(String pair2: pairs2) {
                if(pair1.equals(pair2)) {
                    intersection++;
                    pairs2.remove(pair2);
                    break;
                }
            }
        }
        return (2.0 * intersection)/union;
    }

    private List<String> extractPairs(String s1) {
        List<String> pairs = new ArrayList<>();
        for(int i = 1; i < s1.length(); i++) {
            pairs.add(s1.substring(i - 1, i + 1));
        }
        return pairs;
    }
}
