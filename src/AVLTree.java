/**
 * An implementation of an AVL tree
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>
{
    BinaryNode<T> root;


    public AVLTree()
    {
        root = null;
    }

    public BinaryNode<T> insert(T data, BinaryNode<T> d)
    {
        super.insert(data);
        return balance(d);
    }

    public BinaryNode<T> balance(BinaryNode<T> r)
    {
        if(r == null)
        {
            return null;
        }

        if(height(r.getLeft()) - height(r.getRight()) > 1)
        {
            if(height(r.getLeft().getLeft()) >= height(r.getLeft().getRight()))
            {
                r = singleRightRotation(r);
            }
            else
            {
                r = doubleLeftRightRotation(r);
            }
        }
        else if(height(r.getRight()) - height(r.getLeft()) > 1)
        {
            if(height(r.getRight().getRight()) >= height(r.getRight().getLeft()))
            {
                r = singleLeftRotation(r);
            }
            else
            {
                r = doubleRightLeftRotation(r);
            }
        }
        return r;

    }

    //single rotation on left child
    public BinaryNode<T> singleRightRotation(BinaryNode<T> b)
    {
        BinaryNode<T> a = b.getLeft();
        b.setLeft(a.getRight());
        a.setRight(b);
        System.out.println("Single right rotation: " + b.getData());
        return a;

    }

    //single rotation on right child
    public BinaryNode<T> singleLeftRotation(BinaryNode<T> b)
    {
        BinaryNode<T> c = b.getRight();
        b.setRight(c.getLeft());
        c.setLeft(b);
        System.out.println("Single left rotation: " + b.getData());
        return c;

    }

    //double rotation on left child
    public BinaryNode<T> doubleLeftRightRotation(BinaryNode<T> c)
    {
        System.out.println("Double left-right rotation: " + c.getData());
        c.setLeft(singleLeftRotation(c.getLeft()));
        return singleRightRotation(c);
    }

    //double rotation on right child
    public BinaryNode<T> doubleRightLeftRotation(BinaryNode<T> a)
    {
        System.out.println("Double right-left rotation: " + a.getData());
        a.setRight(singleRightRotation(a.getRight()));
        return singleLeftRotation(a);
    }


    public BinaryNode<T> remove(T data, BinaryNode<T> d)
    {
        super.remove(data);
        return balance(d);
    }


}
