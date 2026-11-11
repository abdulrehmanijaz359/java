public class StackDriver {
    public static void main(String[] args) {
        StackADT<String> stack = new LinkedListStack<String>();
        System.out.println("isEmpty: " + stack.isEmpty());
        stack.push("A"); stack.push("B"); stack.push("C");
        System.out.println("After pushing A, B, C: " + stack + " (size " + stack.size() + ")");
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("Now: " + stack + " (size " + stack.size() + ")");
        System.out.println("pop: " + stack.pop());
        System.out.println("isEmpty: " + stack.isEmpty());
        try { stack.pop(); } catch (EmptyCollectionException e) { System.out.println("Expected: " + e.getMessage()); }
    }
}
