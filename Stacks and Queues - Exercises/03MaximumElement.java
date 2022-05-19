import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> number = new ArrayDeque<>();
        int command = console.nextInt();
        for (int i = 0; i < command; i++) {
            switch (console.nextInt()){
                case 1:
                    number.push(console.nextInt());
                    break;
                case 2:
                    number.pop();
                    break;
                case 3:
                    System.out.println(number.stream().max(Integer::compare).get());
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }
}
