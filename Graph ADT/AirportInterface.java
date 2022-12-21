
// 
//  Name:   Hung, Kayden 
//  Project:  #5
//  Due:        12/9/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Airport Inteface for Airport class
// 

public interface AirportInterface
{
	/** Gets the IATA code of the airport
	 * @return IATA code 
	 */
	public String getLabel();

	/** Gets the city of the airport
	 * @return city location of airport
	 */
	public String getCity();

	/** Gets the airport name
	 * @return airport name
	 */
	public String getAirport();

	/** Gets the state of the airport
	 * @return state location of airport
	 */
	public String getState();

}