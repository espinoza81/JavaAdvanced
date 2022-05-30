import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + numbers.stream().mapToInt(i -> i).sum());
    }
}
