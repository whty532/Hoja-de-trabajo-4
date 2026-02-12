package main.java;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data; 
        }
    }

    private Node<T> head;

    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        n.next = head;
        head = n;
        size++;
    }

    public T removeFirst() {
        if (head == null) return null;
        T val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }

    @Override
    public void add(T item) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public T get(int index) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}
