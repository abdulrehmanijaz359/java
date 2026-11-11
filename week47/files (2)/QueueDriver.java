public class QueueDriver {
    public static void main(String[] args) {
        QueueADT<Integer> queue = new ArrayListQueue<Integer>();
        System.out.println("isEmpty: " + queue.isEmpty());
        queue.enqueue(1); queue.enqueue(2); queue.enqueue(3);
        System.out.println("After enqueueing 1, 2, 3: " + queue + " (size " + queue.size() + ")");
        System.out.println("first: " + queue.first());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("Now: " + queue + " (size " + queue.size() + ")");
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("isEmpty: " + queue.isEmpty());
        try { queue.dequeue(); } catch (EmptyCollectionException e) { System.out.println("Expected: " + e.getMessage()); }
    }
}
