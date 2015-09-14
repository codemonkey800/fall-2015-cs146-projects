import java.util.Random;


public class AVLTester 
{
	public static void main(String[] args)
	{
	AVLTree<Integer> avl = new AVLTree<Integer>();
	TreePrinter printer = new TreePrinter(avl);
	
	int min = 10;
	int max = 100;
	
	Random rand = new Random();
	
	for (int i = 0; i < 35; i++)
	{
		avl.insert(rand.nextInt(max - min) + min);
		printer.print("AVL");
	}
	}
	
}
