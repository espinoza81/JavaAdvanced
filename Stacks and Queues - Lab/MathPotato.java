import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, input);
        int number = Integer.parseInt(console.nextLine());
        int primeCircle = 1;
        while (kids.size()>1){
            for(int i=1; i<number;i++){
                kids.offer(kids.poll());
            }
            if(primeCircle==1 || primeCircle==4 || (primeCircle>5 && (primeCircle%2==0 || primeCircle%3==0 || primeCircle%5==0))) {
                System.out.println("Removed " + kids.poll());
            }
            else {
                System.out.println("Prime " + kids.peek());
            }
            primeCircle++;
        }
        System.out.println("Last is " + kids.peek());
    }
}
