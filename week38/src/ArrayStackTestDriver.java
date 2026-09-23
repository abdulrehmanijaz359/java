import jsjf.ArrayStack;
import jsjf.exceptions.EmptyCollectionException;

/**
 * Exercises every method of ArrayStack<T> and prints the results so
 * their correctness can be checked from the console output (or by
 * stepping through with a debugger). Also deliberately triggers
 * EmptyCollectionException to show the exception-handling path works.
 */
public class ArrayStackTestDriver {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        System.out.println("=== Newly created stack ===");
        System.out.println("isEmpty(): " + stack.isEmpty());   // expect true
        System.out.println("size():    " + stack.size());      // expect 0
        System.out.println("toString(): " + stack);            // expect []

        System.out.println("\n=== push(10), push(20), push(30) ===");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("toString(): " + stack);            // expect [10, 20, 30]
        System.out.println("size():    " + stack.size());      // expect 3
        System.out.println("isEmpty(): " + stack.isEmpty());   // expect false

        System.out.println("\n=== peek() ===");
        try {
            System.out.println("peek() returned: " + stack.peek()); // expect 30
            System.out.println("toString() after peek (unchanged): " + stack);
        } catch (EmptyCollectionException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        System.out.println("\n=== pop() ===");
        try {
            int popped = stack.pop();
            System.out.println("pop() returned: " + popped);   // expect 30
            System.out.println("toString() after pop: " + stack); // expect [10, 20]
            System.out.println("size():    " + stack.size());  // expect 2
        } catch (EmptyCollectionException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        System.out.println("\n=== forcing the array to grow (push past default capacity) ===");
        ArrayStack<Integer> smallStack = new ArrayStack<>(2); // tiny capacity to prove growth works
        smallStack.push(1);
        smallStack.push(2);
        smallStack.push(3); // triggers expandCapacity() internally
        System.out.println("toString(): " + smallStack);      // expect [1, 2, 3]
        System.out.println("size():    " + smallStack.size()); // expect 3

        System.out.println("\n=== emptying the stack completely ===");
        while (!stack.isEmpty()) {
            System.out.println("popped: " + stack.pop());
        }
        System.out.println("isEmpty(): " + stack.isEmpty());   // expect true
        System.out.println("size():    " + stack.size());      // expect 0
        System.out.println("toString(): " + stack);            // expect []

        System.out.println("\n=== causing EmptyCollectionException on pop() ===");
        try {
            stack.pop();
        } catch (EmptyCollectionException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("\n=== causing EmptyCollectionException on peek() ===");
        try {
            stack.peek();
        } catch (EmptyCollectionException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}

