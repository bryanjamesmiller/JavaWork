/** 
 *  This class allows for a king's moves to be
 *  simulated on a chess board
 *  
 * @author    Bryan Miller and Dr. Leitner
 * @version   Last modified on 2/25/2014
 **/
import java.lang.Math;
class King extends Piece
{ 
	boolean attackingThisLocation (int indexRow, int indexColumn)
	{
		int columnDiff = pieceColumn - indexColumn;
		int rowDiff = pieceRow - indexRow;

		if((columnDiff==0 && Math.abs(rowDiff)==1 
				|| Math.abs(columnDiff)==1 && rowDiff==0))
			return true;

		if (((columnDiff + rowDiff == 0) || (columnDiff == rowDiff)) 
				&& (Math.abs(columnDiff)<=1 && Math.abs(rowDiff)<=1))
			return true;

		return false; 
	}
}