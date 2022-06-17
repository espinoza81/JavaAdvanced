package Iterators;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String command;
        Lake lake = new Lake();

        while (!"END".equals(command = console.nextLine())) {
            int[] tokens = Arrays.stream(command.split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            for (Integer token : tokens) {
                lake.addLast(token);
            }
        }

        Lake.print(lake);
    }
}
