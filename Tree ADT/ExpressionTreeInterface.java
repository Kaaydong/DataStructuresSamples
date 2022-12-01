// 
//  Name:   Hung, Kayden
//  Project:  #4 
//  Due:        12/2/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Interface for ExpressionTree that extends all methods of BinaryTreeInterface<Strings>
//	and adds evaluate and postorder methods 

public interface ExpressionTreeInterface extends BinaryTreeInterface<String>
{
	/** Outputs the calculation of a math expression which can only
	 * have integers and the binary operations of +, -, *, /
	 * @return double, the calculation of math expression
	*/
	public double evaluate();


	/** Prints out the contents of the extended 
	 * binary tree in the postorder form
	*/
	public void postorder();
}