import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] rowColumn = console.nextLine().split("\\s+");
        int rowMatrix = Integer.parseInt(rowColumn[0]);
        int colMatrix = Integer.parseInt(rowColumn[1]);
        List<List<Integer>> matrix = createMatrix(rowMatrix, colMatrix);

        String command;
        while (!"Nuke it from orbit".equals(command = console.nextLine())) {
            String[] attribute = command.split("\\s+");
            int row = Integer.parseInt(attribute[0]);
            int col = Integer.parseInt(attribute[1]);
            int radius = Integer.parseInt(attribute[2]);
            for (int i = Math.max(0, row - radius); i <= Math.min(matrix.size() - 1, row + radius); i++) {
                if (i != row && col>= 0 && matrix.get(i).size() > col) {
                    matrix.get(i).remove(col);
                }
                if (i == row) {
                    for (int j = Math.min(matrix.get(i).size() - 1, col + radius); j >= Math.max(0, col - radius); j--) {
                        matrix.get(i).remove(j);
                    }
                }
            }
            matrix.removeIf(List::isEmpty);
        }

        matrix.forEach(s -> System.out.println(s.toString().replaceAll("[\\[\\],]", "")));
    }

    private static List<List<Integer>> createMatrix(int rows, int cols) {
        int number = 1;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(number++);
            }
            matrix.add(row);
        }
        return matrix;
    }
}
