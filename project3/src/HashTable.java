/**
 * An implementation of hashtable mapping strings to
 * integers. The hashtable uses separate chaining to
 * for collision reduction.
 *
 * @author Jeremy Asuncion
 * @author Phyllis Lau
 */
public class HashTable implements DataCounter<String> {
    private static final int DEFAULT_BUCKET_COUNT = 16;

    private Node[] buckets;

    private int size;

    public HashTable() {
        this(DEFAULT_BUCKET_COUNT);
    }

    public HashTable(int bucketCount) {
        this.buckets = new Node[bucketCount];
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public DataCount<String>[] getCounts() {
        DataCount<String>[] dataCounts = new DataCount[size];
        int i = 0;
        for(Node node : buckets) {
            for(; node != null; node = node.next) {
                dataCounts[i++] = new DataCount<>(node.data, node.count);
            }
        }
        return dataCounts;
    }

    /**
     * {@inheritDoc}
     */
    public int getSize() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    public void incCount(String data) {
        if(calculateLoadFactor() > 0.75) {
            rehash();
        }
        if(insert(buckets, data)) size++;
    }
    
    /**
     * Helper method to add elements into hashtable
     * 
     * @param buckets An array of nodes
     * @param data The element to add to the hashtable
     * @return Boolean value depending on whether insertion is successful
     */
    private boolean insert(Node[] buckets, String data) {
        int hash = hashString(data) % buckets.length;
        Node node = buckets[hash];
        if(node == null) {
            buckets[hash] = new Node(data);
            return true;
        } else {
            while(node != null && !node.data.equals(data)) {
                node = node.next;
            }

            if(node == null) {
                buckets[hash] = new Node(data, buckets[hash]);
                return true;
            } else {
                node.count++;
                return false;
            }
        }
    }
    
    /**
     * Finding the load factor of the hashtable 
     * 
     * @return the load factor of the hashtable
     */
    private double calculateLoadFactor() {
        return (double) size / (double) buckets.length;
    }

    /**
     * To rehash (create a bigger array of nodes and insert nodes again)
     */
    private void rehash() {
        Node[] buckets = new Node[this.buckets.length * 2];
        for(Node node : this.buckets) {
            for(; node != null; node = node.next) {
                put(buckets, node.data, node.count);
            }
        }
        this.buckets = buckets;
    }
    
    /**
     * Puts data into its corresponding bucket and updates its count
     * 
     * @param buckets The array of nodes
     * @param data The element to insert
     * @param count The element's count
     */
    private void put(Node[] buckets, String data, int count) {
        int hash = hashString(data) % buckets.length;
        Node node = buckets[hash];
        if(node != null) {
            while(node != null && !node.data.equals(data)) {
                node = node.next;
            }
            if(node != null) {
                node.count = count;
            } else {
                buckets[hash] = new Node(data, buckets[hash]);
                buckets[hash].count = count;
            }
        } else {
            buckets[hash] = new Node(data);
            buckets[hash].count = count;
        }

    }

    /**
     * Returns the hash function for inserting elements into hashtable
     * 
     * @param the element to insert
     * @return the index to insert the element 
     */
    private int hashString(String str) {
        final int multiplier = 29;
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) * multiplier;
        }

        return sum;
    }
    
    /**
     * An implementation of a Node
     */
    private class Node {
        private String data;
        private int    count;
        private Node   next;

        public Node(String data) {
            this(data, null);
        }

        public Node(String data, Node next) {
            this.data = data;
            this.count = 1;
            this.next = next;
        }
    }


}
