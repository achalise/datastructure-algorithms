package sort;

/**
 * Created by achalise on 7/2/17.
 *
 * CountingSort example to sort array of integers in a given range
 */
public class CountingSortIntegers {
    private static final int N = 20;
    int[] count = new int[N + 1];

    public int[] sort(int[] input) {
        int[] aux = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            count[input[i] + 1]++;
        }
        int index = 0, j = 0;
        for(int i = 1; i < count.length; i++) {
            int n = count[i];
            for(j = index; j < index + n; j++) {
                aux[j] = i -1;
            }
            index = j;
        }
        return aux;

    }


    public static void main(String[] args) {
        int[] input = new int[]{10, 5, 7, 11, 2, 0, 8, 15, 3, 9, 8};
        printArray(input);
        CountingSortIntegers sort = new CountingSortIntegers();
        int[] sorted = sort.sort(input);
        printArray(sorted);
    }

    private static void printArray(int[] input) {
        for(int i : input) {
            System.out.print(i + " " );
        }
        System.out.println();
    }
}
