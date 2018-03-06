package FerretArmyChess;

/** 
*  Normal move in chess game.
*  @author Jordan Guerrero
*/
public class RegularMove implements Move{
	//Constructor, to be called by individual pieces
	public RegularMove(Piece c, int x, int y, Piece d, int destX, int destY){
		_current = c;
		_x = x;
		_y = y;
		_destination = d;
		_destX = destX;
		_destY = destY;
		_replace = null;
	}

	//Constructor, if needed will be called by undoMove()
	/*
	private RegularMove(Piece c, int x, int y, Piece d, int destX, int destY, Piece r){
		_current = c;
		_x = x;
		_y = y;
		_destination = d;
		_destX = destX;
		_destY = destY;
		_replace = r;
	}
	*/

	/*@Override
	public Move undoMove(){
		return new RegularMove(_current, _destX, _destY, null, _x, _y, _destination);
	}*/

	/*@Override
	public Piece pieceThatMoved(){
		return _current;
	}*/

	@Override
	public boolean isSpecialMove(){
		return false;
	}

	//Getters
	public Piece current(){
		return _current;
	}

	public Piece destination(){
		return _destination;
	}

	public Piece replace(){
		return _replace;
	}

	public int getX(){
		return _x;
	}

	public int getY(){
		return _y;
	}

	public int getDestX(){
		return _destX;
	}

	public int getDestY(){
		return _destY;
	}

	//Piece that is being moved
	private Piece _current;

	//Piece at move destination
	private Piece _destination;

	//Piece that will replace the moved piece after the move is complete
	private Piece _replace;

	//Current x
	private int _x;

	//Current y
	private int _y;

	//Destination x
	private int _destX;

	//Destination y
	private int _destY;
}