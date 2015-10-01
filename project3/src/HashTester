
public class HashTester
{
	public static void main(String[] args)
	{
		HashTable hash = new HashTable(100);
		hash.incCount("bob");
		hash.incCount("hello");
		hash.incCount("bob");
		hash.incCount("bob");
		hash.incCount("hello");
		hash.incCount("java");
		hash.incCount("data");
		
		for (DataCount d: hash.getCounts())
		{
			System.out.println(d);
		}
		
		
		System.out.println("Expected: 4");
		System.out.println("Actual: " + hash.getSize());
		
	}
}
