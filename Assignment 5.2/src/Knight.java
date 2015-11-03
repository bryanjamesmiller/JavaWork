/** 
 *  This class allows for a knight's moves to be
 *  simulated on a chess board
 *  
 * @author    Bryan Miller and Dr. Leitner
 * @version   Last modified on 2/25/2014
 **/

class Knight extends Piece
{
	boolean attackingThisLocation (int indexRow, int indexColumn)
	{
		int columnDiff = pieceColumn - indexColumn;
		int rowDiff = pieceRow - indexRow;

		if ((columnDiff * columnDiff + rowDiff * rowDiff == 5) ||
				( (columnDiff == 0) && (rowDiff == 0))) return true;
		else return false; 

	}
}