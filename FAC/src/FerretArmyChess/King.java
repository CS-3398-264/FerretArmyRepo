package FerretArmyChess;

import java.lang.Math;
import static FerretArmyChess.PieceType.*;

/** 
*  King
*  @author Jordan Guerrero
*/
public class King implements Piece{
	public King (Game game, Color color, int x, int y){
		_game = game;
		_color = color;
		_x = x;
		_y = y;
	}

	@Override
	public String getImageText(){
		return _color.text() + KING.text();
	}

	@Override
	public Color getColor(){
		return _color;
	}

	@Override
	public PieceType type(){
		return KING;
	}

	@Override
	public boolean canMakeValidMove(int destX, int destY){
		if(Math.abs(destX - _x) <= 1 && Math.abs(destY - _y) <= 1
		   && (_game.getPiece(destX, destY) == null ||
		   _game.getPiece(destX, destY).getColor() != _color)){
			Move move = new RegularMove(this, _x, _y, 
						_game.getPiece(destX, destY), destX, destY);
			return kValMove(move);
		}
		//More Code will be added later for castling
		else{
			return false;
		}
	}

	@Override
	public boolean hasValidMoveToMake(){
		for(int i = -1; i < 2; i++){
			for(int j = -1; j < 2; j++){
				if(_x + i >= 0 && _x + i <= 7 && _y + j >= 0 && _y + j <= 7){
					if(canMakeValidMove(_x + i, _y + j)){
						//_game.undoMove();
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean canCapture(int destX, int destY){
		return Math.abs(destX - _x) <= 1 && Math.abs(destY - _y) <= 1;
	}

	@Override
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
	}

	//Getters
	public int getX(){
		return _x;
	}

	public int getY(){
		return _y;
	}

	/**
	*  @return TRUE if the move doesn't leave your king in check, and will make
	*		   the move, and update the turn. Otherwise it returns false.
	*  @param move that it will try to make.
	*/
	private boolean kValMove(Move move){
		_game.makeMove(move); //Makes move & updates turn
		if(_game.inCheck(_game.turn().oppositeColor())){
			//_game.undoMove(); //Undoes the move
			return false;
		}
		else{
			return true;
		}
	}

	//Game that this piece belongs to
	private Game _game;

	private Color _color;

	private int _x;

	private int _y;
}