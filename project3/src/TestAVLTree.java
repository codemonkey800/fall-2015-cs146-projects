/**
 * Tests the AVL Tree implementation.
 */
public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        for(int i = 0; i < 100; i++) {
            avlTree.incCount(i);
        }

    }
}
