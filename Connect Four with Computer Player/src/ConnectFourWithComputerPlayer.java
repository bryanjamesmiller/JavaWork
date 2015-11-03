/** ConnectFour.java
 *  This program creates a Connect Four
 *  GUI and functionality.
 *
 *  @author:     Bryan Miller
 *  @version:    5/26/2014
 */
import javax.swing.*;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class ConnectFourWithComputerPlayer {
	private static final int WIDTH=814;
	private static final int HEIGHT=870;
	
	/** Main initializes the GUI and gets the
	 * program started.
	 */
	public static void main(String[] args){
		ConnectFourGUI connectFourWindow = new ConnectFourGUI("Connect Four", WIDTH, HEIGHT);
		connectFourWindow.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		connectFourWindow.setVisible(true);
	}
}

/**
 * This class creates the GUI for the Connect Four game.
 *
 */
class ConnectFourGUI extends JFrame{
	
	private final String DID_BLACK_WIN="black won";
	private final String DID_RED_WIN="red won";
	private final int ROWS=6;
	private final int COLUMNS=7;
	private final int GAME_OVER=7;
	private final String BLACKS_TURN = "     Black's turn     ";
	private final String REDS_TURN = "     Red's turn     ";
	private final String COMPUTERS_TURN = "     Computer is thinking...     ";
	private final String BLACK_WON = "    Black is victorious!    ";
	private final String RED_WON = "    Red is victorious!    ";
	private boolean blackLastPlayed=false;
	private int lastLocationClickedInteger;
	private JButton location_0_0=new JButton("00");
	private JButton location_1_0=new JButton("10");
	private JButton location_2_0=new JButton("20");
	private JButton location_3_0=new JButton("30");
	private JButton location_4_0=new JButton("40");
	private JButton location_5_0=new JButton("50");
	private JButton location_6_0=new JButton("60");
	private JButton location_0_1=new JButton("01");
	private JButton location_1_1=new JButton("11");
	private JButton location_2_1=new JButton("21");
	private JButton location_3_1=new JButton("31");
	private JButton location_4_1=new JButton("41");
	private JButton location_5_1=new JButton("51");
	private JButton location_6_1=new JButton("61");
	private JButton location_0_2=new JButton("02");
	private JButton location_1_2=new JButton("12");
	private JButton location_2_2=new JButton("22");
	private JButton location_3_2=new JButton("32");
	private JButton location_4_2=new JButton("42");
	private JButton location_5_2=new JButton("52");
	private JButton location_6_2=new JButton("62");
	private JButton location_0_3=new JButton("03");
	private JButton location_1_3=new JButton("13");	
	private JButton location_2_3=new JButton("23");
	private JButton location_3_3=new JButton("33");
	private JButton location_4_3=new JButton("43");
	private JButton location_5_3=new JButton("53");
	private JButton location_6_3=new JButton("63");
	private JButton location_0_4=new JButton("04");
	private JButton location_1_4=new JButton("14");
	private JButton location_2_4=new JButton("24");
	private JButton location_3_4=new JButton("34");
	private JButton location_4_4=new JButton("44");
	private JButton location_5_4=new JButton("54");
	private JButton location_6_4=new JButton("64");
	private JButton location_0_5=new JButton("05");
	private JButton location_1_5=new JButton("15");
	private JButton location_2_5=new JButton("25");
	private JButton location_3_5=new JButton("35");
	private JButton location_4_5=new JButton("45");
	private JButton location_5_5=new JButton("55");
	private JButton location_6_5=new JButton("65");
	private JButton computersButton=new JButton();
	private JButton nothingAvailableInThisColumn=new JButton();
	private JButton isThisAGoodButton=new JButton();
	private JButton [][] myJButtonArray=new JButton[ROWS][COLUMNS];
	private JButton newGame=new JButton("New Game");
	private JButton directions=new JButton("Directions");
	private boolean isThisTheColumnsLowestOpenSquare[]=new boolean[COLUMNS];
	private JPanel myJPanel=new JPanel();
	private JPanel myNorthJPanel=new JPanel();
	private JPanel mySouthJPanel=new JPanel();
	private JLabel playerOnesLabel=new JLabel("Player One (black checker player):");
	private JLabel playerTwosLabel=new JLabel("      Player Two (red checker player):");
	private JTextField playerOneName=new JTextField("(Enter name)");
	private JTextField playerTwoName=new JTextField("(Enter name)");
	private JLabel myRecordOfSquares=new JLabel("");
	private JLabel whoseTurnLabel=new JLabel(BLACKS_TURN);
	private ImageIcon emptySquare=new ImageIcon("emptySquare.gif");
	private ImageIcon redChecker=new ImageIcon("redChecker1.png");
	private ImageIcon blackChecker=new ImageIcon("blackChecker.png");
	private int desiredCheckerRow;
	private int desiredCheckerColumn;
	private int rowsInColumn0Available=5;
	private int rowsInColumn1Available=5;
	private int rowsInColumn2Available=5;
	private int rowsInColumn3Available=5;
	private int rowsInColumn4Available=5;
	private int rowsInColumn5Available=5;
	private int rowsInColumn6Available=5;
	private String desiredLocation="";
	private int numDesiredLocation;
	private int firstDigit;
	private int secondDigit;
	private Font whoseTurnFont = new Font ("Times New Roman", Font.BOLD, 35);
	private Font redVictoryFont = new Font ("Times New Roman", Font.BOLD, 49);
	private Font blackVictoryFont = new Font ("Times New Roman", Font.BOLD, 35);
	private Font blackFont = new Font ("Times New Roman", Font.BOLD, 17);
	private Font redFont = new Font ("Times New Roman", Font.BOLD, 17);
	private Font namesFont = new Font ("Helvetica", Font.ITALIC, 12);
	private JCheckBox computerPlayerCheckBox = new JCheckBox("Computer Player");

	/**
	 * This method constructs the GUI for the game.
	 * 
	 * @param name		This is the name of the GUI, a String
	 * @param height	This is the height of the GUI, an int
	 * @param width		This is the width of the GUI, an int
	 */
	public ConnectFourGUI(String name, int height, int width){
		setSize(height, width);
		setTitle(name);
		initializeArray();
		setButtonClickers();

		whoseTurnLabel.setForeground(Color.BLACK);
		whoseTurnLabel.setFont(whoseTurnFont);
		myJPanel.setLayout(new GridLayout(ROWS, COLUMNS));
		//myNorthJPanel.add(myRecordOfSquares, BorderLayout.CENTER);
		playerOnesLabel.setFont(namesFont);
		playerOneName.setFont(blackFont);
		playerOneName.setForeground(Color.BLACK);
		playerTwosLabel.setFont(namesFont);
		playerTwoName.setFont(redFont);
		playerTwoName.setForeground(Color.RED);

		myNorthJPanel.add(playerOnesLabel, BorderLayout.CENTER);
		myNorthJPanel.add(playerOneName, BorderLayout.CENTER);
		myNorthJPanel.add(playerTwosLabel, BorderLayout.CENTER);
		myNorthJPanel.add(playerTwoName, BorderLayout.CENTER);
		myNorthJPanel.add(computerPlayerCheckBox, BorderLayout.CENTER);

		mySouthJPanel.add(directions, BorderLayout.CENTER);
		mySouthJPanel.add(whoseTurnLabel, BorderLayout.CENTER);
		mySouthJPanel.add(newGame, BorderLayout.CENTER);
		add(myJPanel, BorderLayout.CENTER);
		add(myNorthJPanel, BorderLayout.NORTH);
		add(mySouthJPanel, BorderLayout.SOUTH);
		newGame.addActionListener(new NewGameClick());
		directions.addActionListener(new DirectionsClick());
	}

	/**
	 * This method sets each button up with a 
	 * click event handler.
	 */
	public void setButtonClickers(){
		for(int j=0; j<COLUMNS; j++){
			for(int i=0; i<ROWS; i++)
				myJButtonArray[i][j].addActionListener(new ButtonClicker());
		}
	}

	/**
	 * This method initializes each square on the 
	 * board to the Array, puts each square into
	 * an array, and sets the image to the empty square.
	 */
	public void initializeArray(){
		myJButtonArray[0][0]=location_0_0;
		myJButtonArray[0][1]=location_6_0;
		myJButtonArray[0][2]=location_5_1;
		myJButtonArray[0][3]=location_4_2;
		myJButtonArray[0][4]=location_3_3;
		myJButtonArray[0][5]=location_2_4;
		myJButtonArray[0][6]=location_1_5;
		myJButtonArray[1][0]=location_1_0;
		myJButtonArray[1][1]=location_0_1;
		myJButtonArray[1][2]=location_6_1;
		myJButtonArray[1][3]=location_5_2;
		myJButtonArray[1][4]=location_4_3;
		myJButtonArray[1][5]=location_3_4;
		myJButtonArray[1][6]=location_2_5;
		myJButtonArray[2][0]=location_2_0;
		myJButtonArray[2][1]=location_1_1;
		myJButtonArray[2][2]=location_0_2;
		myJButtonArray[2][3]=location_6_2;
		myJButtonArray[2][4]=location_5_3;
		myJButtonArray[2][5]=location_4_4;
		myJButtonArray[2][6]=location_3_5;
		myJButtonArray[3][0]=location_3_0;
		myJButtonArray[3][1]=location_2_1;
		myJButtonArray[3][2]=location_1_2;
		myJButtonArray[3][3]=location_0_3;
		myJButtonArray[3][4]=location_6_3;
		myJButtonArray[3][5]=location_5_4;
		myJButtonArray[3][6]=location_4_5;
		myJButtonArray[4][0]=location_4_0;
		myJButtonArray[4][1]=location_3_1;
		myJButtonArray[4][2]=location_2_2;
		myJButtonArray[4][3]=location_1_3;
		myJButtonArray[4][4]=location_0_4;
		myJButtonArray[4][5]=location_6_4;
		myJButtonArray[4][6]=location_5_5;
		myJButtonArray[5][0]=location_5_0;
		myJButtonArray[5][1]=location_4_1;
		myJButtonArray[5][2]=location_3_2;
		myJButtonArray[5][3]=location_2_3;
		myJButtonArray[5][4]=location_1_4;
		myJButtonArray[5][5]=location_0_5;
		myJButtonArray[5][6]=location_6_5;
		for(int j=0; j<COLUMNS; j++){
			for(int i=0; i<ROWS; i++){
				myJPanel.add(myJButtonArray[i][j]);
			}
		}
		for(int j=0; j<COLUMNS; j++){
			for(int i=0; i<ROWS; i++)
				myJButtonArray[i][j].setIcon(emptySquare);
		}
	}

	/**
	 * This method checks to see if the clicked square
	 * is the lowest open square.  If so, it returns 
	 * true to show that it's valid.  If not, it returns
	 * false.
	 * 
	 * @return	true	If a valid square was clicked.
	 * 			false	If an invalid square was clicked.
	 */
	public boolean isThisTheColumnsLowestOpenSquareFinder(){
		numDesiredLocation=Integer.parseInt(desiredLocation);
		firstDigit=numDesiredLocation/10;
		secondDigit=numDesiredLocation%10;
		if(firstDigit==0){
			if(secondDigit==rowsInColumn0Available){
				rowsInColumn0Available--;
				return true;
			}
			else
				return false;
		}
		else if(firstDigit==1){
			if(secondDigit==rowsInColumn1Available){
				rowsInColumn1Available--;
				return true;
			}
			else
				return false;
		}
		else if(firstDigit==2){
			if(secondDigit==rowsInColumn2Available){
				rowsInColumn2Available--;
				return true;
			}
			else
				return false;
		}
		else if(firstDigit==3){
			if(secondDigit==rowsInColumn3Available){
				rowsInColumn3Available--;
				return true;
			}
			else
				return false;
		}				
		else if(firstDigit==4){
			if(secondDigit==rowsInColumn4Available){
				rowsInColumn4Available--;
				return true;
			}
			else
				return false;
		}		
		else if(firstDigit==5){
			if(secondDigit==rowsInColumn5Available){
				rowsInColumn5Available--;
				return true;
			}
			else
				return false;
		}
		else if(firstDigit==6){
			if(secondDigit==rowsInColumn6Available){
				rowsInColumn6Available--;
				return true;
			}
			else
				return false;
		}		
		return false;
	}

	/**
	 * This class allows the user to click the directions button
	 * and receive the appropriate response.
	 */
	class DirectionsClick implements ActionListener
	{
		/**
		 * This method allows the user to click the directions button 
		 * and receive the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			String myDirections="Connect Four is trademarked by Hasbro\n" + 
					"and so no profit may\nbe gained from this program.\n\n" +
					"You may only select a\nsquare that is on the lowest\n" +
					"available row.  \n\n" + 
					"The first player to get \nfour in a row horizontally,\n"+
					"vertically or diagnoally wins.  \n\nInterestingly, Captian Cook\n" +
					"used to play this game on\nhis ship with his crewmates.";
			DirectionsFrame recordFrameWindow = new DirectionsFrame("Directions", 550, 500, myDirections);
			recordFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			recordFrameWindow.setVisible(true);
		}
	}

	/**
	 * This class allows the user to click the new game button
	 * and receive the appropriate response.
	 */
	class 	NewGameClick implements ActionListener
	{
		/**
		 * This method allows the user to click the new game button 
		 * and receive the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			whoseTurnLabel.setForeground(Color.BLACK);
			whoseTurnLabel.setText(BLACKS_TURN);
			rowsInColumn0Available=5;
			rowsInColumn1Available=5;
			rowsInColumn2Available=5;
			rowsInColumn3Available=5;
			rowsInColumn4Available=5;
			rowsInColumn5Available=5;
			rowsInColumn6Available=5;
			for(int j=0; j<COLUMNS; j++){
				for(int i=0; i<ROWS; i++)
					myJButtonArray[i][j].setIcon(emptySquare);
			}
		}
	}

	/**
	 * This class allows the user to click the game square buttons 
	 * and receive the appropriate response.
	 */
	class ButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to click the game square buttons 
		 * and receive the appropriate response.
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			if(computerPlayerCheckBox.isSelected())
				playerTwoName.setText("Mr. Computer");
			else{
				String myName=playerTwoName.getText();
				playerTwoName.setText(myName);
			}

			JButton buttonThatGotClicked=(JButton)e.getSource();
			int i=0;
			int j=0;
			for(j=0; j<COLUMNS; j++){
				for(i=0; i<ROWS; i++){
					if(buttonThatGotClicked.equals(myJButtonArray[i][j])){
						desiredLocation=myJButtonArray[i][j].getText();
						lastLocationClickedInteger=Integer.parseInt(desiredLocation);
					}
				}
			}
			if(!computerPlayerCheckBox.isSelected()){
				for(j=0; j<COLUMNS; j++){
					for(i=0; i<ROWS; i++)
						if(buttonThatGotClicked.equals(myJButtonArray[i][j]))
							if(isThisTheColumnsLowestOpenSquareFinder()){
								if(blackLastPlayed==false){
									buttonThatGotClicked.setIcon(blackChecker);
									if(!checkForAWinner(blackChecker)){
										blackLastPlayed=true;
										whoseTurnLabel.setText(REDS_TURN);
										whoseTurnLabel.setFont(whoseTurnFont);
										whoseTurnLabel.setForeground(Color.RED);
									}
									else{
										whoseTurnLabel.setText(BLACK_WON);
										whoseTurnLabel.setFont(blackVictoryFont);
										whoseTurnLabel.setForeground(Color.BLUE);
									}
								}
								else{
									buttonThatGotClicked.setIcon(redChecker);
									if(!checkForAWinner(redChecker)){
										blackLastPlayed=false;
										whoseTurnLabel.setText(BLACKS_TURN);
										whoseTurnLabel.setFont(whoseTurnFont);
										whoseTurnLabel.setForeground(Color.BLACK);
									}
									else{
										whoseTurnLabel.setText(RED_WON);
										whoseTurnLabel.setFont(redVictoryFont);
										whoseTurnLabel.setForeground(Color.BLUE);
									}
								}
							}
				}
			}
			else{
				for(j=0; j<COLUMNS; j++){
					for(i=0; i<ROWS; i++)
						if(buttonThatGotClicked.equals(myJButtonArray[i][j]))
							if(isThisTheColumnsLowestOpenSquareFinder()){
								if(blackLastPlayed==false){
									buttonThatGotClicked.setIcon(blackChecker);
									if(checkForAWinner(blackChecker)){
										whoseTurnLabel.setText(BLACK_WON);
										whoseTurnLabel.setFont(blackVictoryFont);
										whoseTurnLabel.setForeground(Color.BLUE);
									}
									else{
										blackLastPlayed=true;
										whoseTurnLabel.setText(COMPUTERS_TURN);
										whoseTurnLabel.setFont(whoseTurnFont);
										whoseTurnLabel.setForeground(Color.RED);
										computersButton=computersStrategicMove(lastLocationClickedInteger);

										computersButton.setIcon(redChecker);
										if(!checkForAWinner(redChecker)){
											whoseTurnLabel.setText(BLACKS_TURN);
											whoseTurnLabel.setFont(whoseTurnFont);
											whoseTurnLabel.setForeground(Color.BLACK);
										}
										else{
											whoseTurnLabel.setText(RED_WON);
											whoseTurnLabel.setFont(redVictoryFont);
											whoseTurnLabel.setForeground(Color.BLUE);
										}
									}
								}
							}
				}
				blackLastPlayed=false;
			}
		}
	}

	/**
	 * This method causes the computer to select a button
	 * based on strategically locating an empty button
	 * next to where the human player last played.  If the human
	 * moved on the edge, the computer moves on top of the human.
	 * If the computer can't go on top, it moves towards the center
	 * of the board.  Otherwise, the computer first looks to make 
	 * a move in the next row towards the center of the board with 
	 * respect to where the human moved, as this is a good defensive strategy.  
	 * If the computer can't move in that direction, it tries to move on top 
	 * of where the human moved.  If it can't move on top, it moves 
	 * towards the edge of the board.  If it can't move towards the edge, 
	 * it tries to make a "connect four" of its own by taking the 
	 * leftmost available square on the board.  However, I did have
	 * to change this strategy for column 5, as I found a way to 
	 * easily win otherwise.  Then I added some randomization, too,
	 * because otherwise the computer is too predictable.
	 * 
	 * @param	lastLocationClickedInteger	This is an integer reference to the last button
	 * 										that the human player clicked.	
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton computersStrategicMove(int lastLocationClickedInteger){

		double randomNum = Math.random();


		if(lastLocationClickedInteger/10==0){
			if(randomNum<.57){
				isThisAGoodButton=findAnOpenSquareInColumnZero();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
			}
			else{
				isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
			}	
			return isThisAGoodButton;
		}

		if(lastLocationClickedInteger/10==1){
			if(randomNum<.57){
				isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
			}
			else{
				isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
			}
			return isThisAGoodButton;
		}

		if(lastLocationClickedInteger/10==2){
			if(randomNum<.57){
				isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
			}
			else{
				isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
			}
			return isThisAGoodButton;
		}

		if(lastLocationClickedInteger/10==3){
			if(randomNum<.57){
				isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
			}
			else{
				isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();			
			}
			return isThisAGoodButton;
		}

		if(lastLocationClickedInteger/10==4){
			if(randomNum<.57){
				isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
			}
			else{
				isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
			}
			return isThisAGoodButton;
		}

		if(lastLocationClickedInteger/10==5){
			if(randomNum<.57){
				isThisAGoodButton=findAnOpenSquareInColumnSix();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
			}
			else{
				isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnZero();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();	
			}
			return isThisAGoodButton;
		}

		if(lastLocationClickedInteger/10==6){
			if(randomNum<.57){
				isThisAGoodButton=findAnOpenSquareInColumnSix();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();
			}
			else{
				isThisAGoodButton=findAnOpenSquareInColumnFive();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnSix();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnOne();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnTwo();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnThree();
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFour();			
				if(isThisAGoodButton==nothingAvailableInThisColumn)
					isThisAGoodButton=findAnOpenSquareInColumnFive();			
			}
			return isThisAGoodButton;
		}

		return isThisAGoodButton;

	}

	/**
	 * This method finds the best square for the computer to move
	 * if the desired column to move in is Column Zero
	 * 
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton findAnOpenSquareInColumnZero(){
		desiredLocation="05";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_0_5;
		desiredLocation="04";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_0_4;
		desiredLocation="03";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_0_3;
		desiredLocation="02";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_0_2;
		desiredLocation="01";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_0_1;
		desiredLocation="00";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_0_0;

		return nothingAvailableInThisColumn;
	}

	/**
	 * This method finds the best square for the computer to move
	 * if the desired column to move in is Column One
	 * 
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton findAnOpenSquareInColumnOne(){
		desiredLocation="15";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_1_5;
		desiredLocation="14";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_1_4;
		desiredLocation="13";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_1_3;	
		desiredLocation="12";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_1_2;
		desiredLocation="11";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_1_1;
		desiredLocation="10";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_1_0;

		return nothingAvailableInThisColumn;
	}

	/**
	 * This method finds the best square for the computer to move
	 * if the desired column to move in is Column Two
	 * 
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton findAnOpenSquareInColumnTwo(){
		desiredLocation="25";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_2_5;
		desiredLocation="24";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_2_4;		
		desiredLocation="23";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_2_3;
		desiredLocation="22";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_2_2;
		desiredLocation="21";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_2_1;
		desiredLocation="20";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_2_0;

		return nothingAvailableInThisColumn;
	}	

	/**
	 * This method finds the best square for the computer to move
	 * if the desired column to move in is Column Three
	 * 
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton findAnOpenSquareInColumnThree(){
		desiredLocation="35";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_3_5;
		desiredLocation="34";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_3_4;
		desiredLocation="33";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_3_3;
		desiredLocation="32";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_3_2;
		desiredLocation="31";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_3_1;
		desiredLocation="30";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_3_0;

		return nothingAvailableInThisColumn;
	}

	/**
	 * This method finds the best square for the computer to move
	 * if the desired column to move in is Column Four
	 * 
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton findAnOpenSquareInColumnFour(){
		desiredLocation="45";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_4_5;
		desiredLocation="44";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_4_4;
		desiredLocation="43";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_4_3;
		desiredLocation="42";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_4_2;
		desiredLocation="41";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_4_1;
		desiredLocation="40";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_4_0;

		return nothingAvailableInThisColumn;
	}

	/**
	 * This method finds the best square for the computer to move
	 * if the desired column to move in is Column Five
	 * 
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton findAnOpenSquareInColumnFive(){
		desiredLocation="55";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_5_5;
		desiredLocation="54";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_5_4;
		desiredLocation="53";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_5_3;
		desiredLocation="52";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_5_2;
		desiredLocation="51";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_5_1;
		desiredLocation="50";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_5_0;

		return nothingAvailableInThisColumn;
	}

	/**
	 * This method finds the best square for the computer to move
	 * if the desired column to move in is Column Six
	 * 
	 * @return	computersButton		This is the JButton that is the computer's strategic 
	 * 								choice based on the human player's move. 
	 */
	public JButton findAnOpenSquareInColumnSix(){
		desiredLocation="65";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_6_5;
		desiredLocation="64";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_6_4;
		desiredLocation="63";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_6_3;
		desiredLocation="62";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_6_2;
		desiredLocation="61";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_6_1;
		desiredLocation="60";

		if(isThisTheColumnsLowestOpenSquareFinder())
			return location_6_0;

		return nothingAvailableInThisColumn;
	}

	/**
	 * This method causes the game to stop allowing
	 * the players to continue playing if someone
	 * has won and thus ends the game.
	 */
	public void gameOver(){
		rowsInColumn0Available=GAME_OVER;
		rowsInColumn1Available=GAME_OVER;
		rowsInColumn2Available=GAME_OVER;
		rowsInColumn3Available=GAME_OVER;
		rowsInColumn4Available=GAME_OVER;
		rowsInColumn5Available=GAME_OVER;
		rowsInColumn6Available=GAME_OVER;
	}

	/**
	 * This method checks to see if the player
	 * who last took a turn has won.
	 * 
	 * @param whoWon	This String indicates whether 
	 * 					red or black last had a turn
	 * 					and thus potentially won the game.
	 */
	public boolean checkForAWinner(ImageIcon whoWonTest){
		//checks horizontals for four in a row
		if(location_0_0.getIcon().equals(whoWonTest)
				&& location_1_0.getIcon().equals(whoWonTest)
				&& location_2_0.getIcon().equals(whoWonTest)
				&& location_3_0.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_1.getIcon().equals(whoWonTest)
				&& location_1_1.getIcon().equals(whoWonTest)
				&& location_2_1.getIcon().equals(whoWonTest)
				&& location_3_1.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_2.getIcon().equals(whoWonTest)
				&& location_1_2.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_3.getIcon().equals(whoWonTest)
				&& location_1_3.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_4.getIcon().equals(whoWonTest)
				&& location_1_4.getIcon().equals(whoWonTest)
				&& location_2_4.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_5.getIcon().equals(whoWonTest)
				&& location_1_5.getIcon().equals(whoWonTest)
				&& location_2_5.getIcon().equals(whoWonTest)
				&& location_3_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;	
		}
		if(location_1_0.getIcon().equals(whoWonTest)
				&& location_2_0.getIcon().equals(whoWonTest)
				&& location_3_0.getIcon().equals(whoWonTest)
				&& location_4_0.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_1.getIcon().equals(whoWonTest)
				&& location_2_1.getIcon().equals(whoWonTest)
				&& location_3_1.getIcon().equals(whoWonTest)
				&& location_4_1.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_2.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_3.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_4.getIcon().equals(whoWonTest)
				&& location_2_4.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_5.getIcon().equals(whoWonTest)
				&& location_2_5.getIcon().equals(whoWonTest)
				&& location_3_5.getIcon().equals(whoWonTest)
				&& location_4_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;		
		}
		if(location_2_0.getIcon().equals(whoWonTest)
				&& location_3_0.getIcon().equals(whoWonTest)
				&& location_4_0.getIcon().equals(whoWonTest)
				&& location_5_0.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_1.getIcon().equals(whoWonTest)
				&& location_3_1.getIcon().equals(whoWonTest)
				&& location_4_1.getIcon().equals(whoWonTest)
				&& location_5_1.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_2.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)
				&& location_5_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_3.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_4.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)
				&& location_5_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_5.getIcon().equals(whoWonTest)
				&& location_3_5.getIcon().equals(whoWonTest)
				&& location_4_5.getIcon().equals(whoWonTest)
				&& location_5_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;		
		}
		if(location_3_0.getIcon().equals(whoWonTest)
				&& location_4_0.getIcon().equals(whoWonTest)
				&& location_5_0.getIcon().equals(whoWonTest)
				&& location_6_0.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_1.getIcon().equals(whoWonTest)
				&& location_4_1.getIcon().equals(whoWonTest)
				&& location_5_1.getIcon().equals(whoWonTest)
				&& location_6_1.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_2.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)
				&& location_5_2.getIcon().equals(whoWonTest)
				&& location_6_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_3.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)
				&& location_6_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_4.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)
				&& location_5_4.getIcon().equals(whoWonTest)
				&& location_6_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_5.getIcon().equals(whoWonTest)
				&& location_4_5.getIcon().equals(whoWonTest)
				&& location_5_5.getIcon().equals(whoWonTest)
				&& location_6_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;		
		}

		//checks verticals for four in a row
		if(location_0_0.getIcon().equals(whoWonTest)
				&& location_0_1.getIcon().equals(whoWonTest)
				&& location_0_2.getIcon().equals(whoWonTest)
				&& location_0_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_0.getIcon().equals(whoWonTest)
				&& location_1_1.getIcon().equals(whoWonTest)
				&& location_1_2.getIcon().equals(whoWonTest)
				&& location_1_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_0.getIcon().equals(whoWonTest)
				&& location_2_1.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_0.getIcon().equals(whoWonTest)
				&& location_3_1.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_4_0.getIcon().equals(whoWonTest)
				&& location_4_1.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_5_0.getIcon().equals(whoWonTest)
				&& location_5_1.getIcon().equals(whoWonTest)
				&& location_5_2.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_6_0.getIcon().equals(whoWonTest)
				&& location_6_1.getIcon().equals(whoWonTest)
				&& location_6_2.getIcon().equals(whoWonTest)
				&& location_6_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_1.getIcon().equals(whoWonTest)
				&& location_0_2.getIcon().equals(whoWonTest)
				&& location_0_3.getIcon().equals(whoWonTest)
				&& location_0_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_1.getIcon().equals(whoWonTest)
				&& location_1_2.getIcon().equals(whoWonTest)
				&& location_1_3.getIcon().equals(whoWonTest)
				&& location_1_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_1.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_2_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_1.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_4_1.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_5_1.getIcon().equals(whoWonTest)
				&& location_5_2.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)
				&& location_5_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_6_1.getIcon().equals(whoWonTest)
				&& location_6_2.getIcon().equals(whoWonTest)
				&& location_6_3.getIcon().equals(whoWonTest)
				&& location_6_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_2.getIcon().equals(whoWonTest)
				&& location_0_3.getIcon().equals(whoWonTest)
				&& location_0_4.getIcon().equals(whoWonTest)
				&& location_0_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_2.getIcon().equals(whoWonTest)
				&& location_1_3.getIcon().equals(whoWonTest)
				&& location_1_4.getIcon().equals(whoWonTest)
				&& location_1_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_2.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_2_4.getIcon().equals(whoWonTest)
				&& location_2_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_2.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)
				&& location_3_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_4_2.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)
				&& location_4_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_5_2.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)
				&& location_5_4.getIcon().equals(whoWonTest)
				&& location_5_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_6_2.getIcon().equals(whoWonTest)
				&& location_6_3.getIcon().equals(whoWonTest)
				&& location_6_4.getIcon().equals(whoWonTest)
				&& location_6_5.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}

		//checks diagonals for four in a row
		if(location_3_5.getIcon().equals(whoWonTest)
				&& location_2_4.getIcon().equals(whoWonTest)
				&& location_1_3.getIcon().equals(whoWonTest)
				&& location_0_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_1.getIcon().equals(whoWonTest)
				&& location_1_2.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_4_5.getIcon().equals(whoWonTest)
				&& location_1_2.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_5_5.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_1.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_1.getIcon().equals(whoWonTest)
				&& location_0_0.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_6_5.getIcon().equals(whoWonTest)
				&& location_5_4.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_1.getIcon().equals(whoWonTest)
				&& location_5_4.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_1.getIcon().equals(whoWonTest)
				&& location_1_0.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_6_4.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)
				&& location_3_1.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_0.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)
				&& location_3_1.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_0.getIcon().equals(whoWonTest)
				&& location_4_1.getIcon().equals(whoWonTest)
				&& location_5_2.getIcon().equals(whoWonTest)
				&& location_6_3.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_3_5.getIcon().equals(whoWonTest)
				&& location_4_4.getIcon().equals(whoWonTest)
				&& location_5_3.getIcon().equals(whoWonTest)
				&& location_6_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_2_5.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_5_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_6_1.getIcon().equals(whoWonTest)
				&& location_3_4.getIcon().equals(whoWonTest)
				&& location_4_3.getIcon().equals(whoWonTest)
				&& location_5_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_1_5.getIcon().equals(whoWonTest)
				&& location_2_4.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_5_1.getIcon().equals(whoWonTest)
				&& location_2_4.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_5_1.getIcon().equals(whoWonTest)
				&& location_6_0.getIcon().equals(whoWonTest)
				&& location_3_3.getIcon().equals(whoWonTest)
				&& location_4_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_5.getIcon().equals(whoWonTest)
				&& location_1_4.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_4_1.getIcon().equals(whoWonTest)
				&& location_1_4.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_4_1.getIcon().equals(whoWonTest)
				&& location_5_0.getIcon().equals(whoWonTest)
				&& location_2_3.getIcon().equals(whoWonTest)
				&& location_3_2.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		if(location_0_4.getIcon().equals(whoWonTest)
				&& location_1_3.getIcon().equals(whoWonTest)
				&& location_2_2.getIcon().equals(whoWonTest)
				&& location_3_1.getIcon().equals(whoWonTest)){
			gameOver();
			return true;
		}
		return false;
	}
}

/**
 * This class creates the GUI 
 * for the directions window.
 *
 */
class DirectionsFrame extends JFrame
{
	private JTextArea myDirectionsTextArea = new JTextArea (100,100);
	private Font directionsFont = new Font ("Courier", Font.BOLD, 21);
	/**
	 * This class creates the GUI 
	 * for the directions window.
	 *
	 * 
	 * @param name		This is the name of the GUI, a String
	 * @param height	This is the height of the GUI, an int
	 * @param width		This is the width of the GUI, an int
	 * @String myRecord	This is the directions to be printed
	 */
	public DirectionsFrame(String name, int height, int width, String myDirections){
		setSize(height, width);
		setTitle(name);
		myDirectionsTextArea.setText(myDirections);
		myDirectionsTextArea.setFont(directionsFont);
		myDirectionsTextArea.setBackground(Color.LIGHT_GRAY);
		JScrollPane scroller = new JScrollPane(myDirectionsTextArea);
		add(scroller);
	}
}