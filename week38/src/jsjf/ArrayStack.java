package jsjf;

import jsjf.exceptions.EmptyCollectionException;
import java.util.Arrays;

/**
 * ArrayStack implements the StackADT interface using an array
 * as the underlying storage structure. The array grows automatically
 * when it becomes full.
 *
 * @param <T> the type of elements stored in the stack
 */
public class ArrayStack<T> implements StackADT<T> {

    private final static int DEFAULT_CAPACITY = 100;

    /** Index of the next free slot; also equals the current size. */
    private int top;

    private T[] stack;

    /** Creates an empty stack using the default capacity. */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        top = 0;
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates an empty stack using the given initial capacity.
     * 
     * @param initialCapacity the initial size of the underlying array
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        top--;
        T result = stack[top];
        stack[top] = null; // avoid holding a reference to a removed object
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return (top == 0);
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < top; i++) {
            result.append(stack[i]);
            if (i < top - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    /** Doubles the capacity of the underlying array. */
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }
}