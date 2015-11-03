
public class StringRecu {

	public static void main (String [] args)
	{
		String myString="Foo";
		System.out.println(recurse(myString));
	}
	public static String recurse(String myString)
	{
		if(myString.length()==0)
			return "";
		else
		{			
			char ch = myString.charAt(0);
			//It works because ch is the FIRST PIECE THAT gets taken off (the F).String mySubString=recurse(myString.substring(1));
			return mySubString+ch;
			//It works because ch is the FIRST PIECE THAT gets taken off (the F). 
		}
	}

}
