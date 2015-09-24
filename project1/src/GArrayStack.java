import java.util.EmptyStackException;
import java.util.Objects;

/**
 * Generic stack implementation using Arrays
 *
 * @see GStack
 * @author Jeremy Asuncion
 */
public class GArrayStack<T> implements GStack<T> {
    private static final int DEFAULT_SIZE = 10;

    private Object[] stack;
    private int      size;

    public GArrayStack() {
        stack = new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T item) {
        if(stack.length == size) {
            resize(stack.length * 2);
        }

        stack[size++] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        Object item = stack[--size];

        if(size <= (int) (stack.length * 0.25)) {
            resize(stack.length / 2);
        }

        return (T) item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        return (T) stack[size - 1];
    }

    private void resize(int newSize) {
        if(newSize == 0) {
            newSize = 1;
        }

        Object[] newStack = new Object[newSize];

        int itemCount = (stack.length > newSize) ? newSize : stack.length;

        for(int i = 0; i < itemCount; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        newStack = null;
    }
}
