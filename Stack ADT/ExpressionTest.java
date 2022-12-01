// 
//  Name:   Hung, Kayden 
//  Project:  #3
//  Due:        10/21/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//	Tester which runs all methods in the LinkedStack and Expression class to ensure
// 	all methods are working as intended 

import java.util.Arrays;
import java.util.EmptyStackException;

public class ExpressionTest
{

	public static void main(String[] args)
	{
		String inputArgs = args[0];
		String[] infix = inputArgs.split(" ");
		String[] postfix = Expression.convertToPostfix(infix);
		System.out.println(Expression.evaluatePostfix(postfix));

		System.out.println("\n\nInput Infix Expression: " + Arrays.toString(postfix));

		System.out.println("\n\nTests: by K. Hung\n");

		/////////////////////////////////////////

		StackInterface<Integer> stack1 = new LinkedStack<>();
		System.out.println(stack1.isEmpty());
		try{
			stack1.pop();
		}
		catch(EmptyStackException e)
		{
			System.out.println(e);
		}
		
		stack1.push(40);
		stack1.push(20);
		System.out.println(stack1.peak());
		System.out.println(stack1.pop());
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.pop());
		System.out.println(stack1.isEmpty());

		stack1.push(1);
		stack1.push(3);
		stack1.push(5);
		System.out.println(stack1.isEmpty());
		stack1.clear();
		System.out.println(stack1.isEmpty());

		try{
			stack1.peak();
		}
		catch(EmptyStackException e)
		{
			System.out.println(e);
		}


		System.out.println("\n");
		String[] array1 = "1 + 2 * ( 6 + 4 ) ^ 2 / 5 - 8".split(" ");
		array1 = Expression.convertToPostfix(array1);
		System.out.println(Arrays.toString(array1));
		System.out.println(Expression.evaluatePostfix(array1));


		System.out.println("\n");
		String[] array2 = "{ [ 5 * ( 4 - 1 ) / ( 9 - 2 ) ^ 5 ] + 3 / [ 4 * 8 ] }".split(" "); // Tests a bunch of delimiters and parenthesis/bracket orders
		array2 = Expression.convertToPostfix(array2);
		System.out.println(Arrays.toString(array2));
		System.out.println(Expression.evaluatePostfix(array2));

		array2 = "5 ^ 4 + 9 ^ 3 ^ 2".split(" ");	// Tests carrot operator and big outputs
		array2 = Expression.convertToPostfix(array2);
		System.out.println(Arrays.toString(array2));
		System.out.println(Expression.evaluatePostfix(array2));


		System.out.println("\n");
		String[] array3 = new String[0];	// Tests Empty Array
		try{
			Expression.convertToPostfix(array3);
		}
		catch(EmptyStackException e)
		{
			System.out.println(e);
		}
		try{
			Expression.evaluatePostfix(array3);
		}
		catch(EmptyStackException e)
		{
			System.out.println(e);
		}


		System.out.println("\n");
		String[] array4 = "( 3 + 5 ) * 2 ^ ( 2 + 3 ]".split(" "); // Tests for unmatching bracket pairs
		try{
			Expression.convertToPostfix(array4);
		}
		catch(RuntimeException e)
		{
			System.out.println(e);
		}

		array4 = "[ (3 + 5) * 8".split(" "); // Tests for unpaired bracket delimiters
		try{
			Expression.convertToPostfix(array4);
		}
		catch(RuntimeException e)
		{
			System.out.println(e);
		}
		
		
		System.out.println("\n");
		String[] array5 = "( 3 + 5 ) * 3 +".split(" "); // Tests for missing operand
		array5 = Expression.convertToPostfix(array5);

		System.out.println(Arrays.toString(array5));
		try{
			Expression.evaluatePostfix(array5);
		}
		catch(RuntimeException e)
		{
			System.out.println(e);
		}

		array5 = "( 3 + ) * 5".split(" "); // Tests for missing operand inside closed parenthesis
		try{
			array5 = Expression.convertToPostfix(array5);
			Expression.evaluatePostfix(array5);
		}
		catch(RuntimeException e)
		{
			System.out.println(e);
		}
	}
}