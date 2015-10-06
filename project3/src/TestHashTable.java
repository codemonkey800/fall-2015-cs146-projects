/**
 * Unit tests for the hashtable {@code DataCounter}.
 *
 * @author Jeremy Asuncion
 * @author Phyllis Lau
 */
public class TestHashTable {
    public static void main(String[] args) {
        HashTable hash = new HashTable(10);
		
		String[] data = {"bob", "hello there", "bob", "bob", "hello there", "javadoc", "data structures","hello there",
				"javadoc", "dumbo", "computer science", "project3", "computer science", "project3", "phyllislau", "jeremy", "phyllislau", "dumbo"};
			
		DataCount d = new DataCount("hello there", 3);
		DataCount d1 = new DataCount("bob", 3);
		DataCount d2 = new DataCount("jeremy", 1);
		DataCount d3 = new DataCount("computer science", 2);
		DataCount d4 = new DataCount("project3", 2);
		DataCount d5 = new DataCount("javadoc", 2);
		DataCount d6 = new DataCount("data structures", 1);
		DataCount d7 = new DataCount("dumbo", 2);
		DataCount d8 = new DataCount("phyllislau", 2);
	
		
		DataCount[] expected = {d, d1, d2, d3, d4, d5, d6, d7, d8};

		
		for (String s: data)
		{
			hash.incCount(s);
			
		}
	
		boolean error = false;
		int k = 0;
		for(DataCount c: hash.getCounts())
		{
			if (!c.equals(expected[k]))
			{
				error = false;
				break;
			}
			k++;
		}
		if (error)
		{
			System.out.println("Test failed");
			
		}
		else
		{
			System.out.println("Test passed");
		}

    }
}
