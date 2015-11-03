/**
 *  TestSets.java
 *
 *  @version: Last Modified May 22, 2014
 *  @author:  Henry Leitner/Bryan Miller
 */

import java.util.*;

/**
 * This class allows one to test the Bitset class
 * with user input by selecting among several options
 * related to set arithmetic.
 * 
 */
public class TestSets
{
	/**
	 * This method provides a menu to test the Bitset class
	 * with user input by selecting among several options
	 * related to set arithmetic.
	 * 
	 */
	static void menu()
	{
		System.out.println ();
		System.out.print ("Type 1 to CREATE SET A\n");
		System.out.print ("Type 2 to CREATE SET B\n");
		System.out.print ("Type 3 to CREATE INTERSECTION (A * B)\n");
		System.out.print ("Type 4 to CREATE UNION (A + B)\n");
		System.out.print ("Type 5 to CREATE DIFFERENCE (A - B)\n");
		System.out.println ("Type 6 to get the cardinality of A");
		System.out.println ("Type 7 to get the cardinality of B");
		System.out.println ("Type 8 to see if A is a subset of B");
		System.out.println ("Type 9 to see if B is a subset of A");
		System.out.print ("Type any OTHER # to EXIT PROGRAM \n\n");
		System.out.print ("Command: ");
	}

	/**
	 * Main provides the output from selecting 
	 * among several options related to set arithmetic.
	 * 
	 */
	public static void main (String [] args) 
	{
		Bitset setA = new Bitset (16);
		Bitset setB = new Bitset (8);
		int command;

		Scanner keyboard = new Scanner (System.in);
		do 
		{
			menu();

			switch (command = keyboard.nextInt ()) 
			{
			case 1:
				System.out.println ("Type some small integers, each < 16" 
						+ ", and type DONE when all done!");
				setA.readSet(keyboard);
				System.out.print ("     SET A = " + setA);
				break;

			case 2:
				System.out.println ("Type some small integers, each < 8"
						+ ", and type DONE when all done!");
				setB.readSet(keyboard);
				System.out.print ("     SET B = " + setB);
				break;

			case 3:
				System.out.print ("     Intersection (A * B) = ");
				System.out.print (setA.intersect(setB));
				break;

			case 4:
				System.out.print ("     Union (A + B) = ");
				System.out.print (setA.union(setB));
				break;

			case 5:
				System.out.print ("     Difference (A - B) = ");
				System.out.print (setA.difference(setB));
				break;

			case 6:
				System.out.print ("     Cardinality of A = ");
				System.out.print (setA.cardinality());
				break;

			case 7:
				System.out.print ("     Cardinality of B = ");
				System.out.print (setB.cardinality());
				break;

			case 8:
				System.out.println ("Is A a subset of B?  ");
				System.out.print (setA.isSubset(setB));
				break;

			case 9:
				System.out.println ("Is B a subset of A?  ");
				System.out.print (setB.isSubset(setA));
				break;

			default:  System.exit(0);

			}
		} while (command > 0 && command < 6);
	}
}