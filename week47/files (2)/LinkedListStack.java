/** PP 6.1: stack stored in a LinkedList object. The top of the stack is the END of the list. */
public class LinkedListStack<T> implements StackADT<T> {
    private LinkedList<T> list = new LinkedListImpl<T>();

    public void push(T element) { list.add(element); }

    public T pop() {
        if (list.isEmpty()) throw new EmptyCollectionException("stack");
        return list.removeLast();
    }

    public T peek() {
        if (list.isEmpty()) throw new EmptyCollectionException("stack");
        return list.getLast();
    }

    public boolean isEmpty() { return list.isEmpty(); }
    public int size() { return list.size(); }
    public String toString() { return list.toString(); }
}
