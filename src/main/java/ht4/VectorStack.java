package ht4;

import java.util.Vector;


public class VectorStack<T> extends AbstractStack<T> {
    private final Vector<T> data = new Vector<>();

    @Override
    public void push(T item) {
        data.add(item);
    }

    @Override
    public T pop() {
        if (data.isEmpty()) return null;
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (data.isEmpty()) return null;
        return data.get(data.size() - 1);
    }

    @Override
    public int size() {
        return data.size();
    }

    public Vector<T> getData() {
        return data;
    }
}