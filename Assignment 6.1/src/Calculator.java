/** Calculator.java
 *  This program creates a calculator GUI
 *  and functionality.
 *  
 *  ****Dimitri**** - I did two of the extras, one for extra credit,
 *  one because I had to.  You can count the plus/minus for part of 
 *  the grade, and then the GUI recording window (that doesn't work 
 *  quite right) for extra credit if you want.
 *  Thanks!  
 *
 *  @author:     Bryan Miller
 *  @version:    4/14/2014
 */

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class Calculator
{
	/**
	 * Main initializes the programs making use of the CalculatorFrame class.
	 * 
	 * @param args	The command line arguments (a String) which are not used in this program.
	 */
	public static void main (String [] args)
	{	
		CalculatorFrame calculatorFrameWindow = new CalculatorFrame("Calculator", 500, 500);
		calculatorFrameWindow.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		calculatorFrameWindow.setVisible(true);
	}
}

/**
 * This class creates the GUI and the functionality
 * for the recording window.
 *
 */
class RecordingFrame extends JFrame
{
	private JTextArea myRecordingTextArea = new JTextArea (100,100);
	/**
	 * This method constructs the GUI for the recording window.
	 * 
	 * @param name		This is the name of the GUI, a String
	 * @param height	This is the height of the GUI, an int
	 * @param width		This is the width of the GUI, an int
	 * @String myRecord	This is the record of the buttons that have been pushed
	 */
	public RecordingFrame(String name, int height, int width, String myRecord){
		setSize(height, width);
		setTitle(name);
		setLayout( new FlowLayout( ) );
		myRecordingTextArea.setText(myRecord);
		JScrollPane scroller = new JScrollPane(myRecordingTextArea);
		add(scroller);
	}
}
/**
 * This class creates the GUI and the functionality
 * for the calculator.
 */
class CalculatorFrame extends JFrame
{
	private final int CALCULATOR_ROWS=5;
	private final int CALCULATOR_COLUMNS=4;
	private final int MAXIMUM_NUMBERS_ALLOWED_ON_DISPLAY=17;
	private final String SQUARE_ROOT_SYMBOL="\u221A";
	private final String PLUS_MINUS_SYMBOL="\u00B1";
	private int digitCounter=0;
	private JButton oneButton=new JButton("1");
	private JButton twoButton=new JButton("2");
	private JButton threeButton=new JButton("3");
	private JButton fourButton=new JButton("4");
	private JButton fiveButton=new JButton("5");
	private JButton sixButton=new JButton("6");
	private JButton sevenButton=new JButton("7");
	private JButton eightButton=new JButton("8");
	private JButton nineButton=new JButton("9");
	private JButton zeroButton=new JButton("0");
	private JButton decimalPointButton=new JButton(".");
	private JButton clearButton=new JButton("C");
	private JButton squareRootButton=new JButton(SQUARE_ROOT_SYMBOL);
	private JButton divideButton=new JButton("/");
	private JButton timesButton=new JButton("*");
	private JButton minusButton=new JButton("-");
	private JButton plusButton=new JButton("+");
	private JButton equalsButton=new JButton("=");
	private JButton plusMinusButton=new JButton(PLUS_MINUS_SYMBOL);
	private JButton buttonRecordButton=new JButton("Button Record");
	private JButton [][] myJButtonArray=new JButton[CALCULATOR_ROWS][CALCULATOR_COLUMNS];

	private String []aMultipleDigitsNumberConstructor=new String[MAXIMUM_NUMBERS_ALLOWED_ON_DISPLAY];
	JPanel myJPanel = new JPanel();
	JPanel myNorthJPanel = new JPanel();
	private JLabel calculatorOutputJLabel = new JLabel("0");
	private Font font = new Font("Helvetica", Font.BOLD, 36);
	private String displayNumber="";
	private boolean isDecimalPointInNumberAlready=false;
	private ArrayList<Double> mathNumbersToCompute=new ArrayList<Double>();
	private ArrayList<String> mathSymbolsToCompute=new ArrayList<String>();
	private ArrayList<String> recordOfAllButtonsClicked=new ArrayList<String>();
	/**
	 * This method constructs the GUI for the calculator.
	 * 
	 * @param name		This is the name of the GUI, a String
	 * @param height	This is the height of the GUI, an int
	 * @param width		This is the width of the GUI, an int
	 */
	public CalculatorFrame(String name, int height, int width){
		setSize(height, width);
		setTitle(name);
		calculatorOutputJLabel.setFont(font);
		myNorthJPanel.add(calculatorOutputJLabel);
		startoverConstructingOneNewPotentiallyMultipleDigitsNumber();

		myJPanel.setLayout(new GridLayout(CALCULATOR_ROWS, CALCULATOR_COLUMNS));
		myJButtonArray[0][0]=clearButton;
		myJButtonArray[1][0]=squareRootButton;
		myJButtonArray[2][0]=divideButton;
		myJButtonArray[3][0]=timesButton;
		myJButtonArray[4][0]=sevenButton;
		myJButtonArray[0][1]=eightButton;
		myJButtonArray[1][1]=nineButton;
		myJButtonArray[2][1]=minusButton;
		myJButtonArray[3][1]=fourButton;
		myJButtonArray[4][1]=fiveButton;
		myJButtonArray[0][2]=sixButton;
		myJButtonArray[1][2]=plusButton;
		myJButtonArray[2][2]=oneButton;
		myJButtonArray[3][2]=twoButton; 
		myJButtonArray[4][2]=threeButton;
		myJButtonArray[0][3]=equalsButton;
		myJButtonArray[1][3]=zeroButton;
		myJButtonArray[2][3]=decimalPointButton; 
		myJButtonArray[3][3]=plusMinusButton;
		myJButtonArray[4][3]=buttonRecordButton;
		for(int j=0; j<CALCULATOR_COLUMNS; j++){
			for(int i=0; i<CALCULATOR_ROWS; i++)
				myJPanel.add(myJButtonArray[i][j]);
		}

		//These are the digits 0-9, the plus/minus operator, the clear button, and the "." decimal point and their addActionListener
		myJButtonArray[4][0].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[0][1].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[1][1].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[3][1].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[4][1].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[0][2].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[2][2].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[3][2].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[4][2].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[1][3].addActionListener(new numberOrDecimalButtonClicker());		
		myJButtonArray[2][3].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[3][3].addActionListener(new numberOrDecimalButtonClicker());
		myJButtonArray[0][0].addActionListener(new numberOrDecimalButtonClicker());

		//These are the math symbols and their addActionListener

		myJButtonArray[1][0].addActionListener(new mathSymbolButtonClicker());
		myJButtonArray[2][0].addActionListener(new mathSymbolButtonClicker());
		myJButtonArray[3][0].addActionListener(new mathSymbolButtonClicker());
		myJButtonArray[2][1].addActionListener(new mathSymbolButtonClicker());
		myJButtonArray[1][2].addActionListener(new mathSymbolButtonClicker());
		myJButtonArray[0][3].addActionListener(new mathSymbolButtonClicker());

		add(myJPanel, BorderLayout.CENTER);
		add(myNorthJPanel, BorderLayout.NORTH);
	}

	/**
	 * This class allows the user to push the number buttons, decimal button,
	 * and plus/minus button on the calculator and get correct responses.
	 */
	class numberOrDecimalButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to push the number buttons, decimal button,
		 * clear button, and plus/minus button on the calculator and get correct responses.		 
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			if(digitCounter<MAXIMUM_NUMBERS_ALLOWED_ON_DISPLAY){
				calculatorOutputJLabel.setText("");
				JButton buttonThatGotClicked=(JButton)e.getSource();
				if(buttonThatGotClicked.getText().equals(plusMinusButton.getText())){
					double displayNumberDouble = Double.parseDouble(displayNumber);
					displayNumberDouble=displayNumberDouble*(-1.0);
					displayNumber=String.valueOf(displayNumberDouble);
					calculatorOutputJLabel.setText(displayNumber);
				}
				else if(buttonThatGotClicked.getText().equals(clearButton.getText())){
					calculatorOutputJLabel.setText("0");
					displayNumber="";
					digitCounter=0;
					startoverConstructingOneNewPotentiallyMultipleDigitsNumber();
					mathNumbersToCompute.clear();
					mathSymbolsToCompute.clear();
				}
				else if(buttonThatGotClicked.getText().equals(decimalPointButton.getText())){
					if(!isDecimalPointInNumberAlready){
						aMultipleDigitsNumberConstructor[digitCounter]=buttonThatGotClicked.getText();
						displayNumber+=aMultipleDigitsNumberConstructor[digitCounter];
						calculatorOutputJLabel.setText(displayNumber);
						digitCounter++;
						isDecimalPointInNumberAlready=true;
					}	
					calculatorOutputJLabel.setText(displayNumber);
				}
				else{
					aMultipleDigitsNumberConstructor[digitCounter]=buttonThatGotClicked.getText();
					displayNumber+=aMultipleDigitsNumberConstructor[digitCounter];
					calculatorOutputJLabel.setText(displayNumber);
					digitCounter++;
				}
			}
		}
	}
	/**
	 * This class allows the user to push the plus, times, divide, minus,
	 * equals and square root button on the calculator and get correct responses.
	 */
	class mathSymbolButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to push the plus, times, divide, minus,
		 * equals and square root button on the calculator and get correct responses.
		 * 
		 * @param 	e	This is the ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			double myNumberToCompute = Double.parseDouble(displayNumber);
			mathNumbersToCompute.add(myNumberToCompute);
			displayNumber="";
			JButton buttonThatGotClicked=(JButton)e.getSource();
			if(buttonThatGotClicked.equals(plusButton)){
				mathSymbolsToCompute.add("+");
				recordOfAllButtonsClicked.add("+");
			}
			if(buttonThatGotClicked.equals(minusButton)){
				mathSymbolsToCompute.add("-");
				recordOfAllButtonsClicked.add("-");
			}
			if(buttonThatGotClicked.equals(timesButton)){
				mathSymbolsToCompute.add("*");
				recordOfAllButtonsClicked.add("*");
			}
			if(buttonThatGotClicked.equals(divideButton)){
				mathSymbolsToCompute.add("/");
				recordOfAllButtonsClicked.add("/");
			}
			if(buttonThatGotClicked.equals(squareRootButton)){
				mathSymbolsToCompute.add(SQUARE_ROOT_SYMBOL);
				recordOfAllButtonsClicked.add(SQUARE_ROOT_SYMBOL);
				int isThereASquareRoot = mathSymbolsToCompute.indexOf(SQUARE_ROOT_SYMBOL);
				MathComputer myComp=new MathComputer();
				String myNumber=myComp.doSquareRootsMath(mathSymbolsToCompute, mathNumbersToCompute, isThereASquareRoot);
				calculatorOutputJLabel.setText(myNumber);
				displayNumber=calculatorOutputJLabel.getText();
			}
			if(buttonThatGotClicked.equals(equalsButton)){
				MathComputer myComp=new MathComputer();
				while(mathSymbolsToCompute.size()>0){
					String myNumber=myComp.doMathExceptSquareRoots(mathSymbolsToCompute, mathNumbersToCompute);
					calculatorOutputJLabel.setText(String.valueOf(myNumber));
				}
				mathNumbersToCompute.clear();
				mathSymbolsToCompute.clear();
				startoverConstructingOneNewPotentiallyMultipleDigitsNumber();
				displayNumber=calculatorOutputJLabel.getText();
			}
			startoverConstructingOneNewPotentiallyMultipleDigitsNumber();
			digitCounter=0;		
		}
	}
	/**
	 * This class allows the user to push the Button Record (button)
	 * which should display a new window with a record of all of the 
	 * buttons pushed so far.
	 */
	class RecordButtonClicker implements ActionListener
	{
		/**
		 * This method allows the user to push the Button Record (button)
		 * which should display a new window with a record of all of the 
		 * buttons pushed so far.		 
		 *  
		 * @param 	e		This is an ActionEvent object
		 */
		public void actionPerformed (ActionEvent e)
		{
			String myRecord="Test";
			RecordingFrame recordFrameWindow = new RecordingFrame("Record of all buttons clicked", 300, 150, myRecord);
			recordFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			recordFrameWindow.setVisible(true);
		}
	}

	/**
	 * This method clears out the previous potentially multiple-digits number
	 * that was being entered into the calculator and allows a new
	 * potentially multiple-digits number to get constructed.
	 */
	public void startoverConstructingOneNewPotentiallyMultipleDigitsNumber(){
		isDecimalPointInNumberAlready=false;
		for(int j=0; j<aMultipleDigitsNumberConstructor.length; j++)
			aMultipleDigitsNumberConstructor[j]="";
	}
}

/**
 * This class does the math requested by the buttons pushed on the numbers 
 * entered.    
 */
class MathComputer{

	private final double TRUNCATED_TO_TEN_DECIMALS=10000000000.0;
	private String myNumber="";

	public MathComputer()
	{
	}

	/**
	 * This method does the math (except square roots) requested by 
	 * the buttons pushed on the numbers entered.  It removes the number 
	 * immediately before the math symbol and the number immediately afterwards 
	 * in the ArrayList keeping track of all of the numbers.  It replaces those
	 * numbers with the new number calculated into that same ArrayList.  Finally,
	 * it removes the math symbol entered into the calculator after the 
	 * math has been completed from a different ArrayList that is keeping track
	 * of all of the buttons that have been pushed.
	 * 
	 *   @param	mathSymbolsToCompute	The math symbols to compute (an ArrayList of Strings)
	 *   @param	mathNumbersToCompute	The math numbers to compute (an ArrayList of Doubles)
	 */
	public String doMathExceptSquareRoots(ArrayList<String> mathSymbolsToCompute, ArrayList<Double> mathNumbersToCompute){
		//Multiply
		if(mathSymbolsToCompute.indexOf("*")!=-1){
			int isThereAMultiplySign = mathSymbolsToCompute.indexOf("*");
			double myNumberToMultiply=mathNumbersToCompute.get(isThereAMultiplySign);
			double myOtherNumberToMultiply=mathNumbersToCompute.get(isThereAMultiplySign+1);
			double myMultipliedNumber=myNumberToMultiply*myOtherNumberToMultiply;
			double myTruncatedMultipliedNumber=truncateMyDecimal(myMultipliedNumber);
			myNumber=String.valueOf(myTruncatedMultipliedNumber);
			mathSymbolsToCompute.remove(isThereAMultiplySign);
			mathNumbersToCompute.remove(isThereAMultiplySign+1);
			mathNumbersToCompute.remove(isThereAMultiplySign);
			mathNumbersToCompute.add(isThereAMultiplySign, myMultipliedNumber);
		}
		//Divide
		if(mathSymbolsToCompute.indexOf("/")!=-1){
			int isThereADivideSign = mathSymbolsToCompute.indexOf("/");
			double myNumberToDivide=mathNumbersToCompute.get(isThereADivideSign);
			double myOtherNumberToDivide=mathNumbersToCompute.get(isThereADivideSign+1);
			double myDividedNumber=myNumberToDivide/myOtherNumberToDivide;
			double myTruncatedDividedNumber=truncateMyDecimal(myDividedNumber);
			myNumber=String.valueOf(myTruncatedDividedNumber);
			mathSymbolsToCompute.remove(isThereADivideSign);
			mathNumbersToCompute.remove(isThereADivideSign+1);
			mathNumbersToCompute.remove(isThereADivideSign);
			mathNumbersToCompute.add(isThereADivideSign, myDividedNumber);
		}
		//Addition
		if(mathSymbolsToCompute.indexOf("+")!=-1){
			int isThereAPlusSign = mathSymbolsToCompute.indexOf("+");
			double myNumberToAdd=mathNumbersToCompute.get(isThereAPlusSign);
			double myOtherNumberToAdd=mathNumbersToCompute.get(isThereAPlusSign+1);
			double myAddedNumber=myNumberToAdd+myOtherNumberToAdd;
			double myTruncatedAddedNumber=truncateMyDecimal(myAddedNumber);
			myNumber=String.valueOf(myTruncatedAddedNumber);
			mathSymbolsToCompute.remove(isThereAPlusSign);
			mathNumbersToCompute.remove(isThereAPlusSign+1);
			mathNumbersToCompute.remove(isThereAPlusSign);
			mathNumbersToCompute.add(isThereAPlusSign, myAddedNumber);
		}
		//Subtraction
		if(mathSymbolsToCompute.indexOf("-")!=-1){
			int isThereAMinusSign = mathSymbolsToCompute.indexOf("-");
			double myNumberToSubtract=mathNumbersToCompute.get(isThereAMinusSign);
			double myOtherNumberToSubtract=mathNumbersToCompute.get(isThereAMinusSign+1);
			double mySubtractedNumber=myNumberToSubtract-myOtherNumberToSubtract;
			double myTruncatedSubtractedNumber=truncateMyDecimal(mySubtractedNumber);
			myNumber=String.valueOf(myTruncatedSubtractedNumber);
			mathSymbolsToCompute.remove(isThereAMinusSign);
			mathNumbersToCompute.remove(isThereAMinusSign+1);
			mathNumbersToCompute.remove(isThereAMinusSign);
			mathNumbersToCompute.add(isThereAMinusSign, mySubtractedNumber);
		}
		return myNumber;				
	}

	/**
	 * This method does the square roots math.
	 * 
	 *   @param	mathSymbolsToCompute	The math symbols to compute (an ArrayList of Strings)
	 *   @param	mathNumbersToCompute	The math numbers to compute (an ArrayList of Doubles)
	 *   @param	isThereASquareRoot		The index at which there is a square root
	 */ 
	public String doSquareRootsMath(ArrayList<String> mathSymbolsToCompute, ArrayList<Double> mathNumbersToCompute, int isThereASquareRoot){
		double myNumberToTakeSquareRootOf=mathNumbersToCompute.get(isThereASquareRoot);
		if(myNumberToTakeSquareRootOf<0)
			return("ERROR");
		else{
			double mySquareRootedNumber=Math.sqrt(myNumberToTakeSquareRootOf);
			double myTruncatedSquareRootedNumber=truncateMyDecimal(mySquareRootedNumber);
			mathSymbolsToCompute.remove(isThereASquareRoot);
			mathNumbersToCompute.remove(isThereASquareRoot);
			mathNumbersToCompute.add(isThereASquareRoot, mySquareRootedNumber);
			return(String.valueOf(myTruncatedSquareRootedNumber));
		}
	}

	/**
	 * This method truncates to ten decimals to the right of the 
	 * decimal point as instructed in the directions. 
	 * 
	 * @param  numToTruncate	This is the number (a double) to truncate.
	 * @return	The truncated number, a double, is returned.
	 */
	public double truncateMyDecimal(double numToTruncate){
		return (double)Math.round(numToTruncate*TRUNCATED_TO_TEN_DECIMALS)/TRUNCATED_TO_TEN_DECIMALS;
	}
}