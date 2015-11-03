
public class HelperArrayMethod {
	public static void main(String [] args)
	{
		//loop by iteration:

		int myArray[] = {1, 2, 7, 4};

		for(int i : myArray){ 
			System.out.println(i);
		}
		
		//Find the max value:
		int maxValue=myArray[0];
		for(int j : myArray){ 
			if(j>maxValue)
				maxValue=j;
		}
		System.out.println("The max value is: " + maxValue);

		testBaz();
		//		int[]a={1, 2, 3, 4};
		//		a=reverse(a);
		//		for(int i=0; i<a.length; i++){
		//			System.out.print(a[i]);
		//		}
	}
	static void testBaz(){
		int[] x = {1, 2, 3, 4};
		System.out.println(x);
		baz(x);
		System.out.println(x[0]);  //This value at index 0 gets changed in the method because x was still pointing at its original memory location
		System.out.println(x[1]);  //This value at index 1 does not get changed in the method because x wasn't pointing to its original memory location anymore, and became a temporary variable that was scoped within the method, which reverted back to the original variable at the original memory address when the method closed.
		System.out.println(x);  // See!  It printed out it's original memory address, even though we tried to change it in the method.  We did change it in the method, in fact, but then that x array variable became a local variable to the method, and was a different x array than this original x array.
	}

	static void baz(int[] x){
		/* Actually changes the real array above because it's 
	 referencing the same memory address of the original x array.*/
		x[0]=77777; 
		System.out.println(x);

		/* Tricky part:  The below doesn't actually change any of the values in the x array.
	 It only changes the address of where you can find x to the address of y.
	 However, the values in x still exist  */
		int[] y={9, 8, 7, 6};
		System.out.println(y);

		/* The below is tricky because at this point, x will be treated like a local variable.  
		 * The values in the original x array will not be changed.  When this method
		 * closes, the original x array will still have its original values in it.  The
		 * new x array will be at a different memory location, so after you do x=y
		 * any changes you try to make to the values in the x array will not affect
		 * the original anymore, because the new x array has a different memory address
		 * than the old x array.  */
		x=y;
		System.out.println(x);
		x[1]=9999;  //won't change the original x array values, because this x array points to a different memory address.
	}

	//This will reverse an array
	static int[] reverse(int[] a){
		/*You have to initialize an array,
	 because in Java, array sizes don't change.*/
		int[] answer = new int[a.length];
		for(int i=a.length-1; i>=0; i--){
			answer[a.length-i-1]=a[i];
		}
		return answer;
	}
}
