// LowestGrade.java

/**	
 * This program drops the lowest grade from a variable number of
 * integers, as long as there are at least two grades, and puts the
 * final grades into an array.  If there are more than one grade equal 
 * to the lowest grade, then just one of them gets removed.  It then 
 * prints an array of the final grades, without the lowest grade.
 * 
 * @author    Bryan Miller
 * @version   Last modified on 2/10/2014
 **/

public class LowestGrade 
{
	public static void main(String[] args) 
	{
		int [] a = removeLowest (23, 90, 47, 55, 88);
		int [] b = removeLowest (85);
		int [] c = removeLowest ();
		int [] d = removeLowest (59, 92, 93, 47, 88, 47);

		System.out.println("a = " + arrayPrint(a));
		System.out.println("b = " + arrayPrint(b));
		System.out.println("c = " + arrayPrint(c));
		System.out.println("d = " + arrayPrint(d));
	}

	/**
	 * This method returns an integer array that contains all of the values 
	 * passed to the method except for the first instance of the lowest score,
	 * as long as there are at least two grades.
	 *   
	 * @param	arrayOfGrades	An int array of grades
	 * @return	finalGrades		An int array has the lowest grade removed
	 *  						from the array that was passed into the method.	
	 **/
	public static int[] removeLowest(int ... arrayOfGrades)
	{
		if(arrayOfGrades.length<2)
			return arrayOfGrades;

		//Since the array of final grades won't have the lowest score, 
		//it will be one element shorter than the original array.
		int [] finalGrades = new int[arrayOfGrades.length-1];

		int temp=arrayOfGrades[0];
		//The below for loop finds which element is the lowest score.
		for(int i=0; i<arrayOfGrades.length; i++)
		{
			if(arrayOfGrades[i]<temp)
				temp=arrayOfGrades[i];
		}

		//The below for loop copies all of the scores into the new array except 
		//for the first instance of the lowest score.
		int j=0;
		boolean repeatsLowest=false;
		for(int i=0; i<finalGrades.length; i++)
		{
			if(arrayOfGrades[j]!=temp || repeatsLowest==true)
				finalGrades[i]=arrayOfGrades[j];
			else if(repeatsLowest==false)
			{
				finalGrades[i]=arrayOfGrades[j+1];
				j++;
				repeatsLowest=true;
			}
			j++;
		}
		return finalGrades;	
	}

	/**
	 * This method returns a string of the integer array that is passed to it.
	 *   
	 * @param	arrayOfGrades	An int array of grades
	 * @return	myStringOutput	A String that represents the arrayOfGrades Array.	
	 **/
	public static String arrayPrint(int ... arrayOfGrades)
	{
		if(arrayOfGrades.length==0)
			return "[]";

		String myStringOutput="[";
		for(int i=0; i<arrayOfGrades.length; i++)
		{
			if(i<arrayOfGrades.length-1)
				myStringOutput+=arrayOfGrades[i] + ",";
		}
		myStringOutput+= arrayOfGrades[arrayOfGrades.length-1] + "]";
		return myStringOutput;
	}
}		
