// 
//  Name:   Hung, Kayden
//  Project:  #4 
//  Due:        12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    BinaryTree interface which extends the TreeInterface and TreeIteratorInterface
//	and adds the setRootData method and setTree methods

public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T>
{
	/** Sets the data of the root node 
	 * @param rootData, the object being set as the data for root of tree
	*/
	public void setRootData(T rootData);


	/** Sets the overall structure of the tree 
	 * @param rootData, the object being set as the data for root of tree
	 * @param leftTree, left child of root of tree
	 * @param rightTree, right child of root of tree
	*/
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);

}
