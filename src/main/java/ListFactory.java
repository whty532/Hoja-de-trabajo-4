package main.java;

public class ListFactory {
    public static <T> MyList<T> create(String listType) {
        String t = listType.toLowerCase();
        
        if (t.equals("simple") || t.equals("singly") || t.equals("s")) {
            return new SinglyLinkedList<T>();
        }

        if (t.equals("doble") || t.equals("doubly") || t.equals("d")) {
            return new DoublyLinkedList<T>();
        }

        return new SinglyLinkedList<T>();
    }
}
