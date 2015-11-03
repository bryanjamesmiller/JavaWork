
public class sandbag1 
{
	static int counter=0;
	static int counter2=0;

	public static void main (String [] args)
	{
		generateSums(5);
		System.out.println("the number of times is: " + counter);

		myGenerateSums(5);
		System.out.println("the number of times is: " + counter2);
	}

	public static void generateSums(int n) {
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				counter++;
				sum = sum + j; // how many times is this executed?
			}
			System.out.println(sum);
		}
	}

	public static void myGenerateSums(int n) {

		for(int i=1; i<n; i++)
		{
			System.out.println(i*(i+1)/2);
		}
		int sum=n*(n+1)/2;
		counter2++;

		System.out.println(sum);
	}

}
