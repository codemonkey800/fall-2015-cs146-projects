import java.util.EmptyStackException;

/**
 * Generic stack implementation using linked lists
 *
 * @see GStack
 * @author Jeremy Asuncion
 */
public class GListStack<T> implements GStack<T> {
    private Node head;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(T item) {
        head = new Node(item, head);
    }

    @Override
    public T pop() {
        if(head == null) {
            throw new EmptyStackException();
        }

        T item = head.item;
        head = head.next;
        return item;
    }

    @Override
    public T peek() {
        if(head == null) {
            throw new EmptyStackException();
        }

        return head.item;
    }

    private class Node {
        private T item;
        private Node next;

        public Node(T item) {
            this(item, null);
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
