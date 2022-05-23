import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        int[][] matrix = getMatrix(console, row, col);

        int maxSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;

        for (int i = 0; i < row-2; i++) {
            for (int j = 0; j < col-2; j++) {
                int tempSum = matrix[i][j] + matrix[i][j+1]+ matrix[i][j+2]
                        + matrix[i+1][j] + matrix[i+1][j+1]+ matrix[i+1][j+2]
                        + matrix[i+2][j] + matrix[i+2][j+1]+ matrix[i+2][j+2];
                if(tempSum > maxSum) {
                    maxSum = tempSum;
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for(int i = indexRow; i<indexRow+3; i++){
            for(int j = indexCol; j<indexCol+3; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
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
