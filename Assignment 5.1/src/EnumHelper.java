
import java.util.*;
enum Months { JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG,		
	SEP, OCT, NOV, DEC};

	public class EnumHelper 
	{
		public static int daysInMonth (Months m)
		{
			switch (m)
			{ 
			case FEB:
				return 28;
			case APR:
			case JUN:
			case SEP:
			case NOV:
				return 30;
			default: 
				return 31;
			}
		}

		public static void main (String [] args)
		{
			for (Months m : Months.values() )
			{
				System.out.println (m + " has " + 
						daysInMonth(m) + " days!");
			}
		}
	}