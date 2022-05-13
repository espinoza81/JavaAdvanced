import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[][] matrix = getMatrix(console, 8, 8);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if("q".equals(matrix[i][j])){
                    boolean realQueen = true;
                    for (int a=0; a<8;a++){
                        if(("q".equals(matrix[a][j]) && a!=i) || ("q".equals(matrix[i][a]) && a!=j)){
                            realQueen = false;
                            break;
                        }
                    }
                    int diagonalRow=0;
                    int diagonalCol=0;
                    int cycle = 8;
                    if(i<j){
                        diagonalCol = j - i;
                        cycle = 8-diagonalCol;
                    }
                    if(i>j){
                        diagonalRow = i-j;
                        cycle = 8-diagonalRow;
                    }
                    for (int a=0; a<cycle;a++){
                        if("q".equals(matrix[diagonalRow][diagonalCol]) && diagonalRow!=i){
                            realQueen = false;
                            break;
                        }
                        diagonalRow++;
                        diagonalCol++;
                    }
                    if(i+j<8){
                        diagonalRow = 0;
                        diagonalCol = i+j;
                        cycle = i+j+1;
                    }
                    else {
                        diagonalRow = i+j-7;
                        diagonalCol = 7;
                        cycle = 8- diagonalRow;
                    }
                    for (int a=0; a<cycle;a++){
                        if("q".equals(matrix[diagonalRow][diagonalCol]) && diagonalRow!=i){
                            realQueen = false;
                            break;
                        }
                        diagonalRow++;
                        diagonalCol--;
                    }
                    if (realQueen) System.out.println(i + " " + j);
                }
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
