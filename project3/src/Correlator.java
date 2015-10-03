import java.io.IOException;
import java.util.HashMap;

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

        System.out.println("Difference metric: " + differenceMetric(count1, count2));

    }

    private static int getTotalCount(DataCount<String>[] count) {
        int totalWords = 0;
        for(DataCount<String> c : count) {
            totalWords += c.count;
        }
        System.out.println("total words: " + totalWords);
        return totalWords;

    }

//    private static DataCount<String>[] frequency(DataCount<String>[] count)
//    {
//    	int index = 0;
//    	DataCount<String>[] frequencies = wordCounter.getCounts();
//    	for (int i  = 0; i < count.length; i++)
//    	{
//    		double freq = count[i].count/(getTotalCount(count));
//    		System.out.println("frequency for " + count[i].toString() + ": fraction - " + freq);
//    		if (freq < 0.01 && freq > 0.0001)
//    		{
//    			frequencies[index] = count[i];
//    			//frequencies[index].data = count[i].data;
//    			frequencies[index].count = (int) freq;
//    			index++;
//    		}
//    	}	
//    	for (DataCount<String> f :frequencies)    
//    	{
//    		System.out.print(f.count + " ");
//    	}
//    	return frequencies;	
//}


    private static HashMap<String, Double> frequency(DataCount<String>[] count) {
        int index = 0;
        int totalCount = getTotalCount(count);
        System.out.println(totalCount);
        HashMap<String, Double> frequencies = new HashMap<>();
        for(int i = 0; i < count.length; i++) {
            System.out.println(count[i].count);

            double freq = (double) count[i].count / (double) totalCount;
            System.out.println("frequency for " + count[i].toString() + ": fraction - " + freq);
            if(freq < 0.01 && freq > 0.0001) {
                frequencies.put(count[i].data, freq);
                //frequencies[index].data = count[i].data;


            }
        }
        for(String f : frequencies.keySet()) {
            System.out.print(frequencies.get(f) + " ");
        }
        return frequencies;
    }

//    private static double differenceMetric(DataCount<String>[] c1, DataCount<String>[] c2)
//    {
//    	double sum = 0;
//    	DataCount<String>[] freq1 = frequency(c1);
//		DataCount<String>[] freq2 = frequency(c2);
//    	for (int i = 0; i < freq1.length; i++)
//    	{
//    		for (int j = 0; j < freq2.length; j++)
//    		{
//    			if (freq1[i].data == freq2[j].data)
//    			{
//    				
//    				double diff = Math.abs(freq1[i].count - freq2[j].count);
//    				sum += diff*diff;
//    			}
//    		}
//    	}
//    	return sum;
//    }

    private static double differenceMetric(DataCount<String>[] c1, DataCount<String>[] c2) {
        double sum = 0;
        HashMap<String, Double> freq1 = frequency(c1);
        HashMap<String, Double> freq2 = frequency(c2);
        for(String f : freq1.keySet()) {
            for(String fr : freq2.keySet()) {
                if(f.equals(fr)) {

                    double diff = Math.abs(freq1.get(f) - freq2.get(fr));
                    sum += diff * diff;
                }
            }
        }
        return sum;
    }
}
