//Ship.java

/** 
 *  This class is a template for a generic ship.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 2/24/2014
 **/

enum ShipEngine {STEAM_ENGINE, STEAM_TURBINE, GAS_TURBINE, DIESEL, 
	ELECTRIC, WIND, HUMAN_FORCE};

	public abstract class Ship {

		protected String shipName;
		protected int shipYear;
		protected ShipEngine engineType;

		/** 
		 *  This constructor receives three parameters and 
		 *  calls the corresponding setter methods.
		 *  
		 * @param	shipName	This is the name of the ship, a String.
		 * @param	shipYear	This is the year the ship was built, an integer.
		 * @param	engineType	This is the type of engine the ship has, which
		 * 						is a data type called ShipEngine, an enum.
		 **/	
		public Ship(String shipName, int shipYear, ShipEngine engineType)
		{
			setShipName(shipName);
			setShipYear(shipYear);
			setShipEngine(engineType);
		}

		/**
		 * This is a setter method for shipName, the name of the ship.
		 * 
		 * @param shipName	The name of the ship.
		 */
		public void setShipName(String shipName)
		{
			this.shipName=shipName;
		}

		/**
		 * This is a setter method for shipYear, the year the ship was built.
		 * 
		 * @param shipYear	The year the ship was built.
		 */
		public void setShipYear(int shipYear)
		{
			this.shipYear=shipYear;
		}

		/**
		 * This is a setter method for engineType, the type of engine
		 * that the ship has.
		 * 
		 * @param shipEngine	The type of engine that the ship has.
		 */
		public void setShipEngine(ShipEngine engineType)
		{
			this.engineType=engineType;
		}

		/**
		 * This is a getter method for shipName, the name of the ship.
		 * 
		 * @return shipName		The name of the ship.
		 */
		public String getShipName()
		{
			return shipName;
		}

		/**
		 * This is a setter method for shipYear, the year the ship was built.
		 * 
		 * @return shipYear	The year the ship was built.
		 */
		public int getShipYear()
		{
			return shipYear;
		}

		/**
		 * This is a return method for engineType, the type of engine
		 * that the ship has.
		 * 
		 * @return shipEngine	The type of engine that the ship has.
		 */
		public ShipEngine getShipEngine()
		{
			return engineType;
		}

		/**
		 * This method returns a String with some relevant ship information.
		 * 
		 * @return myString		Some relevant ship information in the form
		 * 						of a String.
		 */
		public String toString()
		{
			String myString="The name of the ship is: " + shipName + ".  ";
			myString+="The year of the ship is: " + shipYear + ".  ";
			myString+="The engine type of the ship is: " + engineType + ".  ";
			return myString;
		}
	}
