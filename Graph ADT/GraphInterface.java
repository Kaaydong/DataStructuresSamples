
// 
//  Name:   Hung, Kayden 
//  Project:  #5
//  Due:        12/9/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Graph Interface for required graph methods
// 

import java.util.Stack;

public interface GraphInterface<T>
{
	/** Adds a vertex to the graph
	 * @param vertexLabel, the label of the vertex being added
	 * @return true if the vertex was added, false if label exists
	 */
	public boolean addVertex(T vertexLabel);

	/** Adds an edge between two verticies
	 * @param start, the starting vertex
	 * @param end, the neighbor vertex
	 * @param edgeWeight, the weight of the edge connection
	 * @return true if the connection was made, false if not
	 */
	public boolean addEdge(T start, T end, int edgeWeight);

	/** Removes an edge between two verticies
	 * @param start, the starting vertex
	 * @param end, the neighbor vertex
	 * @return true if the connection was removed, false if not
	 */
	public boolean removeEdge(T start, T end);

	/** States whether two verticies has a connection
	 * @oaram start, the starting vertex
	 * @param end, the neighbor vertex
	 * return true if the two verticies have an edge, false if not
	 */
	public boolean hasEdge(T start, T end);

	/** States if graph is empty
	 * @return true if graph is empty, false if not
	 */
	public boolean isEmpty();

	/** Clears the graph and all supporting data */
	public void clear();

	/** Returns the traversal stack built from getCheapestPath method
	 * @return a stack of verticies in the order such that they provide the
	 * shortest path from the input of the getCheapestPath method
	 */
	public Stack<VertexInterface<T>> returnTraversalStack();

	/** Returns the cheapest path between two verticies and builds stack which
	 * can be pushed and display the order of verticies in shortest path
	 * @param originLabel, the start vertex
	 * @param endLabel, the ending vertex
	 * @return the length of the shortests path between verticies, or
	 * returns 0 if path doesn't exist
	 */
	public int getCheapestPath(T originLabel, T endLabel);
}