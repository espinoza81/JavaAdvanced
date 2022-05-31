import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List <String> guests = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toList());
        List <String> temp = new ArrayList<>();
        String command;

        Consumer <List<String>> printer = list -> {
            if(list.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                System.out.println(String.join(", ", list) + " are going to the party!");
            }
        };
        
        while (!"Party!".equals(command=console.nextLine())){
            String[] token = command.split("\\s+");
            Predicate <String> filterCriteria = getFilterCriteria(token);

            if("Remove".equals(token[0])) guests.removeIf(filterCriteria);
            else {
                guests.stream().filter(filterCriteria).forEach(temp::add);
                guests.addAll(temp);
                temp.clear();
            }
        }
        Collections.sort(guests);
        printer.accept(guests);
    }

    private static Predicate<String> getFilterCriteria(String[] token) {
        switch (token[1]){
            case "StartsWith":
                String startLetters = token[2];
                return s -> s.startsWith(startLetters);
            case "EndsWith":
                String endLetters = token[2];
                return s -> s.endsWith(endLetters);
            case "Length":
                int length = Integer.parseInt(token[2]);
                return s -> s.length()==length;
            default:
                throw new IllegalStateException("Unexpected value: " + token[1]);
        }
    }
}
