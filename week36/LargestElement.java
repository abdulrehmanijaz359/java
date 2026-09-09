import java.util.Random;

public class LargestElement {

    public static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Small fixed test
        int[] arr = {34, 12, 89, 45, 67, 23, 90, 11};
        System.out.println("Largest: " + findLargest(arr));

        // Larger random test
        int size = 1_000_000;
        int[] bigArr = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            bigArr[i] = rnd.nextInt(1_000_000);
        }

        long start = System.nanoTime();
        int largest = findLargest(bigArr);
        long end = System.nanoTime();

        System.out.println("Largest of " + size + " elements: " + largest);
        System.out.println("Time taken: " + (end - start) / 1_000_000.0 + " ms");
    }
}