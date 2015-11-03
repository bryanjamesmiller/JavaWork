/**
 * 
 * @author Bryan
 * 
 * An example of MVC.  This is the Model class.  It simply
 * has a counter.  The counter can be incremented or returned.
 * The Model class is totally separate from the View class.
 *
 */
public class ModelClass {
	private int counter;
	
	public ModelClass(){
		this.counter=counter;
	}
	
	public ModelClass(int counter){
		this.counter=counter;
	}
	
	public void incrementCounter(){
		counter++;
	}
	
	public int getCounter(){
		return counter;
	}	
}
