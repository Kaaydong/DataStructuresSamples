// 
//  Name:   Hung, Kayden
//  Project:  #4 
//  Due:        12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    TreeInterface which describes all required Tree methods

public interface TreeInterface<T>
{

	/** Gets the data if the root of the tree. 
	 * @return T, object that represents data of
	 * root node
	*/
	public T getRootData();


	/** Gives the height of the tree
	 * @return int, the number of levels the tree is
	 */
	public int getHeight();


	/** Gives the number of nodes in the tree
	 * @return int, the number of nodes in the tree
	 */
	public int getNumberOfNodes();


	/** Tells whether tree is empty
	 * @return boolean, true if tree is empty, false if not
	 */
	public boolean isEmpty();


	/** Clears the tree of all contents */
	public void clear();
}
