import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Function<List<Integer>, Integer> minElement = findMinElement();
        System.out.println(minElement.apply(Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList())));
    }

    private static Function<List<Integer>, Integer> findMinElement() {
        return arr -> {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < arr.size(); i++) {
                if(arr.get(i) <= min) {
                    min = arr.get(i);
                    index = i;
                }
            }
            return index;
        };
    }
}
