
public class SimpleRecursionExample 
{
	public static void main(String[] args)
	{
		System.out.println(digitSum(3456));
	}
	
	public static int digitSum (int n)

/*	Remember to think about the base case: when have all the values in the
	array been summed up? Then think about how to go from a larger size
	toward that base case — this is your recursive case.*/
	
	{
		if ( n < 10) 
			return n; // base case
		else 
		{
			int mySum=n%10+digitSum (n/10);
			System.out.println(mySum);
			return mySum;
		}
//returns 6+5+4+3, but actually the 3 is the first thing "finally" computed, the base case, and then
		//it goes backwards from there 6 + (calls 5 + (calls
	}

}
//STACK:
//6+digitSum(345)
//5+digitSum(34)
//4+digitSum(3)
//3

//pay attention to where it returns it... it returns it WITHIN the return, 
//because it returns it where the call originally took place.
//i think i may need to just return the call, 
//and the first number I need to crap out is 0 (fibo(4), and then 1 (fibo 3), and then 1 (fibo 2), and then 2 (fibo 1);
//just like in the above example it was 6  (digitSum(3456), then 5 (digitSum(345), then 4, then 3.