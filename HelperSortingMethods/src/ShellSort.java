
public class ShellSort 
{
	public static void main(String[] args)
	{
		int[] myArray = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		//ShellSort is the same thing as InsertionSort, except for two things (see below):
		shellSorter(myArray);
		for(int i=0; i<myArray.length; i++)
			System.out.print(myArray[i] + ", ");
	}
	
	
	public static void shellSorter(int[] arr) 
	{
		//Shell sort uses this increment in order to allow for bigger moves across the array,
		//it does this because it's a weakness of insertionSort when the largest element in the array
		//starts at index 0, as it will only move by 1 index all the way across the array.  Therefore, this allows you to
		//take a large element and let it leap further down the array using an "increment" instead of just moving things by "1". 
		// The increment doesn't work well though unless it's odd numbers that don't divide into each other.
		// Thus, all this increment math to prevent multiples of 2.
		int incr = 1;
		while (2 * incr <= arr.length)
			incr = 2 * incr;
		incr = incr - 1;
		
		//Just resetting the increment to 3 for the purposes of the HW question that requires it.
		incr=3;
		
		
		 while (incr >= 1) {
			 System.out.println("inrecement needs to be 3: " + incr);
			for (int i = incr; i < arr.length; i++) {
				//First it compares index 3 and index 0, then 
				//it compares index 4 and index 1,
				// then index 5 and 2,
				// then index 6 and 3, which is the first time it makes a change, with the 24 and the 8
				// then index 7 and 4, which also makes a change with the 33 and the 3
				if (arr[i] < arr[i-incr]) {
					int toInsert = arr[i];
					int j = i;
					do {
						arr[j] = arr[j-incr];
						j = j - incr;
					} while (j > incr-1 && 
							toInsert < arr[j-incr]);  //If you were to replace "incr" with "1", you would have regular InsertionSort!
					arr[j] = toInsert;
				}
				for(int j=0; j<arr.length; j++)
					System.out.print(arr[j] + ", ");
				System.out.println();
			}
			incr = incr/2;
		 }
	}

}
