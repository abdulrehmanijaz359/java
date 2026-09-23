package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 * StackADT defines the interface for a stack, a LIFO
 * (last-in, first-out) collection.
 *
 * @param <T> the type of elements stored in the stack
 */
public interface StackADT<T> {

    void push(T element);

    T pop() throws EmptyCollectionException;

    T peek() throws EmptyCollectionException;

    boolean isEmpty();

    int size();

    String toString();
}