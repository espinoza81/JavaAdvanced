import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        String currentUrl = "";
        ArrayDeque<String> visitWebSites = new ArrayDeque<>();
        while (!"Home".equals(input= console.next())){
            if("back".equals(input)){
                if(visitWebSites.size()>1){
                    System.out.println(currentUrl = visitWebSites.pop());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                visitWebSites.push(currentUrl);
                currentUrl = input;
                System.out.println(input);
            }
        }
    }
}
