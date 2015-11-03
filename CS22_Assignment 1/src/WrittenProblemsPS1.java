public class WrittenProblemsPS1 {

	public static void main(String[] args){
		
		//System.out.println(mystery(5, 6));
		/*
		int[] myArray = {0, 2, 4, 6, 8, 10};
		for(int i : myArray){ 
			System.out.print("[" + i + "] ");
		}

		System.out.println();

		shiftRight(myArray);
		for(int i : myArray){ 
			System.out.print("[" + i + "] ");
		}
		
		int[] arr1={1, 3, 6};
		int[] arr2={1, 3, 5, 8, 12, 1, 3, 17, 1, 3, 6, 9, 1, 3, 6};
		System.out.print(indexOf(arr1, arr2));
		 */

		/*
		int[]a = {5, 4, 3, 2, 1};
		int[]b = {5, 4, 3, 2, 1};
		int[]c=a;
		for(int i=0; i<b.length; i++){

			c[i]=b[i];
		}
		b[3] += b.length;
		a[3]--;
		System.out.println(a[3] + " " + b[3] + " " + c[3]);

		for(int i : a){ 
			System.out.print("[" + i + "] ");
		}
		System.out.println();
		for(int i : b){ 
			System.out.print("[" + i + "] ");
		}
		System.out.println();
		for(int i : c){ 
			System.out.print("[" + i + "] ");
		}

		int[] searchArray={1, 2, 3};
		System.out.println(searchOriginal(2, searchArray));

		Object[] searchObjectArray={1, "b", 3.14};
		System.out.println(search("b", searchObjectArray));
		 */
		Object[] searchObjectArray={1, "b", 3.14};
		System.out.println(searchRecursively(1, searchObjectArray, 3));
	}

	public static boolean searchOriginal(int item, int[] arr){
		for (int i=0; i<arr.length; i++){
			if(arr[i]==item){
				return true;
			}
		}
		return false;
	}

	public static boolean search(Object myObject, Object[] arr){
		for (int i=0; i<arr.length; i++){
			if(arr[i].equals(myObject)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean searchRecursively(Object myObject, Object[] arr, int i)
	{
		if(i>arr.length-1 || i<0)
			throw new IllegalArgumentException("i must be a valid index value for arr");
		
		if(arr[i].equals(myObject))
			return true;
		else if(i==arr.length-1)
			return false;				
		return searchRecursively(myObject, arr, i+1);
	}


	public static void shiftRight(int[] arr){
		int temp[]=new int[arr.length];
		for(int i=0; i<arr.length-1; i++){
			temp[i+1]=arr[i];
		}
		temp[0]=arr[arr.length-1];

		for(int i=0; i<arr.length; i++){ 
			arr[i]=temp[i];
		}
	}

	public static void shiftRightV2(int[] arr){
		int temp=arr[arr.length-1];  //Store the last value of the array into temp
		for(int i=arr.length-1; i>0; i--){
			//Shift right, starting with the second to last value shifting into the last value
			arr[i]=arr[i-1];  
		}
		arr[0]=temp;
	}


	public static int mystery(int a, int b) {
		if (a * b == 0)
			return a;
		else{
			return b + mystery(a - 1, b - 2);
		}
	} 

	public static int indexOf(int[] arr1, int[] arr2)
	{
		if(arr1.length>arr2.length)
		{
			return -1;
		}

		for(int i=0; i<arr2.length-arr1.length; i++)
		{
			for(int j=0; j<arr1.length; j++)
			{
				if(arr1[j]==arr2[i+j])
				{
					if(j==arr1.length-1)
					{
						return i;
					}
				}
			}
		}
		return -1;
	}
}
