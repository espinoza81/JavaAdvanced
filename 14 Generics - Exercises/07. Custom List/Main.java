package Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Box<String> boxList = new Box<>();

        String tokens;
        while (!"END".equals(tokens=console.nextLine())){
            String[] token = tokens.split("\\s+");
            switch (token[0]){
                case "Add":
                    boxList.add(token[1]);
                    break;
                case "Remove":
                    boxList.remove(Integer.parseInt(token[1]));
                    break;
                case "Contains":
                    System.out.println(boxList.contains(token[1]));
                    break;
                case "Swap":
                    boxList.swap(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
                case "Greater":
                    System.out.println(boxList.countGreaterThan(token[1]));
                    break;
                case "Max":
                    System.out.println(boxList.getMax());
                    break;
                case "Min":
                    System.out.println(boxList.getMin());
                    break;
                case "Print":
                    System.out.println(boxList);
                    break;
            }
        }
    }
}
