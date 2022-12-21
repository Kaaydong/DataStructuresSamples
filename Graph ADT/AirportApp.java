
// 
//  Name:   Hung, Kayden 
//  Project:  #5
//  Due:        12/9/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    AirportApp to run program and graphs
// 

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class AirportApp
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Digraph<String> graph = new Digraph<>();
		MapDictionary<String,Airport> airportList = new MapDictionary<>();

		Scanner airportScanner = new Scanner(new File("airports.csv"));
		Scanner distanceScanner = new Scanner(new File("distances.csv"));

		while(airportScanner.hasNext())
		{
			String phrase = airportScanner.nextLine();
			String[] words = phrase.split(",");
			Airport airport = new Airport(words[0], words[1], words[2], words[3]);

			graph.addVertex(words[0]);
			airportList.add(words[0], airport);
		}
		airportScanner.close();

		while(distanceScanner.hasNext())
		{
			String phrase = distanceScanner.nextLine();
			String[] words = phrase.split(",");
			int distance = Integer.parseInt(words[2]);

			graph.addEdge(words[0], words[1], distance);
		}
		distanceScanner.close();


		System.out.println("Airports v0.1 by K. Hung\n");

		Scanner input = new Scanner(System.in);
		boolean exit = false;

		while(!exit)
		{
			System.out.print("Command? ");
			String inputString = input.next();

			switch(inputString)
			{
				case "H":

					System.out.println("Q Query the airport information by entering the airport code.");
					System.out.println("D Find the minimum distance between two airports.");
					System.out.println("E Exit.\n");
					break;


				case "Q":
				
					String[] stringList;
					if(input.hasNext())
					{
						stringList = input.nextLine().split(" ");
						for(int i = 1; i < stringList.length; i++)
						{
							if(airportList.contains(stringList[i]))
							{
								Airport airport = airportList.getValue(stringList[i]);
								System.out.println(airport.getLabel() + " - " + airport.getAirport() + " - " +
								airport.getCity() + " - " + airport.getState());
							}
							else{
								System.out.println(stringList[i] + " - unknown");
							}
						}
					}
					else{
						System.out.println("Invalid Command");
					}

					System.out.println();
					break;


				case "D":

					String start = input.next();
					String end = input.next();
					if(!airportList.contains(start) || !airportList.contains(end))
					{
						System.out.println("Airport code unknown");
						System.out.println();
						break;
					}

					int pathLength = graph.getCheapestPath(start, end);
					Stack<VertexInterface<String>> pathStack = graph.returnTraversalStack();

					if(pathLength == 0){
						System.out.println("Airports not connected");	
					}
					else{
						System.out.println(airportList.getValue(start).getAirport() + " to " + airportList.getValue(end).getAirport() +
						" is " + pathLength + " through the route:");
						while(!pathStack.empty())
						{
							String label = pathStack.pop().getLabel();
							Airport airport = airportList.getValue(label);
							System.out.println(label + " - " + airport.getAirport());
						}
					}
					System.out.println();
					break;


				case "I":

					String front = input.next().trim();
					String back = input.next().trim();
					int distance = input.nextInt();
					if(!airportList.contains(front) || !airportList.contains(back))
					{
						System.out.println("Airport code unknown");
						System.out.println();
						break;
					}
					else if(graph.hasEdge(front, back)){
						System.out.println("Airports already connected");
						System.out.println();
						break;
					}

					graph.addEdge(front, back, distance);
					System.out.println(airportList.getValue(front).getAirport() + " to " + airportList.getValue(back).getAirport() +
					" with a distance of " + distance + " added.");
					System.out.println();
					break;
					
				
				case "R":

					String origin = input.next().trim();
					String destination = input.next().trim();

					if(!airportList.contains(origin) || !airportList.contains(destination))
					{
						System.out.println("Airport code unknown");
						System.out.println();
						break;
					}
					else if(!graph.hasEdge(origin, destination)){
						System.out.println("Airports not connected directly");
						System.out.println();
						break;
					}

					graph.removeEdge(origin, destination);
					System.out.println(airportList.getValue(origin).getAirport() + " and " + airportList.getValue(destination).getAirport() +
					" removed.");
					System.out.println();
					break;

				case "E":

					input.close();
					exit = true;
					break;

				default:

					System.out.println("Invalid Command\n");
					break;
			}
		}

	}
}