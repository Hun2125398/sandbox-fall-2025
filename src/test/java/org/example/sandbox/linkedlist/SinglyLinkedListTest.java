package org.example.sandbox.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    @DisplayName("New list should be empty")
    void testNewListIsEmpty() {
        assertEquals(0, list.size());
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
    }

    @Test
    @DisplayName("addFirst should add element to empty list")
    void testAddFirstToEmptyList() {
        list.addFirst(1);
        assertEquals(1, list.size());
        assertEquals(1, list.peekFirst());
        assertEquals(1, list.peekLast());
    }

    @Test
    @DisplayName("addFirst should add multiple elements")
    void testAddFirstMultipleElements() {
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        assertEquals(3, list.size());
        assertEquals(1, list.peekFirst());
        assertEquals(3, list.peekLast());
    }

    @Test
    @DisplayName("addLast should add element to empty list")
    void testAddLastToEmptyList() {
        list.addLast(1);
        assertEquals(1, list.size());
        assertEquals(1, list.peekFirst());
        assertEquals(1, list.peekLast());
    }

    @Test
    @DisplayName("addLast should add multiple elements")
    void testAddLastMultipleElements() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.size());
        assertEquals(1, list.peekFirst());
        assertEquals(3, list.peekLast());
    }

    @Test
    @DisplayName("pollFirst should return and remove first element")
    void testPollFirst() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(1, list.pollFirst());
        assertEquals(2, list.size());
        assertEquals(2, list.peekFirst());
    }

    @Test
    @DisplayName("pollFirst on empty list should return null")
    void testPollFirstOnEmptyList() {
        assertNull(list.pollFirst());
    }

    @Test
    @DisplayName("pollLast should return and remove last element")
    void testPollLast() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.pollLast());
        assertEquals(2, list.size());
        assertEquals(2, list.peekLast());
    }

    @Test
    @DisplayName("pollLast on empty list should return null")
    void testPollLastOnEmptyList() {
        assertNull(list.pollLast());
    }

    @Test
    @DisplayName("pollFirst on single element list")
    void testPollFirstSingleElement() {
        list.addFirst(1);
        assertEquals(1, list.pollFirst());
        assertEquals(0, list.size());
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
    }

    @Test
    @DisplayName("pollLast on single element list")
    void testPollLastSingleElement() {
        list.addFirst(1);
        assertEquals(1, list.pollLast());
        assertEquals(0, list.size());
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
    }

    @Test
    @DisplayName("contains should find existing element")
    void testContainsExistingElement() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertTrue(list.contains(2));
    }

    @Test
    @DisplayName("contains should not find non-existing element")
    void testContainsNonExistingElement() {
        list.addLast(1);
        list.addLast(2);
        assertFalse(list.contains(5));
    }

    @Test
    @DisplayName("contains on empty list should return false")
    void testContainsOnEmptyList() {
        assertFalse(list.contains(1));
    }

    @Test
    @DisplayName("clear should remove all elements")
    void testClear() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.clear();
        assertEquals(0, list.size());
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
    }

    @Test
    @DisplayName("toString should format list correctly")
    void testToString() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    @DisplayName("toString on empty list should return empty brackets")
    void testToStringOnEmptyList() {
        assertEquals("[]", list.toString());
    }

    @Test
    @DisplayName("List should handle null elements")
    void testNullElements() {
        list.addFirst(null);
        assertEquals(1, list.size());
        assertNull(list.peekFirst());
    }

    @Test
    @DisplayName("Mixed addFirst and addLast operations")
    void testMixedOperations() {
        list.addFirst(2);
        list.addLast(3);
        list.addFirst(1);
        list.addLast(4);
        assertEquals("[1, 2, 3, 4]", list.toString());
        assertEquals(4, list.size());
    }
}
