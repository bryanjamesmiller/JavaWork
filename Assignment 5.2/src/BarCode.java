//BarCode.java

/** 
 *  This class takes a 5-digit ZIP code as input, and prints
 *  the bar code using the symbol | for a full bar and : for a half bar. 
 *  It also takes a bar code as input and print the corresponding 5-
 *  digit ZIP code.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 2/24/2014
 **/
public class BarCode 
{
	private String myZipCode;
	private String myBarCode;
	private final int INT_ERROR=-1;
	private final char CHAR_ERROR=' ';
	private final String STRING_ERROR="";

	/** 
	 *  This constructor takes a 5-digit ZIP code or a 32-character bar code
	 *  as input and stores it in either myZipCode or myBarCode as appropriate.
	 *  Then it calls the encode or decode method to manipulate myBarCode or myZipCode.
	 *  
	 * @param	myZipCode	This is a five-digit ZIP code that is to be encoded
	 **/
	public BarCode(String myZipOrBarCode)
	{
		if(myZipOrBarCode.length()==5)
		{
			myZipCode=myZipOrBarCode;
			encode(myZipCode);
		}
		else
		{
			myBarCode=myZipOrBarCode;
			decode(myBarCode);
		}
	}

	/** 
	 *  This method takes a digit as a parameter and returns the five bars that
	 *  represent the digit.
	 *  
	 * @param	myDigit	This is a 1-digit character of a ZIP code String
	 * @return	This is the five-bar String representation of myDigit
	 **/
	private String digitToCode(char myDigit)
	{
		switch (myDigit)
		{
		case '1':
			return ":::||";
		case '2':
			return "::|:|";
		case '3':
			return "::||:";
		case '4':
			return ":|::|";
		case '5':
			return ":|:|:";
		case '6':
			return ":||::";
		case '7':
			return "|:::|";
		case '8':
			return "|::|:";
		case '9':
			return "|:|::";
		case '0':
			return "||:::";
		default:
			return STRING_ERROR;
		}
	}

	/** 
	 *  This method converts a five-character bar code to 
	 *  a digit corresponding to a ZIP code integer.
	 *  
	 * @param	myBar	This is five-character bar code String
	 * @return	myDigit	This is a 1-digit character of a ZIP code String
	 * 					that corresponds to myBar.
	 **/
	private char codeToDigit(String myBar)
	{
		switch (myBar)
		{
		case ":::||":
			return '1';
		case "::|:|":
			return '2';
		case "::||:":
			return '3';
		case ":|::|":
			return '4';
		case ":|:|:":
			return '5';
		case ":||::":
			return '6';
		case "|:::|":
			return '7';
		case "|::|:":
			return '8';
		case "|:|::":
			return '9';
		case "||:::":
			return '0';
		default:
			return CHAR_ERROR;
		}
	}

	/** 
	 * This method tests the 5-digit ZIP code myZipCode and returns the 
	 * 32-symbol bar code.
	 *  
	 * @param	myZipCode	This is five-character bar code String
	 * @return	myBarCode	This is a 32-symbol bar code that corresponds
	 * 						to myZipCode.
	 **/
	private String encode(String myZipCode)
	{
		myBarCode="|";
		for(int i=0; i<myZipCode.length(); i++)
		{
			myBarCode+=digitToCode(myZipCode.charAt(i));
		}
		char checkDigit=getCheckDigit(myZipCode);
		myBarCode+=digitToCode(checkDigit);
		myBarCode+="|";
		return myBarCode;
	}

	/** 
	 *  This method tests the 32 symbol bar code myBarCode and returns
	 *  the 5-digit ZIP code as a String. If the bar code is invalid, 
	 *  the method returns  "".
	 *  
	 * @param	myBarCode	The 32-character bar code String
	 * @return	The 5-digit ZIP code String
	 * 			that corresponds to myBarCode, or "" if the bar
	 * 			code is invalid.
	 **/
	private String decode(String myBarCode)
	{
		myZipCode="";
		if(!isValidBarCode(myBarCode))
			return "";

		/*The below ignores the first, the last framing bar, and the "check
		digit", and takes the rest of the bar code five characters at a time.
		to turn into the numerical equivalent.*/ 
		for(int i=1; i<myBarCode.length()-6; i+=5)
		{
			myZipCode+=codeToDigit(myBarCode.substring(i, i+5));
		}
		return myZipCode;
	}

	/** 
	 *  This method checks to see is a bar code is a valid 
	 *  sequence.
	 *  
	 * @param	myBarCode	This is a 5-digit ZIP code String
	 * @return	isValid		A boolean value that is true if the
	 * 						bar code is valid, otherwise it is false.
	 **/
	private boolean isValidBarCode(String myBarCode)
	{
		//The below checks for valid beginning and ending frame bars.
		if(myBarCode.charAt(0)!='|' || myBarCode.charAt(myBarCode.length()-1)!='|')
			return false;

		//The below checks for valid substrings of length five at a time, and
		//ignores the first and last frame bars.
		for(int i=1; i<myBarCode.length()-1; i+=5)
		{
			if(myBarCode.substring(i, i+5) != ":::||" || 
					myBarCode.substring(i, i+5) != "::|:|" 
					|| myBarCode.substring(i, i+5) != "::||:" 
					|| myBarCode.substring(i, i+5) != ":|::|" 
					|| myBarCode.substring(i, i+5) != ":|:|:" 
					|| myBarCode.substring(i, i+5) != ":||::"
					|| myBarCode.substring(i, i+5) != "|:::|" 
					|| myBarCode.substring(i, i+5) != "|::|:" 
					|| myBarCode.substring(i, i+5) !="|:|::" 
					|| myBarCode.substring(i, i+5) !="||:::")
				continue;
			else
				return false;
		}
		return true;
	}

	/** 
	 *  This method returns the integer 0-9 that is necessary for the sum of the
	 *  digits to equal the next multiple of 10.
	 *  
	 * @param	myZipCode	This is a 5-digit ZIP code String
	 * @return	checkDigit	This is the character 0-9 that makes
	 * 						the sum of the digits equal to a
	 * 						multiple of 10.
	 **/
	private char getCheckDigit(String myZipCode)
	{
		int myDigit=0;
		int myInt=0;
		int mySum=0;
		char myChar;

		for(int i=0; i<myZipCode.length(); i++)
		{
			/*I believe there are also Java API methods that can do 
			the below conversion, but I'm not sure if we're allowed to use 
			them, so I made my own*/
			myInt=charToIntConverter(myZipCode.charAt(i));
			mySum+=myInt;
		}

		//The below finds what must be added to get the last digit to equal a zero.
		int resetMySum=mySum;
		for(int i=0; i<10; i++)
		{
			mySum=resetMySum;
			mySum+=i;
			if(mySum%10==0)
				myDigit=i;
		}

		/*I think there is a Java API method that can do this also,
		but again I'm not sure if we're allowed to use it.*/
		return intToCharConverter(myDigit);
	}

	/** 
	 *  This method returns the ZIP code String.
	 *  
	 * @return	myZipCode	This is a 5-digit ZIP code String
	 **/
	public String getZipCode()
	{
		return myZipCode;
	}

	/** 
	 *  This method returns the bar code String.
	 *  
	 * @return	myBarCode	This is a 32-character bar code String
	 **/
	public String getBarCode()
	{
		return myBarCode;
	}

	/** 
	 *  This method converts a single-digit char integer to an int.
	 *  
	 * @param	ch		The char that will be converted to an int.
	 * @return			The int version of the char.
	 **/
	private int charToIntConverter(char ch)
	{
		switch (ch)
		{
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case '0':
			return 0;
		default:
			return INT_ERROR;
		}
	}

	/** 
	 *  This method converts an single-digit int to a char
	 *  
	 * @param	myDigit	The int that will be converted to a char
	 * @return			The char version of the int
	 **/
	private char intToCharConverter(int myDigit)
	{
		switch (myDigit)
		{
		case 1:
			return '1';
		case 2:
			return '2';
		case 3:
			return '3';
		case 4:
			return '4';
		case 5:
			return '5';
		case 6:
			return '6';
		case 7:
			return '7';
		case 8:
			return '8';
		case 9:
			return '9';
		case 0:
			return '0';
		default:
			return CHAR_ERROR;
		}
	}
}
