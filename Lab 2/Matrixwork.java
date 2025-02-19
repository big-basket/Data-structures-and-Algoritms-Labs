
import java.util.Arrays;
import java.util.Random;

public class Matrixwork {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] result = new int[rows][cols];

        Random rand = new Random(); // Create a Random object
        System.out.println(Arrays.deepToString(matrix1) + "\n"  + Arrays.deepToString(matrix2));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = rand.nextInt(100) + 1; // Random number from 1 to 100
                matrix2[i][j] = rand.nextInt(100) + 1; // Random number from 1 to 100
            }
        }
        System.out.println(Arrays.deepToString(matrix1) + "\n"  + Arrays.deepToString(matrix2));

        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(result));
    }
}
