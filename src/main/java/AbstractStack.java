package main.java;


public class AbstractStack<T> implements MyStack<T> {
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T item) {
        throw new UnsupportedOperationException("push() not implemented");
    }

    @Override
    public T pop() {
        throw new UnsupportedOperationException("pop() not implemented");
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("peek() not implemented");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("size() not implemented");
    }
}
