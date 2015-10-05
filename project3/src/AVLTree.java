/**
 * Implementation of an AVL Tree
 *
 * @author Jeremy Asuncion
 * @author Phyllis Lau
 */

public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void incCount(E data) {
        super.incCount(data);
        overallRoot = balance(overallRoot);
    }

    /**
     * Balances a subtree {@code root}. Rotations are repeatedly done
     * until the {@code root}'s left and right subtrees differ by
     * at most 1.
     *
     * @param root The root of the subtree
     * @return The new root of the subtree
     */
    private BSTNode balance(BSTNode root) {
        if(root.left == null && root.right == null) {
            return root;
        }

        int heightDiff;
        do {
            heightDiff = height(root.left) - height(root.right);

            if(heightDiff > 1) {
                if(height(root.left.left) >= height(root.left.right)) {
                    root = singleRightRotation(root);
                } else {
                    root = doubleLeftRightRotation(root);
                }
            } else if(heightDiff < 1) {
                if(height(root.right.right) >= height(root.right.left)) {
                    root = singleLeftRotation(root);
                } else {
                    root = doubleRightLeftRotation(root);
                }
            }
        } while(heightDiff > 1 && heightDiff < -1 && root != null);

        return root;
    }

    /**
     * Performs a single left rotations on the subtree {@code root}.
     *
     * @param root The root of the subtree
     * @return The new root of the subtree
     */
    private BSTNode singleLeftRotation(BSTNode root) {
        BSTNode right = root.right;
        root.right = right.left;
        right.left = root;
        return right;
    }

    /**
     * Performs a single right rotation on the subtree {@code root}.
     *
     * @param root The root of the subtree
     * @return The new root of the subtree
     */
    private BSTNode singleRightRotation(BSTNode root) {
        BSTNode left = root.left;
        root.left = left.right;
        left.right = root;
        return left;
    }

    /**
     * Performs a left then right rotation on the subtree {@code root}.
     *
     * @param root The root of the subtree
     * @return The new root of the subtree
     */
    private BSTNode doubleLeftRightRotation(BSTNode root) {
        root.left = singleLeftRotation(root.left);
        return singleRightRotation(root);
    }

    /**
     * Performs a right then left rotation on the subtree {@code root}.
     *
     * @param root The root of the subtree
     * @return The new root of the subtree
     */
    private BSTNode doubleRightLeftRotation(BSTNode root) {
        root.right = singleRightRotation(root.right);
        return singleLeftRotation(root);
    }
}
