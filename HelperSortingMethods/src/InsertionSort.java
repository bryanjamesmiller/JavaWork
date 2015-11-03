
public class InsertionSort 
{
	
	public static void main(String[] args)
	{
		int[] myArray = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int[] myArray2 = {1, 2, 3, 4, 5};
		insertionSort(myArray2);
		//for(int i=0; i<myArray.length; i++)
			//System.out.print(myArray[i] + ", ");
	}

	public static void insertionSort(int[] arr) {
int counter=0;
		for (int i = 1; i < 5; i++) 
		{
			System.out.println("\n" + i);
			//Each "for" loop compares ONLY the first two elements, i and i-1
			//If arr[i] < arr[i-1], then it puts arr[i] at arr[i-1] and shifts everything else over to the right one space.
			//So the first loop doesn't do anything because 10<18
			//the second loop sees 18 and 4, so it puts 4 at the left and shifts everything else to the right one space
			//the third loop doesn't do anything because 18<24
			//the fourth loop sees 24 and 33, so it doesn't do anything either
			//Eventually, when it gets to 12, it knows the EXACT RIGHT SPOT to insert it due to the "do...while" loop below.
			counter++;
			System.out.println("The number of comparisons are: " + counter);
			if (arr[i] < arr[i-1]) 
			{
				int toInsert = arr[i];

				int j = i;
				
				//This do..while loop is how InsertionSort knows where to put the number it's trying to insert in the right location
				do {
					arr[j] = arr[j-1];
					j = j - 1;
					counter++;
					counter++;
				} while (j > 0 && toInsert < arr[j-1]);
				arr[j] = toInsert;
			}
			System.out.println("The number of comparisons are: " + counter);
		//	for(int j=0; j<arr.length; j++)
		//		System.out.print(arr[j] + ", ");
		}
		//System.out.println("\n");
	}
}
