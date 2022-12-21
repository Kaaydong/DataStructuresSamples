
// 
//  Name:   Hung, Kayden 
//  Project:  #5
//  Due:        12/9/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Vertex Interface for Vertex implementation
// 

import java.util.Iterator;

public interface VertexInterface<T>
{
	/** Returns label of vertex
	 * @return the label of vertex
	 */
	public T getLabel();
	
	/** Marks the vertex as visited */
	public void visit();

	/** Marks the vertex as not visted */
	public void unvisit();

	/** Checks if vertex is visted
	 * @return true if vertex is visited, false if not
	 */
	public boolean isVisited();

	/** Creates edge between this node and endVertex 
	 * @param endVertex, vertex being connected with
	 * @param edgeWeight, weight of the connection with endVertex
	 * @return true if connection was successful, false if not
	*/
	public boolean connect(VertexInterface<T> endVertex, int edgeWeight);

	/** Deletes edge between this node and endVertex
	 * @param endVertex, vertex being disconnected with
	 * @return true if disconnection was successful, false if not
	 */
	public boolean disconnect(VertexInterface<T> endVertex);

	/** Gets the weight of edge between this vertex and neighbor
	 * @param neighbor, the vertex which edge weight is being found with
	 * @return the edge weight of edge between this and neighbor, returns 0 if no edge exists
	 */
	public int getEdgeWeight(VertexInterface<T> neighbor);

	/** Returns iterator of all neighbor vertices
	 * @return iterator containing all neighbor verticies
	 */
	public Iterator<VertexInterface<T>> getNeighborIterator();

	/** Returns iterator of all edge weights
	 * @return iterator containing all edge weights between neighbor verticies
	 */
	public Iterator<Integer> getWeightIterator();

	/** Returns whether this vertex has a neighbor
	 * @return true if this has neighbors, false if not
	 */
	public boolean hasNeighbor();

	/** Returns a neighbor marked as unvisited
	 * @return neighbor vertex that is marked as unvisited
	 */
	public VertexInterface<T> getUnvisitedNeighbor();

	/** Sets the predecessor of this vertex
	 * @param predecessor, the vertex being set as this vertex's predescessor
	 */
	public void setPredecessor(VertexInterface<T> predecessor);

	/** Returns the predecessor of this vertex
	 * @return vertex that is predecessor
	 */
	public VertexInterface<T> getPredecessor();

	/** Returns whether this vertex has a predecessor
	 * @return true if there is a predecessor, false if not
	*/
	public boolean hasPredecessor();
}