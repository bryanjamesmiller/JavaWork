/** TestSetsExtraCredit.java
 *  This program creates a GUI for the TestSets
 *  program.  
 *
 *  @author:     Bryan Miller
 *  @version:    4/26/2014
 */
import javax.swing.*;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class TestSetsExtraCredit {
	/** Main initializes the GUI and gets the
	 * program started.
	 */
	public static void main(String[] args){
		TestSetsGUI testSetsWindow = new TestSetsGUI("Test Sets", 700, 500);
		testSetsWindow.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		testSetsWindow.setVisible(true);
	}
}

/**
 * This class creates the GUI for the TestSets program.
 *
 */
class TestSetsGUI extends JFrame{
	private JButton createSetA=new JButton("Click to CREATE SET A");
	private JButton createSetB=new JButton("Click to CREATE SET B");
	private JButton createIntersection=new JButton("Click to CREATE INTERSECTION (A * B)");
	private JButton createUnion=new JButton("Click to CREATE UNION (A + B)");
	private JButton createDifference=new JButton("Click to CREATE DIFFERENCE (A - B)");
	private JButton getCardinalityA=new JButton("Click to get the cardinality of A");
	private JButton getCardinalityB=new JButton("Click to get the cardinality of B");
	private JButton isASubsetOfB=new JButton("Click to see if A is a subset of B");
	private JButton isBSubsetOfA=new JButton("Click to see if B is a subset of A");
	private JButton clearSets=new JButton("Click to clear the sets");
	private JPanel myJPanel=new JPanel();
	private JPanel myNorthJPanel=new JPanel();
	private JPanel mySouthJPanel=new JPanel();
	private JLabel setALabel=new JLabel("Set A:  ");
	private JLabel setBLabel=new JLabel("Set B:  ");
	private JTextField setAContents=new JTextField("                                        ");
	private JTextField setBContents=new JTextField("                                        ");
	private JLabel outputLabel=new JLabel("Output:  ");
	private JTextField outputContents=new JTextField("                                        ");
	private final int ROWS=10;
	private final int COLUMNS=1;
	private String setAString="";
	private String setBString="";
	private Bitset setA = new Bitset (16);
	private Bitset setB = new Bitset (8);
	/**
	 * This method constructs the GUI for the TestSets program.
	 * 
	 * @param name		This is the name of the GUI, a String
	 * @param height	This is the height of the GUI, an int
	 * @param width		This is the width of the GUI, an int
	 */
	public TestSetsGUI(String name, int height, int width){
		setSize(height, width);
		setTitle(name);
		myJPanel.setLayout(new GridLayout(ROWS, COLUMNS));
		initializeJPanel();
		add(myJPanel, BorderLayout.CENTER);

		myNorthJPanel.add(setALabel, BorderLayout.CENTER);
		myNorthJPanel.add(setAContents, BorderLayout.CENTER);
		myNorthJPanel.add(setBLabel, BorderLayout.CENTER);
		myNorthJPanel.add(setBContents, BorderLayout.CENTER);
		add(myNorthJPanel, BorderLayout.NORTH);

		mySouthJPanel.add(outputLabel, BorderLayout.CENTER);
		mySouthJPanel.add(outputContents, BorderLayout.CENTER);
		add(mySouthJPanel, BorderLayout.SOUTH);

		setButtonClickers();
	}
	/**
	 * This method initializes the JPanel by adding
	 * the buttons that perform the functions in TestSets.
	 */
	public void initializeJPanel(){
		myJPanel.add(createSetA);
		myJPanel.add(createSetB);
		myJPanel.add(createIntersection);
		myJPanel.add(createUnion);
		myJPanel.add(createDifference);
		myJPanel.add(getCardinalityA);
		myJPanel.add(getCardinalityB);
		myJPanel.add(isASubsetOfB);
		myJPanel.add(isBSubsetOfA);
		myJPanel.add(clearSets);
	}

	public void setButtonClickers(){
		createSetA.addActionListener(new SetCreatorButtonClicker());
		createSetB.addActionListener(new SetCreatorButtonClicker());
		createIntersection.addActionListener(new IntersectionButtonClicker());
		createUnion.addActionListener(new UnionButtonClicker());
		createDifference.addActionListener(new DifferenceButtonClicker());
		getCardinalityA.addActionListener(new CardinalityButtonClicker());
		getCardinalityB.addActionListener(new CardinalityButtonClicker());
		isASubsetOfB.addActionListener(new SubsetButtonClicker());
		isBSubsetOfA.addActionListener(new SubsetButtonClicker());
		clearSets.addActionListener(new ClearSetsButtonClicker());
	}

	/**
	 * This class allows the user to click the create set buttons 
	 * and receive the appropriate response.
	 */
	class SetCreatorButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click the create set buttons 
		 * and receive the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			JButton buttonThatGotClicked=(JButton)e.getSource();
			if(buttonThatGotClicked.getText()=="Click to CREATE SET A")
				createSet(setA);
			else
				createSet(setB);
		}
	}
	/**
	 * This method reads in the integers entered into the set
	 * using an input dialog box and stores them in the proper set.
	 * 
	 * @param mySet	This is either setA or setB that was clicked to be
	 * 				initialized.
	 */
	public void createSet(Bitset mySet){
		if(mySet.equals(setA)){
			do{
				setAString=JOptionPane.showInputDialog (null, "Type an integer to include in set A" +
						", smaller than 16, and click OK.\nWhen you have on more numbers to add, click OK.");
				if(setAString!=""){
					setA.include(Integer.parseInt(setAString));
					setAContents.setText(setA.toString());
				}
			}while(setAString!="");
		}
		else{
			do{
				setBString=JOptionPane.showInputDialog (null, "Type an integer to include in the set" +
						", smaller than 8, and click OK.\nWhen you have on more numbers to add, click OK.");
				if(setBString!=""){
					setB.include(Integer.parseInt(setBString));
					setBContents.setText(setB.toString());
				}
			}while(setBString!="");
		}
	}
	/**
	 * This class allows the user to click the intersect button
	 * and receive the appropriate response.
	 */
	class IntersectionButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click the intersect button 
		 * and receive the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			outputContents.setText(setA.intersect(setB).toString());
		}
	}
	/**
	 * This class allows the user to click the union button 
	 * and receive the appropriate response.
	 */
	class UnionButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click the union button 
		 * and receive the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			outputContents.setText(setA.union(setB).toString());
		}
	}
	/**
	 * This class allows the user to click the difference button
	 * and receive the appropriate response.
	 */
	class DifferenceButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click the difference button 
		 * and receive the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			outputContents.setText(setA.difference(setB).toString());
		}
	}
	/**
	 * This class allows the user to click the cardinality buttons
	 * and get the appropriate response.
	 */
	class CardinalityButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click the cardinality buttons
		 * and get the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			JButton buttonThatGotClicked=(JButton)e.getSource();
			if(buttonThatGotClicked.getText()=="Click to get the cardinality of A")
				outputContents.setText(String.valueOf(setA.cardinality()));
			else
				outputContents.setText(String.valueOf(setB.cardinality()));
		}
	}
	/**
	 * This class allows the user to click the subset buttons 
	 * and receive the appropriate response.
	 */
	class SubsetButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click subset buttons
		 * and get the appropriate response
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			JButton buttonThatGotClicked=(JButton)e.getSource();
			if(buttonThatGotClicked.getText()=="Click to see if A is a subset of B")
				outputContents.setText(String.valueOf(setA.isSubset(setB)));
			else
				outputContents.setText(String.valueOf(setB.isSubset(setA)));
		}
	}

	/**
	 * This class allows the user to click the clear sets button 
	 * and receive the appropriate response.
	 */
	class ClearSetsButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click the clear sets button
		 * and get the appropriate response
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			setAString="";
			setBString="";
			setAContents.setText("                                        ");
			setBContents.setText("                                        ");
			setA = new Bitset (16);
			setB = new Bitset (8);
		}
	}
}