package Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        Box<Double> boxList = new Box<>();
        while (number-- > 0){
            double boxToAdd = Double.parseDouble(console.nextLine());
            boxList.add(boxToAdd);
        }
        double elementToCompare = Double.parseDouble(console.nextLine());
        System.out.println(boxList.Compare(elementToCompare));
    }
}
