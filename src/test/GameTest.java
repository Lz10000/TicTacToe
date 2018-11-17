package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.GameCheck;
import game.Player;

public class GameTest {

    @Test
    public void test() throws Exception {
        
        
        //check that all rows produces no winner
        for(int row=0; row<3; row++){
            Board b = new Board();
            GameCheck gc = new GameCheck(b);
            b.play(row, 0, Player.X);
            b.play(row, 1, Player.O);
            b.play(row, 2, Player.X);
            assertNull(gc.checkWinner());
        }
        

            Board b = new Board();
            GameCheck gc = new GameCheck(b);
            
            assertFalse(b.isFull());
            assertNull(gc.checkWinner());
            
            b.play(0, 0, Player.X);
            b.play(1, 0, Player.O);
            b.play(0, 1, Player.X);
            b.play(2, 1, Player.O);
            b.play(0, 2, Player.X);
            
            assertEquals(gc.checkWinner(), Player.X);

    }
}
