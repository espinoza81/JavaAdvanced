import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);

        String[][] matrix = getMatrix(console, row, col);
        String command;

        Pattern pattern = Pattern.compile("^swap(\\s+)(?<row1>\\d+)(\\s+)(?<col1>\\d+)(\\s+)(?<row2>\\d+)(\\s+)(?<col2>\\d+)$");

        while (!"END".equals(command = console.nextLine())) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {

                int row1 = Integer.parseInt(matcher.group("row1"));
                int row2 = Integer.parseInt(matcher.group("row2"));
                int col1 = Integer.parseInt(matcher.group("col1"));
                int col2 = Integer.parseInt(matcher.group("col2"));
                if (row1 < 0 || row1 >= row || row2 < 0 || row2 >= row || col1 < 0 || col1 >= col || col2 < 0 || col2 >= col) {
                    System.out.println("Invalid input!");
                } else {
                    String temp;
                    temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("[\\[\\],]", ""));
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static String[][] getMatrix(Scanner console, int row, int col) {
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = console.nextLine().split("\\s+");
        }
        return matrix;
    }
}
