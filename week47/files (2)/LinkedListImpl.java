/** Concrete implementation: only the two needed methods are implemented. */
public class LinkedListImpl<T> extends LinkedList<T> {
    @Override
    public void add(T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        if (isEmpty()) head = node;
        else tail.setNext(node);
        tail = node;
        count++;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new EmptyCollectionException("list");
        return tail.getElement();
    }
}
