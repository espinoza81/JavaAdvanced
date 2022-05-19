import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s");
        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        HashMap<String, Integer> operatorList = new LinkedHashMap<>();
        operatorList.put("+", 2);
        operatorList.put("-", 2);
        operatorList.put("*", 3);
        operatorList.put("/", 3);
        operatorList.put("(", 1);
        operatorList.put(")", 1);

        for (String s : input) {
            if (operatorList.containsKey(s)) {
                switch (s) {
                    case "(":
                        operators.push(s);
                        break;
                    case ")":
                        while (!"(".equals(operators.peek())) {
                            output.offer(operators.pop());
                        }
                        operators.pop();
                        break;
                    default:
                        while (operators.size()>0 && operatorList.get(operators.peek()) >= operatorList.get(s)) {
                            output.offer(operators.pop());
                        }
                        operators.push(s);
                }
            } else {
                output.offer(s);
            }
        }
        while (operators.size()>0){
            output.offer(operators.pop());
        }
        System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
    }
}
