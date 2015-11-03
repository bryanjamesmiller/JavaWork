
/**
 * 
 * @author Bryan
 * 
 * An example of MVC.  This is the Model class.  It simply
 * has a counter.  The counter can be incremented or returned.
 * The Controller class can see both the View class and the Model class.
 *
 */
import java.awt.event.*;
public class ControllerClass {
	private ModelClass model;
	private ViewClass view;
	private ActionListener actionListener;
	
	public ControllerClass(ModelClass model, ViewClass view){
		this.model = model;
		this.view = view;
	}
	
	public void control(){
		actionListener = new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				linkButtonAndLabel();
			}
		};
		view.getButton().addActionListener(actionListener);
	}
	
	/**
	 * Here is where the Model and the View Classes come together, in this code:
	 * view.setText(Integer.toString(model.getCounter()));
	 * The ViewClass object view is updated with the value from the ModelClass.getCounter() model 
	 * 
	 */
	private void linkButtonAndLabel(){
		model.incrementCounter();
		view.setText(Integer.toString(model.getCounter()));
	}
}
