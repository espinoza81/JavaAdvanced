package Generics;

public class Sorter {
    public static <E extends Comparable<E>> void sort(Box<E> elements){
        for (int i=0; i<elements.size(); i++){
            E temp = elements.get(i);
            for (int j = i+1; j< elements.size(); j++){
                if(temp.compareTo(elements.get(j)) >0 ) {
                    elements.swap(i, j);
                }
            }
        }
    }
}
