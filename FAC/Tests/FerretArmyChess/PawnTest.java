package FerretArmyChess;

import org.junit.Test;
import FerretArmyChess.*;

import static org.junit.Assert.*;

public class PawnTest {


    @Test
    //tests minimum BLACK pawn movement
    public void testValidMinBP(){
        Game testGame = new Game();
        Pawn blackPawn = new Pawn (testGame, Color.BLACK, 0,1);
        assertTrue(blackPawn.canMakeValidMove(0,2));

    }

    @Test
    //tests maximum BLACK pawn movement
    public void testValidMaxBP(){
        Game testGame = new Game();
        Pawn blackPawn = new Pawn (testGame, Color.BLACK, 0,1);
        assertTrue(blackPawn.canMakeValidMove(0,3));

    }

    @Test
    //tests invalid pawn movement
    public void testInvalidMovement() {
        Game testGame = new Game();
        Pawn newPawn = new Pawn(testGame, Color.BLACK, 7,1);
        assertFalse(newPawn.canMakeValidMove(7,4));
    }

    @Test
    //tests piece collision (jumping a piece)
    public void testPieceCollision(){
        Game testGame = new Game();
        Pawn newPawn = new Pawn(testGame, Color.WHITE, 2,6);
        Knight newKnight = new Knight(testGame, Color.WHITE, 1,7);
        newKnight.canMakeValidMove(2,5);
        assertFalse(newPawn.canMakeValidMove(2,4));
    }
}