import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowCol = Integer.parseInt(console.nextLine());
        int[][] matrix = getMatrix(console, rowCol, rowCol);

        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int i=0; i<rowCol; i++){
            firstDiagonal += matrix[i][i];
            secondDiagonal += matrix[rowCol-1-i][i];
        }

        System.out.println(Math.abs(firstDiagonal-secondDiagonal));
    }

    private static int[][] getMatrix(Scanner console, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
