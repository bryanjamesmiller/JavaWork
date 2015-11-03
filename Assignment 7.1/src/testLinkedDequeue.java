
/**
 * This class tests the LinkedDequeue object.
 * 
 * @author Bryan Miller
 * @version	Last modified 4/26/2014
 *
 */
public class testLinkedDequeue {
	/**
	 * Main tests the LinkedDequeue object.
	 * @throws DequeueUnderFlowException 
	 */
	public static void main(String []args) throws DequeueUnderFlowException{		
		LinkedDequeue myQueue=new LinkedDequeue ();

		try{
			myQueue.tailPeek();
		}
		catch(Exception e){
			System.out.println("This should throw my DequeueUnderFlowException exception for tailPeek:  ");
		}

		try{
			myQueue.headPeek();
		}
		catch(Exception e){
			System.out.println("This should throw my DequeueUnderFlowException exception for headPeek:  ");
		}
		try{
			myQueue.headRemove();
		}
		catch(Exception e){
			System.out.println("This should throw my DequeueUnderFlowException exception for headRemove:  ");
		}		
		try{
			myQueue.tailRemove();
		}
		catch(Exception e){
			System.out.println("This should throw my DequeueUnderFlowException exception for tailRemove:  ");
		}


		System.out.println("Is the queue empty?  " + myQueue.isEmpty());
		myQueue.tailAdd("one");
		myQueue.tailAdd("two");
		myQueue.tailAdd("I'm at the tail");
		myQueue.headAdd("foobar");
		myQueue.headAdd("I'm at the head");
		System.out.println("\nHere is the queue:\n" + myQueue.toString());
		System.out.println("The size of the queue is:  " + myQueue.size());
		System.out.println("The tail is now:  " + myQueue.tailPeek());
		System.out.println("The head is now:  " + myQueue.headPeek());
		System.out.println("The size of the queue is:  " + myQueue.size());
		System.out.println("\nHere is the queue:\n" + myQueue.toString());
		System.out.println("Is the queue empty?  " + myQueue.isEmpty());		
		myQueue.headRemove();
		System.out.println("\nHere is the queue:\n" + myQueue.toString());
		myQueue.tailRemove();
		System.out.println("\nHere is the queue:\n" + myQueue.toString());
	}
}
