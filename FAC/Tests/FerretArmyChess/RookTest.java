package FerretArmyChess;

import org.junit.Test;
import FerretArmyChess.*;
import static org.junit.Assert.*;

public class RookTest {

    @Test
    //tests minimum Vertical Rook Movement
    public void testValidVertical(){
        Game testGame = new Game();
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 7, 6);
        whitePawn.canMakeValidMove(7,5);
        Rook whiteRook = new Rook(testGame, Color.WHITE, 7,7);
        assertTrue(whiteRook.canMakeValidMove(7,6));
    }

    @Test
    //tests minimum Horizontal Rook Movement
    public void testValidHorizontal(){
        Game testGame = new Game();
        Rook whiteRook = new Rook(testGame, Color.WHITE, 7,7);
        Knight whiteKnight = new Knight(testGame, Color.WHITE, 6,7);
        whiteKnight.canMakeValidMove(7,5);
        assertTrue(whiteRook.canMakeValidMove(6,7));
    }

    @Test
    //tests invalid Rook Movement
    public void testInvalid(){
        Game testGame = new Game();
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 6, 6);
        whitePawn.canMakeValidMove(6,5);
        Rook whiteRook = new Rook(testGame, Color.WHITE, 7,7);
        assertFalse(whiteRook.canMakeValidMove(6,6));
    }

    @Test
    //tests boundary restrictions of WHITE Rook
    public void testBoundary(){
        Game testGame = new Game();
        Rook whiteRook = new Rook(testGame, Color.WHITE, 7,7);
        //RegularMove move = new RegularMove(whiteRook, 7,7,)
        assertFalse(whiteRook.canMakeValidMove(8,7));
    }
}