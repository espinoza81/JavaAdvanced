import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumnFirst = console.nextLine().split("\\s");
        int rowFirst = Integer.parseInt(rowColumnFirst[0]);
        int colFirst = Integer.parseInt(rowColumnFirst[1]);
        int[][] firstMatrix = getMatrix(console, rowFirst, colFirst);

        String[] rowColumnSecond = console.nextLine().split("\\s");
        int rowSecond = Integer.parseInt(rowColumnSecond[0]);
        int colSecond = Integer.parseInt(rowColumnSecond[1]);

        if (verification(rowFirst != rowSecond || colFirst!=colSecond)) return;

        int[][] secondMatrix = getMatrix(console, rowSecond, colSecond);

        for(int i=0; i<rowFirst; i++){
            for (int j=0; j<colFirst; j++){
                if (verification(firstMatrix[i][j]!=secondMatrix[i][j])) return;
            }
        }
        System.out.println("equal");
    }

    private static int[][] getMatrix(Scanner console, int row, int col) {
        int[][] Matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            Matrix[i] = Arrays.stream(console.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        }
        return Matrix;
    }

    private static boolean verification(boolean verification) {
        if(verification) {
            System.out.println("not equal");
            return true;
        }
        return false;
    }
}
