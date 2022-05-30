import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Function<Integer[], Integer> maxElement = intArray -> Arrays.stream(intArray).sorted().findFirst().orElse(0);
        System.out.println(maxElement.apply(Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new)));
    }
}
