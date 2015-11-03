//BarCodeTest.java

/** 
 *  This class tests the BarCode object using a variety of
 *  input and outputs.
 *  
 * @author    Bryan Miller
 * @version   Last modified on 2/24/2014
 **/
import java.util.*;
public class BarCodeTest 
{
	public static void main (String [] args)
	{
		BarCode myFirstBarCode=new BarCode("02138");
		System.out.println(myFirstBarCode.getBarCode());

		BarCode mySecondBarCode=new BarCode("||:|:::|:|:||::::::||:|::|:::|||");
		if(mySecondBarCode.getZipCode()=="")
			System.out.println("This is not a valid bar code.");
		else
			System.out.println(mySecondBarCode.getZipCode());

		BarCode myThirdBarCode=new BarCode("63017");
		System.out.println(myThirdBarCode.getBarCode());

		BarCode myFourthBarCode=new BarCode("|:||::::||:||::::::|||:::|::||:|");
		System.out.println(myFourthBarCode.getZipCode());

		BarCode myFifthBarCode=new BarCode("||:::||::|:::|:|:|::|||:::||:::|");
		if(myFifthBarCode.getZipCode()=="")
			System.out.println("This is not a valid bar code.");
		else
			System.out.println(myFifthBarCode.getZipCode());

		BarCode mySixthBarCode=new BarCode("||:|:::|:|:||::::::||:|::|:::||");
		if(mySixthBarCode.getZipCode()=="")
			System.out.println("This is not a valid bar code.");
		else
			System.out.println(mySixthBarCode.getZipCode());

		BarCode mySeventhBarCode=new BarCode("||:|:::|:|:||::::::||:|::|:::||:");
		if(mySeventhBarCode.getZipCode()=="")
			System.out.println("This is not a valid bar code.");
		else
			System.out.println(mySeventhBarCode.getZipCode());

	}
}
