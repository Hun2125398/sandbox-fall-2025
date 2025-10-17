package org.example.sandbox.queues;

import java.util.ArrayList;
import java.util.List;

public class ArrayListQueue2<E> implements Queue2<E> {

    List<E> queue;

    public ArrayListQueue2() {
        queue = new ArrayList<>();
    }

    @Override
    public boolean add(E e) {

        boolean success = this.queue.add(e);

        if (!success) {
            throw new FailedOperationException("Failed to add");
        }

        return success;
    }

    @Override
    public E remove() {

        E element = this.queue.remove(0);

        if (element == null) {
            throw new FailedOperationException("Failed to remove");
        }

        return element;
    }

    @Override
    public E element() {

        E element = this.queue.get(0);

        if (element == null) {
            throw new FailedOperationException("Failed to get element");
        }

        return element;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayListQueue2 {");
        sb.append("queue=")
                .append(queue);
        sb.append('}');
        return sb.toString();
    }
}
