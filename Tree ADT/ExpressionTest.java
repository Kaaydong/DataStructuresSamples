// 
//  Name:   Hung, Kayden
//  Project:  #4 
//  Due:        12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Tester for ExpressionTree and BinaryTree classes
//

import java.util.Iterator;

public class ExpressionTest
{
	public static void main(String[] args)
	{
		ExpressionTree tree = new ExpressionTree(args[0]);

		System.out.println("Expression Tree by K. Hung\n");
		System.out.println("Input: " + args[0]);
		System.out.println("Value: " + tree.evaluate() + "\n");		// ExpressionTree Test (REQUIRED IO)

		System.out.println("Postorder Traversal:");
		tree.postorder();



		System.out.println("\n");
		System.out.println(tree.getRootData());
		System.out.println(tree.getHeight());
		System.out.println(tree.getNumberOfNodes());		// Test TreeInterface Methods
		System.out.println(tree.isEmpty());
		tree.clear();
		System.out.println(tree.isEmpty() + "\n");



		tree = new ExpressionTree(args[0]);
		printIterator(tree.getPreorderIterator());
		printIterator(tree.getInorderIterator());			// Test TreeIteratorInterface Methods
		printIterator(tree.getPostorderIterator());
		printIterator(tree.getLevelOrderIterator());
		


		tree.setRootData("*");
		System.out.println("\n" + tree.evaluate());

		tree = new ExpressionTree(args[0]);
		ExpressionTree testTree = new ExpressionTree("1 3 +");			// Test BinaryTreeInterface Methods
		testTree.setTree("*",tree,tree);
		System.out.println("\n" + testTree.getNumberOfNodes());
		printIterator(testTree.getPostorderIterator());
		System.out.println(testTree.evaluate());
		
	}

	
	public static void printIterator(Iterator<String> iterator)		// Output contents of Iterator into single line
	{
		while(iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}