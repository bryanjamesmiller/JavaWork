//Two threads are running, which is why the "exiting main" message prints, but the Swing program
//is still running
import javax.swing.*;
public class SwingGUIHelper extends JFrame {
	
	static final int WIDTH = 500;
	static final int HEIGHT = 500;
	
	public static void main(String[] args){
		SwingGUIHelper h = new SwingGUIHelper();
		h.setSize(WIDTH,  HEIGHT);
		h.setVisible(true);
		System.out.println("Exiting!");
		//Test
	}
}
