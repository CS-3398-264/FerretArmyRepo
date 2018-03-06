package FerretArmyChess;

/** 
*  Chess Piece Colors
*  @author Jordan Guerrero
*/
enum Color{
	BLACK, WHITE;

	String text(){
		switch(this){
			case BLACK:
				return "black_";
			case WHITE:
				return "white_";
			default:
				return "-";
		}
	}

	/**
	*  @return the opposite of THIS color. Used for check validation
	*/
	public Color oppositeColor(){
		if(this == WHITE){
			return BLACK;
		}
		else{
			return WHITE;
		}
	}

	/**
	*  @return 1 if THIS color is black, and -1 if white. Used for check 
	*  validation. Used for pawn movements
	*/
	public int direction(){
		if(this == BLACK){
			return 1;
		}
		else{
			return -1;
		}
	}
}