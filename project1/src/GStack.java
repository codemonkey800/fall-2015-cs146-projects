/**
 * Interface for a generic stack
 * 
 * @author Jeremy Asuncion
 */
public interface GStack<T> {
    /**
     * Determines if the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Pushes an item onto the top of the stack
     * @param item The item to push
     */
    void push(T item);

    /**
     * Pops an item off the top of the stack. If the stack
     * is empty, this method throws a {@code EmptyStackException}
     * @return Item from the top of the stack
     * @throws java.util.EmptyStackException
     */
    T pop();

    /**
     * Returns the item off the top of the stack without
     * removing it. If the stack is empty, this method throws a
     * {@code EmptyStackException}
     * @return Item from the top of the stack
     * @throws java.util.EmptyStackException
     */
    T peek();
}
