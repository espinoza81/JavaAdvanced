import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Character> inputParentheses = new ArrayDeque<>();
        HashMap <Character, Character> parentheses = new LinkedHashMap<>();
        parentheses.put('(',')');
        parentheses.put('{','}');
        parentheses.put('[',']');
        parentheses.put(' ',' ');

        String input = console.nextLine();
        boolean balanced = true;

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)==' ' && inputParentheses.size()==0) {
                continue;
            }
            if(parentheses.containsKey(input.charAt(i))){
                inputParentheses.push(input.charAt(i));
            }
            else {
                if(inputParentheses.size()==0) {
                    balanced = false;
                    break;
                }
                while (inputParentheses.peek()==' ') {
                    inputParentheses.pop();
                }
                if(input.charAt(i)!=parentheses.get(inputParentheses.pop())) {
                    balanced = false;
                    break;
                }
            }
        }
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
