package strings.similarity;


public class SimilarStringsTester {

    public static void main(String[] args) {
        String[] listOfStrings = new String[]{"Scala for the impatient ", "Scala in Action", "Programming Scala",
                                                "Functional programming in scala", "Scala in depth"};
        String[] stringsToCompare = new String[]{"Scala", "Programming", "Scala programming", "Scala the language"};

        for(String toCompare: stringsToCompare) {
            System.out.println("Calculating similarity score for input: '" + toCompare + "' using CharacterPairs");
            runSimilarityCheck(toCompare, listOfStrings, new CharacterPairsSimilarity());
            System.out.println();
            System.out.println("Calculating similarity score for input: '" + toCompare + "' using LavenshteinDistance");
            runSimilarityCheck(toCompare, listOfStrings, new LevenshteinDistance());
            System.out.println();
        }
    }


    private static void runSimilarityCheck(String toCompare, String[] listOfStrings,
                                           StringSimilarityCalculator similarityCalculator) {
        String mostSimilar = "";
        double minScore = 0;

        for(String compareAgainst: listOfStrings) {
            double score = similarityCalculator.similarityScore(toCompare, compareAgainst);
            if(score > minScore) {
                minScore = score;
                mostSimilar = compareAgainst;
            }
        }
        System.out.println("The most similar string is : " + mostSimilar);
    }
}
