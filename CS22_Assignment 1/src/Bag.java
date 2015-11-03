/* 
 * Bag.java
 * 
 * Author:          Computer Science E-22 staff
 * Modified by:     Bryan Miller, bmiller100wpm@gmail.com
 * Date modified:   9/4/2014
 */

/**
 * An interface for a Bag ADT.
 */
public interface Bag {
	/**
	 * Returns the maximum number of items that the Bag is able to hold,
	 * irrespective of the number of items that are currently in
	 * the Bag.  This is the same maximum size specified when 
	 * the Bag was created.
	 * 
	 * @return	int	The same maximum size specified when 
	 * the Bag was created. 
	 */
	public int capacity();
	
	/**
	 * Tells whether or not the Bag is full.
	 * 
	 * @return	boolean	True if the Bag is full, false if the Bag is not full.
	 */
	public boolean isFull();
	
	/**
	 * Increases the maximum capacity of the bag by the amount
	 * passed in as a parameter.  This is an increase in addition
	 * to the original maximum capacity of the bag.
	 * 
	 * @param	increment	This is an integer variable that is the
	 * increase in addition to the original max capacity of the bag.
	 */
	public void increaseCapacity(int increment);
	
	/**
	 * Attempts to remove from the called Bag all occurrences of the items found
	 *  in the parameter Bag other.   All copies of "other Bag" items are removed 
	 *  from the called Bag, no matter how many there are in the called Bag.
	 *  
	 *   @param	other		This is a Bag object whose items are all removed from 
	 *   the called Bag.
	 *   
	 *   @return	boolean	Returns true if one or more items are removed, 
	 *   or false if nothing is removed
	 */
	boolean removeItems(Bag other);
	
	/**
	 * Creates and returns a Bag containing one occurrence of any item
	 * found within either the called Bag object or the Bag parameter named "other".
	 * 
	 * @param other This is a Bag object to add one occurrence of its items to
	 * the called Bag.	
	 * 
	 * @return Bag This is the Bag object that has one occurrence of items from
	 * either itself and/or from the parameter Bag.
	 */
	Bag unionWith(Bag other);
	
    /** 
     * adds the specified item to the Bag.  Returns true on success
     * and false if there is no more room in the Bag.
     */
    boolean add(Object item);

    /** 
     * removes one occurrence of the specified item (if any) from the
     * Bag.  Returns true on success and false if the specified item
     * (i.e., an object equal to item) is not in the Bag.
     */
    boolean remove(Object item);

    /**
     * returns true if the specified item is in the Bag, and false
     * otherwise.
     */
    boolean contains(Object item);

    /**
     * returns true if the calling object contain all of the items in
     * otherBag, and false otherwise.  Also returns false if otherBag 
     * is null or empty. 
     */
    boolean containsAll(Bag otherBag);

    /**
     * returns the number of items in the Bag.
     */
    int numItems();

    /**
     * grab - returns a reference to a randomly chosen in the Bag.
     */
    Object grab();

    /**
     * toArray - return an array containing the current contents of the bag
     */
    Object[] toArray();
} 
