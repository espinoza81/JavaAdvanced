package genrtics;

import java.util.ArrayDeque;

public class Jar<E> {
    private ArrayDeque<E> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(E element){
        elements.add(element);
    }

    public E remove(){
        return elements.pop();
    }
}
