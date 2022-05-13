import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rowCol = Integer.parseInt(console.nextLine());
        int[][] matrix = new int[rowCol][];

        for (int i = 0; i < rowCol; i++) {
            matrix[i] = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] matrixFinal = new int[rowCol][matrix[0].length];
        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        int wrongValue = matrix[row][col];

        for (int i = 0; i < rowCol; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    matrixFinal[i][j] = ((j == 0 ? 0 : matrix[i][j - 1] == wrongValue ? 0 : matrix[i][j - 1]) +
                            (j == matrix[i].length - 1 ? 0 : matrix[i][j + 1] == wrongValue ? 0 : matrix[i][j + 1]) +
                            (i == 0 ? 0 : matrix[i - 1][j] == wrongValue ? 0 : matrix[i - 1][j]) +
                            (i == rowCol - 1 ? 0 : matrix[i + 1][j] == wrongValue ? 0 : matrix[i + 1][j]));
                } else {
                    matrixFinal[i][j] = matrix[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(matrixFinal).replace("], ", "\n").replaceAll("[\\[\\],]", ""));
    }
}
