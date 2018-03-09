package FerretArmyChess;

import org.junit.Test;
import FerretArmyChess.*;
import static org.junit.Assert.*;

public class QueenTest {

    @Test
    //tests Valid Vertical Queen Movement
    public void testValidVertical(){
        Game testGame = new Game();
        Queen whiteQueen = new Queen(testGame, Color.WHITE, 3,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 3,6);
        whitePawn.canMakeValidMove(3,4);
        assertTrue(whiteQueen.canMakeValidMove(3,5));
    }

    @Test
    //tests Valid Horizontal Queen Movement
    public void testValidHorizontal(){
        Game testGame = new Game();
        Queen whiteQueen = new Queen(testGame, Color.WHITE, 3,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 3,6);
        Bishop whiteBishop = new Bishop(testGame, Color.WHITE, 2,7);
        whitePawn.canMakeValidMove(3,5);
        whiteBishop.canMakeValidMove(3,6);
        assertTrue(whiteQueen.canMakeValidMove(2,7));
    }

    @Test
    //tests Valid Diagonal Queen Movement
    public void testValidDiagonal(){
        Game testGame = new Game();
        Queen whiteQueen = new Queen(testGame, Color.WHITE, 3,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 2,6);
        whitePawn.canMakeValidMove(2,5);
        assertTrue(whiteQueen.canMakeValidMove(2,6));
    }

    @Test
    //tests Invalid Queen Movement
    public void testInvalidMove() {
        Game testGame = new Game();
        Queen whiteQueen = new Queen(testGame, Color.WHITE, 3, 7);
        //assertion to move like a knight
        assertFalse(whiteQueen.canMakeValidMove(2, 5));
    }

    @Test
    //tests Obstacle Movement
    public void testObstacleMove(){
        Game testGame = new Game();
        Queen whiteQueen = new Queen(testGame, Color.WHITE, 3,7);
        Pawn whitePawn = new Pawn(testGame, Color.WHITE, 3,6);
        whitePawn.canMakeValidMove(3,4);
        assertFalse(whiteQueen.canMakeValidMove(3,3));
    }

    @Test
    //tests Boundary
    public void testBoundary(){
        Game testGame = new Game();
        Queen whiteQueen = new Queen(testGame, Color.WHITE, 3,7);
        assertFalse(whiteQueen.canMakeValidMove(3,8));
    }
}