package FerretArmyChess;

/** 
*  Chess Piece
*  @author Jordan Guerrero
*/
public interface Piece{
	/**
	*  @return the color of THIS piece
	*/
	Color getColor();

	/**
	*  @return the type of THIS piece
	*/
	PieceType type();

	/**
	*  @return the THIS piece's color and type in a string format (For GUI)
	*/
	String getImageText();

	/**
	*  @return TRUE if the destination coordinates are valid for THIS piece
	*  		   to move to, and makes the move if valid. Returns FALSE otherwise
	*  @param destX is an int that represents the desired x-coordinate to move 
	*		  to.
	*  @param destY is an int that represents the desired y-coordinate to move 
	*		  to.
	*/
	boolean canMakeValidMove(int destX, int destY);

	/**
	*  @return TRUE if THIS piece can make any valid moves, otherwise 
	*  		   returns FALSE (Used for stalemate resolution).
	*/
	boolean hasValidMoveToMake();

	/**
	*  @return TRUE if THIS piece is threatening the piece located at the 
	*		   destination coordinates, otherwise returns false.
	*		   (Used for check validation)
	*  @param destX is an int that represents the desired x-coordinate to move 
	*		  to.
	*  @param destY is an int that represents the desired y-coordinate to move 
	*		  to.
	*/
	boolean canCapture(int destX, int destY);

	/*Sets the location of THIS piece to (x,y) on the board*/
	void setLocation(int x, int y);
}