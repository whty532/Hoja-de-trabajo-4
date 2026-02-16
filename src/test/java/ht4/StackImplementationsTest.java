package ht4;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StackImplementationsTest {

    @Test
    public void testArrayListStack() {
        MyStack<Integer> s = new ArrayListStack<>();
        assertTrue(s.isEmpty());
        s.push(10);
        s.push(20);
        assertEquals(2, s.size());
        assertEquals(20, s.peek());
        assertEquals(20, s.pop());
        assertEquals(10, s.pop());
        assertNull(s.pop());
        assertTrue(s.isEmpty());
    }

    @Test
    public void testVectorStack() {
        MyStack<String> s = new VectorStack<>();
        s.push("a");
        s.push("b");
        assertEquals("b", s.peek());
        assertEquals("b", s.pop());
        assertEquals("a", s.pop());
        assertNull(s.peek());
    }

    @Test
    public void testListStackSingly() {
        MyList<Integer> list = new SinglyLinkedList<>();
        MyStack<Integer> s = new ListStack<>(list);

        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, s.size());
        assertEquals(3, s.pop());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertNull(s.pop());
    }

    @Test
    public void testListStackDoubly() {
        MyList<Integer> list = new DoublyLinkedList<>();
        MyStack<Integer> s = new ListStack<>(list);

        s.push(7);
        s.push(8);
        assertEquals(8, s.peek());
        assertEquals(8, s.pop());
        assertEquals(7, s.pop());
    }
}