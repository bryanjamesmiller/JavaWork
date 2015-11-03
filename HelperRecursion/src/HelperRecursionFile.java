
public class HelperRecursionFile 
{
	public static void main(String [] args)
	{
		recursivePrintStarsDownToOne(5);

		//This function shows the order that the stack frames get 
		//generated and then closed down in (First in, Last out, which
		//also is Last in, First out.
		stackFramePrinter(3);
	}

	static void recursivePrintStarsDownToOne(int n)
	{
		if(n==0)
		{
			return;
		} 
		else 
		{
			for(int i=0; i<n; i++)
			{
				System.out.print("*");
			}
			System.out.println();
			recursivePrintStarsDownToOne(n-1);
		}
	}

	static void stackFramePrinter(int n){
		if(n<=0){
			return;
		}
		stackFramePrinter(n-1);
		System.out.println(n);
		//The 3 gets passed in first, and a stack frame gets generated
		//Then the function calls itself with a 2 in a new stack frame.
		//Then the function calls itself with a 1 in another new stack frame
		//Then the stack on top runs to completion, so it prints out the 1
		//Then that stack closes and the next stack on top runs to completion, so the 2 prints out
		//Then the bottom stack, which was the first one called, runs to completion and prints the 3
		// out and the function ends.
	}
}

