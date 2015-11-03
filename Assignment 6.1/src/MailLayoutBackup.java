/** MailLayout.java
 *  This program creates an email GUI.  When the "subject" field
 *  is updated, it will update the title of the GUI with the same
 *  text.  When "send" is clicked, the text of the email will be 
 *  written to a file named outbox.txt.
 *
 *  @author:     Bryan Miller
 *  @version:    4/1/2014
 */
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class MailLayoutBackup extends JFrame implements ActionListener{
	static JButton sendEmailButton=new JButton("Send Mail");
	static JTextArea mailTextBox=new JTextArea();
	static JTextField sendTo = new JTextField();
	static JTextField sendCC = new JTextField();
	static JTextField sendBCC = new JTextField();
	static JTextField mailSubject = new JTextField();
	static String emailAddresses [] = {"test1@test.com", "test2@test.com", "test3@test.com"};
	static JComboBox mailFrom = new JComboBox(emailAddresses);

	public static void main(String[] args){
		String windowTitle="New Message";
		JFrame entireEmailFrameWindow = new JFrame (windowTitle);
		entireEmailFrameWindow.setSize (500, 500);
		entireEmailFrameWindow.setLayout (new BorderLayout());  //BorderLayout is default, too

		/*The directions say the "send mail" button can be anywhere,
		so i put it on the bottom right of the JFrame.*/
		//sendEmailButton.addActionListener(l);
		
		JPanel jPanelFooter = new JPanel (new BorderLayout());
		jPanelFooter.add(sendEmailButton, BorderLayout.EAST);
		Dimension d = new Dimension(50, 10);
		JLabel sendToLabel = new JLabel("To:");
		sendToLabel.setSize(d);
		JLabel sendCCLabel = new JLabel("Cc:");
		sendCCLabel.setSize(d);
		JLabel sendBCCLabel = new JLabel("Bcc:");
		sendBCCLabel.setSize(d);
		JLabel mailSubjectLabel = new JLabel("Subject:");
		mailSubjectLabel.setSize(d);
		//mailSubject.addFocusListener(l)
		//windowTitle=mailSubject.getText();

		entireEmailFrameWindow.setTitle(windowTitle);

		JLabel mailFromLabel = new JLabel("From:");

		GridLayout myGridlayout=new GridLayout(6, 1);

		JPanel jPanelHeader = new JPanel ();
		jPanelHeader.setSize (100, 100);
		jPanelHeader.setLayout (new GridLayout (0, 2, 0, 5) );

		jPanelHeader.add (sendToLabel);
		jPanelHeader.add (sendTo);
		jPanelHeader.add (sendCCLabel);
		jPanelHeader.add (sendCC);
		jPanelHeader.add (sendBCCLabel);
		jPanelHeader.add (sendBCC);
		jPanelHeader.add (mailSubjectLabel);
		jPanelHeader.add (mailSubject);
		jPanelHeader.add (mailFromLabel);
		jPanelHeader.add (mailFrom);

		jPanelHeader.setVisible (true);
		/*add both jpanels to the jframe.  Maybe I could make a left and 
		 * right jPanelHeader to try to fix the label size problem somehow.*/
		entireEmailFrameWindow.add(jPanelFooter, BorderLayout.SOUTH);
		entireEmailFrameWindow.add(jPanelHeader, BorderLayout.NORTH);
		entireEmailFrameWindow.add (mailTextBox, BorderLayout.CENTER );

		entireEmailFrameWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		entireEmailFrameWindow.setVisible(true);
	}
	
	/** 
	 * When the "send mail" button is clicked,
	 * this method is executed to write the 
	 * contents of the email to a file named "outbox.txt"
	 * 
	 *  @param	event	This is an ActionEvent object
	 */
	public void actionPerformed (ActionEvent event) 
	{ 
		if (event.getSource() == sendEmailButton){ 
			 try{
				PrintWriter outFile = new PrintWriter ("outbox.txt");				
				String mailText=mailTextBox.getText();
				String toText=sendTo.getText();
				String ccText=sendCC.getText();
				String bccText=sendBCC.getText();
				String subjectText=mailSubject.getText();
				String mailFromText=mailFrom.getName();	
				outFile.println(toText);
				outFile.println(ccText);
				outFile.println(bccText);
				outFile.println(subjectText);
				outFile.println(mailFromText);
				outFile.println(mailText);
				outFile.close();
			}
			catch(FileNotFoundException exception){
				System.out.println("Sorry, file not found!");
			}
		}
	}
}

