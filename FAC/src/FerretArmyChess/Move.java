package FerretArmyChess;

/** 
*  Chess Piece Move
*  @author Jordan Guerrero
*/
public interface Move{
	//Move undoMove();

	/*//For special move implementation?
	Piece pieceThatMoved();*/

	/**
	*  @return true if move is a special move, false otherwise. 
	*  Implementation class will be added later (SpecialMoves.java) 
	*  to implement special moves (En passant and castling)
	*/
	boolean isSpecialMove();
}