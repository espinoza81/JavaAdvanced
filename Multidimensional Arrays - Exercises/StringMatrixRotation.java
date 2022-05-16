import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rotationNumber = (Integer.parseInt(console.nextLine().replaceAll("[Rotae()]", ""))/90)%4;
        List <String> input = new ArrayList<>();
        String line;
        int col = 0;
        int row = 0;
        while (!"END".equals(line= console.nextLine())){
            col = Math.max(col, line.length());
            input.add(line);
            row = input.size();
        }
        String[][] matrix = getMatrix(input, row, col);

        if (rotationNumber%2==1) {
            int temp = col;
            col = row;
            row = temp;
        }
        String[][] finalMatrix = new String[row][col];
        switch (rotationNumber){
            case 0:
                for (int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++){
                        finalMatrix[i][j] = matrix[i][j];
                    }
                }
                break;
            case 1:
                for (int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++){
                        finalMatrix[i][j] = matrix[col-1-j][i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++){
                        finalMatrix[i][j] = matrix[row-1-i][col-1-j];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++){
                        finalMatrix[i][j] = matrix[j][row-1-i];
                    }
                }
                break;
        }
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                System.out.print(finalMatrix[i][j]);
            }
            System.out.println();
        }

    }

    private static String[][] getMatrix(List <String> input, int row, int col) {
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                if (j < input.get(i).length()){
                    matrix[i][j] = String.valueOf(input.get(i).charAt(j));
                }
                else {
                    matrix[i][j] = " ";
                }
            }
        }
        return matrix;
    }
}
