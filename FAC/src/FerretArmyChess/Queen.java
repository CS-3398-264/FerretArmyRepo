package FerretArmyChess;

import java.lang.Math;
import static FerretArmyChess.PieceType.*;

/** 
*  Queen
*  @author Jordan Guerrero
*/
public class Queen implements Piece{
	public Queen (Game game, Color color, int x, int y){
		_game = game;
		_color = color;
		_x = x;
		_y = y;
	}

	@Override
	public String getImageText(){
		return _color.text() + QUEEN.text();
	}

	@Override
	public Color getColor(){
		return _color;
	}

	@Override
	public PieceType type(){
		return QUEEN;
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
		else if(destX == _x){
			int direction = (destY - _y) / Math.abs(destY - _y);
			for(int i = _y + direction; i != destY; i += direction){
				if(_game.getPiece(_x, i) != null){
					return false;
				}
			}
			Move move = new RegularMove(this, _x, _y, 
				_game.getPiece(destX, destY), destX, destY);
			return kValMove(move);
		}
		else if(destY == _y){
			int direction = (destX - _x) / Math.abs(destX - _x);
			for(int i = _x + direction; i != destX; i += direction){
				if(_game.getPiece(i, _y) != null){
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
		else if(destX == _x){
			int direction = (destY - _y) / Math.abs(destY - _y);
			for(int i = _y + direction; i != destY; i += direction){
				if(_game.getPiece(_x, i) != null){
					return false;
				}
			}
			return true;
		}
		else if(destY == _y){
			int direction = (destX - _x) / Math.abs(destX - _x);
			for(int i = _x + direction; i != destX; i += direction){
				if(_game.getPiece(i, _y) != null){
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