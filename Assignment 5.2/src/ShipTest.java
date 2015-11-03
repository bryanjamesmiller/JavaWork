
//ShipTest.java

/** 
 *  This class tests the Ship class and subclasses
 *  by using a variety of
 *  input and outputs.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 2/24/2014
 **/
public class ShipTest
{
	/** 
	 *  Main tests the Ship class and subclasses
	 *  by using a variety of input and outputs.
	 **/
	public static void main(String [] args)
	{
		ShipEngine steamEngine=ShipEngine.STEAM_TURBINE;
		ShipEngine windPowered=ShipEngine.WIND;

		Ship [] myShips={ new Cruiseship ("Royal Pearl", 2014, steamEngine, 5000, false),
			new Cruiseship ("Royal Clam", 1915, steamEngine, 25, true),
			new CargoShip("Black Pearl", 1700, windPowered, 10000.01),
			new CargoShip("Tartouga", 1670, windPowered, 5237.34),
			new TankerCargoShip("Exon Mobile", 1750, ShipEngine.HUMAN_FORCE, 12.52),
			new TankerCargoShip("Dawn Treader", 1850, ShipEngine.ELECTRIC, 2100.87),		
		};
		for (Ship aShip : myShips )
		{
			System.out.println(aShip.toString());
		}
	}
}
