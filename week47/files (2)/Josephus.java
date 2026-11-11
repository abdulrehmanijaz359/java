import java.util.ArrayList;

/**
 * PP 6.5: Josephus problem with a queue, compared with the ArrayList version.
 * n people stand in a circle; every skip-th person is eliminated until one remains.
 */
public class Josephus {

    /** ArrayList version (as in the chapter): index jumps around the list, remove(index). */
    public static int withArrayList(int n, int skip) {
        ArrayList<Integer> people = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) people.add(i);
        int index = 0;
        while (people.size() > 1) {
            index = (index + skip - 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    /** Queue version: move skip-1 people from front to back, then dequeue the next one. */
    public static int withQueue(QueueADT<Integer> queue, int n, int skip) {
        for (int i = 1; i <= n; i++) queue.enqueue(i);
        while (queue.size() > 1) {
            for (int i = 1; i < skip; i++) queue.enqueue(queue.dequeue());
            queue.dequeue();            // eliminated
        }
        return queue.first();
    }

    private static void time(String name, int n, int skip, java.util.function.IntSupplier run) {
        long t0 = System.nanoTime();
        int winner = run.getAsInt();
        double ms = (System.nanoTime() - t0) / 1e6;
        System.out.printf("  %-18s winner=%-7d %10.2f ms%n", name, winner, ms);
    }

    public static void main(String[] args) {
        int skip = 3;
        // Small sanity check: n=7, skip=3 -> survivor is 4
        System.out.println("n=7, skip=3 -> ArrayList: " + withArrayList(7, 3)
                + ", Queue: " + withQueue(new LinkedQueue<Integer>(), 7, 3));

        for (int n : new int[]{1000, 10000, 50000, 100000}) {
            System.out.println("n = " + n + ", skip = " + skip);
            final int fn = n;
            time("ArrayList", n, skip, () -> withArrayList(fn, skip));
            time("ArrayListQueue", n, skip, () -> withQueue(new ArrayListQueue<Integer>(), fn, skip));
            time("LinkedQueue", n, skip, () -> withQueue(new LinkedQueue<Integer>(), fn, skip));
        }
    }
}
