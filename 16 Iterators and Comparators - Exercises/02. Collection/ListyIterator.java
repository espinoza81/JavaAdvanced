package Iterators;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> collection;
    int index;

    public ListyIterator(String... input) {
        this.collection = Arrays.asList(input);
        this.index=0;
    }

    public boolean Move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < collection.size()-1;
    }

    public void Print() {
        if(collection.isEmpty()){
            System.out.println("Invalid Operation!");
        }
        else {
            System.out.println(collection.get(index));
        }
    }

    public void PrintAll(){
        for (String s: collection) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }
}
