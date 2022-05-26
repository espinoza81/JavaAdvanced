import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int input = Integer.parseInt(console.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for( int i=0; i< input; i++){
            String[] attribute = console.nextLine().split("\\s+");
            String name = attribute[0];
            double grade = Double.parseDouble(attribute[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students
                .forEach((key, value) -> {
                    double sum = 0;
                    for (Double aDouble : value) {
                        sum += aDouble;
                    }
                    double avgGrade = sum / value.size();

                    System.out.println(key +
                            " -> " +
                            value.stream().map(x -> String.format("%.2f", x)).collect(Collectors.joining(" ")) +
                            " (avg: " +
                            String.format("%.2f", avgGrade) +
                            ")");
                });
    }
}
