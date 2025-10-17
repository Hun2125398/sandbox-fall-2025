package org.example.sandbox.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListStackTest {

    private ArrayListStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayListStack<>();
    }

    @Test
    void testEmptyOnNewStack() {
        assertTrue(stack.empty());
    }

    @Test
    void testEmptyAfterPush() {
        stack.push(1);
        assertFalse(stack.empty());
    }

    @Test
    void testEmptyAfterPushAndPop() {
        stack.push(1);
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void testPushAndPeek() {
        stack.push(5);
        assertEquals(5, stack.peek());
        assertFalse(stack.empty());
    }

    @Test
    void testPushMultipleAndPeek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(10);
        assertEquals(10, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void testPopOrder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testSearchFound() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.search(3));
        assertEquals(2, stack.search(2));
        assertEquals(3, stack.search(1));
    }

    @Test
    void testSearchNotFound() {
        stack.push(1);
        stack.push(2);
        assertEquals(0, stack.search(5));
    }

    @Test
    void testSearchOnEmptyStack() {
        assertEquals(0, stack.search(1));
    }

    @Test
    void testToString() {
        stack.push(1);
        stack.push(2);
        assertEquals("[2, 1]", stack.toString());
    }

    @Test
    void testEqualsWithSameContent() {
        ArrayListStack<Integer> other = new ArrayListStack<>();
        stack.push(1);
        stack.push(2);
        other.push(1);
        other.push(2);
        assertEquals(stack, other);
    }

    @Test
    void testEqualsWithDifferentContent() {
        ArrayListStack<Integer> other = new ArrayListStack<>();
        stack.push(1);
        other.push(2);
        assertNotEquals(stack, other);
    }

    @Test
    void testEqualsWithNull() {
        assertNotEquals(null, stack);
    }

    @Test
    void testHashCode() {
        ArrayListStack<Integer> other = new ArrayListStack<>();
        stack.push(1);
        other.push(1);
        assertEquals(stack.hashCode(), other.hashCode());
    }

    @Test
    void testPushNull() {
        assertDoesNotThrow(() -> stack.push(null));
    }

    @Test
    void testWithStrings() {
        ArrayListStack<String> stringStack = new ArrayListStack<>();
        stringStack.push("first");
        stringStack.push("second");
        assertEquals("second", stringStack.peek());
        assertEquals("second", stringStack.pop());
    }
}
