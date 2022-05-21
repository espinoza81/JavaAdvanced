import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int row = Integer.parseInt(console.nextLine());
        int col = Integer.parseInt(console.nextLine());
        char[][] firstMatrix = getMatrix(console, row, col);
        char[][] secondMatrix = getMatrix(console, row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char output = firstMatrix[i][j]==secondMatrix[i][j] ? firstMatrix[i][j] : '*';
                System.out.print(output + " ");
            }
            System.out.println();
        }
    }

    private static char[][] getMatrix(Scanner console, int row, int col) {
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = console.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        return matrix;
    }
}
