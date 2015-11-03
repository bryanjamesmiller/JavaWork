import java.io.*;

//I believe this is an outdated way of reading a file, but you can read one whole line at a time this way.
//We learned it because Buffered Reader has a nice new ability that Scanners don't have.  Scanners won't go back in the file.
//If you have a file that you need to go through more than once, the buffered reader can do it.  The mark() function will allow you to move around
// in the file.

//In order to run this program, you have to use the command line for user input for file name parameters.
public class BufferedFileReader {
	public static void main(String[] args){
		try{
			File f = new File(args[0]);

			//Crazy initialization though
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			PrintWriter myOutputPrinter = new PrintWriter(args[1]);  //The args[1] just gets the filename from the user's command line second file name they enter when they run the program. 
			String line;

			line=br.readLine();
			while(line!=null){
				myOutputPrinter.println(line);
				line=br.readLine();
			}

			/* The above is the same thing as:
			 * while ((line = br.readLine()) != null){
			 * output.println(line);
			 */

			br.close();
			myOutputPrinter.close();}
		catch(IOException ioe){

		}
	}
}
