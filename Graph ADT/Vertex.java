
// 
//  Name:   Hung, Kayden 
//  Project:  #5
//  Due:        12/9/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Vertex implementation that stores vertex label and list of connection edges
// 

import java.util.Iterator;
import java.util.ArrayList;

public class Vertex<T> implements VertexInterface<T>
{
	private T label;
	private ArrayList<Edge> edgeList;
	private boolean visited;
	private Vertex<T> previousVertex;


	/** Constructor that takes in a label
	 * @param label, the label being set as the key of the vertex
	 */
	public Vertex(T label)
	{
		this.label = label;
		edgeList = new ArrayList<Edge>();
		visited = false;
		previousVertex = null;
	}


	public T getLabel()
	{
		return label;
	}


	public void visit()
	{
		visited = true;
	}


	public void unvisit()
	{
		visited = false;
	}


	public boolean isVisited()
	{
		return visited;
	}


	public boolean connect(VertexInterface<T> endVertex, int edgeWeight)
	{
		Edge newEdge = new Edge(endVertex, edgeWeight);
		edgeList.add(newEdge);

		return true;
	}


	public boolean disconnect(VertexInterface<T> endVertex)
	{
		int i = 0;
		boolean found = false;
		while(i < edgeList.size() && !found)
		{
			if(edgeList.get(i).vertex.getLabel().equals(endVertex.getLabel()))
			{
				edgeList.remove(i);
				found = true;
				return true;
			}
		}
		
		return false;
	}


	public int getEdgeWeight(VertexInterface<T> neighbor)
	{
		for(int i = 0; i < edgeList.size(); i++)
		{
			if(edgeList.get(i).vertex.equals(neighbor))
			{
				return edgeList.get(i).weight;
			}
		}

		return -1;
	}


	public Iterator<VertexInterface<T>> getNeighborIterator()
	{
		ArrayList<VertexInterface<T>> neighborList = new ArrayList<>();
		Iterator<Edge> listIterator = edgeList.iterator();
		while(listIterator.hasNext())
		{
			neighborList.add(listIterator.next().vertex);
		}

		return neighborList.iterator();
	}


	public Iterator<Integer> getWeightIterator()
	{
		ArrayList<Integer> weightList = new ArrayList<>();
		Iterator<Edge> listIterator = edgeList.iterator();
		while(listIterator.hasNext())
		{
			weightList.add(listIterator.next().weight);
		}

		return weightList.iterator();
	}


	public boolean hasNeighbor()
	{
		return !(edgeList.size() == 0);
	}


	public VertexInterface<T> getUnvisitedNeighbor()
	{
		Iterator<VertexInterface<T>> neighborList = getNeighborIterator();

		VertexInterface<T> neighbor = null;
		boolean found = false;
		while(neighborList.hasNext() && !found)
		{
			neighbor = neighborList.next();
			if(!neighbor.isVisited())
			{
				found = true;
				return neighbor; 
			}
		}

		return null;
	}


	public void setPredecessor(VertexInterface<T> predecessor)
	{
		previousVertex = (Vertex<T>)predecessor;
	}


	public VertexInterface<T> getPredecessor()
	{
		return previousVertex;
	}


	public boolean hasPredecessor()
	{
		return !(previousVertex == null);
	}



	private class Edge
	{
		private VertexInterface<T> vertex;
		private int weight;

		public Edge(VertexInterface<T> endVertex, int edgeWeight)
		{
			vertex = endVertex;
			weight = edgeWeight;
		}
	}
}
