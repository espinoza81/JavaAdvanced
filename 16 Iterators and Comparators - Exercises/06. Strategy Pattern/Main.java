package Iterators;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        Set<Person> peopleByName = new TreeSet<>(new PersonCompareLengthName());
        Set<Person> peopleByAge = new TreeSet<>(new PersonCompareAge());

        while (number-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");
            Person personToAdd = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleByAge.add(personToAdd);
            peopleByName.add(personToAdd);
        }
        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}
