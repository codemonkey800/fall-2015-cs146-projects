import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order.
 *
 * @author Jeremy Asuncion
 * @author Phllis Lau
 */
public class WordCount
{
    private static final int QUICK_SORT_CUTOFF = 15;

    public static void main(String[] args)
    {
        if(args.length != 3)
        {
            System.out.println("Usage: [-b | -a | -h] [-is | -qs | -ms] <filename>\n");
            System.out.println("-b - Use an Unbalanced BST");
            System.out.println("-a - Use an AVL Tree");
            System.out.println("-h - Use a Hashtable\n");
            System.out.println("-is - Sorts using insertion sort");
            System.out.println("-qs - Sorts using quick sort");
            System.out.println("-ms - Sorts using merge sort");
            return;
        }

        try
        {
            switch(args[1])
            {
                case "-is":
                    countWordFrequencies(countWords(args[0], args[2]), WordCountQS::insertionSort);
                    break;
                case "-qs":
                    countWordFrequencies(countWords(args[0], args[2]), WordCountQS::quickSort);
                    break;
                case "-ms":
                    countWordFrequencies(countWords(args[0], args[2]), WordCountQS::mergeSort);
                    break;
                default:
                    System.out.println("Invalid choice for second argument");
                    break;
            }
        }
        catch(IOException e)
        {
            System.out.println("An error occurred when parsing the file!:");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Counts the words in a document.
     *
     * @return An array of data couns
     * @throws IOException Thrown if there's an exception wile reading
     */
    public static DataCount<String>[] countWords(String dataStructure, String filename) throws IOException
    {
        FileWordReader fileWordReader = new FileWordReader(filename);
        DataCounter<String> wordCounter;

        switch(dataStructure)
        {
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
                wordCounter = new BinarySearchTree<>();
                System.out.println("Invalid data structure. Using BST by default.");
                break;
        }

        String word;
        while((word = fileWordReader.nextWord()) != null)
        {
            wordCounter.incCount(word);
        }

        return wordCounter.getCounts();
    }

    /**
     * Prints the word counts given an array of data counts.
     *
     * @param dataCounts Data counts
     * @param <E>        Some type
     */
    private static <E> void printWordCounts(DataCount<E>[] dataCounts)
    {
        Arrays.stream(dataCounts)
              .forEach(count -> {
                  System.out.format("%d %s\n", count.count, count.data);
              });
    }

    /**
     * Counts the word frequencies in a document and lists them
     * first by frequency, then lexicographically.
     */
    private static void countWordFrequencies(DataCount<String>[] dataCounts,
                                             BiConsumer<DataCount<String>[], Comparator<DataCount<String>>> sortingFunc)
    {
        sortingFunc.accept(dataCounts, (count1, count2) -> count2.count - count1.count);

        System.out.println("Ordered by Frequency:");
        printWordCounts(dataCounts);

        sortingFunc.accept(dataCounts, (count1, count2) -> count1.data.compareTo(count2.data));

        System.out.println("\nOrdered Lexicographically:");
        printWordCounts(dataCounts);
    }

    /**
     * Prints the number of unique words in a document.
     */
    private static void countUniqueWords(DataCount<String>[] dataCounts)
    {
        System.out.println("Unique words: " + dataCounts.length);
    }

    /**
     * Convenience method for sorting an array of data counts using quick sort and a
     * comparator.
     *
     * @param dataCounts The array of data counts
     * @param comparator The comparator to compare data counts
     * @param <E>        Some type
     * @see #insertionSort(DataCount[], int, int, Comparator)
     */
    private static <E> void insertionSort(DataCount<E>[] dataCounts, Comparator<DataCount<E>> comparator)
    {
        insertionSort(dataCounts, 0, dataCounts.length - 1, comparator);
    }

    /**
     * Implementation of insertion sort. Sorts an array of data counts using a comparator
     * over the range {@code [low, high]} within the array, where 0 <= low <= high < n.
     *
     * @param dataCounts The array of data counts
     * @param low        The lower bound
     * @param high       The upper bound
     * @param comparator The comparator to compare data counts
     * @param <E>        Some type
     */
    private static <E> void insertionSort(DataCount<E>[] dataCounts,
                                          int low, int high,
                                          Comparator<DataCount<E>> comparator)
    {
        for(int i = low + 1; i <= high; i++)
        {
            DataCount<E> key = dataCounts[i];
            int j = i - 1;
            while(j >= 0 && comparator.compare(key, dataCounts[j]) < 0)
            {
                dataCounts[j + 1] = dataCounts[j--];
            }
            dataCounts[j + 1] = key;
        }
    }
    
    /**
     * Implementation of quick sort. Sorts an array of data counts using a comparator
     * @param dataCounts The array of data counts
     * @param comparator The comparator to compare data
     */
    private static <E> void quickSort(DataCount<E>[] dataCounts, Comparator<DataCount<E>> comparator) {
 
  
    	sort(dataCounts, 0, dataCounts.length-1, comparator);
    
    }
    
    private static <E> void sort(DataCount<E>[] dataCounts, int left, int right, Comparator<DataCount<E>> comparator)
    {
    	if (left <= right)
    	{
    		return;
    	}
    	
    	if (left + right > QUICK_SORT_CUTOFF) 
    	{
    		int i = left;
    		int j = right+1;
    		DataCount<E> pivot = dataCounts[left];
    		while (true)
    		{
    		while (comparator.compare(dataCounts[++i], pivot) < 0)
    			{
    				if (i == right)
    					break;
    				}
    		while (comparator.compare(pivot, dataCounts[--j]) > 0)
    		{
    			if (j == left)
    				break;
    		}
    		
    		if (i >= j)
    		{
    			break;
    		}
    		
    		DataCount<E> toSwap = dataCounts[i];
    		dataCounts[i] = dataCounts[j];
    		dataCounts[j] = toSwap;
    		}
    		
    		DataCount<E> toSwapPivot = dataCounts[left];
    		dataCounts[left] = dataCounts[j];
    		dataCounts[j] = toSwapPivot;
    	}
    	
    	else
    	{
    		insertionSort(dataCounts, left, right, comparator);
    	}
    }

    /**
     * Implementation of merge sort algorithm. Sorts an array of data counts
     * using a comparator.
     *
     * @param dataCounts The array of data counts
     * @param comparator The comparator to compare data counts
     * @param <E>        Some type
     */
    private static <E> void mergeSort(DataCount<E>[] dataCounts, Comparator<DataCount<E>> comparator)
    {
        if(dataCounts.length > 1)
        {
            int mid = dataCounts.length / 2;
            DataCount<E>[] left = Arrays.copyOfRange(dataCounts, 0, mid);
            DataCount<E>[] right = Arrays.copyOfRange(dataCounts, mid, dataCounts.length);

            mergeSort(left, comparator);
            mergeSort(right, comparator);
            merge(dataCounts, left, right, comparator);
        }
    }

    /**
     * Merges the left and right data counts back into the original array.
     * It's assumed that {@code left + right = dataCounts}.
     *
     * @param dataCounts The original array
     * @param left       The left side of the original array
     * @param right      The right side of the original array
     * @param comparator The comparator to compare data counts
     * @param <E>        Some type
     */
    private static <E> void merge(DataCount<E>[] dataCounts,
                                  DataCount<E>[] left, DataCount<E>[] right,
                                  Comparator<DataCount<E>> comparator)
    {
        int i = 0, j = 0;
        for(int k = 0; k < dataCounts.length; k++)
        {
            if(i < left.length && j < right.length)
            {
                if(comparator.compare(left[i], right[j]) <= 0)
                {
                    dataCounts[k] = left[i++];
                }
                else
                {
                    dataCounts[k] = right[j++];
                }
            }
            else if(i < left.length)
            {
                dataCounts[k] = left[i++];
            }
            else if(j < right.length)
            {
                dataCounts[k] = right[j++];
            }
        }
    }
}
