// RecursivePrint.java

/**	
 * 
 * This program will take an integer in number form
 * and print its equivalent in English words.
 * 
 * @author    Bryan Miller
 * @version   Last modified on 2/3/2014
 * 
 * Please accept this question for extra credit **
 **/

import java.util.*;

public class RecursivePrint
{
	public static void main(String[] args) 
	{
		System.out.println("You can enter a total of 10 different integers " + 
				"each time the program is run.");
		Scanner userInput = new Scanner(System.in);
		for(int i=0; i<10; i++)
		{
			System.out.print("Please enter an integer " + 
					"between -999,999,999 and 999,999,999:  ");
			int myInteger=userInput.nextInt(); 
			printNumber(myInteger);
			System.out.println();
		}
	}

	/**	
	 * This method, printNumber, will accept a parameter of an integer
	 * and print its equivalent in English words.  This method is longer
	 * than a typical method should be, but I believe it was requested
	 * in the problem to just write this one method.
	 * 
	 * @param	n		This is an integer that will be printed into its
	 * 					English	equivalence.
	 **/
	public static void printNumber(int n)
	{
		if(n<0)
		{
			n=-n;
			System.out.print("minus ");
		}
		if(n==0)
			System.out.print("zero");

		int digitFinder=n;
		int adjustedNum=n;
		int numDigits=0;
		while(digitFinder>0)
		{
			digitFinder=digitFinder/10;
			numDigits++;
		}

		if(numDigits>3 && numDigits<7)
			adjustedNum=n/1000;
		else if(numDigits>6)
			adjustedNum=n/1000000;

		if(numDigits==3 || numDigits==6 || numDigits==9)
		{
			switch(adjustedNum/100)
			{
			case 1:
				System.out.print("one hundred ");
				break;
			case 2:
				System.out.print("two hundred ");
				break;
			case 3:
				System.out.print("three hundred ");
				break;
			case 4:
				System.out.print("four hundred ");
				break;
			case 5:
				System.out.print("five hundred ");
				break;
			case 6:
				System.out.print("six hundred ");
				break;
			case 7:
				System.out.print("seven hundred ");
				break;
			case 8:
				System.out.print("eight hundred ");
				break;
			case 9:
				System.out.print("nine hundred ");
				break;
			}
			adjustedNum=adjustedNum%100;
		}

		if(adjustedNum/10>=2)
		{
			switch(adjustedNum/10)
			{
			case 2:
				System.out.print("twenty ");
				break;
			case 3:
				System.out.print("thirty ");
				break;
			case 4:
				System.out.print("forty ");
				break;
			case 5:
				System.out.print("fifty ");
				break;
			case 6:
				System.out.print("sixty ");
				break;
			case 7:
				System.out.print("seventy ");
				break;
			case 8:
				System.out.print("eighty ");
				break;
			case 9:
				System.out.print("ninety ");
				break;
			}
			adjustedNum=adjustedNum%10;
		}	

		if(adjustedNum<10)
		{
			switch(adjustedNum)
			{
			case 1:
				System.out.print("one ");
				break;
			case 2:
				System.out.print("two ");
				break;
			case 3:
				System.out.print("three ");
				break;
			case 4:
				System.out.print("four ");
				break;
			case 5:
				System.out.print("five ");
				break;
			case 6:
				System.out.print("six ");
				break;
			case 7:
				System.out.print("seven ");
				break;
			case 8:
				System.out.print("eight ");
				break;
			case 9:
				System.out.print("nine ");
				break;
			}
		}

		if(adjustedNum%100<20)
		{
			switch(adjustedNum%100)
			{
			case 10:
				System.out.print("ten ");
				break;
			case 11:
				System.out.print("eleven ");
				break;
			case 12:
				System.out.print("twelve ");
				break;
			case 13:
				System.out.print("thirteen ");
				break;
			case 14:
				System.out.print("fourteen ");
				break;
			case 15:
				System.out.print("fifteen ");
				break;
			case 16:
				System.out.print("sixteen ");
				break;
			case 17:
				System.out.print("seventeen ");
				break;
			case 18:
				System.out.print("eighteen ");
				break;
			case 19:
				System.out.print("nineteen ");
				break;	
			}
		}

		if(numDigits>6)
		{
			System.out.print("million ");
			if(n%1000000!=0)
				printNumber(n%1000000);
		}
		if(numDigits>3 && numDigits<7)
		{
			System.out.print("thousand ");
			if(n%1000!=0)
				printNumber(n%1000);
		}
		return;
	}
}