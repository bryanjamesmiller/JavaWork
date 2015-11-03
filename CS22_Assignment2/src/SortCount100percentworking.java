/*
 * SortCount.java
 *
 * Computer Science E-22, Harvard University
 *
 * Modified by:   <Bryan Miller>, <bmiller100wpm@gmail.com>
 * Date modified: <Oct. 4, 2014>
 */

import java.util.*;

/**
 * This class contains implementations of various array-sorting
 * algorithms.  All comparisons and moves are performed using helper
 * methods that maintain counts of these operations.  Each sort method
 * takes an array of integers.  The methods assume that all of the 
 * elements of the array should be sorted.  The algorithms sort the array
 * in place, altering the original array.
 */
public class SortCount100percentworking {
	/* 
	 * the integers in the test arrays are drawn from the range 
	 * 0, ..., MAX_VAL 
	 */
	private static int MAX_VAL = 65536;

	private static long compares;     // total number of comparisons
	private static long moves;        // total number of moves

	/*
	 * compare - a wrapper that allows us to count comparisons.
	 */
	private static boolean compare(boolean comparison) {
		compares++;
		return comparison;
	}

	public static void shellBubbleSort(int [] arr)
	{
		int incr = 1;
		while (2 * incr <= arr.length)
			incr = 2 * incr;
		incr = incr - 1;

		while (incr >= 1) 
		{
			System.out.println("\n\nAt the start of the while loop, the increment is " + incr);
			//These arrays will keep track of if there were any swaps for a given pass
			//through the array  
			boolean wasSwapped[]=new boolean[arr.length];

			//Initialize the wasSwapped array's first value to prevent a false test result below
			wasSwapped[0]=true;
			boolean nextIncr=false;

			//After each inner loop, the outer loop knows the next largest available
			//value has been placed on the first available index on the right end.
			//That value, and those before it, no longer need to be compared to all
			//the others in the array.  Therefore, each time the outer for loop runs,
			//it has one less element that needs to be considered.  When dealing with
			//increments, after the inner loop runs, the outer loop doesn't have to consider
			//the "incr" number of elements on the right end.  Even those elements aren't 
			//perfectly sorted yet, they will be when incr=1 and cleans up the small adjustments
			//that still need to be made to the array that is almost sorted.  Therefore,
			//Instead of i--; we have i=i-incr.  So if the array size is 5, i starts at 4 and incr at 3.
			//The inner loop runs once and we know index 4, 3, 2 are the three largest numbers in the array,
			//since they were compared with 0, 1, and 2 respectively, and swapped if needed.  Now incr is 1,
			//and we go through the whole array except for the last value (i=i-1) and the biggest value
			//gets swapped to the right each time, guaranteeing the final position for all values when
			//the outer for loop finishes.  

			//However, if no swaps get made during a certain incr=3, say for
			// indexes 0, 3, and 6, (in a larger array) then the next time the inner loop runs we can skip
			// that set of indexes.  

			for (int i = arr.length - 1; i > 0; i=i-incr) 
			{
				System.out.println("At the outer for loop, i is: " + i);
				//This for loop tests to see if no swaps were made for a given increment.
				for(int k=0; k<=i; k=k+incr)
				{
					System.out.println("Was swapped equals: " + wasSwapped[k]);
					//If there was at least one swap, then we just continue normally
					if(wasSwapped[k]==true)
						break;
					if(k==i)
						nextIncr=true;					
				}
			
				//the inner for loop goes through the array once EXCEPT for the rightmost values that
				// are "safe" by virtue of them having been bubbled to the right already.  With the "incr",
				// this means the "incr" amount on the right side doesn't need to be tested after every
				// inner for loop.  This is because it bubbles the # of increment values to the right side
				// after every completion of the inner for loop.
				// I need to keep track of the number of swaps, because if it is 0, you don't have to compare them again
				if(nextIncr==false)
				{
					for (int j = 0; j + incr <= i; j++) 
					{
						wasSwapped[j]=false;
						if (compare(arr[j+incr] < arr[j]))
						{	
							swap(arr, j, j+incr);
							wasSwapped[j]=true;
						}
					}
				}
			}
			//this division works because it casts to an int
			System.out.println("Do i get to the skip a pass part?");

			incr = incr/2;
		}
	}    	


	/*
	 * move - moves an element of the specified array to a different
	 * location in the array.  move(arr, dest, source) is equivalent
	 * to arr[dest] = arr[source].  Using this method allows us to
	 * count the number of moves that occur.
	 */
	private static void move(int[] arr, int dest, int source) {
		moves++;
		arr[dest] = arr[source];
	}

	/*
	 * swap - swap the values of two variables.
	 * Used by several of the sorting algorithms below.
	 */
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		moves += 3;
	}

	/** 
	 * randomArray - creates an array of randomly generated integers
	 * with the specified number of elements and the specified
	 * maximum value
	 */
	public static int[] randomArray(int n, int maxVal) {
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * (maxVal + 1));
		}

		return arr;
	}

	public static int[] randomArray(int n) {
		return randomArray(n, MAX_VAL);
	}

	/** 
	 * almostSortedArray - creates an almost sorted array of integers
	 * with the specified number of elements
	 */
	public static int[] almostSortedArray(int n) {
		/* Produce a random array and sort it. */
		int[] arr = randomArray(n);
		quickSort(arr);

		/* 
		 * Move one quarter of the elements out of place by between 1
		 * and 5 places.
		 */
		for (int i = 0; i < n/8; i++) {
			int j = (int)(Math.random() * n);
			int displace = -5 + (int)(Math.random() * 11);
			int k = j + displace;
			if (k < 0)
				k = 0;
			if (k > n - 1)
				k = n - 1;

			swap(arr, j, k);
		}

		return arr;
	}

	/**
	 * Sets the counts of moves and comparisons to 0.
	 */
	public static void initStats() {
		compares = 0;
		moves = 0;
	}

	/**
	 * Prints the current counts of moves and comparisons.
	 */
	public static void printStats() {
		int spaces;
		if (compares == 0)
			spaces = 0;
		else
			spaces = (int)(Math.log(compares)/Math.log(10));
		for (int i = 0; i < (10 - spaces); i++)
			System.out.print(" ");
		System.out.print(compares + " comparisons\t");

		if (moves == 0)
			spaces = 0;
		else
			spaces = (int)(Math.log(moves)/Math.log(10));
		for (int i = 0; i < (10 - spaces); i++)
			System.out.print(" ");
		System.out.println(moves + " moves");
	}

	/*
	 * indexSmallest - returns the index of the smallest element
	 * in the subarray from arr[lower] to arr[upper].  Used by
	 * selectionSort.
	 */
	private static int indexSmallest(int[] arr, int lower, int upper) {
		int indexMin = lower;

		for (int i = lower + 1; i <= upper; i++)
			if (compare(arr[i] < arr[indexMin]))
				indexMin = i;

		return indexMin;
	}

	/** selectionSort */
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int j = indexSmallest(arr, i, arr.length - 1);
			swap(arr, i, j);
		}
	}

	/** insertionSort */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (compare(arr[i] < arr[i-1])) {
				// Save a copy of the element to be inserted.
				int toInsert = arr[i];
				moves++;

				// Shift right to make room for element.
				int j = i;
				do {
					move(arr, j, j - 1);
					j = j - 1;
				} while (j > 0 && compare(toInsert < arr[j-1]));

				// Put the element in place.
				arr[j] = toInsert;
				moves++;
			}
		}
	}

	/** shellSort */
	public static void shellSort(int[] arr) {
		/*
		 * Find initial increment: one less than the largest
		 * power of 2 that is <= the number of objects.
		 */
		int incr = 1;
		while (2 * incr <= arr.length)
			incr = 2 * incr;
		incr = incr - 1;

		/* Do insertion sort for each increment. */
		while (incr >= 1) {
			for (int i = incr; i < arr.length; i++) {
				if (compare(arr[i] < arr[i-incr])) {
					int toInsert = arr[i];
					moves++;

					int j = i;
					do {
						move(arr, j, j-incr);
						j = j - incr;
					} while (j > incr-1 && compare(toInsert < arr[j-incr]));

					arr[j] = toInsert;
					moves++;
				}
			}

			// Calculate increment for next pass.
			incr = incr / 2;
		}
	}

	/** bubbleSort */
	public static void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (compare(arr[j] > arr[j+1]))
					swap(arr, j, j+1);
			}
		}
	}

	/*
	 * A helper method for qSort that takes the array that begins with
	 * element arr[first] and ends with element arr[last] and
	 * partitions it into two subarrays using the middle element of
	 * the array for the pivot.  It returns the index of the last
	 * element of the left subarray formed by the partition.  All
	 * elements in the left subarray are <= the pivot, and all
	 * elements in the right subarray are >= the pivot.
	 */
	private static int partition(int[] arr, int first, int last) {
		int pivot = arr[(first + last)/2];
		moves++;   // for the above assignment
		int i = first - 1;  // index going left to right
		int j = last + 1;   // index going right to left

		while (true) {
			// Moving from left to right, find an element >= the pivot.
			do {
				i++;
			} while (compare(arr[i] < pivot));

			// Moving from right to left, find an element <= the pivot.
			do {
				j--;
			} while (compare(arr[j] > pivot)); 

			// Swap the elements so that they end up in the correct
			// subarray, or quit if the indices have overlapped or crossed.
			if (i < j)
				swap(arr, i, j);
			else
				return j;   // index of last element in the left subarray
		}                   
	}

	/*
	 * A recursive helper method that actually implements quicksort.
	 * The initial recursive call is made by quicksort() -- see below.
	 */
	private static void qSort(int[] arr, int first, int last) {
		// Partition the array.  split is the index of the last
		// element of the left subarray formed by the partition.
		int split = partition(arr, first, last);

		//
		// Note that we only make recursive calls on subarrays that
		// have two or more elements, and thus the base case is when
		// neither subarray has two or more elements.
		//
		if (first < split)
			qSort(arr, first, split);      // left subarray
		if (last > split + 1)
			qSort(arr, split + 1, last);   // right subarray
	}

	/** quickSort */
	public static void quickSort(int[] arr) {
		qSort(arr, 0, arr.length - 1); 
	}

	/* merge - helper method for mergesort */
	private static void merge(int[] arr, int[] tmp, 
			int leftStart, int leftEnd, int rightStart, int rightEnd)
	{
		int i = leftStart;    // index into left subarray
		int j = rightStart;   // index into right subarray
		int k = leftStart;    // index into tmp

		while (i <= leftEnd && j <= rightEnd) {
			if (compare(arr[i] < arr[j]))
				tmp[k++] = arr[i++];
			else
				tmp[k++] = arr[j++];
			moves++;
		}

		while (i <= leftEnd) {
			tmp[k++] = arr[i++];
			moves++;
		}

		while (j <= rightEnd) {
			tmp[k++] = arr[j++];
			moves++;
		}

		for (i = leftStart; i <= rightEnd; i++) {
			arr[i] = tmp[i];
			moves++;
		}
	}

	/** mSort - recursive method for mergesort */
	private static void mSort(int[] arr, int[] tmp, int start, int end) {
		if (start >= end)
			return;

		int middle = (start + end)/2;
		mSort(arr, tmp, start, middle);
		mSort(arr, tmp, middle + 1, end);
		merge(arr, tmp, start, middle, middle + 1, end);
	}

	/** mergesort */
	public static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mSort(arr, tmp, 0, arr.length - 1);
	}

	/**
	 * Prints the specified array in the following form:
	 * { arr[0] arr[1] ... }
	 */
	public static void printArray(int[] arr) {
		// Don't print it if it's more than 10 elements.
		if (arr.length > 10)
			return;

		System.out.print("{ ");

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println("}");
	}

	public static void main(String args[]) {
		int[] a={17895, 5487, 12345, 25053, 17527, 62559, 28717 };       // the array
		int[] asave;   // a copy of the original unsorted array
		int numItems=7;
		String arrayType;

		/*
		 * Get various parameters from the user.
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("How many items in the array? 7" );
		//	numItems = in.nextInt();
		//	in.nextLine();
		System.out.println("Random (r), almost sorted (a), or fully sorted (f)? r");
		//	arrayType = in.nextLine();
		System.out.println();

		/* 
		 * Create the arrays.   

		if (arrayType.equalsIgnoreCase("A"))
			a = almostSortedArray(numItems);
		else {
			a = randomArray(numItems);
			if (arrayType.equalsIgnoreCase("F"))
				quickSort(a);
		}
		 */
		asave = new int[numItems];
		System.arraycopy(a, 0, asave, 0, a.length);
		printArray(a);

		/*
		 * Try each of the various algorithms, starting each time 
		 * with a fresh copy of the initial array.

		System.out.print("quickSort\t\t");
		System.arraycopy(asave, 0, a, 0, asave.length);
		initStats();
		quickSort(a);
		printStats();
		printArray(a);

		System.out.print("mergeSort\t\t");
		System.arraycopy(asave, 0, a, 0, asave.length);
		initStats();
		mergeSort(a);
		printStats();
		printArray(a);

		System.out.print("shellSort\t\t");
		System.arraycopy(asave, 0, a, 0, asave.length);
		initStats();
		shellSort(a);
		printStats();
		printArray(a);

		System.out.print("insertionSort\t\t");
		System.arraycopy(asave, 0, a, 0, asave.length);
		initStats();
		insertionSort(a);
		printStats();
		printArray(a);

		System.out.print("selectionSort\t\t");
		System.arraycopy(asave, 0, a, 0, asave.length);
		initStats();
		selectionSort(a);
		printStats();
		printArray(a);
		 */

		System.out.print("bubbleSort\t\t");
		System.arraycopy(asave, 0, a, 0, asave.length);
		initStats();
		bubbleSort(a);
		printStats();
		printArray(a);

		System.out.print("shellBubbleSort\t\t");
		System.arraycopy(asave, 0, a, 0, asave.length);
		initStats();
		shellBubbleSort(a);
		printStats();
		printArray(a);
	}
}
