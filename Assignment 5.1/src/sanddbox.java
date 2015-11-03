
public class sanddbox {
	static int counter=0;

	public static void main (String[] args){
		System.out.println(power(2, 6));

		int[] x = {1, 2, 3, 4};
		trickyArrayMethods(x);
		System.out.println(x[0]);
	}
	public static void trickyArrayMethods(int x[]){
		x[0]=8;
		int y[]={7, 7, 7, 7};
		x=y;
		System.out.println(x.toString());
		System.out.println(y.toString());

		for(int i=0; i<y.length; i++){
			System.out.println(i);
			System.out.println(x[i]);
			System.out.println(y[i]);
			System.out.println();
		}
		System.out.println(x[0]);
		x[0]=9;
	}
	
	public static double power (double x, int n)
	{
		counter++;
		System.out.println(counter);

		if (n == 0) return 1.0;

		while(n%2==0)
		{
			n=n/2;
			x=x*x;
		}

		if (n > 0) 
		{
			return x * power(x, n-1);
		}
		else return 1.0 / power(x, -n);

	}



}
