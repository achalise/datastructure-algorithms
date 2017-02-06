package strings.similarity;


public class SimilarStringsTester {

    public static void main(String[] args) {
        String[] listOfStrings = new String[]{
                "Haymarket convenience store",
                "shop",
                "local store",
                "Epping coles",
                "coles Epping",
                "scala programming language",
                "java programming language",
                "programming in java",
                "story of a nation rising"
        };
        String[] stringsToCompare = new String[]{"store", "convenience", "stop", "coles", "java", "scala program", "rising"};

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
