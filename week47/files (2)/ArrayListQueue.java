import java.util.ArrayList;

/** PP 6.4: queue stored in an ArrayList. Front of queue = index 0, rear = end. */
public class ArrayListQueue<T> implements QueueADT<T> {
    private ArrayList<T> list = new ArrayList<T>();

    public void enqueue(T element) { list.add(element); }

    public T dequeue() {
        if (list.isEmpty()) throw new EmptyCollectionException("queue");
        return list.remove(0);          // O(n): shifts all remaining elements
    }

    public T first() {
        if (list.isEmpty()) throw new EmptyCollectionException("queue");
        return list.get(0);
    }

    public boolean isEmpty() { return list.isEmpty(); }
    public int size() { return list.size(); }
    public String toString() { return list.toString(); }
}
