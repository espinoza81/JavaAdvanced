import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Comparator <Integer> sortArray = (x, y) ->   (isEven(x) && !isEven(y)) ? -1: (!isEven(x) && isEven(y)) ? 1: x.compareTo(y);
        System.out.println(Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(sortArray)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static boolean isEven(Integer number) {
        return number%2==0;
    }
}
