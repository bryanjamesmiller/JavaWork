
public class QuickSort {

	static int counter2=0;
	
	public static void main(String[] args)
	{
		int[] myArray = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int[] myArray2 = {1, 2, 3, 4, 5};
		//SelectionSort just finds the lowest number in the array and swaps it with the first index,
		//then it finds the second lowest number in the array and swaps it with the second index, etc.
		quickSorter(myArray2);
//		for(int i=0; i<myArray.length; i++)
	//		System.out.print(myArray[i] + ", ");	
	}

	public static void quickSorter(int[] arr) {
		qSort(arr, 0, arr.length - 1); 
	}

	//This method is the recursive method that keeps sorting smaller and smaller subarrays
	private static void qSort(int[] arr, int first, int last) {
		
		//The partition method is where the swapping actually happens
		int split = partition(arr, first, last);
		
		if (first < split)
			qSort(arr, first, split); // sort the left subarray recursively, breaking it into little subarrays until you just have 1 element, 
		//then recombining them like a tree
		
		if (last > split + 1)
			qSort(arr, split + 1, last); // Same thing as above for the right subarray
	}

	//This method makes a swap if the left index finds something less than the right index.  
	//The two indexes start from both ends and move towards the middle, and make a swap if something on the left side of the array is greater than the 
	// partition value, and something on the right side of the array is less than the partition value.  Then they swap.  The index positions don't have
	// to be symmetrical (and usually aren't).  In other words, i might find something it wants to swap right away at index=0, but the j index might
	// have to go through a few values from the right end towards the middle before finding something it wants to swap.  Once they both find
	// something they want to swap, they do (including the partition value that can be swapped), and then they keep on heading towards the middle
	// by going to the next index closer in.  Once the two indexes reach each other or pass each other on the array index, they quit and return the 
	// position of j (you don't need to know both i and j because they will be equal or one apart, i believe...).  That value becomes the pivot
	// for the next split in the recurisve call.  
	
	private static int partition(int[] arr, int first, int last) 
	{
		//This pivot value is calculated in a random manner, actually, because
		//you don't know what value is going to be in the array at the middle location,
		//and that is the value you are going to use for your pivot.  You're only guaranteed
		//that it will be an actual value in the array.
		int pivot = arr[(first + last)/2];
		System.out.println("\nThe pivot is: " + pivot);
		int i = first - 1; // index going left to right
		int j = last + 1; // index going right to left
		while (true) {
			do {
				i++;
				counter2++;
				System.out.println("The number of comparisons are: " + counter2);
				System.out.println("arr[i] is " + arr[i] + " and i is " + i);
			} while (arr[i] < pivot);
			do {
				j--;
				counter2++;
				System.out.println("The number of comparisons are: " + counter2);
				System.out.println("arr[j] is " + arr[j] + " and j is " + j);

			} while (arr[j] > pivot);
			
			counter2++;
			System.out.println("The number of comparisons are: " + counter2);
			if (i < j)
			{
				swap(arr, i, j);
				System.out.println("\nSwapping results in: ");
				for(int k=0; k<arr.length; k++)
					System.out.print(arr[k] + ", ");	
			}
			else
			{
					System.out.println("\nRBRRR results are: ");
					for(int k=0; k<arr.length; k++)
						System.out.print(arr[k] + ", ");	

				return j; // arr[j] = end of left array
			}
		} 
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}

}
