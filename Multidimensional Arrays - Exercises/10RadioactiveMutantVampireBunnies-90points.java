import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        Character[][] matrix = new Character[row][col];
        int playerRow = 0;
        int playerCol = 0;
        List<int[]> bunny = new ArrayList<>();
        
        for (int i = 0; i < row; i++) {
            String input = console.nextLine();
            for (int j = 0; j < col; j++) {
                switch (input.charAt(j)) {
                    case 'P':
                        playerRow = i;
                        playerCol = j;
                        matrix[i][j] = '.';
                    break;
                    case '.':
                        matrix[i][j] = input.charAt(j);
                    break;
                    case'B':
                        matrix[i][j] = input.charAt(j);
                        int[] coordinateToAdd = new int[2];
                        coordinateToAdd[0] = i;
                        coordinateToAdd[1] = j;
                        bunny.add(coordinateToAdd);
                    break;
                }
            }
        }

        String command = console.nextLine();
        boolean won = false;
        boolean dead = false;

        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'L':
                    if (playerCol!=0) playerCol--;
                    else won = true;
                    break;
                case 'U':
                    if (playerRow!=0) playerRow--;
                    else won = true;
                    break;
                case 'R':
                    if (playerCol!= col-1) playerCol++;
                    else won = true;
                    break;
                case 'D':
                    if (playerRow!= row-1) playerRow++;
                    else won = true;
                    break;
            }

            for (int j=bunny.size()-1; j>=0; j--) {
                int bunnyRow = bunny.get(j)[0];
                int bunnyCol = bunny.get(j)[1];
                bunny.remove(j);
                if(bunnyRow!=0) {
                    matrix[bunnyRow-1][bunnyCol] = 'B';
                    int[] coordinateToAdd = new int[2];
                    coordinateToAdd[0] = bunnyRow-1;
                    coordinateToAdd[1] = bunnyCol;
                    bunny.add(coordinateToAdd);
                }
                if (bunnyCol!= col-1) {
                    matrix[bunnyRow][bunnyCol+1] = 'B';
                    int[] coordinateToAdd = new int[2];
                    coordinateToAdd[0] = bunnyRow;
                    coordinateToAdd[1] = bunnyCol+1;
                    bunny.add(coordinateToAdd);
                }
                if (bunnyCol!=0) {
                    matrix[bunnyRow][bunnyCol-1] = 'B';
                    int[] coordinateToAdd = new int[2];
                    coordinateToAdd[0] = bunnyRow;
                    coordinateToAdd[1] = bunnyCol-1;
                    bunny.add(coordinateToAdd);
                }
                if (bunnyRow!= row-1) {
                    matrix[bunnyRow+1][bunnyCol] = 'B';
                    int[] coordinateToAdd = new int[2];
                    coordinateToAdd[0] = bunnyRow+1;
                    coordinateToAdd[1] = bunnyCol;
                    bunny.add(coordinateToAdd);
                }
            }

            if (matrix[playerRow][playerCol] == 'B' && !won) dead = true;
            if (dead || won) break;
        }
        Arrays.stream(matrix).forEach(s -> {
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        });
        if (dead) System.out.printf("dead: %d %d", playerRow, playerCol);
        else System.out.printf("won: %d %d", playerRow, playerCol);
    }
}
