import java.util.EmptyStackException;

/**
 * Implementation of a stack using linked lists
 *
 * @see DStack
 * @author Jeremy Asuncion
 */
public class ListStack implements DStack {

    private Node head;

    /**
     * Constructs a new ListStack object with the
     * head of the node being null
     */
    public ListStack() {
        head = null;
    }

    /**
     * Checks if the stack is empty
     *
     * @return True if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Pushes a new item on the top of the stack
     *
     * @param d The item to push onto the stack
     */
    @Override
    public void push(double d) {
        head = new Node(d, head);
    }

    /**
     * Pops the current item at the top off the stack and returns
     * it.
     *
     * @return The item currently at the top of the stack
     */
    @Override
    public double pop() {
        if(head == null) {
            throw new EmptyStackException();
        }

        double d = head.item;
        head = head.next;
        return d;
    }

    /**
     * Pops and returns the current item on the top of the stack
     *
     * @return The current item on the top of the stack
     */
    @Override
    public double peek() {
        if(head == null) {
            throw new EmptyStackException();
        }

        return head.item;
    }

    /**
     * A node in a linked list
     */
    private class Node {
        private double item;
        private Node   next;

        /**
         * Constructs a node with an item but no next field
         *
         * @param item The item to assign to this node
         */
        public Node(double item) {
            this(item, null);
        }

        /**
         * Constructs a node with an item pointing to another node
         *
         * @param item The item to assign to this node
         * @param next The next node in the linked list
         */
        public Node(double item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
