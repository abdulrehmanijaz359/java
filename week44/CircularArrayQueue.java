import java.util.NoSuchElementException;

public class CircularArrayQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] queue;
    private int front;   // index of first element
    private int rear;    // index of next free slot

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int capacity) {
        // one extra slot so that full and empty can be told apart
        queue = (T[]) new Object[capacity + 1];
        front = 0;
        rear = 0;
    }

    public CircularArrayQueue() { this(DEFAULT_CAPACITY); }

    public void enqueue(T element) {
        if (size() == queue.length - 1) expandCapacity();
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty");
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        return result;
    }

    public T first() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty");
        return queue[front];
    }

    public boolean isEmpty() { return front == rear; }

    public int size() {
        return (rear - front + queue.length) % queue.length;
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        int n = size();
        T[] bigger = (T[]) new Object[(queue.length - 1) * 2 + 1];
        for (int i = 0; i < n; i++) {
            bigger[i] = queue[(front + i) % queue.length];
        }
        queue = bigger;
        front = 0;
        rear = n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(queue[(front + i) % queue.length]);
        }
        return sb.append("]").toString();
    }
}