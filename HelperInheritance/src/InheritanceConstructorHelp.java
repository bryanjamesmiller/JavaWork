
public class InheritanceConstructorHelp {
	
	public static void main(String [] args){
		//All constructors along the chain of inheritance get called AUTOMATICALLY 
		// all the way up to the built-in Object class, which is Java's highest superclass.
		TankerLargeShip myTestShip = new TankerLargeShip();	
	}
}

// Any class can inherit, but a class that is created to be a superclass only (never itself instantiated) is created with the keyword "abstract"
abstract class Ship{
	
	//Constructor - same as the class name, and notice no return parameter allowed
	Ship(){
		System.out.println("Ship's Constructor was called");
	}
}

class LargeShip extends Ship{
	
	int cargoCapacity=100000;
	
	//Constructor - same as the class name, and notice no return parameter allowed
	LargeShip(){
		System.out.println("LargeShip's Constructor was called");
	}
	
	int getCapacity(){
		return cargoCapacity;
	}
}

class TankerLargeShip extends LargeShip{
	
	//Constructor - same as the class name, and notice no return parameter allowed
	TankerLargeShip(){
		System.out.println("TankerLargeShip's Constructor was called");
	}
	
	//OOP methods are public by default, since that's the whole point
	int CargoCapacity(){
		//If there is a method (and value) for the capacity is in the superclass, you can use the "super" keyword to access it. 
		int myCargoCapacity=super.getCapacity();
		return myCargoCapacity;
	}
}
