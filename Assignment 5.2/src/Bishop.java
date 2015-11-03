/** 
 *  This class allows for a bishop's moves to be
 *  simulated on a chess board
 *  
 * @author    Bryan Miller and Dr. Leitner
 * @version   Last modified on 2/25/2014
 **/

class Bishop extends Piece
{
	boolean attackingThisLocation (int indexRow, int indexColumn)
	{
		int columnDiff = pieceColumn - indexColumn;
		int rowDiff = pieceRow - indexRow;

		if ((columnDiff + rowDiff == 0) ||  (columnDiff == rowDiff))
			return true;
		else return false; 
	}
}