// 
//  Name:   Hung, Kayden 
//  Homework: #1 
//  Due:      9/26/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    JavaKeywords class to test out BagInterface and ArrayBag programs 
// 

import java.io.File;
import java.util.Scanner;

public class JavaKeywords
{
	public static void main(String[] args)
	{
		BagInterface<String> bag = new ArrayBag<>();

		System.out.println("Java Keywords by K. Hung\n");
		System.out.println(args.length + " Java Keywords loaded.\n");


		File file = new File("javakeywords.txt");
		try
		{
		Scanner scanner = new Scanner(file);

		while(scanner.hasNextLine())
		{
			bag.add(scanner.nextLine());
		}

		scanner.close();
		}
		catch(Exception e)
		{
			System.out.println("Error with file");
			e.printStackTrace();
		}


		for(String input : args)
		{
			if(bag.contains(input))
			{
				System.out.println(input + " is a keyword");
			}
			else
			{
				System.out.println(input + " is not a keyword");
			}
		}
		System.out.println();


		// Test Demonstration
		BagInterface<String> bagTest = new ArrayBag<>(2);
		System.out.println("Was Cat Added Successfully: " + bagTest.add("Cat"));
		bagTest.add("Dog");
		bagTest.add("Fish");
		bagTest.add("Rat");
		bagTest.add("Raccoon");
		bagTest.add("Rat");
		bagTest.add("Human");

		System.out.println("Current Size: " + bagTest.getCurrentSize());
		System.out.println("Is Bag Empty: " + bagTest.isEmpty());
		System.out.println("Item Removed: " + bagTest.remove());
		System.out.println("Was Item Raccoon Removed: " + bagTest.remove("Raccoon"));
		System.out.println("Frequency of Rat: " + bagTest.getFrequencyOf("Rat"));
		System.out.println("Does Bag Contain Human: " + bagTest.contains("Human"));

		bagTest.clear();
		System.out.println("Bag is now cleared, Size is: " + bagTest.getCurrentSize());
		
		Object[] stringArray = bagTest.toArray();
	}
}