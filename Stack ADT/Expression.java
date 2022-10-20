// 
//  Name:   Hung, Kayden 
//  Project:  #3
//  Due:        10/19/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//	Expression class which contains a public static method to convert a math infix expression to
// 	a postfix expression and another public static method to calculate the output of a postfix expression

import java.util.EmptyStackException;
import java.util.Arrays; // For debuging

public class Expression
{

	private Expression()
	{
		// Prevents instantiation of Expression object
	}

	/** Converts an infix math expression into a postfix math expression
	 * @param infixExpression, the input infix math expression with all operands, operators,
	 * and delimiters in their own cell in the array
	 * @return postfix expression of the parameter as an array of Strings
	 * @throws EmptyStackException if infixExpression is empty
	 * @throws RunTimeException if infixExpression is unbalanced or contains illegal characters or delimiters like letters
	 */ 
	public static String[] convertToPostfix(String[] infixExpression) throws EmptyStackException
	{
		String[] output = new String[infixExpression.length];

		if(infixExpression.length == 0)
		throw new EmptyStackException();
		else if(!isBalanced(infixExpression))
		throw new RuntimeException("Infix Expression is unbalanced");
		else if(!isNumeric(infixExpression))
		throw new RuntimeException("Infix Contains letters or illegal delimiters");

		StackInterface<String> delimiterStack = new LinkedStack<>();

		int index = 0;
		int outputSize = 0;
		String thisString = "";
		String delimiter = "";
		while((index < infixExpression.length) && infixExpression[index] != null) // 2 * (5 + 2)  -> 2 5 2 + *
		{
			thisString = infixExpression[index];

			if(!delimiterStack.isEmpty())
			delimiter = delimiterStack.peak();
			// System.out.print(delimiter + ":" + thisString); // Debugging

			switch(thisString)
			{
				case "(": case "[": case "{":
				delimiterStack.push(thisString);
				break;


				case ")": case "]": case "}":
				while(!delimiter.equals("(") && !delimiter.equals("[") && !delimiter.equals("{")) // checks for opening delimiter 
				{
					// System.out.println(delimiterStack.peak()); // Debugging
					output[outputSize++] = delimiterStack.pop();
					delimiter = delimiterStack.peak();
					// System.out.println(delimiter); // Debugging
				}
				delimiterStack.pop();
				break;


				case "^":
				delimiterStack.push(thisString);
				break;


				case "+": case "-": case "*": case "/":
				while(!delimiterStack.isEmpty() && !isHigher(thisString, delimiterStack.peak()) && 
				!(delimiterStack.peak().equals("(") || delimiterStack.peak().equals("[") || delimiterStack.peak().equals("{")))
				{
					// System.out.print(delimiterStack.peak()); // Debugging
					output[outputSize++] = delimiterStack.pop();
				}
				delimiterStack.push(thisString);
				break;

				
				default:
				output[outputSize++] = thisString;
				break;
			}

		//	System.out.println(Arrays.toString(output)); // Debugging
			index++;
			delimiter = "";
		}
		while(!delimiterStack.isEmpty())
		{
			output[outputSize++] = delimiterStack.pop();
		}

		return correctArray(output, outputSize);
	}


	/** Calculates the ouput of a postfix math expression
	 * @param postfixExpression, input post fix expression which have its output calculated. Each operand, operator,
	 * and delimiter in postfixExpression should have their own cell in the array
	 * @return the calculated output of the postfixExpression as a double
	 * @throws EmptyStackException if postfixExpression is empty
	 * @throws RuntimeException if postfixExpression contains unpaired operators/missing operands
	 */
	public static double evaluatePostfix(String[] postfixExpression) throws EmptyStackException
	{
		if(postfixExpression.length == 0)
		throw new EmptyStackException();

		StackInterface<String> valueStack = new LinkedStack<>();

		int index = 0;
		String thisString = "";
		while(index < postfixExpression.length)
		{
			thisString = postfixExpression[index];

			switch(thisString)
			{
				case "+": case "-": case "*": case "/": case "^":
				double value1 = Double.parseDouble(valueStack.pop());
				double value2;

				if(!valueStack.isEmpty())
				value2 = Double.parseDouble(valueStack.pop());
				else
				throw new RuntimeException("Input postfix expression is unpaired operator/missing operand"); // Checks for unpaired operators/missing operands
				
				switch(thisString)
				{
					case "+":
					value2 += value1;
					break;

					case "-":
					value2 -= value1;
					break;

					case "*":
					value2 *= value1;
					break;

					case "/":
					value2 /= value1;
					break;

					case "^":
					value2 = Math.pow(value2,value1);
					break;
				}
				valueStack.push(value2+"");
				break;
				
				default: 
				valueStack.push(thisString);
				break;
			}
			index++;
		}

		double output = Double.parseDouble(valueStack.pop());
		
		return output;
	}



	private static boolean isHigher(String thisString, String delimiter) // Checks if left side delimiter is of higher order than parameter delimiter
	{
		if(thisString.equals("+") || thisString.equals("-"))
		{
			return false;
		}
		else if(thisString.equals("*") || thisString.equals("/"))
		{
			if(delimiter.equals("+") || delimiter.equals("-"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(thisString.equals("^"))
		{
			return true;
		}

		return false;
	}



	private static boolean isBalanced(String[] infixExpression) // Checks if ( , [ , and { delimiters are paired properly
	{
		boolean isBalanced = true;
		int index = 0;

		StackInterface<String> delimiterStack = new LinkedStack<>();

		String thisString = "";

		while(isBalanced && (index < infixExpression.length) && infixExpression[index] != null)
		{
			thisString = infixExpression[index];

			switch(thisString){

				case("("): case("["): case("{"):
				delimiterStack.push(thisString);
				break;

				case(")"): case("]"): case("}"):
				if(delimiterStack.isEmpty()){
					return false;
				}
				else{
					switch(delimiterStack.pop())
					{
						case("("):
						if(!thisString.equals(")"))
						return false;
						break;

						case("["):
						if(!thisString.equals("]"))
						return false;
						break;

						case("{"):
						if(!thisString.equals("}"))
						return false;
						break;
					}
				}
				break;
			}
			index++;
		}

		if(delimiterStack.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}



	private static boolean isNumeric(String[] input) // Tests if input expression only has the allowed characters (ie: doesnt have letters)
	{
		for(int i = 0; i < input.length; i++)
		{
			String thisString = input[i];

			switch(thisString)
			{
				case("("): case("["): case("{"): case(")"): case("]"): case("}"):
				case("+"): case("-"): case("*"): case("/"): case("^"):
				break;

				default:
				try{
					Double.parseDouble(thisString);
				}
				catch(RuntimeException e)
				{
					return false;
				}
				break;
			}
		}

		return true;
	}



	private static String[] correctArray(String[] array, int size) //corrects the size of the array
	{
		if(array.length == size)
		{
			return array;
		}
		else{
			String[] output = new String[size];
			for(int i = 0; i < size; i++)
			{
				output[i] = array[i];
			}
			
			return output;
		}
	}
}