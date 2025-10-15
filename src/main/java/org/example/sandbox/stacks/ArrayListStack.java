package org.example.sandbox.stacks;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack<E> implements Stack<E> {

    private List<E> stack;

    public ArrayListStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public void push(E item) {

    }

    @Override
    public int search(E element) {
        return 0;
    }
}
