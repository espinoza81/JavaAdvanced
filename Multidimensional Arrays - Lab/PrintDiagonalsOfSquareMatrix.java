import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rowCol = Integer.parseInt(console.nextLine());
        int[][] matrix = getMatrix(console, rowCol, rowCol);

        for (int i=0; i<rowCol; i++){
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i=0; i<rowCol; i++){
            System.out.print(matrix[rowCol-1-i][i] + " ");
        }
    }

    private static int[][] getMatrix(Scanner console, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
