//ArrayLists are like Arrays, but they can change in size.
//You have to import java.util.*; to use ArrayLists
//Test
import java.util.*;

public class ArrayListHelper {
	public static void main (String[] args){
		ArrayList<String> myArrayListTest = new ArrayList<String>();
		myArrayListTest.add("Hello");
		myArrayListTest.add(0, "Wait, me first!");
		myArrayListTest.add("Ok, me last!");
		System.out.println(myArrayListTest.toString());
		myArrayListTest.size();
		System.out.println(myArrayListTest.get(1));
	}
}
