
public class Intersect {
	static final int ARRAY_LENGTH = 7;
	static final int ARRAY_MAX_VALUE = 10;
	static final int SUM_GOAL = 12;
	static int counter=0;

	public static void main(String[] args)
	{
		int testArray1[] = SortCount.randomArray(ARRAY_LENGTH, ARRAY_MAX_VALUE);
		int testArray2[] = SortCount.randomArray(ARRAY_LENGTH-2, ARRAY_MAX_VALUE);

		System.out.print("The longer array is: ");
		for(int i = 0; i < testArray1.length; i++)
			System.out.print(testArray1[i] + " ");
		System.out.println();

		System.out.print("The shorter array is: ");
		for(int i = 0; i < testArray2.length; i++)
			System.out.print(testArray2[i] + " ");
		System.out.println();
		
		int intersectionArray[] = intersect(testArray1, testArray2);
		System.out.print("The intersection of the two arrays is: ");
		for(int i = 0; i < intersectionArray.length; i++)
			System.out.print(intersectionArray[i] + " ");

	}

	/*
	 * I'm assuming it's okay that I'm forcing testArray2 to be the shorter
	 * of the two arrays. 
	 */
	private static int[] intersect(int[] testArray1, int[] testArray2) {
		Sort.mergeSort(testArray1);
		Sort.mergeSort(testArray2);

		int intersectionArray[] = new int[testArray2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < testArray2.length && j < testArray1.length)
		{
			if(testArray2[i] == testArray1[j])
			{
				intersectionArray[k]=testArray2[i];
				i++;
				j++;
				k++;
			}
			else if (testArray2[i]<testArray1[j])
				i++;
			else if(testArray2[i]>testArray1[j])
				j++;
		}		
		return intersectionArray;
	}
}
