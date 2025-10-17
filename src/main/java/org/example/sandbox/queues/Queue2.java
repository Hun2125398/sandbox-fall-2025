package org.example.sandbox.queues;

public interface Queue2<E> {

    boolean add(E e);
    E remove();
    E element();
    boolean isEmpty();

}
