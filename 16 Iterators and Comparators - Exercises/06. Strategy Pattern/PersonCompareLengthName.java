package Iterators;

import java.util.Comparator;
import java.util.Locale;

public class PersonCompareLengthName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if(first.getName().length()==second.getName().length()){
            return Character.compare(first.getName().toLowerCase(Locale.ROOT).charAt(0), second.getName().toLowerCase(Locale.ROOT).charAt(0));
        }
        return Integer.compare(first.getName().length(), second.getName().length());
    }
}
