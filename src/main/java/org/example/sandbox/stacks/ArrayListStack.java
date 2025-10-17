package org.example.sandbox.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListStack<E extends Comparable<E>> implements Stack<E> {

    private List<E> stack;

    public ArrayListStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public boolean empty() {
        return this.stack.isEmpty();
    }

    @Override
    public E peek() {
        return this.stack.get(0);
    }

    @Override
    public E pop() {
        return this.stack.remove(0);
    }

    @Override
    public void push(E item) {
        this.stack.add(0, item);
    }

    @Override
    public int search(E element) {
        return this.stack.indexOf(element) + 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(stack);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListStack<?> that = (ArrayListStack<?>) o;
        return Objects.equals(stack, that.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stack);
    }
}
