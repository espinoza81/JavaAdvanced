import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        int[][] matrix = new int[row][col];
        String command;

        while (!"stop".equals(command = console.nextLine())) {
            String[] attribute = command.split("\\s+");
            int entryRow = Integer.parseInt(attribute[0]);
            int rowParking = Integer.parseInt(attribute[1]);
            int colParking = Integer.parseInt(attribute[2]);
            int index = 1;
            int stepToParking = 1 + Math.abs(entryRow - rowParking) + colParking;
            while (true) {
                if (matrix[rowParking][colParking] == 0) {
                    matrix[rowParking][colParking] = 1;
                    System.out.println(stepToParking);
                    break;
                } else {
                    if (colParking - index >= 1 && matrix[rowParking][colParking - index] == 0) {
                        stepToParking -= index;
                        matrix[rowParking][colParking - index] = 1;
                        System.out.println(stepToParking);
                        break;
                    } else if (colParking + index < col && matrix[rowParking][colParking + index] == 0) {
                        stepToParking += index;
                        matrix[rowParking][colParking + index] = 1;
                        System.out.println(stepToParking);
                        break;
                    } else if (colParking-index >=1 || colParking+index < col){
                        index++;
                    }
                    else {
                        System.out.println("Row " + rowParking + " full");
                        break;
                    }
                }
            }
        }
    }
}
