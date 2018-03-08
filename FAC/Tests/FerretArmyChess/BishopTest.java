package FerretArmyChess;

import org.junit.Test;
import FerretArmyChess.*;
import static org.junit.Assert.*;

public class BishopTest {

    @Test
    //tests Valid Bishop NE Movement
    public void testValidNE(){
        Game testGame = new Game();
        Bishop whiteBishop = new Bishop(testGame, Color.WHITE, 5,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 6,6);
        whitePawn.canMakeValidMove(6,4);
        assertTrue(whiteBishop.canMakeValidMove(6,6));
    }

    @Test
    //tests Valid Bishop NW Movement
    public void testValidNW(){
        Game testGame = new Game();
        Bishop whiteBishop = new Bishop(testGame, Color.WHITE, 5,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 4,6);
        whitePawn.canMakeValidMove(4,4);
        assertTrue(whiteBishop.canMakeValidMove(4,6));
    }

    @Test
    //tests Invalid Bishop Movement
    public void testInvalidMove(){
        Game testGame = new Game();
        Bishop whiteBishop = new Bishop(testGame, Color.WHITE, 5,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 5,6);
        whitePawn.canMakeValidMove(5,4);
        assertFalse(whiteBishop.canMakeValidMove(5,6));
    }

}