package org.example.sandbox.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListQueue<E> implements Queue<E> {

    private List<E> queue;

    public ArrayListQueue() {
        this.queue = new ArrayList<>();
    }

    @Override
    public boolean offer(E element) {
        return this.queue.add(element);
    }

    @Override
    public E poll() {
        return this.queue.remove(0);
    }

    @Override
    public E peek() {
        return this.queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(queue);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListQueue<?> that = (ArrayListQueue<?>) o;
        return Objects.equals(queue, that.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(queue);
    }
}
