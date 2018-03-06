package FerretArmyChess;

import java.lang.Math;
import static FerretArmyChess.PieceType.*;

/** 
*  Pawn
*  @author Jordan Guerrero
*/
public class Pawn implements Piece{
	public Pawn (Game game, Color color, int x, int y){
		_game = game;
		_color = color;
		_x = x;
		_y = y;
	}

	@Override
	public String getImageText(){
		return _color.text() + PAWN.text();
	}

	@Override
	public Color getColor(){
		return _color;
	}

	@Override
	public PieceType type(){
		return PAWN;
	}

	@Override
	public boolean canMakeValidMove(int destX, int destY){
		if(_y == start()){
			if(destY == _y + (2 * direction())){
				if(destX == _x && _game.getPiece(destX, _y + direction()) == null
				   && _game.getPiece(destX, destY) == null){
					Move move = new RegularMove(this, _x, _y, 
						_game.getPiece(destX, destY), destX, destY);
						return kValMove(move);
				}
				else{
					return false;
				}
			}
		}
		if(destY == _y + direction()){
			if(destX == _x && _game.getPiece(destX, destY) == null){
				Move move = new RegularMove(this, _x, _y, 
					_game.getPiece(destX, destY), destX, destY);
				return kValMove(move);
				//More code will be added here later for Pawn Promotion
			}
			else if(Math.abs(destX - _x) == 1 && _game.getPiece(destX, destY) != null
					&& _game.getPiece(destX, destY).getColor() != _color){
				Move move = new RegularMove(this, _x, _y, 
					_game.getPiece(destX, destY), destX, destY);
				return kValMove(move);
				//More code will be added here later for Pawn Promotion
			}
			//More code will be added here later for En Passant
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	@Override
	public boolean hasValidMoveToMake(){
		if((_x + 1 <= 7 && canMakeValidMove(_x + 1, _y + 1))
			|| (canMakeValidMove(_x, _y + 1))
			|| (_x - 1 >= 0 && canMakeValidMove(_x - 1, _y + 1))){
			//_game.undoMove();
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean canCapture(int destX, int destY){
		return(destY == _y + direction() && Math.abs(destX - _x) == 1);
	}

	@Override
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
	}

	//Returns -1 if white, and 1 if black
	private int direction(){
		return _color.direction();
	}

	//Returns 1 if black, and 6 if white (Index of starting row)
	private int start(){
		if(_color == Color.BLACK){
			return 1;
		}
		else{
			return 6;
		}
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