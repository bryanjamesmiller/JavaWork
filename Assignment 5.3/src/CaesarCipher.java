//CasearCipher.java

/** 
 *  This program encodes or decodes an input file via user input
 *  on a line by line basis.  It shifts the contents according 
 *  to the user's input by a Caesar Cipher, and places the results 
 *  in an output file.  It ignores characters in the file that are 
 *  not upper-case alphabetic.  
 *    
 * @author    Bryan Miller
 * @version   Last modified on 3/21/2014
 **/
import java.io.*;
import java.util.*;
public class CaesarCipher {
	private final static int ENCIPHER=1;
	private final static int DECIPHER=2;
	private final static int EXIT=-1;
	private final static int NO_VALID_OPTION_ENTERED_YET=9999;
	private final static String FILE_NOT_FOUND="error9999";

	public static void main(String [] args){	
		Scanner userInput=new Scanner(System.in);
		System.out.println("Welcome to CaesarCipher\n");
		int optionForEncipherDecipherOrExit=NO_VALID_OPTION_ENTERED_YET;
		while(optionForEncipherDecipherOrExit!=EXIT){
			optionForEncipherDecipherOrExit=getEncipherOrDecipherOrExit(userInput);
			if(optionForEncipherDecipherOrExit!=EXIT){
				int shift=getShift(userInput);
				StringBuilder output=getInputFileName(userInput, optionForEncipherDecipherOrExit, shift);
				System.out.print("What is the output file name? ");
				String myOutputFileName=userInput.next();
				printToNewFile(myOutputFileName, output);
			}
		}
	}

	/**
	 *  This method gets the input file name and sends that file to the 
	 *  method shiftMyString to shift it as appropriate.  It returns the
	 *  shifted results to main. 
	 * 
	 * @param	userInput	This Scanner object allows for the program to read
	 * 						input typed in by the user regarding the input file name.
	 * @param	optionForEncipherDecipherOrExit	This is the user input integer that
	 * 					determines if the program enciphers, deciphers or exits
	 * 					the program.
	 * @param	shift	This is the integer that determines how many places 
	 * 					to shift the original data file's upper-case characters.	
	 * @return	output	This is the StringBuilder that contains the shifted
	 * 					string from the original file.
	 **/
	public static StringBuilder getInputFileName(Scanner userInput, int optionForEncipherDecipherOrExit, int shift){
		System.out.print("What is the input file name? ");
		String myInputFileName=userInput.next();
		File myInputFile=new File(myInputFileName);
		StringBuilder output=shiftMyString(optionForEncipherDecipherOrExit, shift, 
				myInputFile);
		String testForValidFile=output.substring(0);

		while(testForValidFile.equals(FILE_NOT_FOUND)){
			System.out.print("What is the input file name? ");
			myInputFileName=userInput.next();
			myInputFile=new File(myInputFileName);
			output=shiftMyString(optionForEncipherDecipherOrExit, shift, 
					myInputFile);
			testForValidFile=output.substring(0);
		}
		return output;
	}

	/**
	 *  This method gets input typed in by the user regarding if they would
	 * 	like to select a encipher, decipher or exit option with some rigorous 
	 * 	error prevention.  It then returns that option to main. 
	 * 
	 * @param	userInput	This Scanner object allows for the program to read
	 * 						input typed in by the user regarding if they would
	 * 						like to select a encipher, decipher or exit option.
	 * @return	optionForEncipherDecipherOrExit	This is the user input integer that
	 * 					determines if the program enciphers, deciphers or exits
	 * 					the program.
	 **/
	public static int getEncipherOrDecipherOrExit(Scanner userInput){
		int optionForEncipherDecipherOrExit=NO_VALID_OPTION_ENTERED_YET;
		boolean mustChooseFromCorrectOptions=false;
		while(mustChooseFromCorrectOptions==false){
			System.out.print("Enter 1 to encipher, or 2 to decipher (-1 to exit): ");
			if(!userInput.hasNextInt()){
				try{
					optionForEncipherDecipherOrExit=userInput.nextInt();
				}
				catch(InputMismatchException e){
					System.out.println("That is not 1, 2, or -1.  Please try again.");
					userInput.next();  //This gets rid of the newline character stuck in the Scanner
				}
			}
			else if(userInput.hasNextInt()){
				optionForEncipherDecipherOrExit=userInput.nextInt();				
			}
			if(optionForEncipherDecipherOrExit==ENCIPHER || optionForEncipherDecipherOrExit==DECIPHER || optionForEncipherDecipherOrExit==EXIT)
				mustChooseFromCorrectOptions=true;
		}
		return optionForEncipherDecipherOrExit;
	}

	/**
	 *  This method gets the number of shifts the user wants to implement
	 *  with some rigorous error prevention.  It also builds
	 *  the StringBuider named "output" that contains the shifted string 
	 *  from the original input file. 
	 * 
	 * @param	userInput	This Scanner object allows for the program to read
	 * 						input typed in by the user regarding how many
	 * 						shifts they would like.
	 * @return	shift	This is the integer that determines how many places 
	 * 					to shift the original data file's upper-case characters.
	 **/
	public static int getShift(Scanner userInput){
		boolean mustChooseFromCorrectOptions=false;
		int shift=NO_VALID_OPTION_ENTERED_YET;
		while(mustChooseFromCorrectOptions==false){
			System.out.print("What shift should I use? ");
			if(!userInput.hasNextInt()){
				try{
					shift=userInput.nextInt();
				}
				catch(InputMismatchException e){
					System.out.println("That is not an integer.  Please try again.");
					userInput.next();  //This gets rid of the newline character stuck in the Scanner
				}
			}
			else if(userInput.hasNextInt()){
				shift=userInput.nextInt();				
				mustChooseFromCorrectOptions=true;
			}
		}		
		return shift;
	}

	/**
	 *  This method implements the instructions to encipher, decipher, or
	 *  exit the program with some rigorous error prevention.  It also builds
	 *  the StringBuider named "output" that contains the shifted string 
	 *  from the original input file. 
	 * 
	 * @param	optionForEncipherDecipherOrExit	This is the user input integer that
	 * 					determines if the program enciphers, deciphers or exits
	 * 					the program.
	 * @param	shift	This is the integer that determines how many places 
	 * 					to shift the original data file's upper-case characters.
	 * @param	myInputFile	This is the File object that contains the original
	 * 					input file to be shifted.
	 * @return	output	This is the StringBuilder that contains the shifted
	 * 					string from the original file.
	 **/
	public static StringBuilder shiftMyString(int optionForEncipherDecipherOrExit, int shift, File myInputFile){
		StringBuilder output=new StringBuilder();
		StringBuilder input=new StringBuilder();
		try{
			Scanner fileReader=new Scanner(myInputFile);
			while(fileReader.hasNext()){
				String oneLineOfCode=fileReader.nextLine();
				for(int i=0; i<oneLineOfCode.length(); i++){
					input.append(oneLineOfCode.charAt(i));	
				}
				input.append('\n');
			}
			if(optionForEncipherDecipherOrExit==ENCIPHER)
				output=caesarEncipher (input, shift);
			else
				output=caesarDecipher (input, shift);
		}
		catch(FileNotFoundException e){
			System.out.println("Sorry, file not found.  Please try again!");
			output.append(FILE_NOT_FOUND);
			return output;
		}			
		return output;
	}

	/**
	 *  This method prints the shifted StringBuilder to a new file
	 *  for output.  The file's name is passed as an argument
	 *  to this method and was designated by the user.
	 * 
	 * @param	myOutputFileName	This String is the name of the new
	 * 								file where the output will be printed.
	 * @param	output	This is the StringBuilder that contains the shifted
	 * 					string from the original file.
	 **/
	public static void printToNewFile(String myOutputFileName, StringBuilder output){
		try{
			PrintWriter outFile = new PrintWriter (myOutputFileName);
			outFile.println(output);      
			outFile.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Sorry, file not found!");
		}
	}

	/**
	 *  This method shifts only the upper-case characters in the 
	 *  input String by the shift integer.  The shift occurs 
	 *  in the forward direction as it is the encipher function.
	 * 
	 * @param	input	This is the StringBuilder object containing
	 * 					the entire String from the data file.	
	 * @param	shift	This is the integer containing the amount
	 * 					of shift that the input String must undergo
	 * 					in the forward (encipher) direction
	 * @return	output	This is the new StringBuilder that has all
	 * 					of the upper-case letters successfully shifted.
	 **/
	public static StringBuilder caesarEncipher (StringBuilder input, int shift){
		StringBuilder output=new StringBuilder();
		for(int i=0; i<input.length(); i++){
			char myChar=input.charAt(i);
			if(Character.isUpperCase(input.charAt(i))){
				for(int j=0; j<shift; j++){
					if(myChar=='Z')
						myChar='A';
					else
						myChar++;
				}
			}
			output.append(myChar);
		}
		return output;
	}

	/**
	 *  This method shifts only the upper-case characters in the 
	 *  input String by the shift integer.  The shift occurs 
	 *  in reverse since it is executing the decipher function.
	 * 
	 * @param	input	This is the StringBuilder object containing
	 * 					the entire String from the data file.	
	 * @param	shift	This is the integer containing the amount
	 * 					of shift that the input String must undergo
	 * 					in the reverse (decipher) direction
	 * @return	output	This is the new StringBuilder that has all
	 * 					of the upper-case letters successfully shifted.
	 **/
	public static StringBuilder caesarDecipher (StringBuilder input, int shift){
		StringBuilder output=new StringBuilder();
		for(int i=0; i<input.length(); i++){
			char myChar=input.charAt(i);
			if(Character.isUpperCase(input.charAt(i))){
				for(int j=0; j<shift; j++){
					if(myChar=='A')
						myChar='Z';
					else
						myChar--;
				}
			}
			output.append(myChar);
		}
		return output;
	}
}