
public class RandomNumGenerator {

	public static void main(String[] args) 
	{
		//Returns a number between 4 and 9:
		int myRandomInteger=rint(4, 9);
		System.out.println(myRandomInteger);
		System.out.println(rint(4, 9));
		System.out.println(rint(4, 9));
		System.out.println(rint(4, 9));
		System.out.println(rint(4, 9));
		System.out.println((1 + (int)((9-1+1) * Math.random())));
		
	}

	public static int rint (int a, int b)
	{
		return (a + (int)((b-a+1) * Math.random()));
	}


}
