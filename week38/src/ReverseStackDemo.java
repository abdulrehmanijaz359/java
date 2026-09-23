import java.util.Scanner;
import java.util.Stack;

/**
 * Demonstrates how a LIFO stack naturally reverses the order of a
 * sequence of elements: whatever goes in last comes out first.
 *
 * Example with the five integers 12, 23, 1, 45, 9:
 *
 *  push 12 -> [12]
 *  push 23 -> [12, 23]
 *  push 1  -> [12, 23, 1]
 *  push 45 -> [12, 23, 1, 45]
 *  push 9  -> [12, 23, 1, 45, 9]   <- 9 is now on top
 *
 *  pop -> 9
 *  pop -> 45
 *  pop -> 1
 *  pop -> 23
 *  pop -> 12
 *
 * Reading the popped values in order gives: 9, 45, 1, 23, 12
 * i.e. the original order reversed.
 */
public class ReverseStackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] numbers = {12, 23, 1, 45, 9};

        System.out.print("Enter 5 integers separated by spaces (or press Enter to use the default 12 23 1 45 9): ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.hasNextLine() ? scanner.nextLine().trim() : "";

        if (!line.isEmpty()) {
            String[] parts = line.split("\\s+");
            numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
        }

        System.out.print("Original order: ");
        for (int n : numbers) {
            System.out.print(n + " ");
            stack.push(n);
        }
        System.out.println();

        System.out.print("Reversed order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        scanner.close();
    }
}