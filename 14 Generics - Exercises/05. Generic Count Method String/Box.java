package Generics;

import java.util.ArrayList;
import java.util.List;

public class Box<E extends Comparable<E>> {
    private List<E> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(E element){
        elements.add(element);
    }

    public long Compare(E element){
        return this.elements.stream().filter(s -> s.compareTo(element) > 0).count();
    }
}
