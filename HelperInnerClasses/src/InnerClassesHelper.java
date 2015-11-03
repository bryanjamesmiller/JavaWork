//You make inner classes so that they have access to variables from the outer class.
public class InnerClassesHelper {
	
	private String needsToBeAccessible = "hi!";
	
	public static void main(String[] args){	
		InnerClassesHelper myInnerClassesHelper1 = new InnerClassesHelper("Example One");
		InnerClassesHelper myInnerClassesHelper2 = new InnerClassesHelper("Another Example");
		
		InnerClass InnerObject1 = myInnerClassesHelper1.makeInnerClassObjectFactory(); //It has to be this way because the inner class object must be a part of (wrapped in?) an outer class object
		InnerClass InnerObject2 = myInnerClassesHelper2.makeInnerClassObjectFactory(); //It has to be this way because the inner class object must be a part of (wrapped in?) an outer class object
		System.out.println(InnerObject1.toString());
		System.out.println(InnerObject2.toString());
	}
	
	//Here is the constructor for the outer class
		public InnerClassesHelper(String n){
			needsToBeAccessible = n;
		}

	//Here's an inner class.  Notice it doesn't accept any parameters as arguments:
	public class InnerClass{
		//Here's the constructor for the inner class:
		public InnerClass(){
			//It has access to the outer class variable needsToBeAccessible:
			System.out.println(needsToBeAccessible);
		}
	}

	//This is called a "factory" method, because it makes an object:
	public InnerClass makeInnerClassObjectFactory(){
		return new InnerClass();
	}
	
}
