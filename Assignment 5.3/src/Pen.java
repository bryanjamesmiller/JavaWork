//Pen.java

/** 
 *  This program outputs all of its command-line arguments
 *  in reverse order, one per line.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 3/10/2014
 **/

import java.util.*;
import java.io.*;
public class Pen 
{
	public static void main(String [] args)
	{
		String hi="hello";
		System.out.println(hi + " , how are you?");
		/*
		for(int i=0; i<args.length; i++)
		{
			System.out.println(args[args.length-i-1]);
		}

		ArrayList<String> a = new ArrayList<String>();
		a.add("Now");
		a.add("Later");
		a.add("Ever");
		System.out.println(a);
		int myCounter=a.size();
		for(int i=0; i<a.size(); i=i+2)
		{
			a.add(i, "NOT");
		}
		System.out.println(a);
		int tester=5/0;

		Scanner keyboard = new Scanner (System.in);
		int n1;
		int n2=0;
		double r=0;
		boolean stringTester=true;

		while(n2==0 || stringTester)
		{
			stringTester=false;
			try
			{
				System.out.print("Type an int: ");
				n1 = keyboard.nextInt();
				System.out.print("Now type another int: ");
				n2 = keyboard.nextInt();
				r = (double) (n1/n2);
			}
			catch(ArithmeticException e)
			{
				System.out.println("You just tried to divide by 0.  " +
						"Please try again!");
			}
			catch(InputMismatchException e)
			{
				System.out.println("You did not enter two integers.  " +
						"Please try again!");
				stringTester=true;
				keyboard.next();
			}
		}
		System.out.println("The result is: " + r);
		*/
	}
}
