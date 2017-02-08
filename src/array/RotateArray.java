package array;

/**
 * Created by achalise on 8/2/17.
 * Rotate a 2D 90 degrees to the right.
 */
public class RotateArray {
    public int[][] rotate2DArray(int[][] input) {
        int[][] rotated = new int[input.length][input[0].length];
        int I = input.length - 1;
        int J = input[0].length - 1;

        for(int j = 0; j <=J; j++) {
            for(int i = 0; i <= I; i++) {
                rotated[j][i] = input[I - i][j];
            }
        }
        return rotated;
    }

    private static void printArray(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{3, 8, 5}, {1, 7, 4}, {2, 0, 3}};
        printArray(input);

        RotateArray solution = new RotateArray();
        int[][] rotated = solution.rotate2DArray(input);
        printArray(rotated);
    }

}
