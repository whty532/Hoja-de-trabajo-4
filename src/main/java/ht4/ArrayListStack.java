package ht4;

import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {

    private final ArrayList<T> data = new ArrayList<>();

    @Override
    public void push(T item) {
        data.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }

    @Override
    public int size() {
        return data.size();
    }
}
