/**
 * This class creates an exception to be thrown if the Queue is 
 * empty and a head or tail element is trying to be accessed.
 * 
 * 
 * @author Bryan Miller
 * @version Last modified 4/26/2014
 *
 */

public class DequeueUnderFlowException extends Exception {
	/**
	 * This constructor creates an exception to be thrown if the Queue is 
	 * empty and a head or tail element is trying to be accessed.
	 * 
	 */

	public DequeueUnderFlowException(){
		System.out.println("Error - Queue is already empty.  DequeueUnderFlowException thrown.");
	}
}
