/**
 * CSCI E-22 HW#1 Q#2
 * 
 * @author Bryan Miller
 * @date	09/12/2014
 *
 */
public class StringRecursion 
{
	public static void main(String []args)
	{
		printLetters("I like to recurse!");

		System.out.println(replace("base case", 'e', 'y'));  // Should print "basy casy"
		System.out.println(replace("base case", 'r', 'y'));  // Should print "base case"

		System.out.println(indexOf('b', "Rabbit"));  // Should print 2
		System.out.println(indexOf('P', "Rabbit"));  // Should print -1

	}

	// You may find it helpful to employ the substring,
	// charAt, and length methods of the String class as part of your solutions

	/**
	 * This method will take the String passed in and separate out its
	 * characters to separate them with a comma and a space.  I 
	 * give credit to the example done in class in the method printVertical.
	 * 
	 * @param str This is the String to reformat and print.
	 */
	public static void printLetters(String str)
	{
		if (str == null || str.equals("")) 
			return;
		else if(str.length() == 1)
			System.out.println(str.charAt(0));
		else
			System.out.print(str.charAt(0) + ", ");
		printLetters(str.substring(1)); 
	}

	/**
	 * This method returns a String that is formed by replacing all occurrences 
	 * of the character oldChar in the string str with the character newChar.
	 * 
	 * @param str This is the original String.
	 * @param oldChar This is the character to remove all occurrences of.
	 * @param newChar This is the character that replaces the oldChar characters.
	 * @return The newly constructed String is returned.
	 */
	public static String replace(String str, char oldChar, char newChar)
	{
		if(str.equals(null))
			return null;
		if(str.equals(""))
			return "";
		if(str.charAt(0) == oldChar)
			return newChar + replace(str.substring(1), oldChar, newChar);
		return str.charAt(0) + replace(str.substring(1), oldChar, newChar);				
	}	

	/**
	 * This method uses recursion to find and return the index of the first
	 * occurrence of the character ch in the string str, or -1 if ch does not 
	 * occur in str.
	 * 
	 * @param ch	This is the character that is being searched for. 
	 * @param str	This is the String in which the character is being searched for.
	 * @return	This is the index of the first occurrence of ch, if there is one.  
	 * Otherwise, it will return -1.
	 */
	public static int indexOf(char ch, String str)
	{
		if(str.equals(null) || str == "")
			return -1;
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)==ch)
				break;
			if(str.charAt(i) != ch && i == str.length()-1)
				return -1;
		}
		if(str.charAt(0) == ch)
			return 0;
		int temp = indexOf(ch, str.substring(1));
		if(temp==-1)
			return -1;
		return 1 + temp; 
	}
}
