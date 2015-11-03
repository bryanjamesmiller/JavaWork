
public class MergeSort {
	
	static int counter=0;

	public static void main(String[] args)
	{
		int[] myArray = {1, 2, 3, 4, 5};
		int[] myArray2 = {1, 1, 1, 1, 1};  //4 is the correct number of duplicates, because the first one is not a duplicate

		System.out.println(numDuplicatesB(myArray));
		for(int i=0; i<myArray2.length; i++)
			System.out.print(myArray[i] + ", ");
		System.out.println("\nThere are this many comparisons: " + counter);
		/*
		System.out.println();
		System.out.println(numDuplicatesB(myArray2));
		for(int i=0; i<myArray2.length; i++)
			System.out.print(myArray2[i] + ", ");
		System.out.println("There are this many comparisons: " + counter;)
		*/
	}

	//He calls this method mergeSort
	public static void mergeSorter(int[] arr) {
		int[] temp = new int[arr.length];
		mSort(arr, temp, 0, arr.length - 1);
	}

	public static void mSort(int[] arr, int[] temp,	int start, int end) 
	{ 

		if (start >= end) // base case
		{
			
			return;
		}
		int middle = (start + end)/2;
		mSort(arr, temp, start, middle);
		mSort(arr, temp, middle + 1, end);

		merge(arr, temp, start, middle, middle+1, end);
	}


	public static void merge(int[] arr, int[] temp, 
			int leftStart, int leftEnd, int rightStart, int rightEnd) 
	{
		int i = leftStart; // index into left subarray
		int j = rightStart; // index into right subarray
		int k = leftStart; // index into temp
		while (i <= leftEnd && j <= rightEnd) {
			if (arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while (i <= leftEnd)
		{
			temp[k++] = arr[i++];
		}
		while (j <= rightEnd)
		{
			temp[k++] = arr[j++];
		}
		for (i = leftStart; i <= rightEnd; i++)
			arr[i] = temp[i];
	}



	public static int numDuplicatesB(int[] arr) {
		mergeSorter(arr);
		int numDups = 0;
		for (int i = 1; i < arr.length; i++) {
			counter++;
			if (arr[i] == arr[i - 1]) {
				numDups++;
			}
		}
		return numDups;
	}

}
