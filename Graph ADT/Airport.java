// 
//  Name:   Hung, Kayden 
//  Project:  #5
//  Due:        12/9/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Airport class to store airport data
// 

public class Airport implements AirportInterface
{
	String label, city, airport, state;


	/** Constructor for Airport that requires all necessary data
	 * @param label, the IATA code of airport
	 * @param city, the city location of airport
	 * @param airport, the name of the airport
	 * @param state, the state location of airport
	 */
	public Airport(String label, String city, String airport, String state)
	{
		this.label = label;
		this.city = city;
		this.airport = airport;
		this.state = state;
	}

	public String getLabel() {
		return label;
	}

	public String getCity() {
		return city;
	}

	public String getAirport() {
		return airport;
	}

	public String getState() {
		return state;
	}
}