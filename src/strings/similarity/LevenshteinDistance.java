package strings.similarity;

public class LevenshteinDistance implements StringSimilarityCalculator {

    public double similarityScore(String s1, String s2) {
        String longer = s1;
        String shorter = s2;
        if(s1.length() < s2.length()) {
            longer = s2;
            shorter = s1;
        }
        double similarity = (longer.length() - editDistance(longer, shorter)) / (double) longer.length();
        return similarity;
    }

    public int editDistance(String s1, String s2) {
        if(s1 == null && s2 == null) {
            return 0;
        }
        if(s1.length() == 0) {
            return s2.length();
        }
        if(s2.length() == 0) {
            return s1.length();
        }


        int[][] matrix = new int[s1.length()][s2.length()];

        //initialise the first column
        for(int i = 0; i < s1.length(); i++) {
            matrix[i][0] = i;
        }

        //initialise the first row
        for(int i = 0; i < s2.length(); i++) {
            matrix[0][i] = i;
        }

        populateMatrix(matrix, s1, s2);

        //printMatrix(matrix);
        return matrix[s1.length() - 1][s2.length() - 1];
    }

    private void populateMatrix(int[][] matrix, String s1, String s2) {
        for(int i = 1; i < s1.length(); i++) {
            for(int j = 1; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.min(Math.min(matrix[i -1][j] + 1, matrix[i][j - 1] + 1), matrix[i-1][j-1] + 1);
                }
            }
        }
    }

    private void printMatrix(int[][] m) {
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        String[] list = new String[]{"A quick fox", "brown fox", "A fox", "Some brown fox", "A different sentence with brown fox"};
        String toTest = "different fox";
        String mostSimilar = list[0];
        double similarityMeasure = 0;

        LevenshteinDistance ld = new LevenshteinDistance();
        for(String s : list) {
            double measure = ld.similarityScore(s, toTest);
            if(measure > similarityMeasure) {
                mostSimilar = s;
                similarityMeasure = measure;
            }
            System.out.println("Similarity measure between '" + toTest + "' and '" + s + "' : " + measure);
        }

        System.out.println("The most similar string is: " + mostSimilar);
    }
}
