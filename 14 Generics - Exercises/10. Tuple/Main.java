package Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //"{first name} {last name} {address}"
        String[] input = console.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        Tuple<String, String> tempTuple = new Tuple<>(name, address);
        System.out.println(tempTuple);

        //"{name} {liters of beer}"
        input = console.nextLine().split("\\s+");
        name = input[0];
        int litersBeer = Integer.parseInt(input[1]);
        Tuple<String, Integer> tempTuple2 = new Tuple<>(name, litersBeer);
        System.out.println(tempTuple2);

        //"{Integer} {Double}"
        input = console.nextLine().split("\\s+");
        int integerNumber = Integer.parseInt(input[0]);
        double doubleNumber = Double.parseDouble(input[1]);
        Tuple<Integer, Double> tempTuple3 = new Tuple<>(integerNumber, doubleNumber);
        System.out.println(tempTuple3);
    }
}
