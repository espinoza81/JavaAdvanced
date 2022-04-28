import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibonacci {

    private final Map<Integer, Long> memoizeTable = new HashMap<>(); // O(1)

    public long fibonacciMemoize(int n){

        if( n == 0 ) return 1;
        if( n == 1 ) return 1;

        if( this.memoizeTable.containsKey(n) )
        {
            return this.memoizeTable.get(n);
        }

        long result = fibonacciMemoize(n-1)+ fibonacciMemoize(n-2);

        this.memoizeTable.put(n, result);

        return result;

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        RecursiveFibonacci fibonacciAlgorithm = new RecursiveFibonacci();
        int n = Integer.parseInt(console.nextLine());
        System.out.println(fibonacciAlgorithm.fibonacciMemoize(n));

    }
}
