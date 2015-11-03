//TankerCargoShip.java

/** 
 *  This class is a template for a tanker cargo ship.  It's
 *  parent class is the CargoShip class.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 2/24/2014
 **/
public class TankerCargoShip extends Ship{

	protected double gasVolume;

	/** 
	 *  This constructor receives four parameters and 
	 *  calls the corresponding setter methods.
	 *  
	 * @param	shipName	This is the name of the ship, a String.
	 * @param	shipYear	This is the year the ship was built, an integer.
	 * @param	engineType	This is the type of engine the ship has, which
	 * 						is a data type called ShipEngine, an enum.
	 * @param	gasVolume	This is the volume of gas that the ship can carry
	 * 						and is a double data type.
	 **/	
	public TankerCargoShip(String shipName, int shipYear, ShipEngine engineType, 
			double gasVolume) {
		super(shipName, shipYear, engineType);
		setGasVolume(gasVolume);
	}

	/**
	 * This is a setter method for gasVolume, the volume of gas that the ship can carry.
	 * 
	 * @param gasVolume		The volume of gas that the ship can carry.
	 */
	public void setGasVolume(double gasVolume)
	{
		this.gasVolume=gasVolume;
	}

	/**
	 * This is a getter method for gasVolume, the volume of gas that the ship can carry.
	 * 
	 * @return gasVolume		The volume of gas that the ship can carry.
	 */
	public double getGasVolume()
	{
		return gasVolume;
	}

	/**
	 * This method returns a String with some relevant ship information.
	 * 
	 * @return myString		Some relevant ship information in the form
	 * 						of a String.
	 */
	public String toString()
	{
		String myString="The ship's name is: " + shipName + ".  ";
		myString+="The ship is carrying a gas volume of: " + gasVolume +".  ";
		return myString;
	}
}
