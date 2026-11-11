/** Node-based queue, O(1) enqueue/dequeue; used only for the PP 6.5 comparison. */
public class LinkedQueue<T> implements QueueADT<T> {
    private LinearNode<T> head, tail;
    private int count;

    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        if (count == 0) head = node; else tail.setNext(node);
        tail = node;
        count++;
    }

    public T dequeue() {
        if (count == 0) throw new EmptyCollectionException("queue");
        T result = head.getElement();
        head = head.getNext();
        if (--count == 0) tail = null;
        return result;
    }

    public T first() {
        if (count == 0) throw new EmptyCollectionException("queue");
        return head.getElement();
    }

    public boolean isEmpty() { return count == 0; }
    public int size() { return count; }
    public String toString() { return "LinkedQueue(" + count + ")"; }
}
