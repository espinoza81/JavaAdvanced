import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Arrays.stream(console.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .sorted(Comparator.reverseOrder())
              .limit(3)
              .forEach(s -> System.out.print(s + " "));
    }
}
