import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        int[][] matrix = getMatrix(console, row, col);
        List <List<Integer>> reversDiagonal = new ArrayList<>();
        for(int i=0; i<row+col-1; i++){
            reversDiagonal.add(new ArrayList<>());
        }
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++){
                reversDiagonal.get(row+col-2-(i+j)).add(0, matrix[i][j]);
            }
        }
        Arrays.stream(matrix).forEach(s -> {
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        });
    }

    private static int[][] getMatrix(Scanner console, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
