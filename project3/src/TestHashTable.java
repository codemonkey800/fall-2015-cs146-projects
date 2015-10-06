/**
 * Unit tests for the hashtable {@code DataCounter}.
 *
 * @author Jeremy Asuncion
 * @author Phyllis Lau
 */
public class TestHashTable {
    public static void main(String[] args) {
        HashTable hash = new HashTable(10);

        String[] data = {"bob", "hello there", "bob", "bob", "hello there", "javadoc", "data structures", "hello there",
                         "javadoc", "dumbo", "computer science", "project3", "computer science", "project3", "phyllislau", "jeremy", "phyllislau", "dumbo"};

        DataCount<String> d = new DataCount<>("hello there", 3);
        DataCount<String> d1 = new DataCount<>("bob", 3);
        DataCount<String> d2 = new DataCount<>("jeremy", 1);
        DataCount<String> d3 = new DataCount<>("computer science", 2);
        DataCount<String> d4 = new DataCount<>("project3", 2);
        DataCount<String> d5 = new DataCount<>("javadoc", 2);
        DataCount<String> d6 = new DataCount<>("data structures", 1);
        DataCount<String> d7 = new DataCount<>("dumbo", 2);
        DataCount<String> d8 = new DataCount<>("phyllislau", 2);


        DataCount[] expected = {d, d1, d2, d3, d4, d5, d6, d7, d8};

        boolean error = false;

        for(String s : data) {
            hash.incCount(s);
        }

        DataCount<String>[] dataCounts = hash.getCounts();
        if(dataCounts.length != expected.length) {
            error = true;
        } else {
            int k = 0;
            for(DataCount<String> c : dataCounts) {
                if(!c.data.equals(expected[k].data) || c.count != expected[k].count) {
                    error = true;
                    break;
                }
                k++;
            }
        }

        if(error) {
            System.out.println("Test failed");
        } else {
            System.out.println("Test passed");
        }

    }
}
