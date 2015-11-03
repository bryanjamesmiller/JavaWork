/** TrafficLight.java
 *  This program creates a drawing that resembles
 *  a traffic light with correct signal
 *  colors and grey box dividers between
 *  each light. 
 *
 *  @author:     Bryan Miller
 *  @version:    4/4/2014
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class creates the JFrame, gives it a size and
 * adds the StopLightCircles object to it.
 * 
 */
public class TrafficLight {
	public static void main( String [] args){
		JFrame StopLightBox = new JFrame ("Traffic Light");
		StopLightBox.setSize(220, 640);
		StopLightBox.add (new StopLightCircles());
		StopLightBox.setVisible (true);
		StopLightBox.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}

/**
 * This class draws the stop light circles
 * and the grey rectangle boxes.
 */
class StopLightCircles extends JPanel{
	/**
	 * This method draws the stop light circles
	 * and the grey rectangle boxes.
	 * 
	 * @param	g	This is the Graphics object.
	 */
	public void paintComponent (Graphics g){
		g.setColor(Color.RED);
		g.fillOval(0, 0, 200, 200);
		g.setColor(Color.YELLOW);
		g.fillOval(0, 200, 200, 200);
		g.setColor(Color.GREEN);
		g.fillOval(0, 400, 200, 200);
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, 200, 200);
		g.drawRect(0, 200, 200, 200);
		g.drawRect(0, 400, 200, 200);
	}
}
