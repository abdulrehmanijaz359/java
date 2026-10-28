public class QueueDriver {
    public static void main(String[] args) {
        CircularArrayQueue<Integer> q = new CircularArrayQueue<>(3);
        System.out.println("isEmpty: " + q.isEmpty() + ", size: " + q.size());

        q.enqueue(4); q.enqueue(1); q.enqueue(8);
        System.out.println(q + " size: " + q.size());       // [4, 1, 8] size: 3

        System.out.println("first: " + q.first());          // 4
        System.out.println("dequeue: " + q.dequeue());      // 4
        q.enqueue(2);                                       // forces wrap-around
        System.out.println(q + " size: " + q.size());       // [1, 8, 2] size: 3

        q.enqueue(5);                                       // forces expandCapacity
        System.out.println(q + " size: " + q.size());       // [1, 8, 2, 5] size: 4

        while (!q.isEmpty()) System.out.println("dequeue: " + q.dequeue());
        System.out.println("isEmpty: " + q.isEmpty() + ", size: " + q.size());

        try { q.dequeue(); }
        catch (java.util.NoSuchElementException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}