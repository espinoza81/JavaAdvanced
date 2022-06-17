package Iterators;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        Set<Person> peopleTree = new TreeSet<>();
        Set<Person> peopleHash = new HashSet<>();

        while (number-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");
            Person personToAdd = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleTree.add(personToAdd);
            peopleHash.add(personToAdd);
        }
        System.out.println(peopleTree.size());
        System.out.println(peopleHash.size());
    }
}
