// You need to import java.util.HashMap to use the HashMap class and the ListIterator class
import java.util.*;
public class HashMapHelper {

	public static void main(String[] args){
		HashMap<String, String> myTestHashMap = new HashMap<String, String>();

		// These are KEY and VALUE pairs!!!!
		myTestHashMap.put("California",  "Sacramento");
		myTestHashMap.put("Oregon", "Salem");
		myTestHashMap.put("Washington",  "Olympia");
		System.out.println(myTestHashMap);

		// Here's how you add another item
		myTestHashMap.put("Alaska", "Juneau");
		System.out.println(myTestHashMap);

		// Here's how you remove an item
		myTestHashMap.remove("California");
		System.out.println(myTestHashMap);

		/* There are two ways to loop through a HashMap.  You can use the key
		or the value as the iterator.  If you want to iterate through the keys, 
		then use the keySet() method:*/
		Set<String> myTestKeys = myTestHashMap.keySet();
		
		Iterator<String> myTestIterator = myTestKeys.iterator();
		while(myTestIterator.hasNext()){
			String myTestValue = myTestIterator.next();
			System.out.println("The capitol of " + myTestValue + " is " + myTestHashMap.get(myTestValue));
		}
	}
}

