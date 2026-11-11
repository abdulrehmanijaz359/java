/** Abstract list (stand-in for the course's LinkedList). Only add and getLast are left abstract. */
public abstract class LinkedList<T> {
    protected LinearNode<T> head, tail;
    protected int count;

    public LinkedList() { head = tail = null; count = 0; }

    /** Adds an element to the end of the list. */
    public abstract void add(T element);
    /** Returns the last element without removing it. */
    public abstract T getLast();

    public T removeLast() {
        if (isEmpty()) throw new EmptyCollectionException("list");
        T result = tail.getElement();
        if (count == 1) {
            head = tail = null;
        } else {
            LinearNode<T> current = head;
            while (current.getNext() != tail) current = current.getNext();
            current.setNext(null);
            tail = current;
        }
        count--;
        return result;
    }

    public boolean isEmpty() { return count == 0; }
    public int size() { return count; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinearNode<T> n = head; n != null; n = n.getNext()) sb.append(n.getElement()).append(" ");
        return sb.toString().trim();
    }
}
