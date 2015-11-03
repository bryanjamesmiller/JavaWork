// File LinkedDequeue.java 
/** 
 *  This class represents a Queue datatype implemented using a singly-linked
 *  list with appropriate operations.
 *
 * @author:	Henry Leitner/Bryan Miller
 * @version: Last modified on April 26, 2014
 * Implements a Queue as a linked-list
 */
public class LinkedDequeue {
	private QueueNode rear;
	private QueueNode front;
	private int count;

	/**
	 *  The QueueNode class is an inner class implemented to model a queue node;
	 *  it can contain an Object type of data, and also holds the link to the
	 *  next node in the queue.  If there are no other nodes, the link will be null.
	 */
	class QueueNode        
	{
		private Object item;
		private QueueNode link;
	}

	/**
	 *  This constructor for the class will set up the needed instance variables
	 *  which begin with no nodes present and thus are set to null.
	 */
	public LinkedDequeue ()
	{
		rear = front = null;
		count = 0;
	}

	/**
	 *  This method will construct a new QueueNode and add it onto the rear
	 *  of the queue (standard FIFO behavior). If it is the first node added into
	 *  the queue, both front and rear will reference it, otherwise it is added
	 *  using the rear variable.  The node counter is also updated.
	 *
	 *  @param   x     The Object to be added as part of a new QueueNode
	 */
	void tailAdd(Object x){
		QueueNode temp = new QueueNode();
		temp.item = x;
		temp.link = null;  

		if (rear == null) 
			front = rear = temp;
		else
		{
			rear.link = temp;
			rear = temp;
		}
		count++ ;
	}	

	/**
	 *  This method will construct a new QueueNode and add it onto the front
	 *  of the queue. If it is the first node added into the queue, both front
	 *  and rear will reference it, otherwise it is added using the front 
	 *  variable.  The node counter is also updated.
	 *
	 *  @param   x     The Object to be added as part of a new QueueNode
	 */
	void headAdd (Object o){
		QueueNode temp = new QueueNode();
		temp.item = o;
		temp.link = front;  

		if (front == null) 
			front = rear = temp;
		else
		{
			front = temp;
		}
		count++ ;
	}

	/**
	 *  This method will test for an empty queue and return a boolean result.
	 *
	 *  @return     true for an empty list; false if the queue contains QueueNodes.
	 */
	public boolean isEmpty()
	{
		return ( count == 0 );
	}

	/**
	 *  This method will evaluate and return the current size of the queue.
	 *
	 *  @return     An int describing the current number of nodes in the queue
	 */
	public int size()
	{
		return count;
	}

	/**
	 *  This method will remove an item from the front of the queue.  
	 *  In doing so, the queue variables are reset to detach the node,
	 *  and the Object which it contains is then returned.  The queue
	 *  counter is also updated to reflect the removal.
	 *
	 *  @return     The Object which was just removed from the queue.
	 */
	public Object headRemove () throws DequeueUnderFlowException
	{
		if(front==null)
			throw new DequeueUnderFlowException();
		if ( isEmpty() ) 
			return null;
		else
		{
			Object tempItem = front.item;
			front = front.link;
			if (front == null)   
				rear = null;
			count -- ;
			return tempItem;
		}
	}

	/**
	 *  This method will remove an item from the back of the queue.  
	 *  In doing so, the queue variables are reset to detach the node,
	 *  and the Object which it contains is then returned.  The queue
	 *  counter is also updated to reflect the removal.
	 *
	 *  @return     The Object which was just removed from the queue.
	 */
	Object tailRemove() throws DequeueUnderFlowException{
		if(rear==null)
			throw new DequeueUnderFlowException();
		QueueNode temp = front;

		if ( isEmpty() ) 
		{
			front=null;
			return null;
		}
		//While loop finds the last link before a link is null (which the last node will have)
		while (temp.link.link != null) 
		{
			temp = temp.link;
		}
		temp.link=null;  //cuts the last link (which was to the node with a null link) to get rid of the last node
		return temp.item;
	}

	/**
	 * This method prints out the whole list neatly and 
	 * returns it as a String.
	 * 
	 * @return	myString The String of the list.
	 */
	public String toString(){
		QueueNode position = front;
		String myString="";
		while (position != null)
		{
			myString+=position.item + "\n";
			position = position.link;
		}
		return myString;
	}

	/**
	 * This method returns the Object at the front of the list
	 * 
	 * @return The Object at the head of the list.
	 */
	Object headPeek () throws DequeueUnderFlowException{
		if(front==null)
			throw new DequeueUnderFlowException();
		return front.item;
	}

	/**
	 * This method returns the Object at the back of the list
	 * 
	 * @return The Object at the tail of the list.
	 */
	Object tailPeek() throws DequeueUnderFlowException{
		if(rear==null)
			throw new DequeueUnderFlowException();
		return rear.item;
	}
}

