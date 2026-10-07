// StackDemo.java
public class StackDemo {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();

        // isEmpty, size on a new stack
        System.out.println("isEmpty: " + stack.isEmpty());       // true
        System.out.println("size: " + stack.size());             // 0

        // push
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("After pushes: " + stack);            // [top] C B A
        System.out.println("size: " + stack.size());             // 3

        // peek (does not remove)
        System.out.println("peek: " + stack.peek());             // C
        System.out.println("size after peek: " + stack.size());  // 3

        // contains
        System.out.println("contains B: " + stack.contains("B")); // true
        System.out.println("contains Z: " + stack.contains("Z")); // false

        // pop
        System.out.println("pop: " + stack.pop());               // C
        System.out.println("After pop: " + stack);               // [top] B A
        System.out.println("size: " + stack.size());             // 2
        System.out.println("isEmpty: " + stack.isEmpty());       // false

        // clear
        stack.clear();
        System.out.println("After clear: " + stack);             // [top]
        System.out.println("isEmpty: " + stack.isEmpty());       // true
        System.out.println("size: " + stack.size());             // 0

        // Exception 1: caught
        try {
            stack.peek();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Exception 2: uncaught, ends the program with a stack trace
        stack.pop();
    }
}
