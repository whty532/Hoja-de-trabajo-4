package main.java;

import java.util.Vector;

public class VectorStack<T> extends AbstractStack<T> {
    private final Vector<T> data = new Vector<>();

    public void push(T item) {
        data.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.remove(data.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }

    public int size() {
        return data.size();
    }
}
