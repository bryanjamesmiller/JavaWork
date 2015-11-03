
	/*
	 * This is an example of polymorphism.  There is one superclass Employee
	 * from which Lawyer and Secretary are subclasses.  Then LegalSecretary 
	 * is a subclass of Secretary.  Yet all of these classes produce objects which 
	 * can be treated as Employee objects.  Thus, we are able to make an array
	 * of Employee objects that include Lawyers, Secretaries, LegalSecretaries and
	 * Employee objects.  I can also pass this Array to a method and return
	 * just one Employee object from that array, yet that object can be any of 
	 * the sublcasses as well, and it retains it subclass identity despite
	 * being wrapped up as a superclass object.
	 * 
	 * However, you cannot call methods unique to a particular subclass while it is wrapped 
	 * by the superclass.  Only the superclass' methods may be used.
	 * 
	 */
	class Employee{
		public String toString(){
			return "This is an 'Employee' object";
		}
		
		public void canCall(){
			System.out.println("You can call me");
		}
	}

	class Lawyer extends Employee{
		public String toString(){
			return "This is still a 'Lawyer' object";
		}
		
		// Can't call this method while it is wrapped as a superclass Employee object
		public void cantCall(){
		}
	}

	class Secretary extends Employee{
		public String toString(){
			return "This is still a 'Secretary' object";
		}
	}

	class LegalSecretary extends Secretary{
		public String toString(){
			return "This is even a 'LegalSecreatry' object";
		}
	}

	public class PolymorphismHelperTwo {
		public static void main (String[] args){
			Employee ed = new Employee();
			Lawyer lucy = new Lawyer();
			Secretary stan = new Secretary();
			LegalSecretary leo = new LegalSecretary();

			Employee [] mySuperclassArrayOfAllEmployeeSubclassDataTypes = {ed, lucy, stan, leo};

			Employee winningEmployee = whoIsTheBestEmployee(mySuperclassArrayOfAllEmployeeSubclassDataTypes);
			System.out.println(winningEmployee.toString());

			//The Object class can be used as well, since it is the superclass of all classes
			Object [] anObjectArray = mySuperclassArrayOfAllEmployeeSubclassDataTypes;
			Object winningEmployeeObject = whoIsTheBestEmployeeObject(mySuperclassArrayOfAllEmployeeSubclassDataTypes);
			System.out.println(winningEmployeeObject.toString());
		}

		/*
		 * This method returns a random employee, but it can be 
		 * any of the employee subclasses
		 */
		public static Employee whoIsTheBestEmployee(Employee [] myEmployees){

			int myRandomlySelectedBestEmployee=randomIntegerGenerator(0, myEmployees.length-1);;
			//myEmployees[myRandomlySelectedBestEmployee].cantCall();
			myEmployees[myRandomlySelectedBestEmployee].canCall();
			return myEmployees[myRandomlySelectedBestEmployee];
		}

		public static int randomIntegerGenerator (int a, int b)
		{
			return (a + (int)((b-a+1) * Math.random()));
		}
		
		/*
		 * This method does the same thing as the whoIsTheBestEmployee,
		 * but uses the Object class which is the superclass of all classes.  
		 */
		public static Object whoIsTheBestEmployeeObject(Object [] myEmployees){
			int myRandomlySelectedBestEmployee=randomIntegerGenerator(0, myEmployees.length-1);
			return myEmployees[myRandomlySelectedBestEmployee];
		}
	}


