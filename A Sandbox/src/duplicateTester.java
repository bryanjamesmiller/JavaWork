
public class duplicateTester {

	public static void main(String [] args)
	{
		int[] myArray = {1, 2, 3, 4, 5, 6, 7};
		int[] myArray2 = {1, 1, 3, 4, 1};
		System.out.println("array has no duplicates:");
		System.out.println("number of duplicates: " + numDuplicatesA(myArray));
		System.out.println("array is all duplicates:");
		
		numDuplicatesA(myArray2);
		System.out.println("number of duplicates: " + numDuplicatesA(myArray2));
	}
	public static int numDuplicatesA(int[] arr) {

		int numDups = 0;
		int counter=0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				System.out.println("i = " + i);
				System.out.println("j = " + j);
				counter++;
				
				System.out.println("the number of comparisons is " + counter);
				if (arr[j] == arr[i]) {
					numDups++;
					System.out.println("number of duplicates: " + numDups);
					break;
				}
			}
		}
		return numDups;
	}
}
