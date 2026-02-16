package ht4;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data; 
        }
    }

    private Node<T> head;

    @Override
    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        n.next = head;
        head = n;
        size++;
    }

    @Override
    public T removeFirst() {
        if (head == null) return null;
        T val = head.data;
        head = head.next;
        size--;
        return val;
    }

    @Override
    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }

    public void add(T item) {
        Node<T> n = new Node<>(item);
        if (head == null) {
            head = n;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
        size++;
    }

    public T get(int index) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    public T remove(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}
