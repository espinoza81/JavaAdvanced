package Generics;

public class Tuple<E, T> {
    private E item1;
    private T item2;

    public Tuple(E item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        //"{item1} -> {item2}"
        return item1 + " -> " + item2;
    }
}
