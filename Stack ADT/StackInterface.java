// 
//  Name:   Hung, Kayden 
//  Project:  #3
//  Due:        10/19/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Stack ADT which gives directions on what all implementing stacks should do
// 

public interface StackInterface<T>
{
	/** Adds new entry to the stack
	 * @param T, generic object being added to the stack
	 */
	void push(T newEntry);

	/** Removes the top entry from the stack and returns the entry's data 
	 *  @return T, generic object from the entry being removed
	 *  @throws EmptyStackException if the stack is empty when method is called
	 */
	T pop();

	/** Looks at the data of the top entry in the stack
	 * @return T, generic object from the entry on top of stack
	 * @throws EmptyStackException if the stack is empty when method is called
	 */
	T peak();

	/** Returns whether the stack is empty or not
	 * @return boolean, true if stack is empty, false if not
	 */
	boolean isEmpty();

	/** Clears the stack of all entries
	 */
	void clear();
}