import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int end = Integer.parseInt(console.nextLine());
        Integer[] divideNumbers = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Predicate<Integer> numberToPrint = i -> Arrays.stream(divideNumbers).allMatch(divide -> i%divide==0);
        System.out.println(IntStream.range(1, end+1)
                .boxed()
                .filter(numberToPrint)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
