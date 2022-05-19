import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);
        boolean[][] matrix = new boolean[row][col];
        String command;
        int steps;

        while (!"stop".equals(command = console.nextLine())) {
            String[] attribute = command.split("\\s+");
            int entryRow = Integer.parseInt(attribute[0]);
            int rowParking = Integer.parseInt(attribute[1]);
            int colParking = Integer.parseInt(attribute[2]);

            steps = Steps(matrix, entryRow, rowParking, colParking, 1, colParking);
            if (steps != 0) {
                System.out.println(steps);
            } else {
                System.out.println("Row " + rowParking + " full");
            }
        }
    }

    private static int Steps(boolean[][] matrix, int entryRow, int rowParking, int colParking, int index, int oldColParking) {
        int steps = 1 + Math.abs(entryRow - rowParking) + colParking;
        if (!matrix[rowParking][colParking]) {
            matrix[rowParking][colParking] = true;
            return steps;
        } else {
            if (oldColParking - index >= 1 && !matrix[rowParking][colParking - index]) {
                return Steps(matrix, entryRow, rowParking, oldColParking - index, index, oldColParking);
            } else if (oldColParking + index < matrix[0].length && !matrix[rowParking][colParking + index]) {
                return Steps(matrix, entryRow, rowParking, oldColParking + index, index, oldColParking);
            } else if (colParking - index >= 1 || colParking + index < matrix[0].length) {
                return Steps(matrix, entryRow, rowParking, oldColParking, index + 1, oldColParking);
            } else {
                return 0;
            }
        }
    }
}
