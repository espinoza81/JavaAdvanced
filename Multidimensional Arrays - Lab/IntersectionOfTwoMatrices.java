import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int row = Integer.parseInt(console.nextLine());
        int col = Integer.parseInt(console.nextLine());
        String[][] firstMatrix = getMatrix(console, row, col);
        String[][] secondMatrix = getMatrix(console, row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
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
