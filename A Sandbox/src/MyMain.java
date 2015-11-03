
public class MyMain 
{
		public static void main(String[] args)
		{
			String message = "hello, world";
			ArrayBag b = new ArrayBag(4);
			System.out.println(b.add(message));
			System.out.println(b.add(message));
			System.out.println(b.add(message));
			System.out.println(b.add(message));
			System.out.println(b.add(message));
			System.out.println("----------");
			System.out.println(b.contains(message));
			System.out.println(b.contains("hello, world"));  //Notice the string itself is an object also equals to the object stored in the array in the object
			System.out.println("----------");
			ArrayBag stringBag = b;
			String str = (String) stringBag.grab();  //Must cast
			System.out.println(str);
		}
	
}
