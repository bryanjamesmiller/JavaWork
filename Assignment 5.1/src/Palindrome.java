// Palindrome.java

/**	
 * @author    Bryan Miller
 * @version   Last modified on 2/10/2014
 **/

import java.util.*;

public class Palindrome
{
	public static void main(String[] args) 
	{
		System.out.print("Please enter a String to be analyzed: ");
		Scanner userInput = new Scanner(System.in);
		String myString=userInput.nextLine();
		if(isPalindrome(myString))
			System.out.println("The following IS a palindrome: " + myString);
		else
			System.out.println("This is NOT a palindrome: " + myString);
	}

	/**	
	 * This method, isPalindrome, uses recursion to see if a String s 
	 * parameter is a palindrome, and returns a boolean true if it is.  
	 * Otherwise it returns false.
	 * 
	 * @param		s	This is a String that will be tested to see if it 
	 * 					is a Palindrome. 
	 * @return			Returns a boolean of true if the String s is a palindrome,
	 * 					but returns false if the String s is not a palindrome.
	 **/
	public static boolean isPalindrome(String s)
	{
		//The below line is the base case
		if(s.length()<=1)
			return true;

		//The below lines allow the String to be upper case characters only
		//and no punctuation or spaces.
		s=s.toUpperCase();
		String newString="";
		for(int i=0; i<s.length(); i++)
		{
			if(Character.isLetter(s.charAt(i)))
				newString+=s.charAt(i);
		}

		//It's not a palindrome if the first character doesn't match the last
		if(newString.charAt(0)!=newString.charAt(newString.length()-1))
			return false;

		/*It's not a palindrome if any of the substrings don't have matching 
		first and last characters.*/
		else if(!isPalindrome(newString.substring(1, newString.length()-1)))
			return false;

		//If all first-and-last pairs of characters match, return true 
		return true;
	}
}