import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> number = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(number::push);
        System.out.println(number.toString().replaceAll("[\\[\\],]", ""));
    }
}
