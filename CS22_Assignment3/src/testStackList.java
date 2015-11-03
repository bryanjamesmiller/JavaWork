
public class testStackList {
	public static void main (String [] args)
	{
		System.out.println(isPalindrome("abcdcba"));
		System.out.println(isPalindrome("abccba"));
		System.out.println(isPalindrome("t"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("notapalindrome"));
	}
	
	public static boolean isPalindrome(String str)
	{
		if(str == null)
			throw new IllegalArgumentException("string is null");
		if(str.length() == 1)
			return true;

		LLStack<Character> myStack = new LLStack<Character>();

		Boolean myTest = false;
		if(str.length() % 2 == 0)
		{
			for(int i = 0; i < str.length()/2; i++)
			{
				Character myChar = str.charAt(i);
				myStack.push(myChar);
			}
			for(int i = str.length() / 2; i < str.length(); i++)
			{
				Character myChar = str.charAt(i);
				if(myChar != myStack.pop())
				{
					
					return false;
				}
			}
		}
		else
		{
			for(int i = 0; i < str.length()/2; i++)
			{
				Character myChar = str.charAt(i);
				myStack.push(myChar);
			}
			for(int i = str.length() / 2 + 1; i < str.length(); i++)
			{
				Character myChar = str.charAt(i);
				if(myChar != myStack.pop())
					return false;
			}
		}
		return true;
	}
}
