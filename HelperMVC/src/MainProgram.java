/**
 * 
 * @author Bryan
 * 
 * An example of MVC.  This is the Model class.  It simply
 * has a counter.  The counter can be incremented or returned.
 * The Controller class can see both the View class and the Model class.
 *
 */
import javax.swing.*;
public class MainProgram {
	public static void main(String [] args){
		ModelClass model = new ModelClass(0);
		ViewClass view = new ViewClass("0");
		ControllerClass controller = new ControllerClass(model, view);
		controller.control();
	}

}

