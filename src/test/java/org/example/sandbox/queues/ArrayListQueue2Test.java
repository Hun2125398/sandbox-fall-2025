package org.example.sandbox.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListQueue2Test {

    private ArrayListQueue2<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new ArrayListQueue2<>();
    }

    @Test
    void addReturnsTrueAndAffectsIsEmpty() {
        assertTrue(queue.isEmpty());
        assertTrue(queue.add(5));
        assertFalse(queue.isEmpty());
    }

    @Test
    void fifoOrderIsPreserved() {
        queue.add(10);
        queue.add(20);
        queue.add(30);

        assertEquals(Integer.valueOf(10), queue.element());
        assertEquals(Integer.valueOf(10), queue.remove());
        assertEquals(Integer.valueOf(20), queue.remove());
        assertEquals(Integer.valueOf(30), queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    void removeOnEmptyThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.remove());
    }

    @Test
    void elementOnEmptyThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.element());
    }

    @Test
    void nullElementBehavior_elementDoesNotRemove_butThrows() {
        queue.add(null);
        assertFalse(queue.isEmpty());

        // element() should detect null and throw, but not remove the head
        assertThrows(FailedOperationException.class, () -> queue.element());
        assertFalse(queue.isEmpty(), "element() should not remove the head on exception");
    }

    @Test
    void nullElementBehavior_removeRemovesThenThrows() {
        queue.add(null);
        assertFalse(queue.isEmpty());

        // remove() removes the head (null) then throws due to null check
        assertThrows(FailedOperationException.class, () -> queue.remove());
        assertTrue(queue.isEmpty(), "remove() should have removed the null element even though it throws");
    }

    @Test
    void toStringContainsQueueRepresentation() {
        queue.add(1);
        queue.add(2);
        String s = queue.toString();
        assertTrue(s.contains("queue="), "toString should include the field name");
        assertTrue(s.contains("1"), "toString should include element 1");
        assertTrue(s.contains("2"), "toString should include element 2");
    }
}
