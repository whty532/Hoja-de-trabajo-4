package ht4;


public class ListStack<T> extends AbstractStack<T> {
    private final MyList<T> list;

    public ListStack(MyList<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.addFirst(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }
    
}