// Piece.java 
/**  
 *  This class puts the chess piece on a square
 *  on the chessboard, or if not, it prints 
 *  a warning message and tries to 
 *  anyways.
 *
 *  @author  Bryan Miller and Dr. H.H. Leitner
 *  @version Last modified:  2/25/2014
 */

import java.util.*;

abstract class Piece
{
	protected int pieceRow;
	protected int pieceColumn;

	public void placeOnChessBoard()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Type the ROW where your chess piece is located: ");
		pieceRow = keyboard.nextInt();
		System.out.print ("Type the COLUMN where your chess piece is located: ");
		pieceColumn = keyboard.nextInt();
		if ((pieceRow < 1) || (pieceRow > 8)
				|| (pieceColumn < 1) || (pieceColumn > 8))
			System.out.print ("Invalid input, but I'll try anyway");
		keyboard.nextLine();
	}

	abstract boolean attackingThisLocation (int row, int column);
}