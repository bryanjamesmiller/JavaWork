//CargoShip.java

/** 
 *  This class is a template for a cargo ship.  It's
 *  parent class is the Ship class and it's child class
 *  is the TankerCargoShip class.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 2/25/2014
 **/
public class CargoShip extends Ship{

	protected double cargoCapacity;

	/** 
	 *  This constructor receives four parameters and 
	 *  calls the corresponding setter methods.
	 *  
	 * @param	shipName	This is the name of the ship, a String.
	 * @param	shipYear	This is the year the ship was built, an integer.
	 * @param	engineType	This is the type of engine the ship has, which
	 * 						is a data type called ShipEngine, an enum.
	 * @param	cargoCapacity	The cargo capacity the ship has,
	 * 							a double data type.
	 **/
	public CargoShip(String shipName, int shipYear, ShipEngine engineType, double cargoCapacity) 
	{
		super(shipName, shipYear, engineType);
		setCargoCapacity(cargoCapacity);
	}

	/**
	 * This is a setter method for getCargoCapacity, 
	 * the number of people that the ship can carry.
	 * 
	 * @param	getCargoCapacity	The cargo capacity the ship has,
	 * 								a double data type.
	 */
	public void setCargoCapacity(double cargoCapacity)
	{
		this.cargoCapacity=cargoCapacity;
	}

	/**
	 * This is a getter method for getCargoCapacity, 
	 * the number of people that the ship can carry.
	 * 
	 * @return	getCargoCapacity	The cargo capacity the ship has,
	 * 								a double data type.
	 */
	public double getCargoCapacity()
	{
		return cargoCapacity;
	}

	/**
	 * This method returns a String with some relevant ship information.
	 * 
	 * @return	myString	A string containing descriptive information
	 * 						about the cargo ship.
	 */
	public String toString()
	{
		String myString="The ship's name is: " + shipName + ".  ";
		myString+="The ship's tonage is: " + cargoCapacity +".  ";
		return myString;
	}
}
