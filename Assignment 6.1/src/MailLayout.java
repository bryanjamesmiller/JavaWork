/** MailLayout.java
 *  This program creates an email GUI.  When the "subject" field
 *  is updated, it will update the title of the GUI with the same
 *  text.  When "send" is clicked, the text of the email will be 
 *  written to a file named outbox.txt.
 *
 *  @author:     Bryan Miller
 *  @version:    4/4/2014
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

class MailLayout
{
	public static void main (String [] args)
	{
		EmailFrame entireEmailFrameWindow = new EmailFrame ("New Message", 500, 500);
		entireEmailFrameWindow.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		entireEmailFrameWindow.setVisible(true);
	}
}

class EmailFrame extends JFrame
{
	private JButton sendEmailButton=new JButton("Send Mail");
	private JTextArea mailTextBox=new JTextArea();
	private JTextField sendTo = new JTextField();
	private JTextField sendCC = new JTextField();
	private JTextField sendBCC = new JTextField();
	private JTextField mailSubject = new JTextField();
	public static String EMAIL_ADDRESSES[] = {"test1@test.com", "test2@test.com", "test3@test.com"};
	private JComboBox<String> mailFrom = new JComboBox<String>(EMAIL_ADDRESSES);

	public EmailFrame(String name, int height, int width){
		setSize(height, width);
		setTitle(name);

		/*The directions say the "send mail" button can be anywhere,
	so i put it on the bottom right of the JFrame.*/
		ButtonListener bl = new ButtonListener ();
		sendEmailButton.addActionListener (bl);
		SubjectListener s1=new SubjectListener();
		mailSubject.addFocusListener(s1);

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
		add(jPanelFooter, BorderLayout.SOUTH);
		add(jPanelHeader, BorderLayout.NORTH);
		add (mailTextBox, BorderLayout.CENTER );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/** 
	 * When the "send mail" button is clicked, the method in
	 * this class is executed to write the 
	 * contents of the email to a file named "outbox.txt"
	 */

	class ButtonListener implements ActionListener
	{ 

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
					String myOutputFileName="outbox.txt";
					PrintWriter outFile = new PrintWriter (myOutputFileName);				
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


	/** 
	 * When the subject box loses its focus, the method in
	 * this class is executed to write the 
	 * contents of the subject line to the title of the email
	 */

	class SubjectListener implements FocusListener
	{ 
		/**
		 * This method must be included in order to successfully
		 * "implements" the FocusListener class, even though my 
		 * program does not make use of it.
		 */
		public void focusGained(FocusEvent e) {
		}

		/** 
		 * When the subject box loses its focus, the method in
		 * this class is executed to write the 
		 * contents of the subject line to the title of the email
		 * 
		 *  @param	event	This is an ActionEvent object
		 */
		public void focusLost(FocusEvent e) {
			if(e.getSource().equals(mailSubject)){
				String newTitle=mailSubject.getText();
				setTitle(newTitle);
			}
		}
	}
}