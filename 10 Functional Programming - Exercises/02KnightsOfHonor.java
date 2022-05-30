import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Consumer<String> printer = name -> System.out.println("Sir " + name);
        Arrays.stream(console.nextLine().split("\\s+")).forEach(printer);
    }
}
