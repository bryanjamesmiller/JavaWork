
public class PolymorphismHelper {
	public static void main(String[] args){
		Manager donald = new Manager();
		Object d = donald;  //Even though it's an 'Object' object, the JVM knows to use the Manager toString method and not the Object class toString method.
		//However, you can only use methods this way that are defined in the superclass.  So this won't work on the bonus() method (because the Object class doesn't have that method).
		
		System.out.println(donald.toString());
		System.out.println(d.toString());
		
		System.out.println(donald.bonus());
		//System.out.println(d.bonus());  //this will give you a compilation error for the above reason.

	}
}

class Manager{
	public Manager(){
		
	}

	public String bonus(){
		return ("You get a bonus");
	}
	
	public String toString(){
		return "I'm a manager";
	}
	
}
