
public class PairSums 
{
	static final int ARRAY_LENGTH = 7;
	static final int ARRAY_MAX_VALUE = 10;
	static final int SUM_GOAL = 12;
	static int counter=0;
	static int counter2=0;

	public static void main(String[] args)
	{
		int testArray[] = SortCount.randomArray(ARRAY_LENGTH, ARRAY_MAX_VALUE);
		System.out.print("The array is: ");
		for(int i = 0; i < testArray.length; i++)
			System.out.print(testArray[i] + " ");
		System.out.println();
		int k = SUM_GOAL;
		System.out.println("Here is the findPairs method: ");
		findPairs(testArray, k);
		System.out.println("The findPairs counter is: " + counter2);
		System.out.println();

		System.out.println("Here is the faster findPairsFaster method: ");
		findPairsFaster(testArray, k);
		System.out.println("The findPairsFaster counter is: " + counter);
	}

	/*
	 * This method is O(n^2) because there are n(n+1)/2
	 * comparisons for an array of length n.  The largest
	 * term is n^2, thus the efficiency is O(n^2).
	 */
	public static void findPairs(int[] testArray, int k) 
	{
		for(int i = 0; i < testArray.length; i++)
		{
			for(int j = 0; j < testArray.length; j++)
			{				
				if(i == j)
					break;

				counter2++;
				if(testArray[i] + testArray[j] == k)
					System.out.println(testArray[i] + " + " + testArray[j] + " = " + k);
			}
		}
	}

	/*
	 * This method is O(n log n) because mergeSort is O(n log n) and
	 * we are only adding on to that O(n), which is less than O(n log n).  
	 * Therefore the largest of the two terms remains, making this method 
	 * O(n log n) efficient.  We are only adding on O(n) because C(n) is
	 * equal to n*(a constant), which amounts to O(n).  
	 */
	public static void findPairsFaster(int[] testArray, int k) 
	{
		Sort.mergeSort(testArray);
		int i;
		for(i=0; testArray[i] < k / 2; i++)
		{
			for(int j = testArray.length - 1; testArray[j] > k / 2; j--)
			{
				counter++;
				if(testArray[i] + testArray[j] == k)
					System.out.println(testArray[i] + " + " + testArray[j] + " = " + k);
			}
		}

		while(testArray[i] == k / 2)
		{
			counter++;
			if(testArray[i]<testArray.length)
				if(testArray[i+1] == k / 2)
					System.out.println(testArray[i] + " + " + testArray[i] + " = " + k);
			i++;
		}
	}

}
