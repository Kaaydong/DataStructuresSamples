// 
//  Name:   Hung, Kayden
//  Project:  #4 
//  Due:        12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Binary Tree class which implements all methods 
//	in BinaryTreeInterface and extended interfaces

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{

	private BinaryNode<T> rootNode;
	private ArrayList<T> traversalList;


	/** Default constructor that has a null root node */
	public BinaryTree()
	{
		rootNode = null;
		traversalList = new ArrayList<T>();
	}


	/** Constructor that takes in data 
	 * @param data, the object that will be the data 
	 * for the root node
	*/
	public BinaryTree(T data)
	{
		BinaryNode<T> node = new BinaryNode<>(data);
		rootNode = node;
		traversalList = new ArrayList<T>();
	}


	/** Returns the root node
	 * @return BinaryNode<T>, the root node
	 */
	protected BinaryNode<T> getRootNode()
	{
		return rootNode;
	}


	/** Sets the root node to the parameter
	 * @param BinaryNode<T> node, the node being set as 
	 * the root node
	 */
	protected void setRootNode(BinaryNode<T> node)
	{
		clear();
		rootNode = node;
	}


	public T getRootData()
	{
		if(rootNode != null)
		return rootNode.data;
		else
		throw new RuntimeException("Tree is Empty");
	}


	public int getHeight()
	{
		return getHeight(rootNode);
	}

	private int getHeight(BinaryNode<T> node)
	{
		if(node != null)
		{
			int leftHeight = getHeight(node.leftNode);
			int rightHeight = getHeight(node.rightNode);

			if(leftHeight > rightHeight)
			return leftHeight + 1;
			else
			return rightHeight + 1;
		}

		return 0;
	}


	public int getNumberOfNodes()
	{
		return getNumberOfNodes(rootNode);
	}

	private int getNumberOfNodes(BinaryNode<T> node)
	{
		int counter = 0;

		if(node != null)
		{
			counter++;
			counter += getNumberOfNodes(node.leftNode);
			counter += getNumberOfNodes(node.rightNode);
		}

		return counter;
	}


	public boolean isEmpty()
	{
		return getNumberOfNodes() == 0;
	}


	public void clear()
	{
		clearTraversal(rootNode);
		rootNode = null;
		// postorder traversal clear
	}

	private void clearTraversal(BinaryNode node)
	{
		if(node != null)
		{
			clearTraversal(node.leftNode);
			clearTraversal(node.rightNode);
			node.data = null;
			node.leftNode = null;
			node.rightNode = null;
			node = null;
		}
	}


	public void setRootData(T rootData)
	{
		if(!isEmpty())
		rootNode.data = rootData;
	}


	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
	{
		clear();
		rootNode = new BinaryNode<T>(rootData);
		BinaryTree<T> left = (BinaryTree<T>) leftTree;
		BinaryTree<T> right = (BinaryTree<T>) rightTree;

		if(left != null)
		rootNode.leftNode = left.rootNode;

		if(right != null)
		rootNode.rightNode = right.rootNode;
	}


	/*
	 * 	ITERATORS
	 */


	public Iterator<T> getPreorderIterator()
	{
		traversalList.clear();
		traversalList = new ArrayList<T>();

		preorderTraversal(rootNode);

		return traversalList.iterator();
	}

	private void preorderTraversal(BinaryNode<T> node)
	{
		if (node != null)
		{
			traversalList.add(node.data);
			preorderTraversal(node.leftNode);
			preorderTraversal(node.rightNode);
		}

	}


	public Iterator<T> getPostorderIterator()
	{
		traversalList.clear();
		traversalList = new ArrayList<T>();

		postorderTraversal(rootNode);

		return traversalList.iterator();
	}

	private void postorderTraversal(BinaryNode<T> node)
	{
		if (node != null)
		{
			postorderTraversal(node.leftNode);
			postorderTraversal(node.rightNode);
			traversalList.add(node.data);
		}
	}


	public Iterator<T> getInorderIterator()
	{
		traversalList.clear();
		traversalList = new ArrayList<T>();

		inorderTraversal(rootNode);

		return traversalList.iterator();
	}

	private void inorderTraversal(BinaryNode<T> node)
	{
		if (node != null)
		{
			inorderTraversal(node.leftNode);
			traversalList.add(node.data);
			inorderTraversal(node.rightNode);
		}
	}


	public Iterator<T> getLevelOrderIterator()
	{
		traversalList.clear();
		traversalList = new ArrayList<T>();

		int height = getHeight();

		for(int i = 1; i <= height; i++)
		{
			levelOrderTraversal(rootNode, i);
		}

		return traversalList.iterator();
	}

	private void levelOrderTraversal(BinaryNode<T> node, int level)
	{
		if(node != null)
		{
		       if (level == 1)
		       	traversalList.add(node.data);
		       else if (level > 1) {
		       	levelOrderTraversal(node.leftNode, level - 1);
		       	levelOrderTraversal(node.rightNode, level - 1);
	       	}
		}	
	}


	protected class BinaryNode<T>
	{
		T data;
		BinaryNode<T> leftNode;
		BinaryNode<T> rightNode;

		public BinaryNode(T data)
		{
			this(data, null, null);
		}

		public BinaryNode(T data, BinaryNode leftNode, BinaryNode rightNode)
		{
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
}