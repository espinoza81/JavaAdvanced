import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> number = new ArrayDeque<>();
        int elementToPush = console.nextInt();
        int elementToPop = console.nextInt();
        int elementToCheck = console.nextInt();
        for (int i = 0; i < elementToPush; i++) {
            number.offer(console.nextInt());
        }
        for (int i = 0; i < elementToPop; i++) {
            number.poll();
        }
        if (number.size() == 0) System.out.println(0);
        else if (number.contains(elementToCheck)) System.out.println("true");
        else System.out.println(number.stream().min(Integer::compare).get());
    }
}
