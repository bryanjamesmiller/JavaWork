public class BubbleSort {

	public static void main(String[] args)
	{
		int[] myArray = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int[] myArray2 = {1, 2, 3, 4, 5};
;
		//BubbleSorter compares two values next to each other and swaps them if the first one is higher
		//than the second one.  Then it moves to the next value (and the second one of the previous two values) and
		//does the same thing.  So the biggest number is going to get bubbled all the way to the right side of the array
		//after every iteration, and other values may get swapped some as well.  
		bubbleSorter(myArray2);
	//	for(int i=0; i<myArray.length; i++)
	//		System.out.print(myArray[i] + ", ");
	}

	public static void bubbleSorter(int[] arr) {
		//I'm just adding the counters to help me see what's going on each loop
		int counter=1;
		int counter2=0;
		
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) 
			{
				counter2++;
				System.out.println("The number of comparisons are: " + counter2);
				if (arr[j] > arr[j+1])
					swap(arr, j, j+1);
			}
			
			//I'm just adding the counter to help me see what's going on each loop
			System.out.println("\n" + counter + " pass ");
			counter++;
			for(int j=0; j<arr.length; j++)
				System.out.print(arr[j] + ", ");
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}

}