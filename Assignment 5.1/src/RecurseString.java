//  RecurseString.java

/**
 *  This program will take a String from the user and recursively reverse
 *  its characters.
 *
 *  The program has two modes - normal and verbose.  To run the program in
 *  verbose mode, start it by typing:
 *      java RecurseString -v
 *
 *
 *  @author   Jan Jackson
 *  @version  1.0
 */

import java.util.*;

public class RecurseString
{
    private static boolean verbose = false;

    /** 
     *  This method takes a string and makes recursive calls to 
     *  reverse it.  The resulting String is accumulated and then
     *  returned at the end.
     *
     *  @param  input  The String ( or portion of it) to reverse
     *  @return        The accumulated reversed String (up to this point)
     */
    public static String reverse( String input )
    {
	//  This is the base case - no letters left - return ""
	//  Returning "" also makes sure we always have a String building...
	if( input.length() == 0 ) {
	    if( verbose ) System.out.println( "Base case reached...  returning... \n" );
	    return "";
	}
	//  We're not done yet - make the recursive call
	else {
	    //  If I were not printing, this case would simply read:
	    //         return reverse( input.substring( 1 ) ) + input.charAt(0);
	    //  Since we want to print things, we'll use variables to hold them.

	    char letter = input.charAt(0);   // hold the first letter
	    if( verbose ) System.out.println( "Holding '" + letter + 
					      "' and calling reverse( " + input.substring( 1 ) 
					      + " )." );

	    //  We'll use a String to hold the reversed String so we can print info
	    String result = reverse( input.substring( 1 ) );
	    if( verbose ) System.out.println( "Returned from recursion with \"" 
                                              + result + "\"" );
	    return result + letter;
	}
    }

    public static void main(String [] args)
    {
	if( args.length > 0 && args[0].equals( "-v" ) )
	    verbose = true;

	Scanner in = new Scanner( System.in );
	System.out.print( "Please enter a string and I'll reverse it: \n\t" );
	String text = in.nextLine();
	System.out.println( "The reversed String is: \n\t"
			    + reverse( text ) );
	System.out.println();
    }

}