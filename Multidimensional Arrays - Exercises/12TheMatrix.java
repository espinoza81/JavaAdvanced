import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);

        String[][] matrix = getMatrix(console, row, col);


        String fillChar = console.nextLine();

        String[] start = console.nextLine().split("\\s+");
        int startRow = Integer.parseInt(start[0]);
        int startCol = Integer.parseInt(start[1]);

        String startChar = matrix[startRow][startCol];
        matrix[startRow][startCol] = fillChar;
        ArrayDeque<int[]> sellToChange = new ArrayDeque<>();
        int[] coordinateSell = new int[2];
        coordinateSell[0] = startRow;
        coordinateSell[1] = startCol;
        sellToChange.push(coordinateSell);



        while (!sellToChange.isEmpty())
        {
            coordinateSell = sellToChange.pop();
            int rowToChange = coordinateSell[0];
            int colToChange = coordinateSell[1];
            if (rowToChange!=0 && startChar.equals(matrix[rowToChange-1][colToChange])) {
                matrix[rowToChange-1][colToChange] = fillChar;
                int[] coordinateToAdd = new int[2];
                coordinateToAdd[0] = rowToChange-1;
                coordinateToAdd[1] = colToChange;
                sellToChange.push(coordinateToAdd);
            }
            if (colToChange!= col-1 && startChar.equals(matrix[rowToChange][colToChange+1])) {
                matrix[rowToChange][colToChange+1] = fillChar;
                int[] coordinateToAdd = new int[2];
                coordinateToAdd[0] = rowToChange;
                coordinateToAdd[1] = colToChange+1;
                sellToChange.push(coordinateToAdd);
            }
            if (colToChange!=0 && startChar.equals(matrix[rowToChange][colToChange-1])) {
                matrix[rowToChange][colToChange-1] = fillChar;
                int[] coordinateToAdd = new int[2];
                coordinateToAdd[0] = rowToChange;
                coordinateToAdd[1] = colToChange-1;
                sellToChange.push(coordinateToAdd);
            }
            if (rowToChange!= row-1 && startChar.equals(matrix[rowToChange+1][colToChange])) {
                matrix[rowToChange+1][colToChange] = fillChar;
                int[] coordinateToAdd = new int[2];
                coordinateToAdd[0] = rowToChange+1;
                coordinateToAdd[1] = colToChange;
                sellToChange.push(coordinateToAdd);
            }
        }

        Arrays.stream(matrix).forEach(s -> {
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        });
    }
    private static String[][] getMatrix(Scanner console, int row, int col) {
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = console.nextLine().split("\\s+");
        }
        return matrix;
    }
}
