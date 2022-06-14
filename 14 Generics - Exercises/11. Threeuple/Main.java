package Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //"{first name} {last name} {address} {town}"
        String[] input = console.nextLine().split("\\s+");
        Threeuple<String, String, String> tempThreeuple = new Threeuple<>(input[0] + " " + input[1], input[2], input[3]);
        System.out.println(tempThreeuple);

        //"{name} {liters of beer} {drunk or not}"
        input = console.nextLine().split("\\s+");
        Threeuple<String, Integer, Boolean> tempThreeuple2 = new Threeuple<>(input[0], Integer.parseInt(input[1]), input[2].equals("drunk"));
        System.out.println(tempThreeuple2);

        //"{name} {account balance} {bank name}"
        input = console.nextLine().split("\\s+");
        Threeuple<String, Double, String> tempThreeuple3 = new Threeuple<>(input[0], Double.parseDouble(input[1]), input[2]);
        System.out.println(tempThreeuple3);
    }
}
