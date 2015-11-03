/** Age.java
 *  This program asks a user for their age with a input box
 *  and then uses a message box to respond jokingly if their 
 *  age is under or over 40.
 *
 *  @author:     Bryan Miller
 *  @version:    4/1/2014
 */
import javax.swing.*;

public class Age {

	public static void main(String [] args){
		String ageString = JOptionPane.showInputDialog (null, "What's your age, cowboy?");
		int age= Integer.parseInt(ageString);
		if(age<40)
			JOptionPane.showMessageDialog (null, "You're young.");
		else
			JOptionPane.showMessageDialog (null, "You're old for a cow'boy'.");
	}
}
