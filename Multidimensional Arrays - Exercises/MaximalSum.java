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
        int [][] maxMatrix = new int[3][3];
        int [][] tempMatrix = new int[3][3];
        for (int i = 0; i < row-2; i++) {
            for (int j = 0; j < col-2; j++) {
                for(int a=0; a<tempMatrix.length; a++){
                    System.arraycopy(matrix[i + a], j, tempMatrix[a], 0, tempMatrix[a].length);
                }
                int tempSum = Arrays.stream(tempMatrix).mapToInt(s -> Arrays.stream(s).sum()).sum();
                if(tempSum > maxSum) {
                    maxSum = tempSum;
                    maxMatrix = Arrays.stream(tempMatrix).map(int[]::clone).toArray(int[][]::new);
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        System.out.println(Arrays.deepToString(maxMatrix).replace("], ", "\n").replaceAll("[\\[\\],]", ""));

    }

    private static int[][] getMatrix(Scanner console, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
