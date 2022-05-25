import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] elements = console.nextLine().split("\\s+");
        int elementForFirst = Integer.parseInt(elements[0]);
        int elementForSecond = Integer.parseInt(elements[1]);
        Set<Integer> firstNumbers = new LinkedHashSet<>();
        Set<Integer> secondNumbers = new LinkedHashSet<>();
        for (int i = 0; i < elementForFirst; i++) {
            int numberToAdd = Integer.parseInt(console.nextLine());
            firstNumbers.add(numberToAdd);
        }
        for (int i = 0; i < elementForSecond; i++) {
            int numberToAdd = Integer.parseInt(console.nextLine());
            secondNumbers.add(numberToAdd);
        }
        firstNumbers.retainAll(secondNumbers);
        firstNumbers.forEach(number -> System.out.print(number + " "));
    }
}
