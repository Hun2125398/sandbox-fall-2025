package org.example.sandbox.queues;

public interface Queue<E> {

    boolean offer(E element);
    E poll();
    E peek();
    boolean isEmpty();
    int size();

}
