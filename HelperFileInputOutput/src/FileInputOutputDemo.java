import java.io.*;	//For the File class
import java.util.*;  //For the Scanner class
public class FileInputOutputDemo {
	public static void main(String[] args) throws IOException{
		if(args.length!=2){
			System.out.println("Please enter a file name to copy from and a file name to copy to"
			+ " as two command-line args");
			System.exit(0); //You should quit here so the user can look at the file name he wants to copy from)
		}
		Scanner fileReader = new Scanner (new File(args[0]));  //The "new File(args[0])" part is called something like a phantom object, because it's not defined
		PrintWriter filePrinter = new PrintWriter(args[1]);
		
		while(fileReader.hasNextLine()){
			String myStringReadFromFile=fileReader.nextLine();
			filePrinter.println(myStringReadFromFile);
		}
		System.out.println("\nAll Done!\n");
		fileReader.close();
		filePrinter.close();
	}
}
