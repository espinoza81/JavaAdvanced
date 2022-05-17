import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;
        int playerPoints = 18500;
        double heiganPoints = 3000000;
        double heiganDamage = Double.parseDouble(console.nextLine());
        boolean cloud = false;
        String spell="";

        while (heiganPoints > 0 && playerPoints > 0) {
            String[] command = console.nextLine().split("\\s+");
            spell = command[0];
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);
            heiganPoints -= heiganDamage;
            if ((playerRow >= Math.max(0, row - 1) && playerRow <= Math.min(14, row + 1)) && (playerCol >= Math.max(0, col - 1) && playerCol <= Math.min(14, col + 1))) {
                if (playerRow - 1 >= 0 && playerRow - 1 < Math.max(0, row - 1)) {
                    playerRow--;
                } else if (playerCol + 1 <= 14 && playerCol + 1 > Math.min(14, col + 1)) {
                    playerCol++;
                } else if (playerRow + 1 <= 14 && playerRow + 1 > Math.min(14, row + 1)) {
                    playerRow++;
                } else if (playerCol - 1 >= 0 && playerCol - 1 < Math.max(0, col - 1)) {
                    playerCol--;
                } else if(heiganPoints>0){
                    switch (spell) {
                        case "Cloud":
                            playerPoints -= 3500;
                            spell = "Plague Cloud";
                            break;
                        case "Eruption":
                            if (cloud) {
                                playerPoints -= 3500;
                                cloud = false;
                            }
                            playerPoints -= 6000;
                            break;
                    }
                }
            }

            if (cloud) {
                playerPoints -= 3500;
                cloud = false;
            }
            if ("Plague Cloud".equals(spell)) {
                cloud = true;
            }


        }

        if (heiganPoints > 0) {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerPoints > 0) {
            System.out.printf("Player: %d%n", playerPoints);
        } else {
            System.out.printf("Player: Killed by %s%n", spell);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }
}
