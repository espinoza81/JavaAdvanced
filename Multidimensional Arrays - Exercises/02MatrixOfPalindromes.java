import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        String[][] matrix = getMatrix(row, col);

        System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("[\\[\\],]", ""));

    }

    private static String[][] getMatrix(int row, int col) {
        String[][] matrix = new String[row][col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                char first = (char) ('a'+i);
                char middle = (char)('a'+i+j);
                matrix[i][j] = String.valueOf(first) + middle + first;

            }
        }
        return matrix;
    }
}
