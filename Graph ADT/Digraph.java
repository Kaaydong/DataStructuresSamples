
// 
//  Name:   Hung, Kayden 
//  Project:  #5
//  Due:        12/9/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Directed Graph implementation which stores and traverses Vertexs
// 

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Stack;

public class Digraph<T> implements GraphInterface<T>
{

	private DictionaryInterface<T, VertexInterface<T>> dictionary;
	private int vertexCount;

	private Stack<VertexInterface<T>> traversalStack;

	

	public Digraph()
	{
		dictionary = new MapDictionary<>();
		traversalStack = new Stack<>();

	}

	
	public boolean addVertex(T vertexLabel)
	{
		if(checkLabel(vertexLabel))
		{
			return false;
		}

		VertexInterface<T> vertex = new Vertex(vertexLabel);
		dictionary.add(vertexLabel, vertex);
		vertexCount++;

		return true;
	}


	public boolean addEdge(T start, T end, int edgeWeight)
	{
		if(!checkLabel(start) || !checkLabel(end))
		{
			return false;
		}

		VertexInterface<T> startVertex = dictionary.getValue(start);
		startVertex.connect(dictionary.getValue(end), edgeWeight);

		dictionary.add(start, startVertex);

		return true;
	}


	public boolean removeEdge(T start, T end)
	{
		if(!checkLabel(start) || !checkLabel(end))
		{
			return false;
		}

		VertexInterface<T> startVertex = dictionary.getValue(start);
		startVertex.disconnect(dictionary.getValue(end));

		dictionary.add(start, startVertex);

		return true;
	}


	public boolean hasEdge(T start, T end)
	{
		VertexInterface<T> startVertex = dictionary.getValue(start);
		Iterator<VertexInterface<T>> iterator = startVertex.getNeighborIterator();

		while(iterator.hasNext())
		{
			if(iterator.next().getLabel().equals(end))
			{
				return true;
			}
		}

		return false;
	}


	public boolean isEmpty()
	{
		return vertexCount == 0;
	}

	
	public void clear()
	{
		dictionary.clear();
		vertexCount = 0;
		traversalStack.clear();
	}


	public Stack<VertexInterface<T>> returnTraversalStack()
	{
		return traversalStack;
	}


	public int getCheapestPath(T originLabel, T endLabel)
	{
		VertexInterface<T> origin = dictionary.getValue(originLabel);
		VertexInterface<T> end = dictionary.getValue(endLabel);

		return getCheapestPath(origin, end);
	}


	private int getCheapestPath(VertexInterface<T> originVertex, VertexInterface<T> endVertex)
	{
		boolean done = false;
		traversalStack.clear();

		PriorityQueue<PathNodes> vertexQueue = new PriorityQueue<>();
		vertexQueue.add(new PathNodes(originVertex, null, 0));

		PathNodes frontEntry = null;
		VertexInterface<T> frontVertex = null;
		while(!done && !vertexQueue.isEmpty())
		{
			frontEntry = vertexQueue.poll();
			frontVertex = frontEntry.currentVertex;

			if(!frontVertex.isVisited())
			{
				frontVertex.visit();
				frontVertex.setPredecessor(frontEntry.previousVertex);
				if(frontVertex.equals(endVertex))
				{
					done = true;
				}
				else
				{
					Iterator<VertexInterface<T>> iterator = frontVertex.getNeighborIterator(); 

					while(iterator.hasNext())
					{
						VertexInterface<T> nextNeighbor = iterator.next();
						int edgeWeight = frontVertex.getEdgeWeight(nextNeighbor);

						if(!nextNeighbor.isVisited())
						{
						//	nextNeighbor.visit();
							int nextCost = edgeWeight + frontEntry.totalCost;
							vertexQueue.add(new PathNodes(nextNeighbor, frontVertex, nextCost));
						}

					//	nextNeighbor = frontVertex.getUnvisitedNeighbor();
					}
				}
			}
		}

		unvisitAllNodes();
		int pathCost = frontEntry.totalCost;
		traversalStack.push(frontVertex);

		T match1 = endVertex.getLabel();
		T match2 = frontVertex.getLabel();
		if(!match1.equals(match2))
		{
			return 0;
		}

		while(frontVertex.hasPredecessor())
		{
			frontVertex = frontVertex.getPredecessor();
			traversalStack.push(frontVertex);
		}

		return pathCost;
	}


	private void unvisitAllNodes()
	{
		Iterator<T> iterator = dictionary.getKeyIterator();
		while(iterator.hasNext())
		{
			T label = iterator.next();
			VertexInterface<T> vertex = dictionary.getValue(label);
			vertex.unvisit();
			dictionary.add(label, vertex);
		}
	}


	private boolean checkLabel(T label) 	// returns true if label exists
	{
		Iterator<T> iterator = dictionary.getKeyIterator();
		while(iterator.hasNext())
		{
			if(iterator.next().equals(label))
			{
				return true;
			}
		}

		return false;
	}


	private class PathNodes implements Comparable<PathNodes>
	{
		VertexInterface<T> currentVertex;
		VertexInterface<T> previousVertex;
		int totalCost;

		public PathNodes(VertexInterface<T> currentVertex, VertexInterface<T> previousVertex, int totalCost)
		{
			this.currentVertex = currentVertex;
			this.previousVertex = previousVertex;
			this.totalCost = totalCost;
		}

		@Override
			public int compareTo(PathNodes pathNode)
			{
				if(this.totalCost > pathNode.totalCost)
				{
					return 1;
				}
				else if(this.totalCost < pathNode.totalCost)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
	}
}