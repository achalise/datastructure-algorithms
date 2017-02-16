package dynamic;


/**
 * Created by achalise on 15/2/17.
 */
public class Permutation {

    public void generatePermutations(int[] a) {
        generatePermutations(a, new int[a.length], 0, new boolean[a.length]);
    }

    private void generatePermutations(int[] a, int[] data,  int index, boolean[] used) {
        if(index == 2) {
            print(data, index - 1);
            return;
        }
        for(int pos = 0; pos < a.length; pos++) {
                if(used[pos]) {
                    continue;
                }
                data[index] = a[pos];
                used[pos] = true;
                generatePermutations(a, data, index + 1, used);
                used[pos] = false;
        }
    }

    private void print(int[] a, int end) {
        for(int i = 0; i <= end; i++) {
           System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Permutation solution = new Permutation();
        solution.generatePermutations(new int[] {1,2,3});
    }
}
