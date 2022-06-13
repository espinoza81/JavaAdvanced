package Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        Box<String> boxList = new Box<>();
        while (number-- > 0){
            String boxToAdd = console.nextLine();
            boxList.add(boxToAdd);
        }
        String elementToCompare = console.nextLine();
        System.out.println(boxList.Compare(elementToCompare));
    }
}
