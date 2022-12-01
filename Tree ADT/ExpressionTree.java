// 
//  Name:   Hung, Kayden
//  Project:  #4 
//  Due:        12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    ExpressionTree class which extends BinaryTree
//	Contains implementation of ExpressionTreeInterface 

import java.util.Iterator;

public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface
{
	private LinkedStack<BinaryTree<String>> stack;
	private String[] tokenArray;

	/** Constructor that takes in postfix expression 
	 * @param postfix, postfix math expression with tokens
	 * using " " as delimiter
	*/
	public ExpressionTree(String postfix)
	{
		stack = new LinkedStack<>();
		tokenArray = postfix.split(" ");

		createExpressionTree();
	}

	private void createExpressionTree()
	{
		String token = "";

		for(int i = 0; i < tokenArray.length; i++)
		{
			token = tokenArray[i];

			switch(token)
			{
				case "+": case "-": case "*": case "/":

				BinaryTree<String> tempTree = new BinaryTree<>();
				BinaryTree<String> rightTree = stack.pop();
				BinaryTree<String> leftTree = stack.pop();

				tempTree.setTree(token, leftTree, rightTree);

				stack.push(tempTree);
				break;

				default:

				stack.push(new BinaryTree<String>(token));
				break;
			}
		}

		super.setRootNode(stack.pop().getRootNode());
	}


	public double evaluate()
	{
		String token = "";

		Iterator<String> iterator = super.getPostorderIterator();
		LinkedStack<String> tempStack = new LinkedStack<>();
		
		String rightToken = "";
		String leftToken = "";
		double calculation = 0;
		while(iterator.hasNext())
		{
			token = iterator.next();

			switch(token)
			{
				case "+": 
				rightToken = tempStack.pop();
				leftToken = tempStack.pop();
				calculation = Double.parseDouble(leftToken) + Double.parseDouble(rightToken);
				tempStack.push(calculation + "");
				break;
				
				case "-": 
				rightToken = tempStack.pop();
				leftToken = tempStack.pop();
				calculation = Double.parseDouble(leftToken) - Double.parseDouble(rightToken);
				tempStack.push(calculation + "");
				break;

				case "*": 
				rightToken = tempStack.pop();
				leftToken = tempStack.pop();
				calculation = Double.parseDouble(leftToken) * Double.parseDouble(rightToken);
				tempStack.push(calculation + "");
				break;
				
				case "/":
				rightToken = tempStack.pop();
				leftToken = tempStack.pop();
				calculation = Double.parseDouble(leftToken) / Double.parseDouble(rightToken);
				tempStack.push(calculation + "");
				break;


				default:
				tempStack.push(token);
				break;
			}
		}

		return Double.parseDouble(tempStack.pop());

	}


	public void postorder()
	{
		Iterator<String> iterator = super.getPostorderIterator();
		LinkedStack<String> tempStack = new LinkedStack<>();
		String token = "";
		
		while(iterator.hasNext())
		{
			token = iterator.next();

			switch(token)
			{
				case "+": case "-": case "*": case "/":
				String rightToken = tempStack.pop();
				String leftToken = tempStack.pop();
				System.out.println(leftToken + " : " + token + " : " + rightToken);
				tempStack.push(token);
				break;

				default:

				System.out.println(token);
				tempStack.push(token);
				break;
			}
		}
	}
}
