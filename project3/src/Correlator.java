import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Program that calculates the correlation between
 * two documents.
 *
 * @author Jeremy Asuncion
 * @author Phyllis Lau
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

        DataCount<String>[] count1;
        DataCount<String>[] count2;

        try {
            count1 = WordCount.countWords(args[0], args[1]);
            count2 = WordCount.countWords(args[0], args[2]);
        } catch(IOException e) {
            System.out.println("An error occurred while parsing the files!");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nDifference metric: " + differenceMetric(count1, count2));

    }
    
    /**
     * Gets the total count of words in the document
     * 
     * @param dataCounts Array holding all of document's words and counts
     * @return The total count
     */
    private static int getTotalCount(DataCount<String>[] dataCounts) {
        int totalWords = 0;
        for(DataCount<String> dataCount : dataCounts) {
            totalWords += dataCount.count;
        }
        return totalWords;
    }
    
    /**
     * Finds the frequency of all words in a document and removes all not useful frequencies
     * 
     * @param dataCounts Array holding all of document's words and counts
     * @return A map holding words and their frequencies
     */
    private static Map<String, Double> frequency(DataCount<String>[] dataCounts) {
        double totalCount = (double) getTotalCount(dataCounts);
        Map<String, Double> frequencies = new HashMap<>();
        for(DataCount<String> dataCount : dataCounts) {
            double frequency = (double) dataCount.count / totalCount;
            if(frequency < 0.01 && frequency > 0.0001) {
                System.out.format("%s - %f\n", dataCount.data, frequency);
                frequencies.put(dataCount.data, frequency);
            }
        }
        return frequencies;
    }
    
    /**
     * Gets the difference metric between the two documents
     * 
     * @param c1 An array holding the first document's words and their frequencies
     * @param c2 An array holding the second document's words and their frequencies
     * @return The difference metric
     */
    private static double differenceMetric(DataCount<String>[] c1, DataCount<String>[] c2) {
        System.out.println("Frequencies for first file:");
        Map<String, Double> frequencies1 = frequency(c1);

        System.out.println("\nFrequencies for second file:");
        Map<String, Double> frequencies2 = frequency(c2);

        double sum = 0;
        for(String key : frequencies1.keySet()) {
            if(frequencies2.containsKey(key)) {
                double diff = Math.abs(frequencies1.get(key) - frequencies2.get(key));
                sum += diff * diff;
            }
        }
        return sum;
    }
}
