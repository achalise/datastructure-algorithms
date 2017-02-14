package array;

/**
 * Created by achalise on 12/2/17.
 * Checks if a string can be written as a palindrome
 */
public class PalindromeChecker {

    public boolean check(String input) {
        int evenChars = 0, oddChars = 0;
        int[] count = new int[128];
        input = input.toLowerCase();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'a' && c <= 'z') {
                if(count[c] == 0) {
                    oddChars++;
                } else if(count[c] % 2 == 0) {
                    oddChars++;
                    evenChars--;
                } else {
                    oddChars--;
                    evenChars++;
                }
                count[c]++;
            }
        }
        if(oddChars > 1) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        PalindromeChecker solution = new PalindromeChecker();
        System.out.println("tabc cbat pbm: "  + solution.check("tabc cbat pbb"));
    }
}
