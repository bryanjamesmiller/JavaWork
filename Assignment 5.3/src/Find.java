//Find.java

/** 
 *  This program takes the first command line argument
 *  and searches all files specified after it on the
 *  command line.  It then prints all lines in these files
 *  that contains the designated word, along with the 
 *  name of the file it is contained in.
 *    
 *    
 * @author    Bryan Miller
 * @version   Last modified on 3/17/2014
 **/
import java.io.*;
import java.util.*;
public class Find {
	public static void main(String[] args){
		for(int i=0; i<args.length-1; i++){
			searchOneFile(args[0], args[i+1]);
		}
	}

	/** 
	 *  This method takes in the name of a word to search for 
	 *  and the name of a file to search for it in.  It
	 *  then prints all the occurrences of that word in 
	 *  the file along with the file's name.
	 *    
	 * @param	searchForThis	A String that is the word being
	 * 							searched for.
	 * @param	searchInThisFile	A String that is the name
	 * 							of the file in which to search
	 * 							for the designated word.
	 **/
	public static void searchOneFile(String searchForThis, String searchInThisFile){
		String oneLineFromFile;
		try{
			Scanner fileReader=new Scanner(new File (searchInThisFile));
			while(fileReader.hasNextLine()){
				oneLineFromFile=fileReader.nextLine();
				if(oneLineFromFile.contains(searchForThis))
					System.out.println(searchInThisFile + ":\t" + oneLineFromFile);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.  Please try again!");
		}
	}
}