package FerretArmyChess;

import java.util.concurrent.TimeUnit;

import static FerretArmyChess.Color.*;

public class Game {
	Game(){
		//_moves = new ArrayList<Move>();
		newGame();
		//new GUI display?
		Dialog.main(GW);
	}

	private void initializeGameWindow() {
		GW = GameWindow.main(this);
		updateGameBoard();
	}

	public void updateGameBoard(){
		GW.setGameBoard(new GameBoard(this));
	}

	//Clears game to start a new one
	public void newGame(){
		initializeBoard();
		//_moves.clear();
		_turn = WHITE;
		initializeGameWindow();
	}

	//Makes the move on the board, assuming it is valid
	public void makeMove(Move move){
		//Add move to list?
		if(!move.isSpecialMove()){
			RegularMove regularMove = (RegularMove) move;
			makeRegMove(regularMove);
		}
		else{
			//Code for Special Move
		}
		_turn = _turn.oppositeColor();
	}

	//Makes a regular move on the board(Seperated logic for special moves cond.)
	private void makeRegMove(RegularMove move){
		_board[move.getX()][move.getY()] = move.replace();
		if(move.replace() != null){
			move.replace().setLocation(move.getX(), move.getY());
		}

		_board[move.getDestX()][move.getDestY()] = move.current();
		if(move.current() != null){
			move.current().setLocation(move.getDestX(), move.getDestY());
		}

		if(move.destination() != null){	//Capturing
			move.destination().setLocation(-1, -1);
		}
	}

	/*Undoes the previous move
	public void undoMove(){

	}*/

	//Returns whether king of this color is being checked by opponent
	public boolean inCheck(Color color){
		int x = getKingX(color);
		int y = getKingY(color);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Piece p = getPiece(i, j);
				if (p != null && p.getColor() == color.oppositeColor()
					&& p.canCapture(x, y)) {
					return true;
				}
			}
		}
		return false;
	}

	//Returns whether the current player has any valid moves to make
	public boolean noMovesLeft(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				Piece p = getPiece(i, j);
				if(p != null && p.getColor() == _turn){
					if(p.hasValidMoveToMake()){
						return false;
					}
				}
			}
		}
		return true;
	}

	//Returns the piece at (x,y)
	public Piece getPiece(int x, int y){
		return _board[x][y];
	}

	//Initializes the board
	private void initializeBoard(){
		Piece blackR1 = new Rook(this, BLACK, 0, 0);
		Piece blackKn1 = new Knight(this, BLACK, 1, 0);
		Piece blackB1 = new Bishop(this, BLACK, 2, 0);
		Piece blackQ = new Queen(this, BLACK, 3, 0);
		_blackKing = new King(this, BLACK, 4, 0);
		Piece blackB2 = new Bishop(this, BLACK, 5, 0);
		Piece blackKn2 = new Knight(this, BLACK, 6, 0);
		Piece blackR2 = new Rook(this, BLACK, 7, 0);
		Piece blackP1 = new Pawn(this, BLACK, 0, 1);
		Piece blackP2 = new Pawn(this, BLACK, 1, 1);
		Piece blackP3 = new Pawn(this, BLACK, 2, 1);
		Piece blackP4 = new Pawn(this, BLACK, 3, 1);
		Piece blackP5 = new Pawn(this, BLACK, 4, 1);
		Piece blackP6 = new Pawn(this, BLACK, 5, 1);
		Piece blackP7 = new Pawn(this, BLACK, 6, 1);
		Piece blackP8 = new Pawn(this, BLACK, 7, 1);

		Piece whiteR1 = new Rook(this, WHITE, 0, 7);
		Piece whiteKn1 = new Knight(this, WHITE, 1, 7);
		Piece whiteB1 = new Bishop(this, WHITE, 2, 7);
		Piece whiteQ = new Queen(this, WHITE, 3, 7);
		_whiteKing = new King(this, WHITE, 4, 7);
		Piece whiteB2 = new Bishop(this, WHITE, 5, 7);
		Piece whiteKn2 = new Knight(this, WHITE, 6, 7);
		Piece whiteR2 = new Rook(this, WHITE, 7, 7);
		Piece whiteP1 = new Pawn(this, WHITE, 0, 6);
		Piece whiteP2 = new Pawn(this, WHITE, 1, 6);
		Piece whiteP3 = new Pawn(this, WHITE, 2, 6);
		Piece whiteP4 = new Pawn(this, WHITE, 3, 6);
		Piece whiteP5 = new Pawn(this, WHITE, 4, 6);
		Piece whiteP6 = new Pawn(this, WHITE, 5, 6);
		Piece whiteP7 = new Pawn(this, WHITE, 6, 6);
		Piece whiteP8 = new Pawn(this, WHITE, 7, 6);

		Piece[][] tempBoard = {
			{blackR1, blackP1, null, null, null, null, whiteP1, whiteR1},
			{blackKn1, blackP2, null, null, null, null, whiteP2, whiteKn1},
			{blackB1, blackP3, null, null, null, null, whiteP3, whiteB1},
			{blackQ, blackP4, null, null, null, null, whiteP4, whiteQ},
			{_blackKing, blackP5, null, null, null, null, whiteP5, _whiteKing},
			{blackB2, blackP6, null, null, null, null, whiteP6, whiteB2},
			{blackKn2, blackP7, null, null, null, null, whiteP7, whiteKn2},
			{blackR2, blackP8, null, null, null, null, whiteP8, whiteR2} };

		_board = tempBoard;
		
	}

	//Returns the color whose turn it is
	public Color turn(){
		return _turn;
	}

	//Returns the x location of king of same color
	public int getKingX(Color color){
		if(color == BLACK){
			return _blackKing.getX();
		}
		else{
			return _whiteKing.getX();
		}
	}

	//Returns the y location of king of same color
	public int getKingY(Color color){
		if(color == BLACK){
			return _blackKing.getY();
		}
		else{
			return _whiteKing.getY();
		}
	}


	private Piece[][] _board;

	private Color _turn;

	GameWindow GW;

	//Ordered list of moves made in the game (For En Passant)
	//private List<Move> _moves;

	private King _blackKing;

	private King _whiteKing;
}