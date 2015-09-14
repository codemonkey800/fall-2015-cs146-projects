/**
 * An implementation of a binary search tree
 */
public class BinarySearchTree<T extends Comparable<T>>
{
    protected BinaryNode<T> root;

    /**
     * Constructs an empty tree
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * Inserts new data into the tree
     *
     * @param data The data to insert
     */
    public void insert(T data)
    {
        if(root == null)
        {
            root = new BinaryNode<>(data);
        }
        else
        {
            BinaryNode<T> node = root;
            boolean inserted = false;
            while(!inserted)
            {
                if(node.getData().compareTo(data) > 0)
                {
                    if(node.getLeft() == null)
                    {
                        node.setLeft(new BinaryNode<>(data));
                        inserted = true;
                    }
                    else
                    {
                        node = node.getLeft();
                    }
                }
                else
                {
                    if(node.getRight() == null)
                    {
                        node.setRight(new BinaryNode<>(data));
                        inserted = true;
                    }
                    else
                    {
                        node = node.getRight();
                    }
                }
            }
        }
    }

    /**
     * Determines if a certain value is inside the tree
     *
     * @param data The data to find
     * @return True if the tree has the data ,false otherwise
     */
    public boolean contains(T data)
    {
        BinaryNode<T> node = root;
        while(node != null && node.getData().compareTo(data) != 0)
        {
            if(node.getData().compareTo(data) > 0)
            {
                node = node.getLeft();
            }
            else
            {
                node = node.getRight();
            }
        }
        return node == null;
    }

    /**
     * Removes data from the tree if it exists
     *
     * @param data The data to remove
     * @return The data removed, or null if it didn't exist
     */
    public T remove(T data)
    {
        BinaryNode<T> node = remove(root, data);
        return node == null ? null : node.getData();
    }

    public T getMinimum()
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            BinaryNode<T> node = root;
            while(node.getLeft() != null)
            {
                node = node.getLeft();
            }
            return node.getData();
        }
    }

    public T getMaximum()
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            BinaryNode<T> node = root;
            while(node.getRight() != null)
            {
                node = node.getRight();
            }
            return node.getData();
        }
    }

    /**
     * Returns the root of the tree
     *
     * @return The root
     */
    public BinaryNode<T> getRoot()
    {
        return root;
    }

    /**
     * Removes the root of the tree
     * @return The data of the root node
     */
    public T removeRoot() {
        return remove(root.getData());
    }

    /**
     * Returns the height of the tree
     *
     * @return The height
     */
    public int height()
    {
        return height(root);
    }

    /**
     * Prints the contents of the tree in order
     */
    public void printInOrder()
    {
        printInOrder(root);
    }

    /**
     * Prints the contents of the tree in reverse order
     */
    public void printReverseOrder()
    {
        printReverseOrder(root);
    }

    /**
     * Prints the contents of the tree in pre order
     */
    public void printPreOrder()
    {
        printPreOrder(root);
    }

    /**
     * Prints the contents of the tree in post order
     */
    public void printPostOrder()
    {
        printPostOrder(root);
    }

    /**
     * Recursive helper method for printing the contents of the tree
     * in order
     *
     * @param root The root of the tree
     */
    protected void printInOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
            printInOrder(root.getLeft());
            System.out.println(root.getData());
            printInOrder(root.getRight());
        }
    }

    /**
     * Recursive helper method for printing the contents
     * of the tree in reverse order
     *
     * @param root The root of the tree
     */
    protected void printReverseOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
            printReverseOrder(root.getRight());
            System.out.println(root.getData());
            printReverseOrder(root.getLeft());
        }
    }

    /**
     * Recursive helper method for printing the
     * contents of the tree in pre order
     *
     * @param root The root of the tree
     */
    protected void printPreOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
            System.out.println(root.getData());
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }
    }

    /**
     * Recursive helper method for printing the contents
     * of the tree in post order
     *
     * @param root The root of the tree
     */
    protected void printPostOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    /**
     * Recursive helper method that returns the height of the tree
     *
     * @param root The root of the tree
     * @return The height
     */
    protected int height(BinaryNode<T> root)
    {
        if(root == null)
        {
            return -1;
        }
        else
        {
            return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
        }
    }

    /**
     * Recursive helper method that removes the data from the
     * tree if it exists
     *
     * @param root The tree to remove the data from
     * @param data The data to remove
     * @return The node removed
     */
    protected BinaryNode<T> remove(BinaryNode<T> root, T data)
    {
        if(root == null)
        {
            return null;
        }

        int compareResult = root.getData().compareTo(data);

        if(compareResult > 0) {
            root.setLeft(remove(root.getLeft(), data));
        } else if(compareResult < 0) {
            root.setRight(remove(root.getRight(), data));
        } else if(root.getLeft() != null && root.getRight() != null) {
            BinaryNode<T> minNode = root.getRight();
            while(minNode.getLeft() != null) {
                minNode = minNode.getLeft();
            }

            root.setData(minNode.getData());
            root.setRight(remove(root.getRight(), minNode.getData()));
        } else {
            root = root.getLeft() != null ? root.getLeft() : root.getRight();
        }

        return root;
    }
}
