package Generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Box<E extends Comparable<E>> implements Iterable<E>{
    private List<E> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(E element){
        elements.add(element);
    }

    public E remove(int index){
        return elements.remove(index);
    }

    public boolean contains(E element){
        return elements.contains(element);
    }

    public void swap(int indexFirst, int indexSecond){
        E tempBox = elements.get(indexFirst);
        elements.set(indexFirst, elements.get(indexSecond));
        elements.set(indexSecond, tempBox);
    }

    public int countGreaterThan(E element){
        return Math.toIntExact(this.elements.stream().filter(s -> s.compareTo(element) > 0).count());
    }

    public int size(){
        return this.elements.size();
    }
    public E get(int index){
        return elements.get(index);
    }
    public E getMax(){
        return this.elements.stream().max(E::compareTo).orElse(null);
    }

    public E getMin(){
        return this.elements.stream().min(E::compareTo).orElse(null);
    }

    @Override
    public String toString() {
        return elements.stream().map(s -> s + "").collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }
}
