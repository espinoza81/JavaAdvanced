import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split(",\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        int[][] matrix = getMatrix(console, row, col);

        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(matrix).forEach(s -> sum.addAndGet(Arrays.stream(s).sum()));
        System.out.print(row + System.lineSeparator() + col + System.lineSeparator() + sum);
    }

    private static int[][] getMatrix(Scanner console, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(console.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
