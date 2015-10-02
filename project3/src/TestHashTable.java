
public class TestHashTable {

	public static void main(String[] args)
	{
		HashTable hash = new HashTable(3);
		hash.incCount("bob");
		hash.incCount("hello");
		hash.incCount("bob");
		hash.incCount("bob");
		hash.incCount("hello");
		hash.incCount("java");
		hash.incCount("data");
		hash.incCount("hello");
		hash.incCount("java");
		hash.incCount("data");
		hash.incCount("dumb");
		hash.incCount("hate");
		hash.incCount("what");
		
		
		for (DataCount d: hash.getCounts())
		{
			System.out.println(d);
		}
		
		
		
		
		System.out.println("Expected: 7");
		System.out.println("Actual: " + hash.getSize());
		
	}
}
