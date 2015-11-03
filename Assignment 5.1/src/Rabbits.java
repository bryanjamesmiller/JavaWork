// Rabbits.java

/**	
 * This program calculates the number of mature rabbit pairs after
 * the Nth month according to the Fibonacci series up to the number
 * of months represented by the constant NUM_MONTHS.
 * 
 * @author    Bryan Miller
 * @version   Last modified on 2/10/2014
 **/

import java.util.*;

public class Rabbits
{
	public static final int NUM_MONTHS = 12;

	public static void main(String[] args) 
	{
		for(int i=1; i<=NUM_MONTHS; i++)
		{
			System.out.println("At the end of month #" + i + 
					", there are " + fibo(i) + " mature rabbit pairs.");
		}
	}

	/**	
	 * This method, fibo, computes the Nth Fibonacci number (or the number of
	 * mature rabbit pairs that exist at month N).
	 * 
	 * @param	monthNumber		This is the number of months the rabbits have 
	 * 							to multiply that corresponds to the Nth 
	 * 							Fibonacci number. 
	 * 							 
	 * @return	matureRabbitPairs	Returns an int number of mature rabbit pairs 
	 * 								that exist at the end of N months (in other 
	 * 								words, the Nth Fibonacci number).
	 **/
	public static int fibo(int monthNumber)
	{
		/*The base cases are that month No. 1 has the Fibonacci number 0,
		and month No. 2 has the Fibonacci number 1.*/
		if(monthNumber==1)
			return 0;
		else if(monthNumber==2)
			return 1;
		else
			return(fibo(monthNumber-1)+fibo(monthNumber-2));
	}
}