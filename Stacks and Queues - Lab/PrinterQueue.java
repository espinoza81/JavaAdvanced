import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        ArrayDeque<String> filesToPrint = new ArrayDeque<>();
        while (!"print".equals(input= console.next())){
            if("cancel".equals(input)){
                if(filesToPrint.size()>0){
                    System.out.println("Canceled " + filesToPrint.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                filesToPrint.offer(input);
            }
        }
        filesToPrint.forEach(System.out::println);
    }
}
