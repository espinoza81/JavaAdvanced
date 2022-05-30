import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numberLine = Integer.parseInt(console.nextLine());
        Map<String, Integer> peopleWhitAge = new LinkedHashMap<>();
        for(int i=0; i<numberLine; i++){
            String[] personData = console.nextLine().split(",\\s+");
            peopleWhitAge.put(personData[0], Integer.parseInt(personData[1]));
        }
        String condition = console.nextLine(); //"younger" or "older"
        Integer age = Integer.parseInt(console.nextLine());
        String format = console.nextLine(); //"name", "age" or "name age"

        BiPredicate<Integer, Integer> filterByAge;
        if("younger".equals(condition)){
            filterByAge = (personAge, ageLimit) -> personAge <= ageLimit;
        } else {
            filterByAge = (personAge, ageLimit) -> personAge >= ageLimit;
        }

        Consumer<Map.Entry<String, Integer>> printPersonData;

        switch (format){
            case "name":
                printPersonData = person -> System.out.println(person.getKey());
                break;
            case "age":
                printPersonData = person -> System.out.println(person.getValue());
                break;
            case "name age":
                printPersonData = person -> System.out.println(person.getKey() + " - " + person.getValue());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }
        peopleWhitAge.entrySet()
                .stream()
//                .filter("younger".equals(condition) ? i -> i.getValue() <= age : i -> i.getValue() >= age)
                .filter(person -> filterByAge.test(person.getValue(), age))
                .forEach(printPersonData);

    }
}
