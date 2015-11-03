/* 
 * MagicSquare.java
 * 
 * Author:          Computer Science E-22 staff
 * Modified by:     <your name>, <your e-mail address>
 * Date modified:   <current date>
 */

import java.util.*;

public class MagicSquare {
	//Starting row and column values
	private static final int FIRST_COLUMN = 0;
	private static final int FIRST_ROW = 0;

	// The minimum possible number to try to put on the magic square
	private static final int MIN_NUM = 1;

	// the current contents of the cells of the puzzle values[r][c]
	// gives the value in the cell at row r, column c
	private int[][] values;

	//This array keeps track of if a number is already used in a Magic Square
	//The index number of the array is equal to the number that is available (true) or is not available (false)
	private boolean[] isNumberAvailable;

	// the order (i.e., the dimension) of the puzzle
	private int order;

	//The maximum possible number to try putting on the magic square
	private int maxNum;

	//What each row and column should add up to
	private int sum;

	/**
	 * Creates a MagicSquare object for a puzzle with the specified
	 * dimension/order.
	 */
	public MagicSquare(int order) {
		this.order = order;
		this.values = new int[order][order];
		this.maxNum=this.order*this.order;
		this.sum =((this.order)*(this.order)*(this.order)+(this.order))/2;
		this.isNumberAvailable=new boolean[maxNum+1];

		for(int i=0; i<this.order; i++)
		{
			for(int j=0; j<order; j++)
			{
				this.values[i][j]=0;
			}
		}

		for(int i=0; i<=this.maxNum; i++)
		{
			this.isNumberAvailable[i]=true;
		}

		// Add code to this constructor as needed to initialize
		// the fields that you add to the object.
	}

	/**
	 * This method should call the separate recursive-backtracking method
	 * that you will write, passing it the appropriate initial parameter(s).
	 * It should return true if a solution is found, and false otherwise.
	 */
	public boolean solve() {
		// Replace the line below with your implementation of this method.
		// REMEMBER: The recursive-backtracking code should NOT go here.
		// See the comments above.
		
		return fillOneMagicSquare(FIRST_ROW, FIRST_COLUMN);
	}

	public boolean fillOneMagicSquare(int row, int col)
	{
		if(row == this.order || col == this.order){
			return true;
		}

		for(int i = MIN_NUM; i <= this.maxNum; i++)
		{
			if(this.isNumberAvailable[i])
			{
				//Place a number in the magic square 
				values[row][col]=i;    	

				//Mark the number as not being available to use again.
				isNumberAvailable[i]=false;

				//See if you're at the end of a row to see if the numbers add up
				//(this "if" block won't execute if you're not at the end of a row).
				if(col == this.order - 1) 
				{
					if(numbersAddUpInRow(row))    
					{  
						// If the row adds up to this.sum, 
						// fill the first magic square in the next row  
						// by making a new recursive call.					 		
						if(fillOneMagicSquare(row + 1, FIRST_COLUMN))
							return true;
					}
					// If the numbers didn't add up, the "for" loop should continue to try a new
					// number in the same magic square.
				}

				// See if you're at the end of a column to see if the numbers add up
				// (this "if" block won't execute if you're not at the end of a column).
				if(row==this.order-1)
				{
					//If numbers add up to sum, fill the next magic square (by making a recursive call).
					//If the numbers don't add up, the "for" loop will loop to try a new number.  If all the numbers run out, you'll backtrack to a previous recursive stack frame.
					if(numbersAddUpInColumn(col))
					{
						// If the column adds up correctly, make another recursive call to fill the next box
						// in the same row and the next column.  
						if(col<this.order-1)
						{
							if(fillOneMagicSquare(row, col + 1))
								return true;
						}
					}
				}

				//If you're not at the end of a row, make a recursive call to fill the next square
				if(col < this.order-1 && row < this.order-1)
				{
					if(fillOneMagicSquare(row, col + 1))
						return true;
				}    		

				// At this point, the current value in the for loop is being discarded for 
				// the next value, so we have to make the current value "i" available again
				// for a different magic square to use.
				isNumberAvailable[i]=true;
			}

		}
		return false;
		//When the program reaches here, this is when you will backtrack.
		//You don't have to return here, the program will automatically return since it's "void".  
	}    	


	public boolean numbersAddUpInColumn(int col){
		int tempSumOfColumns = 0;
		for(int i = 0; i < this.order; i++)
		{
			tempSumOfColumns += values[i][col];
		}
		if(tempSumOfColumns == sum)
			return true;
		return false;
	}

	public boolean numbersAddUpInRow(int row){
		int tempSumOfRows = 0;

		for(int i = 0; i < this.order; i++)
		{
			tempSumOfRows += values[row][i];
		}
		if(tempSumOfRows == sum)
			return true;
		return false;
	}

	/**
	 * Displays the current state of the puzzle.
	 * You should not change this method.
	 */
	public void display() {
		for (int r = 0; r < order; r++) {
			printRowSeparator();
			for (int c = 0; c < order; c++) {
				System.out.print("|");
				if (values[r][c] == 0)
					System.out.print("   ");
				else {
					if (values[r][c] < 10) {
						System.out.print(" ");
					}
					System.out.print(" " + values[r][c] + " ");
				}
			}
			System.out.println("|");
		}
		printRowSeparator();
	}

	// A private helper method used by display()
	// to print a line separating two rows of the puzzle.
	private void printRowSeparator() {
		for (int i = 0; i < order; i++)
			System.out.print("-----");
		System.out.println("-");
	}

	public static void main(String[] args) {
		/*******************************************************
		 **** You should NOT change any code in this method ****
		 ******************************************************/

		Scanner console = new Scanner(System.in);
		System.out.print("What order Magic Square would you like to solve? ");
		int order = console.nextInt();

		MagicSquare puzzle = new MagicSquare(order);
		if (puzzle.solve()) {
			System.out.println("Here's the solution:");
			puzzle.display();
		} else {
			System.out.println("No solution found.");
		}
	}
}