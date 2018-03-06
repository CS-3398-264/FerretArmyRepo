package FerretArmyChess;

/** 
*  Types of Chess Pieces
*  @author Jordan Guerrero
*/
enum PieceType{
	BISHOP, KING, KNIGHT, PAWN, QUEEN, ROOK;

	String text(){
		switch(this){
			case BISHOP:
				return "bishop";
			case KING:
				return "king";
			case KNIGHT:
				return  "knight";
			case PAWN:
				return  "pawn";
			case QUEEN:
				return  "queen";
			case ROOK:
				return "rook";
			default:
				return "-";
		}
	}
}