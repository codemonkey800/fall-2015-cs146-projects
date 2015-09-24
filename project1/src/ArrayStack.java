import java.util.EmptyStackException;

/**
 * Implementation of a stack using arrays.
 *
 * @see DStack
 * @author Jeremy Asuncion
 */
public class ArrayStack implements DStack {
    private static final int DEFAULT_SIZE = 10;

    private double[] stack;
    private int size = 0;

    /**
     * Constructs an ArrayStack with a default array size of 10.
     */
    public ArrayStack() {
        stack = new double[DEFAULT_SIZE];
    }

    /**
     * Checks if the stack is empty
     *
     * @return True if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Pushes a new item on the top of the stack
     *
     * @param d The item to push onto the stack
     */
    @Override
    public void push(double d) {
        if(size == stack.length) {
            resize(stack.length * 2);
        }
        stack[size++] = d;
    }

    /**
     * Pops the current item at the top off the stack and returns
     * it.
     *
     * @return The item currently at the top of the stack
     */
    @Override
    public double pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        double d = stack[--size];

        if(size <= (int) (stack.length * 0.25)) {
            resize(stack.length / 2);
        }

        return d;
    }

    /**
     * Pops and returns the current item on the top of the stack
     *
     * @return The current item on the top of the stack
     */
    @Override
    public double peek() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        return stack[size - 1];
    }

    /**
     * Resizes the underlying array to a new size.
     *
     * @param newSize The new size of the array
     */
    private void resize(int newSize) {
        if(newSize == 0) {
            newSize = 1;
        }

        double[] newStack = new double[newSize];

        int itemCount = (stack.length > newSize) ? newSize : stack.length;

        for(int i = 0; i < itemCount; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        newStack = null;
    }
}
