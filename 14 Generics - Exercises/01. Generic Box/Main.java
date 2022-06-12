package generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        while (number-- > 0){
            Box<String> box = new Box<>(console.nextLine());
            System.out.println(box);
        }
    }
}
