import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        String currentUrl = "";
        ArrayDeque<String> backWebSites = new ArrayDeque<>();
        ArrayDeque<String> forwardWebSites = new ArrayDeque<>();
        while (!"Home".equals(input = console.next())) {
            switch (input) {
                case "back":
                    if (backWebSites.size() > 1) {
                        forwardWebSites.addFirst(currentUrl);
                        System.out.println(currentUrl = backWebSites.pop());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;
                case "forward":
                    if (forwardWebSites.size() > 0) {
                        backWebSites.push(currentUrl);
                        System.out.println(currentUrl = forwardWebSites.pop());
                    } else {
                        System.out.println("no next URLs");
                    }
                    break;
                default:
                    backWebSites.push(currentUrl);
                    currentUrl = input;
                    forwardWebSites.clear();
                    System.out.println(currentUrl);
            }
        }
    }
}
