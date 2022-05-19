import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(",\\s+");
        int row = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[row][row];

        switch (pattern){
            case "A":
                matrix = getMatrixA(row);
                break;
            case "B":
                matrix = getMatrixB(row);
                break;
            default:
                System.out.println("wrong pattern");
        }
        System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("[\\[\\],]", ""));
    }

    private static int[][] getMatrixA(int row) {
        int[][] matrix = new int[row][row];
        for (int i=0; i<row; i++){
            for (int j=0; j<row; j++){
                matrix[i][j]= i+j*row+1;

            }
        }
        return matrix;
    }

    private static int[][] getMatrixB(int row) {
        int[][] matrix = new int[row][row];
        for (int i=0; i<row; i++){
            for (int j=0; j<row; j++){
                if(j%2==0){
                    matrix[i][j]= i+j*row+1;
                }
                else {
                    matrix[i][j] = (j + 1) * row - i;
                }
            }
        }
        return matrix;
    }
}
