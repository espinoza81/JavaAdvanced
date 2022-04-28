import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        ArrayDeque<String> stringBeforeCommand = new ArrayDeque<>();
        StringBuilder manipulate = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] command = console.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    stringBeforeCommand.push(String.valueOf(manipulate));
                    manipulate.append(command[1]);
                    break;
                case "2":
                    stringBeforeCommand.push(String.valueOf(manipulate));
                    manipulate.delete(manipulate.length() - Integer.parseInt(command[1]), manipulate.length());
                    break;
                case "3":
                    System.out.println(manipulate.charAt(Integer.parseInt(command[1])-1));
                    break;
                case "4":
                    manipulate = new StringBuilder(stringBeforeCommand.pop());
                    break;
                default:
                    System.out.println("Not a valid command");
            }
        }
    }
}
