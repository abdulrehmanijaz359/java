// LinkedStack.java
public class LinkedStack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> top;
    private int count;

    public void push(T item) {
        Node<T> n = new Node<>(item);
        n.next = top;
        top = n;
        count++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = top.data;
        top = top.next;
        count--;
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() { return top == null; }

    public int size() { return count; }

    public void clear() { top = null; count = 0; }

    public boolean contains(T item) {
        for (Node<T> cur = top; cur != null; cur = cur.next)
            if (cur.data.equals(item)) return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[top] ");
        for (Node<T> cur = top; cur != null; cur = cur.next)
            sb.append(cur.data).append(" ");
        return sb.toString().trim();
    }
}