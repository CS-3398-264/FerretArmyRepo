package FerretArmyChess;

import org.junit.Test;
import FerretArmyChess.*;
import static org.junit.Assert.*;

public class KnightTest {

    @Test
    //tests Vertical Knight Movement
    public void testValidVertical(){
        Game testGame = new Game();
        Knight whiteKnight = new Knight(testGame, Color.WHITE, 6,7);
        assertTrue(whiteKnight.canMakeValidMove(5,5));
    }

    @Test
    //tests Horizontal Knight Movement
    public void testValidHorizontal(){
        Game testGame = new Game();
        Knight whiteKnight = new Knight(testGame, Color.WHITE, 6,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 4,6);
        whitePawn.canMakeValidMove(4,5);
        assertTrue(whiteKnight.canMakeValidMove(4,6));
    }

    @Test
    //tests invalid Knight Movement
    public void testInvalidMove(){
        Game testGame = new Game();
        Knight whiteKnight = new Knight(testGame, Color.WHITE, 6,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 6,6);
        whitePawn.canMakeValidMove(6,4);
        assertFalse(whiteKnight.canMakeValidMove(6,5));
    }

}