import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int divideNumber = Integer.parseInt(console.nextLine());
        Predicate <Integer> numbersDivide = i -> i%divideNumber==0;
        Consumer <Integer> printer = i -> System.out.printf("%d ", i);
        numbers.removeIf(numbersDivide);
        Collections.reverse(numbers);
        numbers.forEach(printer);
    }
}
