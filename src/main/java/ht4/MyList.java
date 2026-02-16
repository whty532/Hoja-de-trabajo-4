package ht4;


public interface MyList<T> {
    void addFirst(T item);
    T removeFirst();     // null si vacía
    T getFirst();        // null si vacía
    boolean isEmpty();
    int size();
    
}
