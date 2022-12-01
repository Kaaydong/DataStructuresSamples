// 
//  Name:   Hung, Kayden
//  Project:  #4 
//  Due:        12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    TreeIteratorInterface which describes all required Iterators
// 

import java.util.Iterator;

public interface TreeIteratorInterface<T>
{
	/** Gives the Iterator of tree in preorder form
	 * @return Iterator<T>, iterator that contains data of tree
	 * in preorder form
	 */
	public Iterator<T> getPreorderIterator();


	/** Gives the Iterator of tree in postorder form
	 * @return Iterator<T>, iterator that contains data of tree
	 * in postorder form
	 */
	public Iterator<T> getPostorderIterator();


	/** Gives the Iterator of tree in inorder form
	 * @return Iterator<T>, iterator that contains data of tree
	 * in inorder form
	 */
	public Iterator<T> getInorderIterator();


	/** Gives the Iterator of tree in level order form
	 * @return Iterator<T>, iterator that contains data of tree
	 * in level order form
	 */
	public Iterator<T> getLevelOrderIterator();
}
