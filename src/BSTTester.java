import java.util.Random;


public class BSTTester 
{
	public static void main(String[] args)
	{
	
	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	TreePrinter printer = new TreePrinter(bst);
	
	
	int min = 10;
	int max = 100;
	
	Random rand = new Random();
	
	while (bst.height() <=5 )
	{
		bst.insert(rand.nextInt(max - min) + min);
		printer.print("BST");
	}
	
	
	}
}
