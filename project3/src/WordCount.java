/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order.
 */
public class WordCount {
    private static DataCounter<String> wordCounter;

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage: [-b | -a | -h] [-frequency | -num_unique] <filename>\n");
            System.out.println("-b - Use an Unbalanced BST");
            System.out.println("-a - Use an AVL Tree");
            System.out.println("-h - Use a Hashtable\n");
            System.out.println("-frequency - Print all the word/frequency pairs, " +
                               "ordered by frequency, and then by the words in" +
                               "lexicographic order.");
            System.out.println("-num_unique - Print the number of unique words in the document. " +
                               "This is the total number of distinct (different) words in the document. " +
                               "Words that appear more than once are only counted as a single word for " +
                               "this statistic");
            return;
        }

        switch(args[0]) {
            case "-b":
                wordCounter = new BinarySearchTree<>();
                break;
            case "-a":
                wordCounter = new AVLTree<>();
                break;
            case "-h":
                wordCounter = new HashTable();
                break;
            default:
                System.out.println("Invalid choice for first argument");
                return;
        }
    }
}
