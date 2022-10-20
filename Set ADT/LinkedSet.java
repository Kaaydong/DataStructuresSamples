// 
//  Name:   Hung, Kayden 
//  Project:  #2 
//  Due:        10/7/2022 
//  Course:  cs-2400-02
// 
//  Description: 
//    LinkedSet class which implements the SetInterface so sets can be used and created
//     Includes private Node class used to store objects in the set

public class LinkedSet<T> implements SetInterface<T> 
{
	private Node firstNode;
	private int numberOfEntries;

	/** Default Constructor: Takes no parameters and initializes a blank LinkedSet */
	public LinkedSet()
	{
		firstNode = null;
		numberOfEntries = 0;
	}

	public int getCurrentSize()
	{
		return numberOfEntries;
	}

	public boolean isEmpty()
	{
		return numberOfEntries==0;
	}

	public boolean add(T data)
	{
		if(contains(data))
		{
			return false;
		}
		else{
			Node newNode = new Node(data);
			newNode.nextNode = firstNode;
			firstNode = newNode;
			numberOfEntries++;

			return true;
		}
		
	}

	public T remove()
	{
		T data = firstNode.data;

		if(numberOfEntries == 0)
		{
			return null;
		}
		else
		{
			Node newFirst = firstNode.nextNode;
			firstNode.data = null;
			firstNode.nextNode = null;
			firstNode = null;

			firstNode = newFirst;
			numberOfEntries--;
			return data;
		}
	}

	public boolean remove(T item)
	{
		Node reference = getReference(item);

		if(reference == null)
		{
			return false;
		}
		else{

			T currentNodeData = firstNode.data;

			firstNode.data = reference.data;
			reference.data = currentNodeData;
			
			remove();
			return true;
		}

	}

	private Node getReference(T item)
	{
		Node currentNode = firstNode;

		while(currentNode!=null)
		{
			if(currentNode.data.equals(item))
			{
				return currentNode; 
			}
			else
			{
				currentNode = currentNode.nextNode;
			}
		}

		return null;
	}

	public void clear()
	{
		while(!isEmpty())
		{
			remove();
		}
	}

	public int getFrequencyOf(T item)
	{
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[numberOfEntries];
		array = toArray();
		int counter = 0;

		for(int i = 0; i < numberOfEntries; i++)
		{
			if(array[i].equals(item))
			{
				counter++;
			}
		}

		return counter;
	}

	public boolean contains(T item)
	{
		Node currentNode = firstNode;
		while(currentNode != null)
		{
			if(currentNode.data.equals(item))
			{
				return true;
			}
			else
			{	
				currentNode = currentNode.nextNode;
			}
		}

		return false;
	}

	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[numberOfEntries];
		
		Node currentNode = firstNode;
		for(int i = 0; i < numberOfEntries; i++)
		{
			array[i] = currentNode.data;
			currentNode = currentNode.nextNode;
		}

		return array;
	}

	public boolean subset(SetInterface rhs)
	{
		Node currentNode = firstNode;

		while(currentNode != null)
		{
			if(rhs.contains(currentNode.data))
			{
				currentNode = currentNode.nextNode;
			}
			else
			{
				return false;
			}
		}

		return true;
	}

	public boolean equals(SetInterface rhs)
	{
		return subset(rhs) && rhs.subset(this); 
	}

	// public SetInterface union(SetInterface rhs)
	// {
	// 	SetInterface<T> c = new LinkedSet<>();
	// 	Node currentNode = firstNode;

	// 	while(currentNode != null)
	// 	{
	// 		if(rhs.contains(currentNode.data))
	// 		{
	// 			c.add(currentNode.data);
	// 		}

	// 		currentNode = currentNode.nextNode;
	// 	}

	// 	return c;
	// }

	public String toString()
	{
		if(numberOfEntries == 0)
		{
			return "";
		}
		else 
		{
			String outputString = "";
			Node currentNode = firstNode.nextNode;
			
			outputString = "{" + firstNode.data + "}"; 

			while(currentNode != null)
			{
				outputString = outputString + " {} {" + currentNode.data + "}";
				currentNode = currentNode.nextNode;
			}

			return outputString;
		}
	}

private class Node
{
	private T data;
	private Node nextNode;

	private Node(T data)
	{
		this(data,null);
	}

	private Node(T data, Node nextNode)
	{
		this.data = data;
		this.nextNode = nextNode;
	}
}

}