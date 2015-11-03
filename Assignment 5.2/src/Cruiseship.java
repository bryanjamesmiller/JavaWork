//Cruiseship.java

/** 
 *  This class is a template for a cruiseship.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 2/25/2014
 **/
public class Cruiseship extends Ship{

	protected int maxNumPassengers;
	protected boolean isNorovirus;

	/** 
	 *  This constructor receives four parameters and 
	 *  calls the corresponding setter methods.
	 *  
	 * @param	shipName	This is the name of the ship, a String.
	 * @param	shipYear	This is the year the ship was built, an integer.
	 * @param	engineType	This is the type of engine the ship has, which
	 * 						is a data type called ShipEngine, an enum.
	 * @param	maxNumPassengers	The maximum number of passengers the ship 
	 * 								can carry, an integer 
	 * @param	isNorovirus		Whether or not the ship has the dreaded norovirus,
	 * 							a boolean.  True means yes, false means no.
	 **/	
	public Cruiseship(String shipName, int shipYear, ShipEngine engineType, int maxNumPassengers, boolean isNorovirus) 
	{
		super(shipName, shipYear, engineType);
		setMaxNumPassengers(maxNumPassengers);
		setNorovirus(isNorovirus);
	}

	/**
	 * This is a setter method for maxNumPassangers, 
	 * the number of people that the ship can carry.
	 * 
	 * @param	maxNumPassengers	The maximum number of passengers the ship 
	 * 								can carry, an integer
	 */
	public void setMaxNumPassengers(int maxNumPassengers)
	{
		this.maxNumPassengers=maxNumPassengers;
	}

	/**
	 * This is a getter method for maxNumPassangers, 
	 * the number of people that the ship can carry.
	 * 
	 * @return	maxNumPassengers	The maximum number of passengers the ship 
	 * 								can carry, an integer
	 */
	public int getMaxNumPassengers()
	{
		return maxNumPassengers;
	}

	/**
	 * This is a setter method for getNorovirus, 
	 * which is whether or not the ship has the norovirus.
	 * 
	 * @param	isNorovirus		Whether or not the ship has the dreaded norovirus,
	 * 							a boolean.  True means yes, false means no.
	 */
	public void setNorovirus(boolean isNorovirus)
	{
		this.isNorovirus=isNorovirus;
	}

	/**
	 * This is a getter method for getNorovirus, 
	 * which is whether or not the ship has the norovirus.
	 * 
	 * @return	isNorovirus		Whether or not the ship has the dreaded norovirus,
	 * 							a boolean.  True means yes, false means no.
	 */
	public boolean getNorovirus()
	{
		return isNorovirus;
	}

	/**
	 * This method returns a String with some relevant ship information.
	 * 
	 * @return	myString	A string containing descriptive information
	 * 						about the Cruiseship.
	 */
	public String toString()
	{
		String myString="The name of the ship is: " + shipName + ".  ";
		myString+="The maximum passengers of the ship is: " + maxNumPassengers + ".  ";
		return myString;
	}
}
