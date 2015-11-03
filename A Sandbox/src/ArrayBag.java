
public class ArrayBag implements Bag
{
	private Object[] items;
	private int numItems=0;

	/**
	 * This constructor will initialize the size of the "items" array to the argument/parameter arraySize that gets
	 * passed into it.
	 * 
	 * @param arraySize  The size that the "items" array will get initialized to.
	 */
	public ArrayBag(int arraySize)
	{
		this.items=new Object[arraySize];
	}

	/*
	 * This method will add a new Object to the bag until
	 * there is no more room in the bag.  The room available
	 * in the bag depends on the class variable numItems defined above.
	 */
	public boolean add(Object item)
	{
		// We check to see if "null" was passed in, just because we don't want the Object to be "nothing".
		if(item == null)
			throw new IllegalArgumentException();

		if(numItems==items.length)  //If there is no more room in the items[] array for another item
			return false;  //then you can't add it
		else  //else, add the item Object to items[] Array
		{
			this.items[numItems]=item;  //You don't have to use the "this" keyword here, so items[numItems]=item; but it clarifies we're accessing data fields from the current object.
			this.numItems++;   //You don't have to use the "this" keyword here, so numItems++; but it clarifies we're accessing data fields from the current object.
			System.out.println(this.toString());
			return true;
		}
	}

	public boolean remove(Object item) 
	{
		return false;
	}

	/**
	 * Returns true if this object's ArrayBag contains the Object item that is passed in.  If this
	 * object's ArrayBag doesn't contain the Object item that is passed in, it returns false.
	 * 
	 * @return		Returns true if the Object item is in this ArrayBag's bag, else false.
	 */
	public boolean contains(Object item) 
	{
		for(int i=0; i<numItems; i++)
		{
			if(items[i].equals(item)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if this object's ArrayBag contains all of the Bag items that are passed in via the Bag Object.  If this
	 * object's ArrayBag doesn't contain all of the the items from the Bag Object that are passed in, it returns false.
	 * 
	 * @return		Returns true if all of the Bag's items are in this ArrayBag's bag, else false.
	 */
	public boolean containsAll(Bag otherBag) 
	{
		/*Note:  otherBag is a Bag object, so it can't reference the methods or parameters in this ArrayBag class.  We have to
		 * use methods and parameters from the Bag interface instead.  However, we can use the methods and parameters from 
		 * this class when dealing with this ArrayBag object (using the keyword "this" ).  Because we don't know that the Bag object 
		 * is an Array, we have to use the Bag class's method "toArray" to convert it to an array. */ 

		if (otherBag==null || otherBag.numItems()==0)
			return false;

		Object[] otherItems=otherBag.toArray();
		for(int i=0; i<otherItems.length; i++)
		{
			if(!contains(otherItems[i]))
				return false;
		}
		
		return true;
	}


	/**
	 * Returns numItems, the number of items that are in this object's array.
	 * 
	 * @return 	numItems	The int value of how many items are in this object's array.
	 */
	public int numItems() 
	{
		return this.numItems;
	}

	/**
	 * Returns a random Object grabbed blindly from the bag.
	 * 
	 * @return		The Object that was randomly grabbed out of the bag
	 */
	public Object grab() 
	{
		int randomNum=0;
		return items[randomNum];
	}

	public Object[] toArray() 
	{
		return null;
	}
}
