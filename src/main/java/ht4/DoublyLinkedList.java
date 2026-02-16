package ht4;

public class DoublyLinkedList<T> extends AbstractList<T> {

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
        if (head != null) {
        }
        head = n;
        size++;
    }

    @Override
    public T removeFirst() {
        if (head == null) return null;
        T val = head.data;
        head = head.next;
        if (head != null) {
        }
        size--;
        return val;
    }

    @Override
    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }
    
    @Override
    public boolean isEmpty() {
        return head == null;
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
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T remove(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
