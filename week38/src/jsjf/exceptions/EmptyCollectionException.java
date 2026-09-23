package jsjf.exceptions;

/**
 * EmptyCollectionException is thrown when an operation is attempted
 * on a collection (e.g. a stack) that has no elements.
 */
public class EmptyCollectionException extends RuntimeException {

    /**
     * Creates a new exception, naming the type of collection that
     * caused the problem, e.g. "Stack".
     *
     * @param collection the name of the collection that is empty
     */
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
}