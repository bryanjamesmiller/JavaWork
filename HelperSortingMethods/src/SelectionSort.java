
public class SelectionSort {

	public static void main(String[] args)
	{
		int[] myArray = {5, 1, 1};
		//SelectionSort just finds the lowest number in the array and swaps it with the first index,
		//then it finds the second lowest number in the array and swaps it with the second index, etc.
		selectionSort(myArray);
		System.out.println();
		for(int i=0; i<myArray.length; i++)
			System.out.print(myArray[i] + ", ");	
	}

	public static void selectionSort(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) 
		{
			int j = indexSmallest(arr, i, arr.length-1);
			swap(arr, i, j);
			System.out.println();
			for(int k=0; k<arr.length; k++)
				System.out.print(arr[k] + ", ");
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}

	private static int indexSmallest(int[] arr, int lower, int upper) 
	{
		int indexMin = lower;
		for (int i = lower+1; i <= upper; i++)
		{
			if (arr[i] < arr[indexMin])
				indexMin = i;
		}
		return indexMin;
	}	


}
