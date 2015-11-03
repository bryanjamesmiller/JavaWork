/** FifteenPuzzle.java
 * 
 * This program will allow the user to swap
 * puzzle pieces with an empty space with
 * the goal of having the puzzle line up
 * in order from 1 to 15.
 *
 *  @author:     Bryan Miller
 *  @version:    4/8/2014
 */
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class FifteenPuzzle
{
	/**
	 * Main simply initializes the programs making use of the PuzzleFrame class.
	 * 
	 * @param args	The command line arguments (a String) which are not used in this program.
	 */
	public static void main (String [] args)
	{
		PuzzleFrame entirePuzzleFrameWindow = new PuzzleFrame("Fifteen Puzzle", 500, 500);
		entirePuzzleFrameWindow.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		entirePuzzleFrameWindow.setVisible(true);
	}
}

/**
 * This program creates the GUI and the functionality
 * for the game "Fifteen," allowing the user to swap
 * puzzle pieces with an empty space with
 * the goal of having the puzzle line up
 * in order from 1 to 15, and it displays a message box
 * of congratulations when victory is achieved.
 *
 *  @author:     Bryan Miller
 *  @version:    4/8/2014
 */
class PuzzleFrame extends JFrame
{
	private final int ROWS=4;
	private final int COLUMNS=4;
	private final String BLANK_SQUARE="";
	private JButton locationOne=new JButton("1");
	private JButton locationTwo=new JButton("2");
	private JButton locationThree=new JButton("3");
	private JButton locationFour=new JButton("4");
	private JButton locationFive=new JButton("5");
	private JButton locationSix=new JButton("6");
	private JButton locationSeven=new JButton("7");
	private JButton locationEight=new JButton("8");
	private JButton locationNine=new JButton("9");
	private JButton locationTen=new JButton("10");
	private JButton locationEleven=new JButton("11");
	private JButton locationTwelve=new JButton("12");
	private JButton locationThirteen=new JButton("13");
	private JButton locationFourteen=new JButton("14");
	private JButton locationFifteen=new JButton("15");
	private JButton initialEmptyLocation=new JButton(BLANK_SQUARE);
	private JButton [][] myJButtonArray=new JButton[ROWS][COLUMNS];
	private int emptyBlockLocationRow=3;
	private int emptyBlockLocationColumn=3;
	private JButton shuffleButton=new JButton("Shuffle");
	private JButton exitButton=new JButton("Exit");
	JPanel mySouthJPanel = new JPanel();

	/**
	 * This method constructs the GUI for the Fifteen game.
	 * 
	 * @param name		This is the name of the GUI, a String
	 * @param height	This is the height of the GUI, an int
	 * @param width		This is the width of the GUI, an int
	 */
	public PuzzleFrame(String name, int height, int width){
		setSize(height, width);
		setTitle(name);
		JPanel myJPanel = new JPanel();
		myJPanel.setLayout(new GridLayout(ROWS, COLUMNS));
		myJButtonArray[0][0]=locationOne;
		myJButtonArray[1][0]=locationTwo;
		myJButtonArray[2][0]=locationThree;
		myJButtonArray[3][0]=locationFour;
		myJButtonArray[0][1]=locationFive;
		myJButtonArray[1][1]=locationSix;
		myJButtonArray[2][1]=locationSeven;
		myJButtonArray[3][1]=locationEight;
		myJButtonArray[0][2]=locationNine;
		myJButtonArray[1][2]=locationTen;
		myJButtonArray[2][2]=locationEleven;
		myJButtonArray[3][2]=locationTwelve;
		myJButtonArray[0][3]=locationThirteen;
		myJButtonArray[1][3]=locationFourteen; 
		myJButtonArray[2][3]=locationFifteen;
		myJButtonArray[3][3]=initialEmptyLocation; 

		for(int j=0; j<ROWS; j++){
			for(int i=0; i<COLUMNS; i++){
				myJPanel.add(myJButtonArray[i][j]);
				myJButtonArray[i][j].addActionListener(new ButtonClicker());
			}
		}
		shuffleButton.addActionListener(new ShuffleButtonClicker());
		exitButton.addActionListener(new ExitButtonClicker());

		add(myJPanel, BorderLayout.CENTER);
		mySouthJPanel.add(exitButton, BorderLayout.WEST);
		mySouthJPanel.add(shuffleButton, BorderLayout.EAST);
		add(mySouthJPanel, BorderLayout.SOUTH);
	}

	/**
	 * This class allows the user to swap
	 * game pieces with the blank piece.
	 */
	class ButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to swap
		 * game pieces with the blank piece.
		 * 
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			JButton buttonThatGotClicked=(JButton)e.getSource();
			String newNumber=buttonThatGotClicked.getText();
			if(emptyBlockLocationRow-1>=0)
				if(emptyBlockLocationRow-1>=0){ 
					if(buttonThatGotClicked.equals(myJButtonArray[emptyBlockLocationRow-1][emptyBlockLocationColumn])){
						myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(newNumber);
						emptyBlockLocationRow=emptyBlockLocationRow-1;
						buttonThatGotClicked.setText(BLANK_SQUARE);
					}
				}
			if(emptyBlockLocationColumn-1>=0){ 
				if(buttonThatGotClicked.equals(myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn-1]) 
						|| (buttonThatGotClicked.equals(myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn-1]))){
					myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(newNumber);
					emptyBlockLocationColumn=emptyBlockLocationColumn-1;
					buttonThatGotClicked.setText(BLANK_SQUARE);
				}
			}
			if(emptyBlockLocationRow+1<ROWS){ 
				if(buttonThatGotClicked.equals(myJButtonArray[emptyBlockLocationRow+1][emptyBlockLocationColumn]) 
						|| (buttonThatGotClicked.equals(myJButtonArray[emptyBlockLocationRow+1][emptyBlockLocationColumn]))){
					myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(newNumber);
					emptyBlockLocationRow=emptyBlockLocationRow+1;
					buttonThatGotClicked.setText(BLANK_SQUARE);
				}
			}
			if(emptyBlockLocationColumn+1<COLUMNS){ 
				if(buttonThatGotClicked.equals(myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn+1]) 
						|| (buttonThatGotClicked.equals(myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn+1]))){
					myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(newNumber);
					emptyBlockLocationColumn=emptyBlockLocationColumn+1;
					buttonThatGotClicked.setText(BLANK_SQUARE);
				}
			}
			winTest();
		}
	}

	/**
	 * This class shuffles the game pieces if the
	 * user clicks on the "shuffle" button.
	 */
	class ShuffleButtonClicker implements ActionListener
	{
		/**
		 * This method shuffles the game pieces if the
		 * user clicks on the "shuffle" button.
		 * 
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			for(int i=0; i<1000; i++){
				int myRandomRowNumber=(int)(Math.random()*5);
				int myRandomColumnNumber=(int)(Math.random()*5);
				if(emptyBlockLocationRow-1>=0)
					if((myRandomRowNumber==emptyBlockLocationRow-1) && (myRandomColumnNumber==emptyBlockLocationColumn)){
						String oldNumber=myJButtonArray[emptyBlockLocationRow-1][emptyBlockLocationColumn].getText();
						myJButtonArray[emptyBlockLocationRow-1][emptyBlockLocationColumn].setText(BLANK_SQUARE);
						myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(oldNumber);
						emptyBlockLocationRow=emptyBlockLocationRow-1;
					}
				if(emptyBlockLocationColumn-1>=0)
					if((myRandomRowNumber==emptyBlockLocationRow) && (myRandomColumnNumber==emptyBlockLocationColumn-1)){
						String oldNumber=myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn-1].getText();
						myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn-1].setText(BLANK_SQUARE);
						myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(oldNumber);
						emptyBlockLocationColumn=emptyBlockLocationColumn-1;
					}
				if(emptyBlockLocationRow+1<ROWS)
					if((myRandomRowNumber==emptyBlockLocationRow+1) && (myRandomColumnNumber==emptyBlockLocationColumn)){
						String oldNumber=myJButtonArray[emptyBlockLocationRow+1][emptyBlockLocationColumn].getText();
						myJButtonArray[emptyBlockLocationRow+1][emptyBlockLocationColumn].setText(BLANK_SQUARE);
						myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(oldNumber);
						emptyBlockLocationRow=emptyBlockLocationRow+1;
					}
				if(emptyBlockLocationColumn+1<COLUMNS)
					if((myRandomRowNumber==emptyBlockLocationRow) && (myRandomColumnNumber==emptyBlockLocationColumn+1)){
						String oldNumber=myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn+1].getText();
						myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn+1].setText(BLANK_SQUARE);
						myJButtonArray[emptyBlockLocationRow][emptyBlockLocationColumn].setText(oldNumber);
						emptyBlockLocationColumn=emptyBlockLocationColumn+1;
					}
			}
		}
	}

	/**
	 * This class quits the game if the user
	 * clicks the "exit" button.
	 */
	class ExitButtonClicker implements ActionListener{
		/**
		 * This method quits the game if the user
		 * clicks the "exit" button.
		 * 
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e){
			System.exit(0);
		}
	}

	/**
	 * This method displays congratulations in a message box if the user is
	 * victorious.
	 */
	public void winTest(){
		if(myJButtonArray[0][0].getText()=="1"
				&& myJButtonArray[1][0].getText()=="2"
				&& myJButtonArray[2][0].getText()=="3"
				&& myJButtonArray[3][0].getText()=="4"
				&& myJButtonArray[0][1].getText()=="5"
				&& myJButtonArray[1][1].getText()=="6"
				&& myJButtonArray[2][1].getText()=="7"
				&& myJButtonArray[3][1].getText()=="8"
				&& myJButtonArray[0][2].getText()=="9"
				&& myJButtonArray[1][2].getText()=="10"
				&& myJButtonArray[2][2].getText()=="11"
				&& myJButtonArray[3][2].getText()=="12"
				&& myJButtonArray[0][3].getText()=="13"
				&& myJButtonArray[1][3].getText()=="14"
				&& myJButtonArray[2][3].getText()=="15"
				&& myJButtonArray[3][3].getText()=="")
			JOptionPane.showMessageDialog (null, "Congratulations, you are Victorious!");
	}
}