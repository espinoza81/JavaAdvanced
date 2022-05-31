import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> guests = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toList());
        String command;
        Set<String> criteriaToApply = new HashSet<>();

        while (!"Print".equals(command=console.nextLine())){
            char addOrRemove = command.charAt(0);
            String filterName = command.substring(command.indexOf(";")+1);

            if(addOrRemove=='A') {
                criteriaToApply.add(filterName);
            } else {
                criteriaToApply.remove(filterName);
            }
        }

        criteriaToApply.forEach(s -> {
            String[] attributes = s.split(";");
            String type = attributes[0];
            String parameter = attributes[1];
            Predicate<String> filterCriteria = getFilterCriteria(type, parameter);
            guests.removeIf(filterCriteria);
        });

        System.out.println(String.join(" ", guests));
    }

    private static Predicate<String> getFilterCriteria(String type, String parameter) {
        Map <String, Predicate<String>> filterCriteriaMap = new HashMap<>();
        filterCriteriaMap.put("Starts with", s -> s.startsWith(parameter));
        filterCriteriaMap.put("Ends with", s -> s.endsWith(parameter));
        filterCriteriaMap.put("Length", s -> s.length()==Integer.parseInt(parameter));
        filterCriteriaMap.put("Contains", s -> s.contains(parameter));
        return filterCriteriaMap.get(type);
    }
}
