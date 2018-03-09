package FerretArmyChess;

import org.junit.Test;
import FerretArmyChess.*;
import static org.junit.Assert.*;

public class KingTest {

    @Test
    //tests Valid Vertical King Movement
    public void testValidVertical(){
        Game testGame = new Game();
        King whiteKing = new King(testGame, Color.WHITE, 4,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 4,6);
        whitePawn.canMakeValidMove(4,5);
        assertTrue(whiteKing.canMakeValidMove(4,6));
    }

    @Test
    //tests Valid Horzontal King Movement
    public void testValidHorizontal(){
        Game testGame = new Game();
        King whiteKing = new King(testGame, Color.WHITE, 4,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 4,6);
        Bishop whiteBishop = new Bishop(testGame, Color.WHITE, 5,7);
        whitePawn.canMakeValidMove(4,5);
        whiteBishop.canMakeValidMove(4,6);
        assertTrue(whiteKing.canMakeValidMove(5,7));
    }

    @Test
    //tests Valid Diagonal King Movement
    public void testValidDiagonal(){
        Game testGame = new Game();
        King whiteKing = new King(testGame, Color.WHITE, 4,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 5,6);
        whitePawn.canMakeValidMove(5,5);
        assertTrue(whiteKing.canMakeValidMove(5,6));
    }

    @Test
    //tests Invalid King Movement
    public void testInvalidMove(){
        Game testGame = new Game();
        King whiteKing = new King(testGame, Color.WHITE, 4,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 4,6);
        whitePawn.canMakeValidMove(6,4);
        assertFalse(whiteKing.canMakeValidMove(4,5));
    }

}