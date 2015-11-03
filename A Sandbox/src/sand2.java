
public class sand2 {
	public static void main(String[] args){
		int[] myArray = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		insertionSort(myArray);
		for(int i=0; i<myArray.length; i++)
			System.out.print(myArray[i] + ", ");
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < 9; i++) 
		{
			System.out.println("\n" + i);
			//Each "for" loop compares ONLY the first two elements, i and i-1
			//If arr[i] < arr[i-1], then it puts arr[i] at arr[i-1] and shifts everything else over to the right one space.
			//So the first loop doesn't do anything because 10<18
			//the second loop sees 18 and 4, so it puts 4 at the left and shifts everything else to the right one space
			//the third loop doesn't do anything because 18<24
			//the fourth loop sees 24 and 33, so it doesn't do anything either
			if (arr[i] < arr[i-1]) 
			{
				int toInsert = arr[i];

				int j = i;
				do {
					arr[j] = arr[j-1];
					j = j - 1;
				} while (j > 0 && toInsert < arr[j-1]);
				arr[j] = toInsert;
			}
			for(int j=0; j<arr.length; j++)
				System.out.print(arr[j] + ", ");
		}
		System.out.println("\n");
	}
}
