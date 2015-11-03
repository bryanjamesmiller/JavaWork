/* 
 * ArrayBag.java
 * 
 * Author:          Computer Science E-22 staff
 * Modified by:     Bryan Miller, bmiller100wpm@gmail.com
 * Date modified:   9/4/2014
 */

import java.util.*;

/**
 * An implementation of a Bag ADT using an array.
 */
public class ArrayBag implements Bag {
	/** 
	 * The array used to store the items in the bag.
	 */
	private Object[] items;

	/** 
	 * The number of items in the bag.
	 */
	private int numItems;

	public static final int DEFAULT_MAX_SIZE = 50;

	/**
	 * Default, no-arg constructor - creates a new, empty ArrayBag with 
	 * the default maximum size.
	 */
	public ArrayBag() {
		items = new Object[DEFAULT_MAX_SIZE];
		numItems = 0;
	}

	/** 
	 * A constructor that creates a new, empty ArrayBag with the specified
	 * maximum size.
	 */
	public ArrayBag(int maxSize) {
		if (maxSize <= 0)
			throw new IllegalArgumentException("maxSize must be > 0");
		items = new Object[maxSize];
		numItems = 0;
	}

	/**
	 * Returns the maximum number of items that the ArrayBag is able to hold,
	 * irrespective of the number of items that are currently in
	 * the ArrayBag.  This is the same maximum size specified when 
	 * the ArrayBag was created.
	 * 
	 * @return	int	The same maximum size specified when 
	 * the ArrayBag was created. 
	 */
	public int capacity(){
		return items.length;
	}

	/**
	 * Tells whether or not the ArrayBag is full.
	 * 
	 * @return	boolean	True if the ArrayBag is full, false if the ArrayBag is not full.
	 */
	public boolean isFull(){
		if(numItems==items.length)
			return true;
		return false;
	}

	/**
	 * Increases the maximum capacity of the ArrayBag by the amount
	 * passed in as a parameter.  This is an increase in addition
	 * to the original maximum capacity of the ArrayBag.
	 * 
	 * @param	increment	This is an integer variable that is the
	 * increase in addition to the original max capacity of the ArrayBag.
	 */
	public void increaseCapacity(int increment){
		if (increment <= 0)
			throw new IllegalArgumentException("The increment must be > 0");
		Object[] temp = new Object[capacity() + increment];

		for(int i=0; i<items.length; i++){
			temp[i]=items[i];
		}
		items=temp;		
	}

	/**
	 * Attempts to remove from the called ArrayBag all occurrences of the items found
	 *  in the parameter Bag other.   All copies of "other Bag" items are removed 
	 *  from the called ArrayBag, no matter how many there are in the called ArrayBag.
	 *  
	 *   @param	other	This is a Bag object whose items are all removed from 
	 *   the called ArrayBag.
	 *   
	 *   @return	boolean	Returns true if one or more items are removed, 
	 *   or false if nothing is removed
	 */
	public boolean removeItems(Bag other){
		int didRemove=this.numItems;

		if (other.equals(null))
			throw new IllegalArgumentException("The parameter was null.");
		if(other.numItems()==0)
			return false;

		for(int i=0; i<this.numItems; i++)
		{
			while(other.contains(items[i]))
			{
				this.remove(this.items[i]);
			}
		}

		if(didRemove!=this.numItems)
			return true;
		return false;
	}

	/**
	 * Creates and returns a Bag containing one occurrence of any item
	 * found within either the called ArrayBag object or the Bag parameter 
	 * named "other".
	 * 
	 * @param other This is a Bag object to add one occurrence of its items to
	 * the new Bag.	
	 * 
	 * @return Bag This is the newly created Bag object that has one occurrence 
	 * of items from the called Bag and/or from the parameter Bag.
	 */
	public Bag unionWith(Bag other){
		if (other.equals(null))
			throw new IllegalArgumentException("The parameter was null.");

		if(this.numItems==0 && other.numItems()==0)
			return new ArrayBag();

		Bag newBag=new ArrayBag(this.capacity()+other.capacity()); 

		int counter=this.numItems();
		if(other.numItems()>counter)
			counter=other.numItems();

		for(int i=0; i<counter; i++)
		{
			if(other.numItems()!=0)
			{
				Object temp = other.grab();
				if(!newBag.contains(temp))
					newBag.add(temp);
				other.remove(temp);
			}

			if(this.numItems()!=0)
			{
				Object temp = this.grab();
				if(!newBag.contains(temp))
					newBag.add(temp);
				this.remove(temp);
			}
		}

		return newBag;
	}

	/** 
	 * add - adds the specified item to the Bag.  Returns true on
	 * success and false if there is no more room in the Bag.
	 */
	public boolean add(Object item) {
		if (item == null)
			throw new IllegalArgumentException("item must be non-null");
		if (numItems == items.length)
			return false;              // no more room!
		else {
			items[numItems] = item;
			numItems++;
			return true;
		}
	}

	/** 
	 * remove - removes one occurrence of the specified item (if any)
	 * from the Bag.  Returns true on success and false if the
	 * specified item (i.e., an object equal to item) is not in the Bag.
	 */
	public boolean remove(Object item) {
		for (int i = 0; i < numItems; i++) {
			if (items[i].equals(item)) {
				// Shift the remaining items left by one.
				for (int j = i; j < numItems - 1; j++) 
					items[j] = items[j + 1];
				items[numItems - 1] = null;

				numItems--;
				return true;
			}
		}
		return false;  // item not found
	}

	/**
	 * contains - returns true if the specified item is in the Bag, and
	 * false otherwise.
	 */
	public boolean contains(Object item) {
		for (int i = 0; i < numItems; i++) {
			if (items[i].equals(item))
				return true;
		}
		return false;
	}

	/**
	 * containsAll - does this ArrayBag contain all of the items in
	 * otherBag?  Returns false if otherBag is null or empty. 
	 */
	public boolean containsAll(Bag otherBag) {
		if (otherBag == null || otherBag.numItems() == 0)
			return false;

		Object[] otherItems = otherBag.toArray();
		for (int i = 0; i < otherItems.length; i++) {
			if (!contains(otherItems[i]))
				return false;
		}
		return true;
	}

	/**
	 * numItems - returns the number of items in the Bag.
	 */
	public int numItems() {
		return numItems;
	}

	/**
	 * grab - returns a reference to a randomly chosen item in the Bag.
	 */
	public Object grab() {
		if (numItems == 0)
			throw new NoSuchElementException("the bag is empty");
		int whichOne = (int)(Math.random() * numItems);
		return items[whichOne];
	}

	/**
	 * toArray - return an array containing the current contents of the bag
	 */
	public Object[] toArray() {
		Object[] copy = new Object[numItems];

		for (int i = 0; i < numItems; i++)
			copy[i] = items[i];

		return copy;
	}

	/**
	 * toString - converts this ArrayBag into a readable String object.
	 * Overrides the Object version of this method.
	 */
	public String toString() {
		String str = "{";

		for (int i = 0; i < numItems; i++)
			str = str + " " + items[i];
		str = str + " }";

		return str;
	}

	/* Test the ArrayBag implementation. */
	public static void main(String[] args) {
		// Create a Scanner object for user input.
		Scanner in = new Scanner(System.in);

		// Create an ArrayBag named bag1.
		System.out.print("Size of bag 1: ");
		int size = in.nextInt();
		Bag bag1 = new ArrayBag(size);
		in.nextLine();    // consume the rest of the line

		// Read in strings, add them to bag1, and print out bag1.
		String itemStr;        
		for (int i = 0; i < size; i++) {
			System.out.print("item " + i + ": ");
			itemStr = in.nextLine();
			bag1.add(itemStr);
		}
		System.out.println("bag 1 = " + bag1);
		System.out.println();

		// Select a random item and print it.
		Object item = bag1.grab();
		System.out.println("grabbed " + item);
		System.out.println();

		// Iterate over the objects in bag1, printing them one per
		// line.
		Object[] items = bag1.toArray();
		for (int i = 0; i < items.length; i++)
			System.out.println(items[i]);
		System.out.println();
		System.out.println("The capacity of the bag is " + bag1.capacity());
		System.out.println("This will print true if the bag is full: " + bag1.isFull());

		// Get an item to remove from bag1, remove it, and reprint the bag.
		System.out.print("item to remove: ");
		itemStr = in.nextLine();
		if (bag1.contains(itemStr))
			bag1.remove(itemStr);
		System.out.println("Here are the contents of bag1 = " + bag1);
		System.out.println();

		// Test for the "boolean isFull()" method
		System.out.println("The capacity of the bag is " + bag1.capacity());
		System.out.println("This will print false if the bag is not full: " + bag1.isFull());

		// Test for the "void increaseCapacity(int increment)" method
		System.out.print("Type in a number to increase the capacity of bag1 by: ");
		int increase = in.nextInt();
		bag1.increaseCapacity(increase);
		System.out.println("The capacity of the bag is now " + bag1.capacity());
		System.out.println("Here are the contents of bag1 now:  " + bag1);	

		// Test for the " boolean removeItems(Bag other)" method
		System.out.print("Enter a size for the 'other' Bag object: ");
		size = in.nextInt();
		Bag other = new ArrayBag(size);
		in.nextLine();    // consume the rest of the line
		System.out.println("Enter some String(s) to add to the 'other' Bag object: ");
		for (int i = 0; i < size; i++) {
			System.out.print("item " + i + ": ");
			itemStr = in.nextLine();
			other.add(itemStr);
		}
		System.out.println("Here are the contents of your 'other' Bag object: " + other);
		System.out.println("Here are the contents of bag1:  " + bag1);
		System.out.println("All occurrences of your String(s) in the 'other' Bag will now be removed from bag1.");
		System.out.println("This will print true if something was removed.  If nothing was removed, false: " + bag1.removeItems(other));
		System.out.println("Here are the contents of bag1 now:  " + bag1);	

		// Test for the "Bag unionWith(Bag other)" method
		System.out.println("Here is the result of bag1.unionWith(other):  " + bag1.unionWith(other));

	}
}
