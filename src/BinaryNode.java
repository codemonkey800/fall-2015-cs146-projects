/**
 * A class representing a node in a binary search tree.
 *
 * @param <T> The data type of the node's data
 */
public class BinaryNode<T extends Comparable<T>>
{
    private T             data;
    private int           height;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    /**
     * Constructs a node with no children
     *
     * @param data The data of the node
     * @see #BinaryNode(Comparable, BinaryNode, BinaryNode)
     */
    public BinaryNode(T data)
    {
        this(data, null, null);
    }

    /**
     * Constructs a node with left and right children.
     *
     * @param data  The data of the node
     * @param left  The left child
     * @param right The right child
     */
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    /**
     * Returns the data for this node
     *
     * @return The data
     */
    public T getData()
    {
        return data;
    }

    /**
     * Sets the data of this node
     *
     * @param data The data
     */
    public void setData(T data)
    {
        this.data = data;
    }

    /**
     * Returns the left child for this node
     *
     * @return The left child
     */
    public BinaryNode<T> getLeft()
    {
        return left;
    }

    /**
     * Sets the left child of this node
     *
     * @param left The left child
     */
    public void setLeft(BinaryNode<T> left)
    {
        this.left = left;
    }

    /**
     * The right child for this node
     *
     * @return The right child
     */
    public BinaryNode<T> getRight()
    {
        return right;
    }

    /**
     * Sets the right child of this node
     *
     * @param right The right child
     */
    public void setRight(BinaryNode<T> right)
    {
        this.right = right;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
}
