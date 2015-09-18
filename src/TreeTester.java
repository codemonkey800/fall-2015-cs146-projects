import java.util.Random;

public class TreeTester
{

    public static void main(String[] args) throws Exception
    {
        if(args.length == 0)
        {
            System.out.println("Usage 1: java TreeTester part1 bst|avl");
            System.out.println("Usage 2: java TreeTester part2 n k");
            System.out.println("n is used for insertion, k is used for search");
            return;
        }

        switch(args[0])
        {
            case "part1":
                switch(args[1])
                {
                    case "bst":
                        testBST();
                        break;
                    case "avl":
                        testAVL();
                        break;
                }

                break;

            case "part2":
                timeTrees(Integer.parseInt(args[1]),
                          Integer.parseInt(args[2]));
                break;
        }
    }

    private static void testBST()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();


        int min = 10;
        int max = 100;

        Random rand = new Random();

        while(bst.height() < 5)
        {
            bst.insert(rand.nextInt(max - min) + min);
            new TreePrinter(bst).print("BST");
        }

        while(!bst.isEmpty())
        {
            bst.remove(bst.getRoot().getData());
            new TreePrinter(bst).print("Removing Root BST");
        }
    }

    private static void testAVL() throws Exception
    {
        AVLTree<Integer> avl = new AVLTree<>(true);

        int min = 10;
        int max = 100;

        Random rand = new Random();

        for(int i = 0; i < 35; i++)
        {
            avl.insert(rand.nextInt(max - min) + min);
            if(!avl.isBalanced())
            {
                throw new Exception("Tree is not balanced after insertion");
            }
            new TreePrinter(avl).print("AVL Tree");
        }

        while(!avl.isEmpty())
        {
            avl.remove(avl.getRoot().getData());
            if(!avl.isBalanced())
            {
                throw new Exception("Tree is not balanced after removal");
            }
            new TreePrinter(avl).print("Removing Root AVL Tree");
        }
    }

    private static void timeTrees(int n, int k)
    {
        Random rand = new Random();
        int    min  = 0, max = 1000;

        int[] randomInts         = new int[n];
        int[] randomIntsToSearch = new int[k];

        for(int i = 0; i < n; i++) {
            randomInts[i] = rand.nextInt(max - min) + min;
            if(i < k) {
                randomIntsToSearch[i] = rand.nextInt(max - min) + min;
            }
        }

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AVLTree<Integer> avl = new AVLTree<>();

        double result = timeRunnable(() -> {
            for(int val : randomInts) {
                bst.insert(val);
            }
        });

        System.out.println("BST Insertion Time: " + result + "ms");

        result = timeRunnable(() -> {
            for(int val : randomInts) {
                avl.insert(val);
            }
        });

        System.out.println("AVL Insertion Time: " + result + "ms");

        result = timeRunnable(() -> {
            for(int val : randomIntsToSearch) {
                bst.contains(val);
            }
        });

        System.out.println("BST Search Time: " + result + "ms");

        result = timeRunnable(() -> {
            for(int val : randomIntsToSearch) {
                avl.contains(val);
            }
        });

        System.out.println("AVL Search Time: " + result + "ms");
    }

    private static double timeRunnable(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000.0;
    }
}
