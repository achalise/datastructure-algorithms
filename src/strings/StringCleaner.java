package strings;

/**
 * Created by achalise on 8/2/17.
 * Remove extra white space leaving only one space between words in a string
 */
public class StringCleaner {

    public String cleanString(String input) {
        char[] chars =  new char[input.length()];
        int i = 0, j = 1;
        chars[i] = input.charAt(0);
        while(j < input.length()) {
            if(input.charAt(j) == ' ' && chars[i] == ' ') {
                j++;
            } else {
                chars[i + 1] = input.charAt(j++);
                i = i + 1;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        StringCleaner solution = new StringCleaner();
        String cleaned = solution.cleanString("word    cleaned");
        System.out.println(cleaned);
    }
}
