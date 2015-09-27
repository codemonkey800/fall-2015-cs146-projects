

/**
 * TODO Replace this comment with your own.
 * 
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable implements DataCounter<String> {
	private Node[] array; 
	
	private int currentSize;
	 
	public HashTable(int arraySize)
	{
		array = new Node[arraySize];
		currentSize = 0;
		
	}
	
		class Node 
		{
			public String data;
			public int count;
			public Node next;
			
			public Node(String data)
			{
				this.data = data;
				this.count = 1;
			}
		}
	
    /** {@inheritDoc} */
	
    public DataCount<String>[] getCounts() 
    {
    	DataCount<String>[] dataArray = new DataCount[currentSize];
    	int countForArray = 0;
    	for (int i = 0; i < array.length; i++)
    	{
    		if (array[i] != null)
    		{
    		Node n = array[i];
    		DataCount stuff = new DataCount(n.data, n.count);
    		
    		dataArray[countForArray] = stuff;
    		countForArray++;
    		while (n.next != null)
    		{
    			if (!n.data.equals(n.next.data))
    			{
    				
    			
    				dataArray[countForArray] = new DataCount(n.next.data, n.next.count);
    				countForArray++;
    			}
    			n = n.next;
    		}
    		}
    	}

    	return dataArray;
    }

    /** {@inheritDoc} */
    
    public int getSize() {
       return currentSize;
    }

    /** {@inheritDoc} */
   
    public void incCount(String data) 
    {
    	int h = hashcode(data);
    	Node n = new Node(data);
    	Node current = array[h];
    	
    		while (current != null)
    		{
    			if (current.data.equals(data))
    			{
    				current.count++;
    				return;
    			}
    			current = current.next;
    		}
    		n.next = array[h];
    		array[h] = n;
    		currentSize++;
    		
    	}
    		
    
    public int hashcode(String data)
    {
    	final int multiplier = 29;
    	int sum = 0;
    	for (int i = 0; i< data.length(); i++)
    	{
    		sum = sum + data.charAt(i) * multiplier;
    	}
    	
    	return sum % array.length;
    
    }
    
    public boolean contains(String data)
    {
    	int h = hashcode(data);
    	Node n = array[h];
    	while (n != null)
    	{
    		if (n.data.equals(data))
    		{
    			
    			return true;
    			
    		}
    		n = n.next;
    	}
    	return false;	
    }
    
//    public boolean equals(String otherData)
//    {
//    	
//    
//    }

}
