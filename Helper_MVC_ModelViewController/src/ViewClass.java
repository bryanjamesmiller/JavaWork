/**
 * 
 * @author Bryan
 * 
 * An example of MVC.  This is the View class.  It simply
 * provides the GUI.  The View class is totally separate 
 * from the Model class.
 *
 */
import javax.swing.*;
import java.awt.BorderLayout;
public class ViewClass {
	private JFrame frame;
	private JLabel label;
	private JButton button;
	
	public ViewClass(String text){
		frame = new JFrame("My Model-View-Controller (MVC) Design Pattern");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.setVisible(true);
		label = new JLabel(text);
		frame.getContentPane().add(label, BorderLayout.CENTER);
		button = new JButton("My Button");
		frame.getContentPane().add(button, BorderLayout.SOUTH);		
		}
	
	public JButton getButton(){
		return button;
	}
	
	public void setText(String text){
		label.setText(text);
	}
}
