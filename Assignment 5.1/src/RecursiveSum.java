// RecursiveSum.java

/**	
 * This program sums up the elements of an array using recursion.
 * 
 * @author    Bryan Miller
 * @version   Last modified on 2/10/2014
 **/

import java.util.*;

public class RecursiveSum
{
	public static void main(String[] args) 
	{
		int[] myArray = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(sumsArrayElements(myArray, myArray.length));

		int[] myArray2 = {5, 2, 3, 5, 6, 7};
		System.out.println(sumsArrayElements(myArray2, myArray2.length));

		int[] myArray3 = {};
		System.out.println(sumsArrayElements(myArray3, myArray3.length));

		int[] myArray4 = {7};
		System.out.println(sumsArrayElements(myArray4, myArray4.length));
	}

	/**	
	 * This method, sumsArrayElements, takes an array of integers as a 
	 * parameter and sums up the elements using recursion.  It returns 
	 * the sum of the elements.
	 * 
	 * @param		myArray			This is an array of integers whose 
	 * 								elements will be summed.
	 * @param		sizeOfMyArray	This is the size of myArray. 
	 * @return						An integer, the sum of the elements
	 * 								in the array.
	 **/
	public static int sumsArrayElements(int [] myArray, int sizeOfMyArray)
	{
		if(sizeOfMyArray==0)
			return 0;

		/*The below adds the last element in the array to the next to last element, and
		repeats until the base case is reached where all the elements have been added.*/
		return myArray[sizeOfMyArray-1] + sumsArrayElements(myArray, sizeOfMyArray-1);
	}
}