package FerretArmyChess;

import java.lang.Math;
import static FerretArmyChess.PieceType.*;

/** 
*  Bishop
*  @author Jordan Guerrero
*/
public class Bishop implements Piece{
	public Bishop (Game game, Color color, int x, int y){
		_game = game;
		_color = color;
		_x = x;
		_y = y;
	}

	@Override
	public String getImageText(){
		return _color.text() + BISHOP.text();
	}

	@Override
	public Color getColor(){
		return _color;
	}

	@Override
	public PieceType type(){
		return BISHOP;
	}

	@Override
	public boolean canMakeValidMove(int destX, int destY){
		if(_game.getPiece(destX, destY) != null
			&& _game.getPiece(destX, destY).getColor() == _color){
			return false;
		}
		else if(destX + destY == _x + _y){
			int direction = (destX - _x) / Math.abs(destX - _x);
			for(int i = _x + direction, j = _y - direction; i != destX;
				i += direction, j -= direction){
					if(_game.getPiece(i, j) != null){
						return false;
					}
			}
			Move move = new RegularMove(this, _x, _y, 
				_game.getPiece(destX, destY), destX, destY);
			return kValMove(move);
		}
		else if(destX - destY == _x - _y){
			int direction = (destX - _x) / Math.abs(destX - _x);
			for(int i = _x + direction, j = _y + direction; i != destX;
				i += direction, j += direction){
					if(_game.getPiece(i, j) != null){
						return false;
					}
			}
			Move move = new RegularMove(this, _x, _y, 
				_game.getPiece(destX, destY), destX, destY);
			return kValMove(move);
		}
		else{
			return false;
		}
	}

	@Override
	public boolean hasValidMoveToMake(){
		if((_x + 1 <= 7 && _y + 1 <= 7 && canMakeValidMove(_x + 1, _y + 1))
			|| (_x + 1 <= 7 && _y - 1 >= 0 && canMakeValidMove(_x + 1, _y - 1))
			|| (_x - 1 >= 0 && _y + 1 <= 7 && canMakeValidMove(_x - 1, _y + 1))
			|| (_x - 1 >= 0 && _y - 1 >= 0 && canMakeValidMove(_x - 1, _y - 1))){
			//_game.undoMove();
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean canCapture(int destX, int destY){
		if(destX + destY == _x + _y){
			int direction = (destX - _x) / Math.abs(destX - _x);
			for(int i = _x + direction, j = _y - direction; i != destX;
				i += direction, j -= direction){
					if(_game.getPiece(i, j) != null){
						return false;
					}
			}
			return true;
		}
		else if(destX - destY == _x - _y){
			int direction = (destX - _x) / Math.abs(destX - _x);
			for(int i = _x + direction, j = _y + direction; i != destX;
				i += direction, j += direction){
					if(_game.getPiece(i, j) != null){
						return false;
					}
			}
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
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