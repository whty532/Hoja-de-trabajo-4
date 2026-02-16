package ht4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListImplementationsTest {

    @Test
    public void testSinglyLinkedList() {
        MyList<Integer> l = new SinglyLinkedList<>();
        assertTrue(l.isEmpty());
        l.addFirst(5);
        l.addFirst(6);
        assertEquals(2, l.size());
        assertEquals(6, l.getFirst());
        assertEquals(6, l.removeFirst());
        assertEquals(5, l.removeFirst());
        assertNull(l.removeFirst());
    }

    @Test
    public void testDoublyLinkedList() {
        MyList<String> l = new DoublyLinkedList<>();
        l.addFirst("x");
        l.addFirst("y");
        assertEquals("y", l.getFirst());
        assertEquals("y", l.removeFirst());
        assertEquals("x", l.removeFirst());
        assertTrue(l.isEmpty());
    }
}