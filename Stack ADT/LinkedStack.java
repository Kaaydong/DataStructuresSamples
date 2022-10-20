// 
//  Name:   Hung, Kayden 
//  Project:  #3
//  Due:        10/19/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    LinkedStack class which implements the StackInterface and uses Nodes in a linear fashion 
//    to store and link data similar to linked sets.  

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
	
	private Node topNode;	

	/** Default constructor : Does nothing but setup LinkedStack object */
	public LinkedStack()
	{}

	public void push(T entry)
	{
		Node currentNode = topNode;
		Node newNode = new Node(entry);

		topNode = newNode;
		topNode.nodeBelow = currentNode;
	}


	public T pop() throws EmptyStackException
	{
		if(topNode == null)
		throw new EmptyStackException();

		Node currentNode = topNode;
		topNode = currentNode.nodeBelow;

		T data = currentNode.data;

		currentNode.data = null;
		currentNode.nodeBelow = null;
		currentNode = null;

		return data;
	}


	public T peak() throws EmptyStackException
	{
		if(topNode == null)
		throw new EmptyStackException();
		
		return topNode.data;
	}


	public boolean isEmpty()
	{
		return topNode == null;
	}


	public void clear()
	{
		Node nextNode;

		while(topNode != null)
		{
			nextNode = topNode.nodeBelow;

			topNode.data = null;
			topNode.nodeBelow = null;
			topNode = null;

			topNode = nextNode;
		}
	}

	

	private class Node
	{
		private T data;
		private Node nodeBelow;

		public Node(T data)
		{
			this(data,null);
		}

		public Node(T data, Node nodeBelow)
		{
			this.data = data;
			this.nodeBelow = nodeBelow;
		}
	}
}