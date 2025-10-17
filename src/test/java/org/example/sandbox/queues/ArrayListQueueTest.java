package org.example.sandbox.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListQueueTest {

    private ArrayListQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new ArrayListQueue<>();
    }

    @Test
    void offerSizeAndIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        assertTrue(queue.offer(1));
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        assertTrue(queue.offer(2));
        assertEquals(2, queue.size());
    }

    @Test
    void fifoOrderIsPreserved() {
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        assertEquals(3, queue.size());
        assertEquals(Integer.valueOf(10), queue.poll());
        assertEquals(Integer.valueOf(20), queue.poll());
        assertEquals(Integer.valueOf(30), queue.poll());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void peekDoesNotRemove() {
        queue.offer(99);
        assertEquals(Integer.valueOf(99), queue.peek());
        assertEquals(1, queue.size(), "peek should not remove the element");
        assertEquals(Integer.valueOf(99), queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    void pollOnEmptyThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.poll());
    }

    @Test
    void peekOnEmptyThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.peek());
    }

    @Test
    void supportsNullElements() {
        assertTrue(queue.offer(null));
        assertEquals(1, queue.size());
        assertNull(queue.peek(), "peek should return null when null is the head");
        assertNull(queue.poll(), "poll should return null when null was the head");
        assertTrue(queue.isEmpty());
    }

    @Test
    void equalsAndHashCodeContract() {
        ArrayListQueue<Integer> a = new ArrayListQueue<>();
        ArrayListQueue<Integer> b = new ArrayListQueue<>();

        a.offer(1);
        a.offer(2);

        b.offer(1);
        b.offer(2);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());

        b.offer(3);
        assertNotEquals(a, b);

        assertNotEquals(a, null);
        assertNotEquals(a, "some string");
    }

    @Test
    void toStringShowsContents() {
        queue.offer(5);
        queue.offer(6);
        // underlying list toString should produce something like "[5, 6]"
        assertEquals(queue.toString(), new ArrayListQueue<Integer>() {{
            offer(5);
            offer(6);
        }}.toString());
    }
}
