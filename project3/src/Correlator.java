/**
 * Program that calculates the correlation between
 * two documents.
 */
public class Correlator {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage: [-b | -a | -h] <filename 1> <filename 2>\n");
            System.out.println("-b Use an unbalanced BST in the backend");
            System.out.println("-a Use an AVL Tree in the backend");
            System.out.println("-h Use a Hashtable in the backend");
            return;
        }
    }
}
